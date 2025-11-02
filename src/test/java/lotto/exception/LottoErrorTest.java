package lotto.exception;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoErrorTest {

    @Test
    void 예외_객체는_문구_앞에_헤더가_붙은_문자열을_리턴한다() {
        //given
        LottoError error = LottoError.NUMBERS_ARE_NOT_UNIQUE;
        //when
        String exceptionMessage = error.message();
        //then
        Assertions.assertThat(exceptionMessage)
                .startsWith("[ERROR] ");
    }
}
