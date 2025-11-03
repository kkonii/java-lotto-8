package lotto;

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

public class Application {
    public static void main(String[] args) {
        RandomPicker picker = new RandomPicker();
        LottoFactory lottoFactory = new LottoFactory(picker);

        LottoMatcher lottoMatcher = new LottoMatcher();
        StatisticCalculator statistics = new StatisticCalculator();
        LotteryService lotteryService = new LotteryService(lottoMatcher, statistics);

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        ConsoleErrorView errorView = new ConsoleErrorView();
        RetryHandler retryHandler = new RetryHandler(errorView);

        LotteryMachine lottoMachine = new LotteryMachine(lottoFactory, lotteryService,
                inputView, outputView, retryHandler);
        lottoMachine.run();
    }
}
