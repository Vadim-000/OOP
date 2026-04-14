package main;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class RuleNamed extends Rule {
    public RuleNamed() {
        super("Соблюдение соглашений об именовании",
                "\\bclass\\s+([a-z][a-zA-Z0-9]*)\\s*\\{|" +
                        "\\binterface\\s+([a-z][a-zA-Z0-9]*)\\s*\\{|" +
                        "(?:private|public|protected)\\s+\\w+\\s+([A-Z][a-zA-Z0-9]*)\\s*[=;]");
    }

    @Override
    public List<Problem> check(String content, int lineNumber) {
        List<Problem> issues = new ArrayList<>();
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            String className = matcher.group(1);
            String interfaceName = matcher.group(2);
            String varName = matcher.group(3);

            if (className != null) {
                issues.add(createProblem(lineNumber, matcher.start(1) + 1,
                        "Имя класса должно начинаться с заглавной буквы: " + className));
            }

            if (interfaceName != null) {
                issues.add(createProblem(lineNumber, matcher.start(2) + 1,
                        "Имя интерфейса должно начинаться с заглавной буквы: " + interfaceName));
            }

            if (varName != null) {
                issues.add(createProblem(lineNumber, matcher.start(3) + 1,
                        "Имя переменной должно начинаться со строчной буквы: " + varName));
            }
        }
        return issues;
    }
}