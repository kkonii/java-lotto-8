package lotto.domain.vo.winning;

import java.util.List;
import lotto.domain.rule.LotteryPolicy;
import lotto.exception.LottoError;

public class BonusNumber extends LotteryPolicy {

    private final int number;

    public BonusNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    public static BonusNumber uniqueFrom(WinningNumber numbers, int number) {
        validateDuplicateOf(numbers, number);

        return new BonusNumber(number);
    }

    private static void validateDuplicateOf(WinningNumber numbers, int bonus) {
        List<Integer> numberValues = numbers.asList();

        if (numberValues.contains(bonus)) {
            throw new IllegalArgumentException(LottoError.BONUS_ARE_NOT_UNIQUE.message());
        }
    }

    public int getValue() {
        return number;
    }
}
