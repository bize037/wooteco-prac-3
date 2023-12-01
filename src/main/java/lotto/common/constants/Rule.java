package lotto.common.constants;

public enum Rule {
    TICKET_PRICE(1000),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    LOTTO_TOTAL_NUMBER(6);
    
    private final int rule;

    Rule(int message) {
        this.rule = message;
    }

    public int getRule() {
        return rule;
    }
}
