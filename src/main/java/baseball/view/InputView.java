package baseball.view;

import baseball.dto.NumberRequest;
import baseball.dto.RestartRequest;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public NumberRequest readBallNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = read();
        return new NumberRequest(input);
    }

    public RestartRequest readRestartNumber() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = read();
        return new RestartRequest(input);
    }

    public void readClose() {
        Console.close();
    }

    public String read() {
        return Console.readLine();
    }
}
