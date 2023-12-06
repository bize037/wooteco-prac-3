package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Referee {
    public List<Integer> matchingCountNumbers = new ArrayList<>(Collections.nCopies(5, 0));

    public enum Place {
        FIFTH_PLACE("3개 일치 (5,000원) - %d개", 4, 3.0, 5_000),
        FOURTH_PLACE("4개 일치 (50,000원) - %d개", 3, 2.0, 50_000),
        THIRD_PLACE("5개 일치 (1,500,000원) - %d개", 2, 1.0, 1_500_000),
        SECOND_PLACE("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", 1, 0.5, 30_000_000),
        FIRST_PLACE("6개 일치 (2,000,000,000원) - %d개", 0, 0.0, 2_000_000_000);

        private final String message;
        private final int listIndex;
        private final double point;
        private final int cashPrize;

        Place(String message, int listIndex, double point, int cashPrize) {
            this.message = message;
            this.listIndex = listIndex;
            this.point = point;
            this.cashPrize = cashPrize;
        }

        public double getPoint() {
            return point;
        }
    }

    public void updateMatchingCount(double point) {
        for (Place place : Place.values()) {
            if (point >= place.getPoint()) {
                matchingCountNumbers.set(place.listIndex, matchingCountNumbers.get(place.listIndex) + 1);
                break;
            }
        }
    }
}
