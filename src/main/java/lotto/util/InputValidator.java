package lotto.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.exception.GlobalError;

public final class InputValidator {

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
}
