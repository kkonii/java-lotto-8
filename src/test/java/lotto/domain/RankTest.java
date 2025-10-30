package lotto.domain;

import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RankTest {

    @ParameterizedTest
    @CsvSource({
            "5, true, SECOND",
            "5, false, THIRD",
            "6, true, FIRST",
            "6, false, FIRST",
            "4, false, FOURTH"
    })
    void 일치하는_숫자_갯수에_해당하는_등수를_반환한다(int matchingCount, boolean matchBonus, Rank expected) {
        //when
        Optional<Rank> rank = Rank.findBy(matchingCount, matchBonus);
        //then
        Assertions.assertThat(rank.get()).isEqualTo(expected);
    }
}
