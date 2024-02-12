package baseball.service;

import baseball.dto.NumberRequest;
import baseball.model.Balls;
import baseball.model.Computer;
import baseball.model.Result;

public class BaseballService {
    public void startGame() {
        Computer.getInstance().createAnswer();
    }

    public Result getResult(NumberRequest request) {
        Balls user = new Balls(request.getNumbers());
        return Computer.getInstance().getAnswer().play(user);
    }

}
