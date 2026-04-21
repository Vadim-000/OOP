package linter;

import java.util.ArrayList;
import java.util.List;

public class RuleLineLength extends Rule {
    private int maxLength;

    public RuleLineLength(int maxLength) {
        super("Строка слишком длинная", "^.{1," + maxLength + "}$");
        this.maxLength = maxLength;
    }

    @Override
    public List<LinterError> check(String content, int lineNumber) {
        List<LinterError> issues = new ArrayList<>();

        if (content.length() > maxLength) {
            issues.add(createLinterError(lineNumber, maxLength + 1,
                    String.format("Строка длиной %d символов (максимум %d)",
                            content.length(), maxLength)));
        }
        return issues;
    }
}
