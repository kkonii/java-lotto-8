package lotto.domain.vo;

import lotto.exception.LottoError;

public class PurchaseAmount {

    private static final int UNIT_AMOUNT = 1000;
    private static final int MAXIMUM_BOUND = 100_000;

    private final int amount;

    public PurchaseAmount(int amount) {
        validateMinimumBound(amount);
        validateUnitOf(amount);
        validateMaximumBound(amount);
        this.amount = amount;
    }

    private void validateMinimumBound(int amount) {
        if (amount < UNIT_AMOUNT) {
            throw new IllegalArgumentException(LottoError.AMOUNT_BELOW_MINIMUM.messageOf(UNIT_AMOUNT));
        }
    }

    private void validateUnitOf(int amount) {
        int remainAmount = amount % UNIT_AMOUNT;

        if (remainAmount != 0) {
            throw new IllegalArgumentException(LottoError.NOT_REQUIRED_AMOUNT_UNIT.messageOf(UNIT_AMOUNT));
        }
    }

    private void validateMaximumBound(int amount) {
        if (amount > MAXIMUM_BOUND) {
            throw new IllegalArgumentException(LottoError.AMOUNT_EXCEED_MAXIMUM.messageOf(MAXIMUM_BOUND));
        }
    }
}
