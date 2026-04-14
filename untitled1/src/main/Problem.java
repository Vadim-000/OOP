package main;

public class Problem {
    private String message;
    private int line;
    private int symbol;

    public Problem(String message, int line, int symbol) {
        this.message = message;
        this.line = line;
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return String.format("Строка %d, позиция %d: %s", line, symbol, message);
    }
}
