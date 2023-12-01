package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import lotto.common.constants.ErrorMessage;
import lotto.common.constants.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BuyerTest {
    @DisplayName("티켓 매수가 정상적으로 저장되는가")
    @ValueSource(strings = {"1000", "2000", "10000", "32000"})
    @ParameterizedTest
    void inputBuyPriceTest(String inputBuyPrice) {
        Buyer buyer = new Buyer(inputBuyPrice);
        int ticketCount = Integer.parseInt(inputBuyPrice) / Rule.TICKET_PRICE.getRule();
        assertThat(buyer.getTicketCount()).isEqualTo(ticketCount);
    }

    @DisplayName("숫자 외의 값을 입력할 시 예외 처리 되는가")
    @ValueSource(strings = {"-1000", "1000d", "asdf000", "zcxv"})
    @ParameterizedTest
    void buyPriceValidateNotNumberTest(String inputBuyPrice) {
        assertThatThrownBy(() -> new Buyer(inputBuyPrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_NUMBER.getMessage());
    }

    @DisplayName("1000원 이하의 값을 입력할 시 예외 처리 되는가")
    @ValueSource(strings = {"0", "500", "999"})
    @ParameterizedTest
    void buyPriceValidateLowerThanBaseNumberTest(String inputBuyPrice) {
        assertThatThrownBy(() -> new Buyer(inputBuyPrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOWER_THAN_BASE_NUMBER.getMessage());
    }

    @DisplayName("입력한 값이 1000원 단위가 아니라면 예외 처리 되는가")
    @ValueSource(strings = {"1234", "120001", "3400"})
    @ParameterizedTest
    void buyPriceValidateNotSpecifiedUnitNumberTest(String inputBuyPrice) {
        assertThatThrownBy(() -> new Buyer(inputBuyPrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_SPECIFIED_UNIT_NUMBER.getMessage());
    }
}
