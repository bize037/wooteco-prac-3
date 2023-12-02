package lotto.controller;

import java.util.List;
import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.Ticket;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private Buyer buyer;
    private Lotto lotto;

    public void start() {
        buyLotto();
        printPurchaseTickets(buyer.getTicketCount(), buyer.getPurchaseTickets());
    }

    private void buyLotto() {
        buyer = new Buyer(InputView.inputBuyPrice());
    }

    private void printPurchaseTickets(int ticketCount, List<List<Integer>> purchaseTickets) {
        OutputView.outputTicketCount(ticketCount);
        OutputView.outputPurchaseTickets(purchaseTickets);
    }

    private void pickLotto() {
    }

    private void pickBonus() {

    }

    private void printPlaceResult() {

    }
}
