package linter;

public class LinterError {
    private String message;
    private int line;
    private int symbol;

    public LinterError(String message, int line, int symbol) {
        this.message = message;
        this.line = line;
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return String.format("Строка %d, позиция %d: %s", line, symbol, message);
    }
}
