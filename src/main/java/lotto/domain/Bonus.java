package lotto.domain;

import lotto.common.constants.Rule;
import lotto.common.validate.Validate;

public class Bonus {
    private final int number;

    public Bonus(String number) {
        validateNumber(number);
        this.number = Integer.parseInt(number);
    }

    public int getNumber() {
        return number;
    }

    private void validateNumber(String number) {
        Validate.checkStringNotNumber(number);
        Validate.checkIntNotOutOfRange(Rule.MIN_LOTTO_NUMBER.getRule(), Rule.MAX_LOTTO_NUMBER.getRule(), Integer.parseInt(number));
    }
}
