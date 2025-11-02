package lotto.fixture;

import java.util.EnumMap;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Rank;
import org.junit.jupiter.params.provider.Arguments;

public class Provider {

    //각 등수가 한 번씩 당첨되도록 주입하는 argument
    public static Stream<Arguments> numberArgumentsOfRank() {
        return Stream.of(
                //Rank.FIFTH
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 9, 10, 11), 4, Rank.FIFTH),
                //Rank.FOURTH
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 5, 8, 9), 4, Rank.FOURTH),
                //Rank.THIRD
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 5, 6, 8), 7, Rank.THIRD),
                //Rank.SECOND
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 5, 6, 8), 4, Rank.SECOND),
                //Rank.FIRST
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6), 22, Rank.FIRST)
        );
    }

    public static Stream<Arguments> argumentsOfStatistics() {
        int purchaseAmount = 8_000;

        //첫 번째 통계
        EnumMap<Rank, Integer> statistic1 = new EnumMap<>(Rank.class);
        statistic1.put(Rank.FIRST, 1);
        int prizeSummary1 = 2_000_000_000;
        float profitRate1 = (float) prizeSummary1 / purchaseAmount * 100;

        //두 번째 통계
        EnumMap<Rank, Integer> statistic2 = new EnumMap<>(Rank.class);
        statistic2.put(Rank.THIRD, 1);
        statistic2.put(Rank.FOURTH, 1);
        int prizeSummary2 = 1_550_000;
        float profitRate2 = (float) prizeSummary2 / purchaseAmount * 100;

        //세 번째 통계
        EnumMap<Rank, Integer> statistic3 = new EnumMap<>(Rank.class);
        statistic3.put(Rank.FIFTH, 1);
        int prizeSummary3 = 5_000;
        float profitRate3 = (float) prizeSummary3 / purchaseAmount * 100;

        return Stream.of(
                Arguments.of(statistic1, profitRate1),
                Arguments.of(statistic2, profitRate2),
                Arguments.of(statistic3, profitRate3)
        );
    }
}
