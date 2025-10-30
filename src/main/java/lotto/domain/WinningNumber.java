package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.LottoError;

public class WinningNumber {

    private static final int FIXED_COUNT = 6;
    private static final int MINIMUM_BOUND = 1;
    private static final int MAXIMUM_BOUND = 45;

    private final List<Integer> numbers;

    public WinningNumber(List<Integer> numbers) {
        validateCountOf(numbers);
        validateUnique(numbers);
        numbers.forEach(this::validateRange);
        this.numbers = numbers;
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

    private void validateRange(int number) {
        if (number < MINIMUM_BOUND || number > MAXIMUM_BOUND) {
            throw new IllegalArgumentException("");
        }
    }

    public List<Integer> asList() {
        return List.copyOf(numbers);
    }
}
