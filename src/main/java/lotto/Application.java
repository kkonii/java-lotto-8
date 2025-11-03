package lotto;

import lotto.config.DependencyConfig;
import lotto.controller.LotteryMachine;

public class Application {
    public static void main(String[] args) {
        LotteryMachine lotteryMachine = new DependencyConfig().lotteryMachine();
        lotteryMachine.run();
    }
}
