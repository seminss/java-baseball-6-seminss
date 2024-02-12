package baseball;

import baseball.exception.BaseballException;
import baseball.model.Decision;
import baseball.model.Result;
import baseball.view.ResultFormatter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {
    Result result;

    @BeforeEach
    void before() {
        result = new Result();
    }

    @DisplayName("1볼 1스트라이크 테스트")
    @Test
    void test1() {
        result.updateResult(Decision.STRIKE);
        result.updateResult(Decision.BALL);
        Assertions.assertEquals("1볼 1스트라이크", ResultFormatter.format(result));
    }

    @DisplayName("2볼 테스트")
    @Test
    void test2() {
        result.updateResult(Decision.BALL);
        result.updateResult(Decision.BALL);
        Assertions.assertEquals("2볼", ResultFormatter.format(result));
    }

    @DisplayName("3스트라이크 테스트")
    @Test
    void test3() {
        result.updateResult(Decision.STRIKE);
        result.updateResult(Decision.STRIKE);
        result.updateResult(Decision.STRIKE);
        Assertions.assertEquals("3스트라이크", ResultFormatter.format(result));
    }

    @DisplayName("낫싱 테스트")
    @Test
    void test4() {
        Assertions.assertEquals("낫싱", ResultFormatter.format(result));
    }

    @DisplayName("스트라이크와 볼의 합이 3을 넘어서면 예외가 발생한다.")
    @Test
    void test5() {
        result.updateResult(Decision.STRIKE);
        result.updateResult(Decision.STRIKE);
        result.updateResult(Decision.BALL);
        Assertions.assertThrows(BaseballException.class, () -> {
            result.updateResult(Decision.STRIKE);
        });
    }
}
