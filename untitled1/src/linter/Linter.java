package linter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class Linter {
    private RuleManager ruleManager;
    private List<LinterError> LinterErrors;

    public Linter() {
        this.ruleManager = new RuleManager();
        this.LinterErrors = new ArrayList<>();
        addRule(new RuleTabSymbol());
        addRule(new RuleLineLength(80));
        addRule(new RuleNamed());
        addRule(new RuleSpaseInEndLine());
        addRule(new RuleEmptyBlock());
    }

    public void addRule(Rule rule) {
        ruleManager.addRule(rule);
    }

    public List<LinterError> lint(String code) {
        LinterErrors.clear();

        try (BufferedReader reader = new BufferedReader(new StringReader(code))) {
            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                checkLine(line, lineNumber);
                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>(LinterErrors);
    }

    private void checkLine(String line, int lineNumber) {
        for (Rule rule : ruleManager.getRules()) {
            List<LinterError> ruleLinterErrors = rule.check(line, lineNumber);
            LinterErrors.addAll(ruleLinterErrors);
        }
    }

    public void printLinterErrors() {
        if (LinterErrors.isEmpty()) {
            System.out.println("Проблем не найдено!");
            return;
        }

        System.out.println("Найденны проблемы:\n");
        for (LinterError LinterError : LinterErrors) {
            System.out.println(LinterError);
        }
        System.out.println("\nВсего: " + LinterErrors.size() + " проблем");
    }
}
