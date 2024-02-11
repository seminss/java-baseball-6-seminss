package baseball.model;

public enum Decision {
    BALL, STRIKE, NOTHING;

    public boolean isNotNothing() {
        return this != Decision.NOTHING;
    }
}
