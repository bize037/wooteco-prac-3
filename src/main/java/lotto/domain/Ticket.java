package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Ticket {
    private final List<Integer> ticketNumber;

    public Ticket() {
        this.ticketNumber = generateTicketNumbers();
    }

    public List<Integer> getTicketNumber() {
        return ticketNumber;
    }

    private List<Integer> generateTicketNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
