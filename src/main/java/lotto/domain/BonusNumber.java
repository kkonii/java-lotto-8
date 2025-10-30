package lotto.domain;

import lotto.exception.LottoError;

public class BonusNumber {

    private static final int MINIMUM_BOUND = 1;
    private static final int MAXIMUM_BOUND = 45;

    private final int number;

    public BonusNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if (number < MINIMUM_BOUND || number > MAXIMUM_BOUND) {
            throw new IllegalArgumentException(LottoError.OUT_OF_BOUNDS.messageOf(MINIMUM_BOUND, MAXIMUM_BOUND));
        }
    }
}
