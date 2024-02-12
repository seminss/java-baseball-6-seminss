package baseball.view;

import baseball.dto.NumberRequest;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public NumberRequest readBallNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = read();
        return new NumberRequest(input);
    }

    public void readClose() {
        Console.close();
    }

    public String read() {
        return Console.readLine();
    }
}
