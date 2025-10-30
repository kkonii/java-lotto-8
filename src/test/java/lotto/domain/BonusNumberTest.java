package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {

    @Test
    void 지정된_범위_외의_보너스_번호에_대해_예외를_발생한다() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new BonusNumber(99));
    }
}
