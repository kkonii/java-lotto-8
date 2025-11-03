package lotto.config;

import lotto.controller.LotteryMachine;
import lotto.controller.RetryHandler;
import lotto.domain.LottoFactory;
import lotto.domain.LottoMatcher;
import lotto.domain.StatisticCalculator;
import lotto.domain.rule.RandomPicker;
import lotto.service.LotteryService;
import lotto.view.ConsoleErrorView;
import lotto.view.InputView;
import lotto.view.OutputView;

public final class DependencyConfig {

    private final RandomPicker randomPicker = new RandomPicker();
    private final LottoFactory lottoFactory = new LottoFactory(randomPicker);

    private final LottoMatcher lottoMatcher = new LottoMatcher();
    private final StatisticCalculator statisticCalculator = new StatisticCalculator();
    private final LotteryService lotteryService = new LotteryService(lottoMatcher, statisticCalculator);

    private final ConsoleErrorView errorView = new ConsoleErrorView();
    private final RetryHandler retryHandler = new RetryHandler(errorView);

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public LotteryMachine lotteryMachine() {
        return new LotteryMachine(lottoFactory, lotteryService, inputView, outputView, retryHandler);
    }
}
