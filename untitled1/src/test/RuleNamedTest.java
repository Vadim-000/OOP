package test;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import main.*;

public class RuleNamedTest {

    private RuleNamed rule = new RuleNamed();

    @Test
    void testWithError() {
        String code = "public class badClass { }";
        List<Problem> problems = rule.check(code, 1);
        assertFalse(problems.isEmpty());
    }

    @Test
    void testWithoutError() {
        String code = "public class GoodClass { }";
        List<Problem> problems = rule.check(code, 1);
        assertTrue(problems.isEmpty());
    }
}