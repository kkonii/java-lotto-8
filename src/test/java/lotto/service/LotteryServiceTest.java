package lotto.service;

import java.util.EnumMap;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoCalculator;
import lotto.domain.Rank;
import lotto.domain.WinningNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class LotteryServiceTest {

    @ParameterizedTest
    @MethodSource("lotto.fixture.Provider#numberArgumentsOfRank")
    void 각_등수가_당첨된_횟수를_반환한다(List<Integer> lottoNumbers, List<Integer> winningNumbers, int numberValue,
                            Rank rank) {
        //given
        LottoCalculator calculator = new LottoCalculator();
        LotteryService service = new LotteryService(calculator);

        Lotto lotto = new Lotto(lottoNumbers);
        WinningNumber winningNumber = new WinningNumber(winningNumbers);
        BonusNumber bonusNumber = new BonusNumber(numberValue);

        //when
        EnumMap<Rank, Integer> statistics = service.statisticsWith(lotto, winningNumber, bonusNumber);

        //then
        Assertions.assertThat(statistics.get(rank)).isEqualTo(1);
    }
}
