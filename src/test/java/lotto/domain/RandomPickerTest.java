package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomPickerTest {

    @Test
    void 지정된_갯수만큼의_난수를_반환한다() {
        //given
        RandomPicker picker = new RandomPicker();
        //when
        List<Integer> numbers = picker.uniqueNumbers();
        //then
        Assertions.assertEquals(numbers.size(), 6);
    }

    @Test
    void 반환된_난수들은_서로_중복되지_않는다() {
        //given
        List<Integer> numbers = new RandomPicker().uniqueNumbers();
        //when
        Set<Integer> toUnique = new HashSet<>(numbers);
        //then
        Assertions.assertEquals(toUnique.size(), numbers.size());
    }
}
