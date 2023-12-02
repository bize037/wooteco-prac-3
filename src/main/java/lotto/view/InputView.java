package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.constants.Message;
import lotto.common.validate.Validate;

public class InputView {
    private static String inputConsole() {
        String inputValue = Console.readLine();
        Validate.checkStringNotBlank(inputValue);
        return inputValue;
    }

    public static String inputBuyPrice() {
        System.out.println(Message.INPUT_BUY_PRICE.getMessage());
        return inputConsole();
    }

    public static String inputLottoNumber() {
        System.out.println(Message.INPUT_LOTTO_NUMBER.getMessage());
        return inputConsole();
    }

    public static String inputBonusNumber() {
        System.out.println(Message.INPUT_BONUS_NUMBER.getMessage());
        return inputConsole();
    }
}
