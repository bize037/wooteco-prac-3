package lotto.common.constants;

public enum Rule {
    TICKET_PRICE(1000),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    LOTTO_NUMBER_COUNT(6);

    private final int rule;

    Rule(int rule) {
        this.rule = rule;
    }

    public int getRule() {
        return rule;
    }
}
