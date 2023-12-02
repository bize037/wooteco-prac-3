package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import lotto.common.constants.Rule;

public class Ticket {
    private final List<Integer> ticketNumber;

    public Ticket() {
        this.ticketNumber = generateTicketNumbers();
    }

    public List<Integer> getTicketNumber() {
        Collections.sort(ticketNumber);
        return ticketNumber;
    }

    private List<Integer> generateTicketNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                Rule.MIN_LOTTO_NUMBER.getRule(),
                Rule.MAX_LOTTO_NUMBER.getRule(),
                Rule.LOTTO_NUMBER_COUNT.getRule());
    }
}
