package baseball.dto;

public class RestartRequest {
    private int number;

    public RestartRequest(String input) {
        this.number = Integer.parseInt(input);
    }

    public boolean isRestart() {
        return number == 1;
    }
}

