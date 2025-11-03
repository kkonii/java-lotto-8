package lotto.domain.vo.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.LottoError;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Nested
    @DisplayName("로또 번호 유효성 검증")
    class validation {

        @Test
        void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
        @Test
        void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 제한된_범위를_벗어난_숫자가_있으면_범위를_안내하는_예외가_발생한다() {
            Assertions.assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 100)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(LottoError.OUT_OF_BOUNDS.messageOf(1, 45));
        }
    }

    @Test
    void 번호를_오름차순_정렬하여_반환한다() {
        //given
        Lotto lotto = new Lotto(List.of(12, 40, 1, 2, 8, 9));
        //when
        List<Integer> sortedNumbers = lotto.sortByAscending();
        //then
        Assertions.assertThat(sortedNumbers).containsExactly(1, 2, 8, 9, 12, 40);
    }
}
