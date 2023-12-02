package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import lotto.common.util.Util;
import lotto.common.validate.Validate;
import lotto.domain.Bonus;
import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private static final Logger logger = Logger.getLogger(LottoController.class.getName());

    private Buyer buyer;
    private Lotto lotto;
    private Bonus bonus;

    public void start() {
        buyLotto();
        printPurchaseTickets(buyer.getTicketCount(), buyer.getPurchaseTickets());
        pickLotto();
        pickBonus();
        printPlaceResult();
    }

    private void buyLotto() {
        InputView.inputBuyPrice();
        generateBuyLotto();
    }

    private void printPurchaseTickets(int ticketCount, List<List<Integer>> purchaseTickets) {
        OutputView.outputTicketCount(ticketCount);
        OutputView.outputPurchaseTickets(purchaseTickets);
    }

    private void pickLotto() {
        InputView.inputLottoNumber();
        generateLottoNumber();
    }

    private void pickBonus() {
        InputView.inputBonusNumber();
        generateBonusNumber();
    }

    private void printPlaceResult() {
        OutputView.outputPrizeStat();
    }


    private void generateBuyLotto() {
        try {
            buyer = new Buyer(InputView.inputConsole());
        } catch (IllegalArgumentException e) {
            logger.severe(e.getMessage());
            generateBuyLotto();
        }
    }

    private void generateLottoNumber() {
        try {
            List<String> lottoNumbers = Arrays.asList(InputView.inputConsole().split(","));
            validateLottoNumbers(lottoNumbers);
            lotto = new Lotto(Util.convertStringListToIntegerList(lottoNumbers));
        } catch (IllegalArgumentException e) {
            logger.severe(e.getMessage());
            generateLottoNumber();
        }
    }

    private void generateBonusNumber() {
        try {
            bonus = new Bonus(InputView.inputConsole());
            Validate.checkListNotSameValue(bonus.getNumber(), lotto.getNumbers());
        } catch (IllegalArgumentException e) {
            logger.severe(e.getMessage());
            generateBonusNumber();
        }
    }

    private void validateLottoNumbers(List<String> lottoNumbers) {
        lottoNumbers.forEach(lottoNumber -> {
            Validate.checkStringNotBlank(lottoNumber);
            Validate.checkStringNotNumber(lottoNumber);
        });
    }
}
