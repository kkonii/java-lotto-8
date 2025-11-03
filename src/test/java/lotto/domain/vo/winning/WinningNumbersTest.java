package lotto.domain.vo.winning;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.vo.lotto.Lotto;
import lotto.exception.LottoError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {

    @Nested
    @DisplayName("당첨 번호의 유효성 검증 테스트")
    class validation {

        @Test
        void 입력한_당첨_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(LottoError.NUMBER_COUNTS_ARE_NOT_MATCH.messageOf(6));
        }

        @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
        @Test
        void 입력한_당첨_번호에_중복된_숫자가_있으면_예외가_발생한다() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(LottoError.NUMBERS_ARE_NOT_UNIQUE.message());
        }

        @Test
        void 제한된_범위를_벗어난_숫자가_있으면_예외가_발생한다() {
            Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new Lotto(List.of(1, 2, 3, 4, 5, 77)));
        }
    }
}
