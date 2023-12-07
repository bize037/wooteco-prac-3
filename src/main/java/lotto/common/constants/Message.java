package lotto.common.constants;

public enum Message {
    INPUT_BUY_PRICE("구입금액을 입력해 주세요."),
    OUTPUT_TICKET_COUNT("개를 구매했습니다."),
    INPUT_LOTTO_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    OUTPUT_PRIZE_STAT("당첨 통계"),
    OUTPUT_PROFIT_RATE("총 수익률은 %d%입니다.");
    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
