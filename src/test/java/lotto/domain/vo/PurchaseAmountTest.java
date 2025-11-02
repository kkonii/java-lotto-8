package lotto.domain.vo;

import lotto.exception.LottoError;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PurchaseAmountTest {

    @Test
    void 최소_금액_미만이면_예외를_반환한다() {
        //given
        int minimumAmount = 1000;
        //when
        int actualAmount = 500;
        //then
        Assertions.assertThatThrownBy(() -> new PurchaseAmount(actualAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.AMOUNT_BELOW_MINIMUM.messageOf(minimumAmount));
    }

    @Test
    void 구매금액_단위가_1000원이_아니면_예외를_반환한다() {
        //given
        int amountUnit = 1000;
        //when
        int actualAmount = 1500;
        //then
        Assertions.assertThatThrownBy(() -> new PurchaseAmount(actualAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoError.NOT_REQUIRED_AMOUNT_UNIT.messageOf(amountUnit));
    }

    @Test
    void 구매금액이_최대를_초과하면_예외를_반환한다() {
        //given
        int maximumBound = 100_000;
        //when
        int actualAmount = 205_000;
        //then
        Assertions.assertThatThrownBy(() -> new PurchaseAmount(actualAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll(LottoError.AMOUNT_EXCEED_MAXIMUM.messageOf(maximumBound));
    }
}
