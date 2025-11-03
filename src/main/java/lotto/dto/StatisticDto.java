package lotto.dto;

import java.util.EnumMap;
import lotto.domain.rule.Rank;

public record StatisticDto(EnumMap<Rank, Integer> statisticSummary, double profitRate) {
}
