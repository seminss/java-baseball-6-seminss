package baseball;

import baseball.exception.BaseballException;
import baseball.model.Ball;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallTest {

    @ParameterizedTest
    @DisplayName("하나의 Ball은 1~9의 수이다.")
    @ValueSource(ints = {1, 9})
    void positiveTest(int number) {
        Assertions.assertNotNull(new Ball(number, 1));
    }

    @ParameterizedTest
    @DisplayName("Ball이 1~9 범위를 벗어나면 예외가 발생한다.")
    @ValueSource(ints = {0, 10})
    void negativeTest(int number) {
        Assertions.assertThrows(BaseballException.class, () -> new Ball(number, 1));
    }
}
