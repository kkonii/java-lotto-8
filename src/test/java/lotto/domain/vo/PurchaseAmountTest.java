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
}
