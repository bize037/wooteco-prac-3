package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    private Ticket ticket = new Ticket();

    private final int buyPrice;
    private final List<List<Integer>> purchaseTickets;

    public Buyer(String buyPrice) {
        validateStringBuyPrice(buyPrice);
        this.buyPrice = Integer.parseInt(buyPrice);
        this.purchaseTickets = addPurchaseTickets(ticket);
    }

    public int getTicketCount() {
        return buyPrice / 1000;
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

    private void validateStringBuyPrice(String buyPrice) {
        // 추후 추가
    }
}
