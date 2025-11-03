package lotto.domain;

import java.util.EnumMap;
import java.util.List;

public class StatisticCalculator {

    public EnumMap<Rank, Integer> summarizeCountOf(List<Rank> ranks) {
        EnumMap<Rank, Integer> rankRepository = Rank.from();
        ranks.forEach(rank -> rankRepository.merge(rank, 1, Integer::sum));

        return rankRepository;
    }
}
