package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.constants.Message;
import lotto.common.validate.Validate;

public class InputView {
    private final static String NEW_LINE = System.lineSeparator();
    public static String inputConsole() {
        String inputValue = Console.readLine();
        Validate.checkStringNotBlank(inputValue);
        return inputValue;
    }

    public static void inputBuyPrice() {
        System.out.println(Message.INPUT_BUY_PRICE.getMessage());
    }

    public static void inputLottoNumber() {
        System.out.println(NEW_LINE + Message.INPUT_LOTTO_NUMBER.getMessage());
    }

    public static void inputBonusNumber() {
        System.out.println(NEW_LINE + Message.INPUT_BONUS_NUMBER.getMessage());
    }
}
