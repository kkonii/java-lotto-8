package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {

    private final RandomPicker randomPicker;

    public LottoFactory(RandomPicker randomPicker) {
        this.randomPicker = randomPicker;
    }

    public List<Lotto> makeFor(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(make());
        }

        return lottos;
    }

    private Lotto make() {
        return new Lotto(randomPicker.uniqueNumbers());
    }
}
