package lotto.controller;

import java.util.Arrays;
import java.util.List;
import lotto.common.util.Util;
import lotto.common.validate.Validate;
import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private Buyer buyer;
    private Lotto lotto;

    public void start() {
        buyLotto();
        printPurchaseTickets(buyer.getTicketCount(), buyer.getPurchaseTickets());
        pickLotto();
        pickBonus();
    }

    private void buyLotto() {
        try {
            buyer = new Buyer(InputView.inputBuyPrice());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            buyLotto();
        }
    }

    private void printPurchaseTickets(int ticketCount, List<List<Integer>> purchaseTickets) {
        OutputView.outputTicketCount(ticketCount);
        OutputView.outputPurchaseTickets(purchaseTickets);
    }

    private void pickLotto() {
        try {
            List<String> lottoNumbers = Arrays.asList(InputView.inputLottoNumber().split(","));
            validateLottoNumbers(lottoNumbers);
            lotto = new Lotto(Util.convertStringListToIntegerList(lottoNumbers));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            pickLotto();
        }
    }

    private void pickBonus() {

    }

    private void printPlaceResult() {

    }

    private void validateLottoNumbers(List<String> lottoNumbers) {
        lottoNumbers.forEach(lottoNumber -> {
            Validate.checkStringNotBlank(lottoNumber);
            Validate.checkStringNotNumber(lottoNumber);
        });
    }
}
