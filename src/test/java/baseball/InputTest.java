package baseball;

import baseball.dto.NumberRequest;
import baseball.exception.BaseballException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

class InputTest {
    @Test
    @DisplayName("사용자 예측 입력는 숫자여야 한다.")
    void userNumbersPositiveTest() {
        Assertions.assertEquals(Arrays.asList(1, 2, 3), new NumberRequest("123").getNumbers());
    }

    @ParameterizedTest
    @DisplayName("사용자 예측 입력이 숫자가 아니면 예외가 발생한다.")
    @ValueSource(strings = {"   ", "abc", "1,2,3"})
    void userNumbersNegativeTest(String input) {
        Assertions.assertThrows(BaseballException.class, () -> new NumberRequest(input));
    }
}
