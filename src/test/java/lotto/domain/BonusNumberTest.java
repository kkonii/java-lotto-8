package lotto.domain;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {

    @Test
    void 지정된_범위_외의_보너스_번호에_대해_예외를_발생한다() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new BonusNumber(99));
    }

    @Test
    void 당첨_번호와_중복되는_보너스_번호에_대해_예외를_발생한다() {
        //given
        WinningNumber winningNumbers = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
        //when
        int bonusValue = 1;
        //then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> BonusNumber.uniqueFrom(winningNumbers, bonusValue));
    }
}
