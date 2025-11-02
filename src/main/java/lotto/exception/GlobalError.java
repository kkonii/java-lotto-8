package lotto.exception;

public enum GlobalError {

    NOT_A_NUMBER("숫자 값만 입력할 수 있습니다."),
    OUT_OF_INTEGER_RANGE("숫자의 입력값이 너무 큽니다. 처리 가능한 범위를 초과했습니다."),
    INPUT_IS_BLANK("입력값이 비어있습니다.");

    private static final String HEADER = "[ERROR] ";

    private final String message;

    GlobalError(String message) {
        this.message = HEADER.concat(message);
    }

    public String message() {
        return message;
    }
}
