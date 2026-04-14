package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class Linter {
    private RuleManager ruleManager;
    private List<Problem> problems;

    public Linter() {
        this.ruleManager = new RuleManager();
        this.problems = new ArrayList<>();
        addRule(new RuleTabSymbol());
        addRule(new RuleLineLength(80));
        addRule(new RuleNamed());
        addRule(new RuleSpaseInEndLine());
        addRule(new RuleEmptyBlock());
    }

    public void addRule(Rule rule) {
        ruleManager.addRule(rule);
    }

    public List<Problem> lint(String code) {
        problems.clear();

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

        return new ArrayList<>(problems);
    }

    private void checkLine(String line, int lineNumber) {
        for (Rule rule : ruleManager.getRules()) {
            List<Problem> ruleProblems = rule.check(line, lineNumber);
            problems.addAll(ruleProblems);
        }
    }

    public void printProblems() {
        if (problems.isEmpty()) {
            System.out.println("Проблем не найдено!");
            return;
        }

        System.out.println("Найденны проблемы:\n");
        for (Problem problem : problems) {
            System.out.println(problem);
        }
        System.out.println("\nВсего: " + problems.size() + " проблем");
    }
}
