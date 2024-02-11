package baseball.model;

import baseball.exception.BaseballException;

import java.util.List;

public class Balls {
    private final List<Ball> balls;

    public Balls(List<Integer> origins) {
        validateDuplication(origins);
        this.balls = mapBall(origins);
    }

    private List<Ball> mapBall(List<Integer> origins) {
        return origins.stream().map(Ball::new).toList();
    }

    private void validateDuplication(List<Integer> origins) {
        if (origins.stream().distinct().count() != origins.size()) {
            throw new BaseballException("중복된 수가 존재 합니다.");
        }
    }
}
