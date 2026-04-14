package test;

import main.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RuleEmptyBlockTest {

    private RuleEmptyBlock rule = new RuleEmptyBlock();

    @Test
    void testWithError() {
        String code = "if (x > 0) {}";
        assertFalse(rule.check(code, 1).isEmpty());
    }

    @Test
    void testWithoutError() {
        String code = "if (x > 0) { return true; }";
        assertTrue(rule.check(code, 1).isEmpty());
    }
}