package lotto.util;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParserTest {

    @ParameterizedTest
    @ValueSource(strings = {"-12", "+12"})
    void 숫자_형식의_입력값을_정수_타입으로_변환한다(String inputValue) {
        // when
        int result = Parser.toInteger(inputValue);

        // then
        Assertions.assertThat(result).isInstanceOf(Integer.class);
    }

    @Test
    void 구분자로_나열된_입력값을_숫자_리스트로_반환한다() {
        //given
        String inputValue = "1,2,5,6,4";
        List<Integer> numbers = Parser.toNumbers(inputValue);

        //then
        org.assertj.core.api.Assertions.assertThat(numbers).containsExactly(1, 2, 5, 6, 4);
    }
}
