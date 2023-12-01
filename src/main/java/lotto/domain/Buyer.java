package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.common.validate.Validate;

public class Buyer {
    private Ticket ticket = new Ticket();

    private final int ticketCount;
    private final List<List<Integer>> purchaseTickets;

    public Buyer(String buyPrice) {
        validateStringBuyPrice(buyPrice);
        this.ticketCount = Integer.parseInt(buyPrice) / 1000;
        this.purchaseTickets = addPurchaseTickets(ticket);
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public List<List<Integer>> getPurchaseTickets() {
        return purchaseTickets;
    }

    private List<List<Integer>> addPurchaseTickets(Ticket ticket) {
        List<List<Integer>> newPurchaseTickets = new ArrayList<>();
        for (int count = 0; count < getTicketCount(); count++) {
            newPurchaseTickets.add(ticket.getTicketNumber());
        }
        return newPurchaseTickets;
    }

    // 예외 처리 메서드
    private void validateStringBuyPrice(String buyPrice) {
        Validate.checkStringNotBlank(buyPrice);
        Validate.checkStringNotNumber(buyPrice);
        Validate.checkStringLowerThanBaseNumber(1000, buyPrice);
        Validate.checkStringNotSpecifiedUnitNumber(1000, buyPrice);
    }
}
