package racingcar.view;

import java.util.List;
import racingcar.constants.Constants;

public class OutputView {
    public static String showExecutionResults(List<String> carNames, List<Integer> carGoingCount) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < carNames.size(); i++) {
            result.append(carNames.get(i)).append(" : ");
            appendHyphens(result, carGoingCount.get(i));
        }
        return result.toString();
    }

    public static String showWinner(String winners) {
        return Constants.WINNER_MESSAGE.getValue() + winners;
    }

    private static void appendHyphens(StringBuilder result, int count) {
        for (int i = 0; i < count; i++) {
            result.append("-");
        }
        result.append("\n");
    }
}