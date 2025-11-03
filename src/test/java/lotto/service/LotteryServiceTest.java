package lotto.service;

import java.util.List;
import java.util.Optional;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoCalculator;
import lotto.domain.Rank;
import lotto.domain.StatisticCalculator;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class LotteryServiceTest {

    @ParameterizedTest
    @MethodSource("lotto.fixture.Provider#numberArgumentsOfRank")
    @DisplayName("[성공] 로또 번호, 당첨번호, 보너스 번호를 비교해 당첨된 여부를 반환한다")
    void 로또와_당첨_번호_보너스_번호에_일치하는_등수를_찾아_반환한다(List<Integer> lottoNumbers, List<Integer> winningNumbers, int numberValue,
                                            Rank rank) {
        //given
        LottoCalculator calculator = new LottoCalculator();
        StatisticCalculator statistic = new StatisticCalculator();
        LotteryService service = new LotteryService(calculator, statistic);

        //when
        Lotto lotto = new Lotto(lottoNumbers);
        WinningNumber winningNumber = new WinningNumber(winningNumbers);
        BonusNumber bonusNumber = new BonusNumber(numberValue);
        Optional<Rank> foundRank = service.findRankWith(lotto, winningNumber, bonusNumber);
        //then
        org.junit.jupiter.api.Assertions.assertEquals(foundRank.get(), rank);
    }
}
