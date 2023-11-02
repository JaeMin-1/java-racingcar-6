package racingcar.view;

import java.util.ArrayList;
import racingcar.model.Constants;

public class OutputView {
    public String showExecutionResults(ArrayList<String> carNames, ArrayList<Integer> carGoingCount) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < carNames.size(); i++) {
            result.append(carNames.get(i)).append(" : ");
            appendHyphens(result, carGoingCount.get(i));
        }
        return result.toString();
    }

    public String showWinner(String winners) {
        return Constants.WINNER_MESSAGE + winners;
    }

    private void appendHyphens(StringBuilder result, int count) {
        for (int i = 0; i < count; i++) {
            result.append("-");
        }
        result.append("\n");
    }
}