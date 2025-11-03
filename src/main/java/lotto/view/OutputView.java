package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.rule.Rank;
import lotto.dto.LottoDto;
import lotto.dto.StatisticDto;

public class OutputView {

    private static final String PURCHASE_AMOUNT_IS = "%d개를 구매했습니다.";

    private static final String HEADER = "당첨 통계";
    private static final String LEADER_LINE = "---";

    private static final String MATCHING_COUNT_IS = "%d개 일치";
    private static final String BONUS_MATCH = ", 보너스 볼 일치";
    private static final String PRIZE_MONEY = " (%,d원)";
    private static final String WINNING_COUNT_IS = " - %d개";

    private static final String PROFIT_RATE_IS = "총 수익률은 %,.1f%%입니다.";

    public void printPurchasedLottos(List<LottoDto> lottos) {
        System.out.println();
        System.out.printf(PURCHASE_AMOUNT_IS, lottos.size());
        System.out.println();
        for (LottoDto lotto : lottos) {
            System.out.println(lotto.numbers());
        }
        System.out.println();
    }

    public void printHeader() {
        System.out.println();
        System.out.println(HEADER);
        System.out.println(LEADER_LINE);
    }

    public void printWinningResult(StatisticDto dto) {
        for (Map.Entry<Rank, Integer> statistic : dto.statisticSummary().entrySet()) {
            Rank rank = statistic.getKey();

            System.out.printf(MATCHING_COUNT_IS, rank.matchingCount());
            if (rank == Rank.SECOND) {
                System.out.print(BONUS_MATCH);
            }
            System.out.printf(PRIZE_MONEY, rank.prizeMoney());
            System.out.printf(WINNING_COUNT_IS, statistic.getValue());
            System.out.println();
        }
        printProfitRate(dto.profitRate());
    }

    private void printProfitRate(double value) {
        System.out.printf(PROFIT_RATE_IS, value);
    }
}
