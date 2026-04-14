package test;

import main.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RuleTabSymbolTest {

    private RuleTabSymbol rule = new RuleTabSymbol();

    @Test
    void testWithError() {
        String code = "\tpublic void method()";
        assertFalse(rule.check(code, 1).isEmpty());
    }

    @Test
    void testWithoutError() {
        String code = "    public void method()";
        assertTrue(rule.check(code, 1).isEmpty());
    }
}