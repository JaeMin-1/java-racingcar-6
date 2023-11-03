package racingcar.controller;

import java.util.List;
import racingcar.model.CarValidation;
import racingcar.model.Constants;
import racingcar.model.NumberValidation;
import racingcar.model.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    public void runStart() {
        List<String> inputArr = InputView.inputCarNames();
        List<String> carNames = CarValidation.carValidateAll(inputArr);

        String inputNumber = InputView.inputTryNumber();
        int tryNumber = NumberValidation.numbervalidateAll(inputNumber);
        System.out.println();

        Race race = new Race();
        race.initialize(carNames);

        runRaceAndPrintResults(race, tryNumber);
    }

    private void runRaceAndPrintResults(Race race, int tryNumber) {
        System.out.println(Constants.EXECUTION_RESULTS_HEADER.getValue());
        for (int i = 0; i < tryNumber; i++) {
            race.runRace();
            System.out.println(OutputView.showExecutionResults(race.getCarNames(), race.getCarGoingCount()));
        }
        System.out.println(OutputView.showWinner(race.winners()));
    }
}