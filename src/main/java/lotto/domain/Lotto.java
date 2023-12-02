package lotto.domain;

import java.util.List;
import lotto.common.constants.Rule;
import lotto.common.validate.Validate;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        Validate.checkListNotSameSize(Rule.LOTTO_NUMBER_COUNT.getRule(), numbers);
        numbers.forEach(number -> {
            validateNumber(number);
        });
    }

    private void validateNumber(int number) {
        Validate.checkIntNotOutOfRange(Rule.MIN_LOTTO_NUMBER.getRule(), Rule.MAX_LOTTO_NUMBER.getRule(), number);
    }
}
