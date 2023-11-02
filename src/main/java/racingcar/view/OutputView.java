package racingcar.view;

import java.util.ArrayList;

public class OutputView {
    public String showExecutionResultsHeader() {
        return "실행 결과";
    }

    public String showExecutionResults(ArrayList<String> carNames, ArrayList<Integer> carGoingCount) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < carNames.size(); i++) {
            result.append(carNames.get(i)).append(" : ");
            appendHyphens(result, carGoingCount.get(i));
            result.append("\n");
        }
        return result.toString();
    }

    public String showWinner(String winners) {
        return "최종 우승자 : " + winners;
    }

    private void appendHyphens(StringBuilder result, int count) {
        for (int i = 0; i < count; i++) {
            result.append("-");
        }
    }
}