package lotto.common.validate;

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

    public static void checkStringNotSpecifiedUnitNumber(int unit, String input) {
        if (Integer.parseInt(input) % unit != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_SPECIFIED_UNIT_NUMBER.getMessage());
        }
    }
}
