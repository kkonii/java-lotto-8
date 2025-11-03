package lotto.controller;

import java.util.function.Supplier;
import lotto.view.ConsoleErrorView;

public class RetryHandler {

    private final ConsoleErrorView errorView;

    public RetryHandler(ConsoleErrorView errorView) {
        this.errorView = errorView;
    }

    public <T> T run(Supplier<T> action) {
        while (true) {
            try {
                return action.get();
            } catch (IllegalArgumentException e) {
                errorView.print(e.getMessage());
            }
        }
    }
}
