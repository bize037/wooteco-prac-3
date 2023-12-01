package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import lotto.common.constants.ErrorMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BuyerTest {
    @ValueSource(strings = {"1000", "2000", "10000", "32000"})
    @ParameterizedTest
    void inputBuyPriceTest(String inputBuyPrice) {
        Buyer buyer = new Buyer(inputBuyPrice);
        int ticketCount = Integer.parseInt(inputBuyPrice) / 1000;
        assertThat(buyer.getTicketCount()).isEqualTo(ticketCount);
    }

    @ValueSource(strings = {"", " "})
    @ParameterizedTest
    void buyPriceValidateNotBlankTest(String inputBuyPrice) {
        assertThatThrownBy(() -> new Buyer(inputBuyPrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_BLANK.getMessage());
    }

    @ValueSource(strings = {"-1000", "1000d", "asdf000", "zcxv"})
    @ParameterizedTest
    void buyPriceValidateNotNumberTest(String inputBuyPrice) {
        assertThatThrownBy(() -> new Buyer(inputBuyPrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_NUMBER.getMessage());
    }

    @ValueSource(strings = {"0", "500", "999"})
    @ParameterizedTest
    void buyPriceValidateLowerThanBaseNumberTest(String inputBuyPrice) {
        assertThatThrownBy(() -> new Buyer(inputBuyPrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOWER_THAN_BASE_NUMBER.getMessage());
    }

    @ValueSource(strings = {"1234", "120001", "3400"})
    @ParameterizedTest
    void buyPriceValidateNotSpecifiedUnitNumberTest(String inputBuyPrice) {
        assertThatThrownBy(() -> new Buyer(inputBuyPrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_SPECIFIED_UNIT_NUMBER.getMessage());
    }
}
