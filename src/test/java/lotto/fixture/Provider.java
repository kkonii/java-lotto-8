package lotto.fixture;

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
}
