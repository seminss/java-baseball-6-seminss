package baseball.model;

import baseball.exception.BaseballException;

public class Ball {
    private final int number;

    public Ball(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if (number > 9 || number < 1) {
            throw new BaseballException("1~9까지의 숫자가 아닙니다.");
        }
    }

}
