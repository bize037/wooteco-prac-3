package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.common.constants.Rule;
import lotto.common.validate.Validate;

public class Buyer {
    private Ticket ticket;

    private final int ticketCount;
    private final List<List<Integer>> purchaseTickets;

    public Buyer(String buyPrice) {
        validateStringBuyPrice(buyPrice);
        this.ticketCount = Integer.parseInt(buyPrice) / Rule.TICKET_PRICE.getRule();
        this.purchaseTickets = addPurchaseTickets();
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public List<List<Integer>> getPurchaseTickets() {
        return purchaseTickets;
    }

    private List<List<Integer>> addPurchaseTickets() {
        List<List<Integer>> newPurchaseTickets = new ArrayList<>();
        for (int count = 0; count < getTicketCount(); count++) {
            ticket = new Ticket();
            newPurchaseTickets.add(ticket.getTicketNumber());
        }
        return newPurchaseTickets;
    }

    private void validateStringBuyPrice(String buyPrice) {
        Validate.checkStringNotNumber(buyPrice);
        Validate.checkStringLowerThanBaseNumber(Rule.TICKET_PRICE.getRule(), buyPrice);
        Validate.checkIntNotSpecifiedUnitNumber(Rule.TICKET_PRICE.getRule(), Integer.parseInt(buyPrice));
    }
}
