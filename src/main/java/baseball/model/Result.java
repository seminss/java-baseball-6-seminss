package baseball.model;

public class Result {
    private int strike;
    private int ball;

    public Result() {
        this.strike = 0;
        this.ball = 0;
    }

    public void updateResult(Decision decision) {
        if (decision.equals(Decision.STRIKE)) {
            strike += 1;
        }
        if (decision.equals(Decision.BALL)) {
            ball += 1;
        }
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
