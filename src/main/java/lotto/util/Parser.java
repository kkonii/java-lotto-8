package lotto.util;

import java.util.Arrays;
import java.util.List;

public final class Parser {

    private static final String DELIMITER = ",";

    private Parser() {
    }

    public static int toInteger(String consoleInput) {
        InputValidator.blankValue(consoleInput);
        InputValidator.numericType(consoleInput);
        InputValidator.rangeOf(consoleInput);

        return Integer.parseInt(consoleInput);
    }

    public static List<Integer> toNumbers(String consoleInput) {
        InputValidator.blankValue(consoleInput);
        InputValidator.numberInputFormat(consoleInput);

        return Arrays.stream(consoleInput.split(DELIMITER))
                .map(Parser::toInteger)
                .toList();
    }
}
