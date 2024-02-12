package baseball.model;

import baseball.exception.BaseballException;

import java.util.Arrays;
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

    public Result play(Balls others) {
        Result result = new Result();
        for (Ball other : others.getBalls()) {
            Decision decision = makeDecision(other);
            result.updateResult(decision);
        }
        return result;
    }

    /**
     * ball가 this의 balls에서 STRIKE나 BALL을 뽑을 수 있는지 확인.
     * 없다면 NOTHING
     */
    private Decision makeDecision(Ball ball) {
        return this.balls.stream()
                .map(b -> b.getDecision(ball))
                .filter(Decision::isNotNothing)
                .findFirst()
                .orElse(Decision.NOTHING);
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

    @Override
    public String toString() {
        return Arrays.toString(balls.toArray());
    }
}
