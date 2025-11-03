package lotto.view;

import java.util.List;
import lotto.dto.LottoDto;

public class OutputView {

    private static final String PURCHASE_AMOUNT_IS = "%d개를 구매했습니다.";

    public void printPurchasedLottos(int amount, List<LottoDto> lottos) {
        System.out.printf(PURCHASE_AMOUNT_IS, amount);
        System.out.println();
        for (LottoDto lotto : lottos) {
            System.out.println(lotto.numbers());
        }
    }
}
