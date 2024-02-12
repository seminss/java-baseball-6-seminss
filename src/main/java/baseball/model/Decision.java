package baseball.model;

public enum Decision {
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱");

    String message;

    Decision(String message) {
        this.message = message;
    }

    public boolean isNotNothing() {
        return this != Decision.NOTHING;
    }

    public String getMessage() {
        return this.message;
    }
}
