package baseball.model;

import baseball.exception.BaseballException;

import java.util.List;
import java.util.stream.IntStream;

public class Balls {
    private final int DIGIT = 3;
    private final List<Ball> balls;

    public Balls(List<Integer> origins) {
        validateDuplication(origins);
        validateDigit(origins);
        this.balls = mapBall(origins);
    }

    public List<Ball> getBalls() {
        return balls;
    }

    private List<Ball> mapBall(List<Integer> origins) {
        return IntStream.range(0, DIGIT)
                .mapToObj(i -> new Ball(origins.get(i), i))
                .toList();
    }

    private void validateDuplication(List<Integer> origins) {
        if (origins.stream().distinct().count() != origins.size()) {
            throw new BaseballException("중복된 수가 존재 합니다.");
        }
    }

    private void validateDigit(List<Integer> origins) {
        if (origins.size() != DIGIT) {
            throw new BaseballException("세 자리 수가 아닙니다.");
        }
    }
}
