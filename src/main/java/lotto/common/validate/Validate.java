package lotto.common.validate;

import java.util.List;
import lotto.common.constants.ErrorMessage;

public class Validate {
    public static void checkStringNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_BLANK.getMessage());
        }
    }

    public static void checkStringNotNumber(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
        }
    }

    public static void checkStringLowerThanBaseNumber(int baseNumber, String input) {
        if (Integer.parseInt(input) < baseNumber) {
            throw new IllegalArgumentException(ErrorMessage.LOWER_THAN_BASE_NUMBER.getMessage());
        }
    }

    public static void checkIntNotSpecifiedUnitNumber(int unit, int input) {
        if (input % unit != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_SPECIFIED_UNIT_NUMBER.getMessage());
        }
    }

    public static void checkIntNotOutOfRange(int minRange, int maxRange, int input) {
        if (input < minRange || input > maxRange) {
            throw new IllegalArgumentException(ErrorMessage.NOT_OUT_OF_RANGE.getMessage());
        }
    }

    public static void checkListNotSameSize(int expectSize, List<Integer> inputs) {
        if (inputs.size() != expectSize) {
            throw new IllegalArgumentException(ErrorMessage.NOT_SAME_SIZE.getMessage());
        }
    }

    public static void checkListNotSameNumber(List<Integer> inputs) {
        if (inputs.size() != inputs.stream().distinct().count()){
            throw new IllegalArgumentException(ErrorMessage.NOT_SAME_VALUE.getMessage());
        }
    }

    public static void checkListNotSameValue(int compareValue, List<Integer> numbers) {
        numbers.forEach(number -> {
            checkIntNotSameValue(number, compareValue);
        });
    }

    private static void checkIntNotSameValue(int compareValue1, int compareValue2) {
        if (compareValue1 == compareValue2) {
            throw new IllegalArgumentException(ErrorMessage.NOT_SAME_VALUE.getMessage());
        }
    }
}
