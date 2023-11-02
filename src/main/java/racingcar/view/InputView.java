package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static List<String> inputCarNames() {
        System.out.println(showInputCarNamesPrompt());
        String input = UserInput();
        String[] inputs = input.split(",");

        List<String> inputArr = new ArrayList<>();
        for (String carName : inputs) {
            inputArr.add(carName);
        }
        return inputArr;
    }

    public static String inputTryNumber() {
        System.out.println(showInputTryNumberPrompt());
        String inputNumber = UserInput();
        return inputNumber;
    }

    private static String UserInput() {
        return Console.readLine();
    }

    private static String showInputCarNamesPrompt() {
        return "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    }

    private static String showInputTryNumberPrompt() {
        return "시도할 회수는 몇회인가요?";
    }
}