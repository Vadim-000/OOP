package linter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class RuleSpaseInEndLine extends Rule {
    public RuleSpaseInEndLine() {
        super("Лишние пробелы в конце строки", "\\s+$");
    }

    @Override
    public List<LinterError> check(String content, int line) {
        List<LinterError> LinterErrors = new ArrayList<>();
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            LinterErrors.add(createLinterError(line, matcher.start() + 1, "лишние пробелы в конце строки"));
        }
        return LinterErrors;
    }
}
