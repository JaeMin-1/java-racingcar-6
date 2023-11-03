package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Race {
    private List<String> carNames;
    private List<Integer> carGoingCount;

    public void initialize(List<String> carNames) {
        this.carNames = carNames;
        /*
         * runRace() 에서 set 메서드로 접근하기 위해 실시하는 초기화
         */
        carGoingCount = new ArrayList<>(carNames.size());
        for (int i = 0; i < carNames.size(); i++) {
            carGoingCount.add(0);
        }
    }

    /*
     * 무작위로 숫자를 자동차 대수만큼 추출해서 4 이상이면 한칸 전진
     */
    public void runRace() {
        List<Integer> randomNumbersList = carNames.stream()
                .map(name -> Randoms.pickNumberInRange((int) Constants.MIN_RANDOM_NUMBER.getValue(),
                        (int) Constants.MAX_RANDOM_NUMBER.getValue()))
                .collect(Collectors.toList());

        IntStream.range(0, randomNumbersList.size())
                .filter(j -> randomNumbersList.get(j) >= (int) Constants.FORWARD_CONDITION.getValue())
                .forEach(j -> carGoingCount.set(j, carGoingCount.get(j) + 1));
    }

    public String winners() {
        int maxCount = 0;
        for (int i = 0; i < carGoingCount.size(); i++) {
            maxCount = Math.max(maxCount, carGoingCount.get(i));
        }
        StringJoiner joiner = new StringJoiner(", ");
        for (int i = 0; i < carGoingCount.size(); i++) {
            if (maxCount == carGoingCount.get(i)) {
                joiner.add(carNames.get(i));
            }
        }
        return joiner.toString();
    }

    public List<Integer> getCarGoingCount() {
        return carGoingCount;
    }

    public List<String> getCarNames() {
        return carNames;
    }
}