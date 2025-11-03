package lotto.domain;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoCalculator {

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

    public boolean matchValuesOf(Lotto lotto, BonusNumber bonusNumber) {
        List<Integer> lottoNumbers = lotto.asList();
        int numberValue = bonusNumber.getValue();

        return lottoNumbers.contains(numberValue);
    }

    public float profitRate(int purchaseAmount, EnumMap<Rank, Integer> winningStatistics) {
        long prize = winningStatistics.entrySet()
                .stream()
                .mapToLong(statistic -> (long) statistic.getKey().prizeMoney() * statistic.getValue())
                .sum();

        return (float) prize / purchaseAmount * 100;
    }
}
