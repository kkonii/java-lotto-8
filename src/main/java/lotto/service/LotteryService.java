package lotto.service;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Optional;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoCalculator;
import lotto.domain.Rank;
import lotto.domain.StatisticCalculator;
import lotto.domain.WinningNumber;

public class LotteryService {

    private final LottoCalculator lottoCalculator;
    private final StatisticCalculator statisticCalculator;

    public LotteryService(LottoCalculator lottoCalculator, StatisticCalculator statisticCalculator) {
        this.lottoCalculator = lottoCalculator;
        this.statisticCalculator = statisticCalculator;
    }

    public EnumMap<Rank, Integer> statisticsWith(List<Lotto> lottos, WinningNumber winningNumbers, BonusNumber bonus) {
        List<Rank> ranks = new ArrayList<>();

        lottos.forEach(lotto -> {
            Optional<Rank> rank = findRankWith(lotto, winningNumbers, bonus);
            if (rank.isPresent()) {
                ranks.add(rank.get());
            }
        });

        return statisticCalculator.summarizeCountOf(ranks);
    }

    public Optional<Rank> findRankWith(Lotto lotto, WinningNumber winningNumber,
                                       BonusNumber bonusNumber) {
        int matchingCount = lottoCalculator.findMatchingCount(lotto, winningNumber);
        boolean matchBonus = lottoCalculator.matchValuesOf(lotto, bonusNumber);

        return Rank.findBy(matchingCount, matchBonus);
    }
}
