package lotto.exception;

public enum GlobalError {

    NOT_A_NUMBER("숫자 값만 입력할 수 있습니다."),
    OUT_OF_INTEGER_RANGE("숫자의 입력값이 너무 큽니다. 처리 가능한 범위를 초과했습니다."),
    INPUT_IS_BLANK("입력값이 비어있습니다."),
    NUMBER_INPUT_FORMAT_IS_NOT_VALID("올바르지 않은 형식입니다. 숫자와 ,로 구분하여 입력해 주세요.");

    private final String message;

    GlobalError(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
