package lotto.domain;

import java.util.EnumMap;
import java.util.List;

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
}
