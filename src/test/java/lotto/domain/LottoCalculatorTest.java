package lotto.domain;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoCalculatorTest {

    @Test
    void 로또와_당첨_번호가_일치하는_갯수를_반환한다() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 7, 8, 9));
        int matchingCount = 3;

        //when
        LottoCalculator calculator = new LottoCalculator();
        int compared = calculator.compareOf(lotto, winningNumber);

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

    @ParameterizedTest
    @MethodSource("lotto.fixture.Provider#numberArgumentsOfRank")
    @DisplayName("[성공] 로또 번호, 당첨번호, 보너스 번호를 비교해 당첨된 여부를 반환한다")
    void 로또와_당첨_번호_보너스_번호에_일치하는_등수를_찾아_반환한다(List<Integer> lottoNumbers, List<Integer> winningNumbers, int numberValue,
                                            Rank rank) {
        //given
        LottoCalculator calculator = new LottoCalculator();
        Lotto lotto = new Lotto(lottoNumbers);
        WinningNumber winningNumber = new WinningNumber(winningNumbers);
        BonusNumber bonusNumber = new BonusNumber(numberValue);

        //when
        Optional<Rank> foundRank = calculator.findRankWith(lotto, winningNumber, bonusNumber);
        //then
        Assertions.assertEquals(foundRank.get(), rank);
    }
}
