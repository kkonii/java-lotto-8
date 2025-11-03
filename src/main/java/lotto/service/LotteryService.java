package lotto.service;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Optional;
import lotto.domain.LottoMatcher;
import lotto.domain.StatisticCalculator;
import lotto.domain.rule.Rank;
import lotto.domain.vo.PurchaseAmount;
import lotto.domain.vo.lotto.Lotto;
import lotto.domain.vo.winning.BonusNumber;
import lotto.domain.vo.winning.WinningNumber;
import lotto.dto.StatisticDto;
import lotto.dto.mapper.DtoMapper;

public class LotteryService {

    private final LottoMatcher lottoMatcher;
    private final StatisticCalculator statisticCalculator;

    public LotteryService(LottoMatcher lottoMatcher, StatisticCalculator statisticCalculator) {
        this.lottoMatcher = lottoMatcher;
        this.statisticCalculator = statisticCalculator;
    }

    public StatisticDto statisticsWith(PurchaseAmount purchaseAmount, List<Lotto> lottos,
                                       WinningNumber winningNumbers, BonusNumber bonus) {
        List<Rank> ranks = new ArrayList<>();

        lottos.forEach(lotto -> {
            Optional<Rank> rank = findRankWith(lotto, winningNumbers, bonus);
            rank.ifPresent(ranks::add);
        });

        EnumMap<Rank, Integer> statisticSummary = statisticCalculator.summarizeCountOf(ranks);
        double profitRate = statisticCalculator.profitRate(purchaseAmount.getValue(), statisticSummary);

        return DtoMapper.from(statisticSummary, profitRate);
    }

    public Optional<Rank> findRankWith(Lotto lotto, WinningNumber winningNumber,
                                       BonusNumber bonusNumber) {
        int matchingCount = lottoMatcher.findMatchingCount(lotto, winningNumber);
        boolean matchBonus = lottoMatcher.containValueOf(lotto, bonusNumber);

        return Rank.findBy(matchingCount, matchBonus);
    }
}
