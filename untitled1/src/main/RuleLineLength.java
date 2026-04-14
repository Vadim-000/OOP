package main;

import java.util.ArrayList;
import java.util.List;

public class RuleLineLength extends Rule {
    private int maxLength;

    public RuleLineLength(int maxLength) {
        super("Строка слишком длинная", "^.{1," + maxLength + "}$");
        this.maxLength = maxLength;
    }

    @Override
    public List<Problem> check(String content, int lineNumber) {
        List<Problem> issues = new ArrayList<>();

        if (content.length() > maxLength) {
            issues.add(createProblem(lineNumber, maxLength + 1,
                    String.format("Строка длиной %d символов (максимум %d)",
                            content.length(), maxLength)));
        }
        return issues;
    }
}
