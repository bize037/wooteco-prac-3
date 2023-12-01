package lotto.common.constants;

public enum ErrorMessage {
    NOT_BLANK("아무것도 입력되지 않았습니다."),
    NOT_NUMBER("숫자 외의 입력값이 존재합니다."),
    LOWER_THAN_BASE_NUMBER("기준 금액보다 낮습니다."),
    NOT_SPECIFIED_UNIT_NUMBER("지정된 숫자 단위에서 벗어났습니다."),
    NOT_OUT_OF_RANGE("지정된 숫자 범위에서 벗어났습니다."),
    NOT_SAME_SIZE("기대하는 리스트 길이가 아닙니다."),
    NOT_SAME_VALUE("중복된 값이 있습니다.");

    private static final String START_WORD = "[ERROR]";
    private static final String SPACE = " ";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return START_WORD + SPACE + message;
    }
}
