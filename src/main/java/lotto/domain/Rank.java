package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Optional;

public enum Rank {

    FIFTH(5_000, 3),
    FOURTH(50_000, 4),
    THIRD(1_500_000, 5),
    SECOND(30_000_000, 5),
    FIRST(2_000_000_000, 6);

    private static final EnumMap<Rank, Integer> RANK_REPOSITORY = new EnumMap<>(Rank.class);

    private final int prizeMoney;
    private final int matchingCount;

    Rank(int prizeMoney, int matchingCount) {
        this.prizeMoney = prizeMoney;
        this.matchingCount = matchingCount;
    }

    public static Optional<Rank> findBy(int count, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchingCount == count)
                .map(rank -> matchBy(rank, matchBonus))
                .findFirst();
    }

    private static Rank matchBy(Rank rank, boolean matchBonus) {
        if (rank == SECOND || rank == THIRD) {
            return findBy(matchBonus);
        }
        return rank;
    }

    private static Rank findBy(boolean matchBonus) {
        if (matchBonus) {
            return SECOND;
        }
        return THIRD;
    }

    public static EnumMap<Rank, Integer> from() {
        for (Rank rank : Rank.values()) {
            RANK_REPOSITORY.put(rank, 0);
        }

        return RANK_REPOSITORY;
    }
}
