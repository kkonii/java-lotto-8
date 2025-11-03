package lotto.domain.vo.winning;

import java.util.List;
import lotto.domain.rule.LotteryPolicy;

public class WinningNumber extends LotteryPolicy {

    private final List<Integer> numbers;

    public WinningNumber(List<Integer> numbers) {
        validateAll(numbers);
        this.numbers = numbers;
    }

    public List<Integer> asList() {
        return List.copyOf(numbers);
    }
}
