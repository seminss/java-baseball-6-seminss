package baseball.controller;

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

    public void start() {
        outputView.printStartMessage();
        inputView.readBallNumbers();
    }
}
