package lotto.domain;

import java.util.List;
import lotto.exception.LottoError;

public class BonusNumber {

    private static final int MINIMUM_BOUND = 1;
    private static final int MAXIMUM_BOUND = 45;

    private final int number;

    public BonusNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    public static BonusNumber uniqueFrom(WinningNumber numbers, int number) {
        validateDuplicateOf(numbers, number);

        return new BonusNumber(number);
    }

    private void validateRange(int number) {
        if (number < MINIMUM_BOUND || number > MAXIMUM_BOUND) {
            throw new IllegalArgumentException(LottoError.OUT_OF_BOUNDS.messageOf(MINIMUM_BOUND, MAXIMUM_BOUND));
        }
    }

    private static void validateDuplicateOf(WinningNumber numbers, int bonus) {
        List<Integer> numberValues = numbers.asList();

        if (numberValues.contains(bonus)) {
            throw new IllegalArgumentException(LottoError.BONUS_ARE_NOT_UNIQUE.message());
        }
    }

    public int getValue() {
        return number;
    }
}
