package lotto.util;

public final class Parser {

    private Parser() {
    }

    public static int toInteger(String value) {
        InputValidator.numericType(value);
        InputValidator.rangeOf(value);

        return Integer.parseInt(value);
    }
}
