package lotto.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.exception.GlobalError;

public final class InputValidator {

    private static final Pattern NUMBER_INPUT_FORMAT_PATTERN = Pattern.compile("^[+-]?\\d+(,[+-]?\\d+)*$");
    private static final Pattern NUMERIC = Pattern.compile("^[+-]?\\d+$");

    private InputValidator() {
    }

    public static void numericType(String value) {
        Matcher matcher = NUMERIC.matcher(value);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(GlobalError.NOT_A_NUMBER.message());
        }
    }

    public static void rangeOf(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(GlobalError.OUT_OF_INTEGER_RANGE.message());
        }
    }

    public static void blankValue(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(GlobalError.INPUT_IS_BLANK.message());
        }
    }

    public static void numberInputFormat(String consoleInput) {
        Matcher matcher = NUMBER_INPUT_FORMAT_PATTERN.matcher(consoleInput.strip());

        if (!matcher.matches()) {
            throw new IllegalArgumentException(GlobalError.NUMBER_INPUT_FORMAT_IS_NOT_VALID.message());
        }
    }
}
