package lotto.domain;

public enum ScoreBoard {
    FIRST_PLACE(2_000_000_000),
    SECOND_PLACE(30_000_000),
    THIRD_PLACE(1_500_000),
    FOURTH_PLACE(50_000),
    FIFTH_PLACE(5_000);

    private final int place;

    ScoreBoard(int place) {
        this.place = place;
    }
}
