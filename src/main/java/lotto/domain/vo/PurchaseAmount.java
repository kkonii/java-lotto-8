package lotto.domain.vo;

import lotto.exception.LottoError;

public class PurchaseAmount {

    private static final int UNIT_AMOUNT = 1000;

    private final int amount;

    public PurchaseAmount(int amount) {
        validateMinimum(amount);
        validateUnitOf(amount);
        this.amount = amount;
    }

    private void validateMinimum(int amount) {
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
}
