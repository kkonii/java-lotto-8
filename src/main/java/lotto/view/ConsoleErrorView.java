package lotto.view;

public class ConsoleErrorView {

    private static final String HEADER = "[ERROR] ";

    public void print(String message) {
        System.out.println(HEADER.concat(message));
    }
}
