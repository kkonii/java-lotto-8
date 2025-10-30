package lotto.exception;

public enum LottoError {

    NUMBER_COUNTS_ARE_NOT_MATCH("로또 번호는 %d개여야 합니다."),
    NUMBERS_ARE_NOT_UNIQUE("로또 번호는 중복되지 않아야 합니다."),
    OUT_OF_BOUNDS("로또 번호는 %d에서 %d 사이의 숫자여야 합니다.");

    private static final String HEADER = "[ERROR] ";

    private final String message;

    LottoError(String message) {
        this.message = HEADER.concat(message);
    }

    public String message() {
        return message;
    }

    public String messageOf(int number) {
        return String.format(message, number);
    }

    public String messageOf(int startInclusive, int endInclusive) {
        return String.format(message, startInclusive, endInclusive);
    }
}
