package lotto.util;

import java.util.Arrays;
import java.util.List;

public final class Parser {

    private static final String DELIMITER = ",";

    private Parser() {
    }

    public static int toInteger(String value) {
        InputValidator.numericType(value);
        InputValidator.rangeOf(value);

        return Integer.parseInt(value);
    }

    public static List<Integer> toNumbers(String consoleInput) {
        InputValidator.numberInputFormat(consoleInput);

        return Arrays.stream(consoleInput.split(DELIMITER))
                .map(Parser::toInteger)
                .toList();
    }
}
