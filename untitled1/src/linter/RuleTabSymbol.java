package linter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class RuleTabSymbol extends Rule {
    public RuleTabSymbol() {
        super("Используйте пробелы вместо табуляции", "\t");
    }

    @Override
    public List<LinterError> check(String content, int lineNumber) {
        List<LinterError> issues = new ArrayList<>();
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            issues.add(createLinterError(lineNumber, matcher.start() + 1,
                    "Найден символ табуляции, используйте пробелы"));
        }
        return issues;
    }
}