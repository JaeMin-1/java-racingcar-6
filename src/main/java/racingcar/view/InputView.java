package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.constants.Constants;

public class InputView {
    public static List<String> inputCarNames() {
        System.out.println(Constants.CAR_NAMES_PROMPT.getValue());
        String input = UserInput();
        String[] inputs = input.split(",");

        List<String> inputArr = new ArrayList<>();
        for (String carName : inputs) {
            inputArr.add(carName);
        }
        return inputArr;
    }

    public static String inputTryNumber() {
        System.out.println(Constants.TRY_NUMBER_PROMPT.getValue());
        String inputNumber = UserInput();
        return inputNumber;
    }

    private static String UserInput() {
        return Console.readLine();
    }
}