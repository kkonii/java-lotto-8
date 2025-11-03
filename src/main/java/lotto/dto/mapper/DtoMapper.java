package lotto.dto.mapper;

import java.util.EnumMap;
import java.util.List;
import lotto.domain.rule.Rank;
import lotto.domain.vo.lotto.Lotto;
import lotto.dto.LottoDto;
import lotto.dto.StatisticDto;

public class DtoMapper {

    public static List<LottoDto> of(List<Lotto> lottos) {
        return lottos.stream()
                .map(DtoMapper::of)
                .toList();
    }

    public static LottoDto of(Lotto lotto) {
        return new LottoDto(lotto.sortByAscending());
    }

    public static StatisticDto from(EnumMap<Rank, Integer> statistic, float rate) {
        return new StatisticDto(statistic, rate);
    }
}
