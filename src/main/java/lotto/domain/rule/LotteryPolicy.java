package lotto.domain.rule;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.LottoError;

public abstract class LotteryPolicy {

    protected static final int FIXED_COUNT = 6;
    protected static final int MINIMUM_BOUND = 1;
    protected static final int MAXIMUM_BOUND = 45;

    protected void validateAll(List<Integer> numbers) {
        validateCountOf(numbers);
        validateUnique(numbers);
        numbers.forEach(this::validateRange);
    }

    private void validateCountOf(List<Integer> numbers) {
        if (numbers.size() != FIXED_COUNT) {
            throw new IllegalArgumentException(LottoError.NUMBER_COUNTS_ARE_NOT_MATCH.messageOf(FIXED_COUNT));
        }
    }

    private void validateUnique(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(LottoError.NUMBERS_ARE_NOT_UNIQUE.message());
        }
    }

    protected void validateRange(int number) {
        if (number < MINIMUM_BOUND || number > MAXIMUM_BOUND) {
            throw new IllegalArgumentException(LottoError.OUT_OF_BOUNDS.messageOf(MINIMUM_BOUND, MAXIMUM_BOUND));
        }
    }
}
