package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.vo.lotto.Lotto;
import lotto.domain.vo.winning.BonusNumber;
import lotto.domain.vo.winning.WinningNumber;

public class LottoMatcher {

    public int findMatchingCount(Lotto lotto, WinningNumber winningNumber) {
        List<Integer> lottoNumbers = lotto.asList();
        List<Integer> winningNumbers = winningNumber.asList();

        int summaryCount = lottoNumbers.size() + winningNumbers.size();
        Set<Integer> uniqueNumbers = removeDuplicateOf(lottoNumbers, winningNumbers);

        return summaryCount - uniqueNumbers.size();
    }

    private Set<Integer> removeDuplicateOf(List<Integer> lotto, List<Integer> winningNumbers) {
        Set<Integer> removeDuplicate = new HashSet<>();

        removeDuplicate.addAll(lotto);
        removeDuplicate.addAll(winningNumbers);

        return removeDuplicate;
    }

    public boolean containValueOf(Lotto lotto, BonusNumber bonusNumber) {
        List<Integer> lottoNumbers = lotto.asList();
        int numberValue = bonusNumber.getValue();

        return lottoNumbers.contains(numberValue);
    }
}
