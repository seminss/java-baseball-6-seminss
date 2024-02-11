package baseball;

import baseball.exception.BaseballException;
import baseball.model.Balls;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BallsTest {

    @Test
    @DisplayName("Balls는 세 자리 수이며, 중복이 없다.")
    void duplicatePositiveTest() {
        assertNotNull(new Balls(Arrays.asList(1, 2, 3)));
    }

    @Test
    @DisplayName("Balls에 중복이 있으면 예외가 발생한다.")
    void duplicateNegativeTest() {
        assertThrows(BaseballException.class, () -> new Balls(Arrays.asList(1, 2, 2)));
    }

    @Test
    @DisplayName("Balls가 세 자리 수가 아니면 예외가 발생한다.")
    void digitNegativeTest() {
        assertThrows(BaseballException.class, () -> new Balls(Arrays.asList(1, 2)));
    }
}
