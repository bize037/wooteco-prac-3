package lotto.view;

import java.util.List;
import lotto.common.constants.Message;

public class OutputView {
    public static void outputTicketCount(int ticketCount) {
        System.out.println(ticketCount + Message.OUTPUT_TICKET_COUNT.getMessage());
    }

    public static void outputPurchaseTickets(List<List<Integer>> tickets) {
        tickets.forEach(ticket -> {
            outputPurchaseTicket(ticket);
        });
    }

    private static void outputPurchaseTicket(List<Integer> ticket) {
        System.out.println(ticket);
    }

}
