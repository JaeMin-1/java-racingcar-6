package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.CarValidation;
import racingcar.model.Constants;
import racingcar.model.NumberValidation;
import racingcar.model.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    public void runGame() {
        List<String> inputArr = InputView.inputCarNames();
        ArrayList<String> carNames = CarValidation.carValidateAll(inputArr);

        String inputNumber = InputView.inputTryNumber();
        int tryNumber = NumberValidation.numbervalidateAll(inputNumber);
        System.out.println();

        Race race = new Race();
        race.initialize(carNames);

        OutputView outputView = new OutputView();
        System.out.println(Constants.EXECUTION_RESULTS_HEADER);
        for (int i = 0; i < tryNumber; i++) {
            race.runRace();
            System.out.println(outputView.showExecutionResults(race.getCarNames(), race.getCarGoingCount()));
        }
        System.out.println(outputView.showWinner(race.winners()));
    }

}