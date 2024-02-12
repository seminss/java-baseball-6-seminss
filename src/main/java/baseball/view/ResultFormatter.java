package baseball.view;

import baseball.model.Decision;
import baseball.model.Result;

import static baseball.model.Decision.BALL;
import static baseball.model.Decision.STRIKE;

public class ResultFormatter {
    private ResultFormatter() {

    }

    public static String format(Result response) {
        if (response.getBall() == 0 && response.getStrike() == 0) {
            return Decision.NOTHING.getMessage();
        }
        if (response.getStrike() > 0 && response.getBall() == 0) {
            return response.getStrike() + STRIKE.getMessage();
        }
        if (response.getBall() > 0 && response.getStrike() == 0) {
            return response.getBall() + BALL.getMessage();
        }
        return response.getBall() + BALL.getMessage() + " " + response.getStrike() + STRIKE.getMessage();

    }
}
