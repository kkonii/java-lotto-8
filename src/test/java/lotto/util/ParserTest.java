package lotto.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParserTest {

    @Nested
    @DisplayName("정수 변환 테스트")
    class 숫자_변환 {

        @ParameterizedTest
        @ValueSource(strings = {"-12", "+12"})
        void 숫자_형식의_입력값을_정수_타입으로_변환한다(String inputValue) {
            // when
            int result = Parser.toInteger(inputValue);

            // then
            Assertions.assertThat(result).isInstanceOf(Integer.class);
        }
    }
}
