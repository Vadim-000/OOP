package linter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class RuleNamed extends Rule {
    public RuleNamed() {
        super("Соблюдение соглашений об именовании",
                "class\\s+([a-z][a-zA-Z0-9]*)|" +           // класс с маленькой буквы
                        "(?:private|public|protected)\\s+\\w+\\s+([A-Z][a-zA-Z0-9]*)\\s*[=;]"); // переменная с большой
    }

    @Override
    public List<LinterError> check(String content, int lineNumber) {
        List<LinterError> issues = new ArrayList<>();

        if (content == null || content.trim().isEmpty()) {
            return issues;
        }

        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            String badClassName = matcher.group(1);
            String badVarName = matcher.group(2);

            if (badClassName != null && !badClassName.isEmpty()) {
                issues.add(createLinterError(lineNumber, matcher.start(1) + 1,
                        "Имя класса должно начинаться с заглавной буквы: " + badClassName));
            }

            if (badVarName != null && !badVarName.isEmpty()) {
                issues.add(createLinterError(lineNumber, matcher.start(2) + 1,
                        "Имя переменной должно начинаться со строчной буквы: " + badVarName));
            }
        }

        return issues;
    }
}