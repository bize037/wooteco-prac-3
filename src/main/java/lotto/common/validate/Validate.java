package lotto.common.validate;

public class Validate {
    public static void checkStringNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 아무것도 입력되지 않았습니다.");
        }
    }

    public static void checkStringNotNumber(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자 외의 입력값이 존재합니다.");
        }
    }

    public static void checkStringLowerThanBaseNumber(int baseNumber, String input) {
        if (Integer.parseInt(input) < baseNumber) {
            throw new IllegalArgumentException("[ERROR] 기준 금액보다 낮습니다.");
        }
    }

    public static void checkStringNotSpecifiedUnitNumber(int unit, String input) {
        if (Integer.parseInt(input) % unit != 0) {
            throw new IllegalArgumentException("[ERROR] 지정된 숫자 단위에서 벗어났습니다.");
        }
    }
}
