package lotto.domain;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class LottoCalculator {

    public int compareOf(Lotto lotto, WinningNumber winningNumber) {
        List<Integer> lottoNumbers = lotto.asList();
        List<Integer> winningNumbers = winningNumber.asList();

        return findMatchingCount(lottoNumbers, winningNumbers);
    }

    private int findMatchingCount(List<Integer> lotto, List<Integer> winningNumbers) {
        int summaryCount = lotto.size() + winningNumbers.size();
        Set<Integer> uniqueNumbers = removeDuplicateOf(lotto, winningNumbers);

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

    public Optional<Rank> statisticsWith(Lotto lotto, WinningNumber winningNumber,
                                         BonusNumber bonusNumber) {
        EnumMap<Rank, Integer> rankRepository = Rank.from();

        int matchingCount = compareOf(lotto, winningNumber);
        boolean matchBonus = matchValuesOf(lotto, bonusNumber);

        Optional<Rank> rank = Rank.findBy(matchingCount, matchBonus);
        if (rank.isPresent()) {
            rankRepository.merge(rank.get(), 1, Integer::sum);
        }
        return rank;
    }
}
