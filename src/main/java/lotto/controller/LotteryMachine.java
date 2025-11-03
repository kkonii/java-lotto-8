package lotto.controller;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.WinningNumber;
import lotto.domain.vo.PurchaseAmount;
import lotto.dto.LottoDto;
import lotto.dto.StatisticDto;
import lotto.dto.mapper.DtoMapper;
import lotto.service.LotteryService;
import lotto.util.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LotteryMachine {

    private final LottoFactory lottoFactory;
    private final LotteryService lotteryService;
    private final InputView inputView;
    private final OutputView outputView;
    private final RetryHandler retryHandler;

    public LotteryMachine(LottoFactory lottoFactory, LotteryService lotteryService,
                          InputView inputView, OutputView outputView, RetryHandler retryHandler) {
        this.lottoFactory = lottoFactory;
        this.lotteryService = lotteryService;
        this.inputView = inputView;
        this.outputView = outputView;
        this.retryHandler = retryHandler;
    }

    public void run() {
        PurchaseAmount purchaseAmount = retryHandler.run(this::requestPurchaseAmount);
        List<Lotto> randomLottos = retryHandler.run(() -> createRandomLottos(purchaseAmount));

        WinningNumber winningNumber = retryHandler.run(this::requestWinningNumber);
        BonusNumber bonus = retryHandler.run(() -> requestBonus(winningNumber));

        StatisticDto statistic = lotteryService.statisticsWith(purchaseAmount, randomLottos, winningNumber, bonus);
        outputView.printHeader();
        outputView.printWinningResult(statistic);
    }

    private PurchaseAmount requestPurchaseAmount() {
        String amountInput = inputView.getAmountInput();
        int parsedAmount = Parser.toInteger(amountInput);

        return new PurchaseAmount(parsedAmount);
    }

    private List<Lotto> createRandomLottos(PurchaseAmount purchaseAmount) {
        int count = purchaseAmount.toTicketCount();
        List<Lotto> lottos = lottoFactory.makeFor(count);

        List<LottoDto> lottoDtos = DtoMapper.of(lottos);
        outputView.printPurchasedLottos(lottoDtos);

        return lottos;
    }

    private WinningNumber requestWinningNumber() {
        String numbersInput = inputView.getWinningNumberInput();
        List<Integer> parsedNumbers = Parser.toNumbers(numbersInput);

        return new WinningNumber(parsedNumbers);
    }

    private BonusNumber requestBonus(WinningNumber winningNumber) {
        String numberInput = inputView.getBonusInput();
        int parsedNumber = Parser.toInteger(numberInput);

        return BonusNumber.uniqueFrom(winningNumber, parsedNumber);
    }
}
