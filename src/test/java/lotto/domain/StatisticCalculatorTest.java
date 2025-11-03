package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class StatisticCalculatorTest {

    @ParameterizedTest
    @MethodSource("lotto.fixture.Provider#argumentsCountOfRank")
    void 당첨된_등수_목록의_횟수를_집계하여_모두_반환한다(List<Rank> ranks, Map<Rank, Integer> expectedStatistic) {
        //given
        StatisticCalculator calculator = new StatisticCalculator();

        //when
        EnumMap<Rank, Integer> actualStatistic = calculator.summarizeCountOf(ranks);

        //then
        Assertions.assertEquals(actualStatistic, expectedStatistic);
    }
}
