package baseball;

import baseball.model.Ball;
import baseball.model.GameResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayTest {
    @Test
    @DisplayName("같은 수가 같은 자리에 있는 경우는 스트라이크다.")
    void strikeTest() {
        Ball computer = new Ball(1, 1);
        GameResult result = computer.getResult(new Ball(1, 1));
        Assertions.assertEquals(GameResult.STRIKE, result);
    }

    @Test
    @DisplayName("같은 수가 다른 자리에 있는 경우는 볼이다.")
    void ballTest() {
        Ball computer = new Ball(1, 1);
        GameResult result = computer.getResult(new Ball(1, 2));
        Assertions.assertEquals(GameResult.BALL, result);
    }

    @Test
    @DisplayName("전혀 다른 수이면 낫싱이다.")
    void nothingTest() {
        Ball computer = new Ball(1, 1);
        GameResult result = computer.getResult(new Ball(2, 3));
        Assertions.assertEquals(GameResult.NOTHING, result);
    }
}
