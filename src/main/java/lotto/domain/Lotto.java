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

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        Validate.checkListNotSameSize(Rule.LOTTO_NUMBER_COUNT.getRule(), numbers);
        Validate.checkListNotSameNumber(numbers);
        validateNumber(numbers);
    }

    private void validateNumber(List<Integer> numbers) {
        numbers.forEach(number -> {
            Validate.checkIntNotOutOfRange(Rule.MIN_LOTTO_NUMBER.getRule(), Rule.MAX_LOTTO_NUMBER.getRule(), number);
        });
    }
}
