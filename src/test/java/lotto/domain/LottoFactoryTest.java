package lotto.domain;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoFactoryTest {

    @Test
    void 입력된_갯수만큼의_로또를_생성한다() {
        //given
        LottoFactory lottoMachine = new LottoFactory(new RandomPicker());
        //when
        int count = 3;
        List<Lotto> lottos = lottoMachine.makeFor(count);
        //then
        Assertions.assertEquals(lottos.size(), count);
    }
}
