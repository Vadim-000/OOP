package main;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Linter linter = new Linter();
        String testCode =
                "public class bad_class {\n" +
                        "\tprivate String myVariable = \"test\";\n" +
                        "    \n" +
                        "    public void veryLongMethodNameWithManyCharactersThatExceedsTheLineLengthLimit() {\n" +
                        "        System.out.println(\"Hello\");   \n" +
                        "    }\n" +
                        "}\n";
        List<Problem> problems = linter.lint(testCode);
        linter.printProblems();
    }
}