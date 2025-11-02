package lotto.service;

import java.util.EnumMap;
import java.util.List;
import java.util.Optional;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoCalculator;
import lotto.domain.Rank;
import lotto.domain.WinningNumber;

public class LotteryService {

    private final LottoCalculator lottoCalculator;

    public LotteryService(LottoCalculator lottoCalculator) {
        this.lottoCalculator = lottoCalculator;
    }

    public EnumMap<Rank, Integer> statisticsWith(List<Lotto> lottos, WinningNumber winningNumbers, BonusNumber bonus) {
        EnumMap<Rank, Integer> rankRepository = Rank.from();

        lottos.forEach(lotto -> {
            Optional<Rank> rank = lottoCalculator.findRankWith(lotto, winningNumbers, bonus);
            if (rank.isPresent()) {
                rankRepository.merge(rank.get(), 1, Integer::sum);
            }
        });
        return rankRepository;
    }
}
