package linter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class RuleEmptyBlock extends Rule {

    public RuleEmptyBlock() {
        super("Пустые блоки кода",
                "\\{\\s*\\}|\\{\\s*\\n\\s*\\}");
    }

    @Override
    public List<LinterError> check(String content, int lineNumber) {
        List<LinterError> issues = new ArrayList<>();
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            issues.add(createLinterError(lineNumber, matcher.start() + 1,
                    "Найден пустой блок кода {}"));
        }
        return issues;
    }
}
