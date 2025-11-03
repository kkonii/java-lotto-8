package lotto.dto;

import java.util.EnumMap;
import lotto.domain.Rank;

public record StatisticDto(EnumMap<Rank, Integer> statisticSummary, float profitRate) {
}
