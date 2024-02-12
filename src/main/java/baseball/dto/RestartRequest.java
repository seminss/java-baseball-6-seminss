package baseball.dto;

import baseball.exception.BaseballException;

public class RestartRequest {
    private int number;

    public RestartRequest(String input) {
        validateFormat(input);
        this.number = Integer.parseInt(input);
    }

    private void validateFormat(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new BaseballException("재시작 입력 숫자는 1 또는 2입니다.");
        }
    }

    public boolean doRestart() {
        return number == 1;
    }
}

