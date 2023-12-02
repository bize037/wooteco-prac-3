package lotto.view;

import java.sql.SQLOutput;
import java.util.List;
import lotto.common.constants.Message;

public class OutputView {
    private final static String NEW_LINE = System.lineSeparator();
    private final static String DIVIDING_LINE = "---";

    public static void outputTicketCount(int ticketCount) {
        System.out.println(NEW_LINE + ticketCount + Message.OUTPUT_TICKET_COUNT.getMessage());
    }

    public static void outputPurchaseTickets(List<List<Integer>> tickets) {
        tickets.forEach(System.out::println);
    }

    public static void outputPrizeStat() {
        System.out.println(NEW_LINE + Message.OUTPUT_PRIZE_STAT.getMessage());
        System.out.println(DIVIDING_LINE);
    }
}
