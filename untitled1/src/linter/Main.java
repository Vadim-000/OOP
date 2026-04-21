package linter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Linter linter = new Linter();
        String testCode = """
                public class bad_class {
                \tprivate String myVariable = "test";
                    \s
                    public void veryLongMethodNameWithManyCharactersThatExceedsTheLineLengthLimit() {
                        System.out.println("Hello");   \s
                    }
                }
                """;
        List<LinterError> LinterErrors = linter.lint(testCode);
        linter.printLinterErrors();
    }
}