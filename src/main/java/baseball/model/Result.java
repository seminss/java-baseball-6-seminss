package baseball.model;

import baseball.exception.BaseballException;

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
        validateSum();
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    private void validateSum() {
        if (strike + ball > 3) {
            throw new BaseballException("스트라이크와 볼의 합은 최대 3입니다.");
        }
    }
}
