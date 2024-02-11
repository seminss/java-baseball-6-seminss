package baseball;

import baseball.exception.BaseballException;
import baseball.model.Balls;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BallsTest {

    @Test
    @DisplayName("Balls에는 중복이 없어야 한다.")
    void duplicatePositiveTest() {
        assertNotNull(new Balls(Arrays.asList(1, 2, 3)));
    }

    @Test
    @DisplayName("Balls에 중복이 있으면 예외가 발생한다.")
    void duplicateNegativeTest() {
        assertThrows(BaseballException.class, () -> new Balls(Arrays.asList(1, 2, 2)));
    }
}
