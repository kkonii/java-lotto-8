package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import lotto.domain.rule.Rank;

public class StatisticCalculator {

    public EnumMap<Rank, Integer> summarizeCountOf(List<Rank> ranks) {
        EnumMap<Rank, Integer> rankRepository = initRepository();
        ranks.forEach(rank -> rankRepository.merge(rank, 1, Integer::sum));

        return rankRepository;
    }

    private EnumMap<Rank, Integer> initRepository() {
        EnumMap<Rank, Integer> repository = new EnumMap<>(Rank.class);

        for (Rank rank : Rank.values()) {
            repository.put(rank, 0);
        }

        return repository;
    }

    public float profitRate(int purchaseAmount, EnumMap<Rank, Integer> winningStatistics) {
        long prize = winningStatistics.entrySet()
                .stream()
                .mapToLong(statistic -> (long) statistic.getKey().prizeMoney() * statistic.getValue())
                .sum();

        return (float) prize / purchaseAmount * 100;
    }
}
