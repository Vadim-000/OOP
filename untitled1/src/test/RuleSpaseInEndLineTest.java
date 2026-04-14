package test;

import main.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RuleSpaseInEndLineTest {

    private RuleSpaseInEndLine rule = new RuleSpaseInEndLine();

    @Test
    void testWithError() {
        String code = "Hello   ";
        assertFalse(rule.check(code, 1).isEmpty());
    }

    @Test
    void testWithoutError() {
        String code = "Hello";
        assertTrue(rule.check(code, 1).isEmpty());
    }
}