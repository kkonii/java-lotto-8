package lotto.domain.vo.lotto;

import java.util.List;
import lotto.domain.rule.LotteryPolicy;

public class Lotto extends LotteryPolicy {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateAll(numbers);
        this.numbers = numbers;
    }

    public List<Integer> sortByAscending() {
        return numbers.stream()
                .sorted()
                .toList();
    }

    public List<Integer> asList() {
        return List.copyOf(numbers);
    }
}
