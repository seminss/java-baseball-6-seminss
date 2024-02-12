package baseball.controller;

import baseball.dto.NumberRequest;
import baseball.model.Result;
import baseball.service.BaseballService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {
    BaseballService service;
    OutputView outputView;
    InputView inputView;

    public BaseballController(InputView inputView, OutputView outputView, BaseballService baseballService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.service = baseballService;
    }

    public void play() {
        outputView.printStartMessage();
        game:
        while (true) {
            service.startGame();
            while (true) {
                NumberRequest request = inputView.readBallNumbers();
                Result result = service.getResult(request);
                outputView.showResult(result);
                if (result.getStrike() == 3) {
                    outputView.printEndMessage();
                    if (!inputView.readRestartNumber().isRestart()) {
                        break game;
                    }
                    break;
                }
            }

        }
    }
}
