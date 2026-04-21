package test;

import main.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RuleLineLengthTest {

    private RuleLineLength rule = new RuleLineLength(10);

    @Test
    void testWithError() {
        String code = "12345678901";
        assertFalse(rule.check(code, 1).isEmpty());
    }

    @Test
    void testWithoutError() {
        String code = "1234567890";
        assertTrue(rule.check(code, 1).isEmpty());
    }
}