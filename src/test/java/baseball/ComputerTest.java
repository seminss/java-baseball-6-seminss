package baseball;

import baseball.model.Balls;
import baseball.model.Computer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {
    @Test
    @DisplayName("랜덤한 3자리 숫자를 출력 하는지 확인한다.")
    void computerTest() {
        Computer instance = Computer.getInstance();
        instance.createAnswer();
        Balls answer1 = instance.getAnswer();
        Assertions.assertEquals(answer1, instance.getAnswer());
        instance.createAnswer();
        Balls answer2 = instance.getAnswer();
        Assertions.assertNotEquals(answer1, answer2);
    }
}
