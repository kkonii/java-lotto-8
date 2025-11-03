package lotto.util;

import lotto.exception.GlobalError;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {

    @Nested
    @DisplayName("[검증] 예외 발생 테스트")
    class validation_error {

        @Nested
        @DisplayName("형식과 범위에 대한 예외")
        class 형식_범위 {

            @ParameterizedTest
            @ValueSource(strings = {"char", "number", "숫자", "###", "☺️"})
            void 숫자_형식이_아닌_값에_대해_예외를_발생한다(String value) {
                Assertions.assertThatThrownBy(() -> InputValidator.numericType(value))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(GlobalError.NOT_A_NUMBER.message());
            }

            @ParameterizedTest
            @ValueSource(strings = {"-2147483649", "1000000000000000"})
            void 정수_범위를_벗어난_값에_대해_예외를_발생한다(String value) {
                Assertions.assertThatThrownBy(() -> InputValidator.rangeOf(value))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContainingAll(GlobalError.OUT_OF_INTEGER_RANGE.message());
            }
        }

        @Nested
        @DisplayName("공백과 null에 대한 예외")
        class 비어있는_값 {

            @ParameterizedTest
            @ValueSource(strings = {"   ", "", "\t", "\n"})
            void 공백으로_이루어진_값에_대해_예외를_발생한다(String value) {
                Assertions.assertThatThrownBy(() -> InputValidator.blankValue(value))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContainingAll(GlobalError.INPUT_IS_BLANK.message());
            }

            @ParameterizedTest
            @NullSource
            void null_값에_대해_예외를_발생한다(String value) {
                Assertions.assertThatThrownBy(() -> InputValidator.blankValue(value))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContainingAll(GlobalError.INPUT_IS_BLANK.message());
            }
        }

        @Nested
        @DisplayName("당첨 번호 입력 형식에 대한 예외")
        class 번호_입력_형식 {

            @ParameterizedTest
            @ValueSource(strings = {",1,2", "2,", "3, 4, 6", "5, 6,,"})
            void 올바르지_않은_형식의_값에_대해_예외를_발생한다(String value) {
                Assertions.assertThatThrownBy(() -> InputValidator.numberInputFormat(value))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(GlobalError.NUMBER_INPUT_FORMAT_IS_NOT_VALID.message());
            }
        }
    }

    @Nested
    @DisplayName("[검증] 통과 테스트")
    class validation_success {

        @ParameterizedTest
        @ValueSource(strings = {"-2147483648", "2147483647"})
        void 정수_범위_내의_값은_검증을_통과한다(String value) {
            org.junit.jupiter.api.Assertions.assertDoesNotThrow(() -> InputValidator.rangeOf(value));
        }

        @ParameterizedTest
        @ValueSource(strings = {"-12", "+2", "0", "54"})
        void 숫자_형식의_입력값은_검증을_통과한다(String value) {
            org.junit.jupiter.api.Assertions.assertDoesNotThrow(() -> InputValidator.numericType(value));
        }

        @ParameterizedTest
        @ValueSource(strings = {"1,2,3", "4", " 5,6 "})
        void 올바른_형식의_당첨번호_입력은_검증을_통과한다(String value) {
            org.junit.jupiter.api.Assertions.assertDoesNotThrow(() -> InputValidator.numberInputFormat(value));
        }
    }
}
