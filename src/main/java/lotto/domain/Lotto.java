package lotto.domain;

import java.util.List;
import lotto.common.constants.Rule;
import lotto.common.validate.Validate;

public record Lotto(List<Integer> numbers) {
    public Lotto {
        validateNumbers(numbers);
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
