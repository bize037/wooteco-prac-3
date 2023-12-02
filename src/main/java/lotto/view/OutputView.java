package lotto.view;

import java.util.List;
import lotto.common.constants.Message;

public class OutputView {
    private final static String NEW_LINE = System.lineSeparator();

    public static void outputTicketCount(int ticketCount) {
        System.out.println(NEW_LINE + ticketCount + Message.OUTPUT_TICKET_COUNT.getMessage());
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
