package main;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class RuleSpaseInEndLine extends Rule {
    public RuleSpaseInEndLine() {
        super("Лишние пробелы в конце строки", "\\s+$");
    }

    @Override
    public List<Problem> check(String content, int line) {
        List<Problem> problems = new ArrayList<>();
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            problems.add(createProblem(line, matcher.start() + 1, "лишние пробелы в конце строки"));
        }
        return problems;
    }
}
