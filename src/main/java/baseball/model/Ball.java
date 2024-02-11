package baseball.model;

import baseball.exception.BaseballException;

public class Ball {
    private final int number;
    private final int place;

    public Ball(int number, int place) {
        validateRange(number);
        this.number = number;
        this.place = place;
    }

    private void validateRange(int number) {
        if (number > 9 || number < 1) {
            throw new BaseballException("1~9까지의 숫자가 아닙니다.");
        }
    }

    public Decision getDecision(Ball ball) {
        if (this.place == ball.place && this.number == ball.number) {
            return Decision.STRIKE;
        }
        if (this.number == ball.number) {
            return Decision.BALL;
        }
        return Decision.NOTHING;
    }
}
