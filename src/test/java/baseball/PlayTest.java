package baseball;

import baseball.model.Ball;
import baseball.model.Balls;
import baseball.model.Decision;
import baseball.model.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class PlayTest {
    @Test
    @DisplayName("같은 수가 같은 자리에 있는 경우는 스트라이크다.")
    void strikeTest() {
        Ball computer = new Ball(1, 1);
        Decision result = computer.getDecision(new Ball(1, 1));
        Assertions.assertEquals(Decision.STRIKE, result);
    }

    @Test
    @DisplayName("같은 수가 다른 자리에 있는 경우는 볼이다.")
    void ballTest() {
        Ball computer = new Ball(1, 1);
        Decision result = computer.getDecision(new Ball(1, 2));
        Assertions.assertEquals(Decision.BALL, result);
    }

    @Test
    @DisplayName("전혀 다른 수이면 낫싱이다.")
    void nothingTest() {
        Ball computer = new Ball(1, 1);
        Decision result = computer.getDecision(new Ball(2, 3));
        Assertions.assertEquals(Decision.NOTHING, result);
    }

    @Test
    @DisplayName("3 스트라이크")
    void three_StrikeTest() {
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        Result result = answer.play(new Balls(Arrays.asList(1, 2, 3)));
        Assertions.assertEquals(3, result.getStrike());
    }

    @Test
    @DisplayName("1 스트라이크 1 볼 테스트")
    void one_Strike_one_BallTest() {
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        Result result = answer.play(new Balls(Arrays.asList(1, 3, 5)));
        Assertions.assertEquals(1, result.getStrike());
        Assertions.assertEquals(1, result.getBall());
    }

    @Test
    @DisplayName("2 볼 테스트")
    void two_BallTest() {
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        Result result = answer.play(new Balls(Arrays.asList(3, 1, 6)));
        Assertions.assertEquals(2, result.getBall());
    }

    @Test
    @DisplayName("낫싱 테스트")
    void totallyNothingTest() {
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        Result result = answer.play(new Balls(Arrays.asList(4, 5, 6)));
        Assertions.assertEquals(0, result.getBall());
        Assertions.assertEquals(0, result.getStrike());
    }
}
