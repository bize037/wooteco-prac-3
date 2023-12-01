package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.validate.Validate;

public class InputView {
    private static String inputConsole() {
        String input = Console.readLine();
        Validate.checkStringNotBlank(input);
        return input;
    }
}
