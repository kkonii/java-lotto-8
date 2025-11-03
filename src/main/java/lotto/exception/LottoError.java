package lotto.exception;

public enum LottoError {

    AMOUNT_BELOW_MINIMUM("구매금액은 최소 %,d원이어야 합니다."),
    NOT_REQUIRED_AMOUNT_UNIT("구매금액은 %,d원 단위여야 합니다."),
    AMOUNT_EXCEED_MAXIMUM("최대 구매금액은 %,d원입니다."),

    NUMBER_COUNTS_ARE_NOT_MATCH("번호의 갯수는 %d개여야 합니다."),
    NUMBERS_ARE_NOT_UNIQUE("번호는 서로 중복되지 않아야 합니다."),
    OUT_OF_BOUNDS("번호는 %d에서 %d 사이의 숫자여야 합니다."),

    BONUS_ARE_NOT_UNIQUE("보너스 번호는 당첨 번호와 중복되지 않아야 합니다");

    private final String message;

    LottoError(String message) {
        this.message = message;
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
