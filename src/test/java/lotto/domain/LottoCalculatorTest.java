package lotto.domain;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoCalculatorTest {

    @Test
    void 로또와_당첨_번호가_일치하는_갯수를_반환한다() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 7, 8, 9));
        int matchingCount = 3;

        //when
        LottoCalculator calculator = new LottoCalculator();
        int compared = calculator.findMatchingCount(lotto, winningNumber);

        //then
        Assertions.assertEquals(compared, matchingCount);
    }

    @Test
    void 로또_번호와_보너스_번호의_일치_여부를_반환한다() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(4);

        //when
        LottoCalculator calculator = new LottoCalculator();
        boolean match = calculator.matchValuesOf(lotto, bonusNumber);

        //then
        org.assertj.core.api.Assertions.assertThat(match)
                .isTrue();
    }
}
