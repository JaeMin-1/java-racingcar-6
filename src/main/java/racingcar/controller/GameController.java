package racingcar.controller;

import java.util.List;
import racingcar.model.CarValidation;
import racingcar.model.Constants;
import racingcar.model.NumberValidation;
import racingcar.model.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    public void runGame() {
        List<String> carNames = getInputCarNames();
        int tryNumber = getInputTryNumber();

        Race race = new Race();
        race.initialize(carNames);

        displayExecutionResultsHeader();
        for (int i = 0; i < tryNumber; i++) {
            race.runRace();
            displayExecutionResults(race.getCarNames(), race.getCarGoingCount());
        }
        displayWinner(race.winners());
    }

    private List<String> getInputCarNames() {
        List<String> inputArr = InputView.inputCarNames();
        return CarValidation.carValidateAll(inputArr);
    }

    private int getInputTryNumber() {
        String inputNumber = InputView.inputTryNumber();
        System.out.println();
        return NumberValidation.numbervalidateAll(inputNumber);
    }

    private void displayExecutionResultsHeader() {
        System.out.println(Constants.EXECUTION_RESULTS_HEADER);
    }

    private void displayExecutionResults(List<String> carNames, List<Integer> carGoingCount) {
        System.out.println(OutputView.showExecutionResults(carNames, carGoingCount));
    }

    private void displayWinner(String winners) {
        System.out.println(OutputView.showWinner(winners));
    }
}