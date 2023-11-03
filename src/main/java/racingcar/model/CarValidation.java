package racingcar.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarValidation {
    public static ArrayList<String> carValidateAll(List<String> inputArr) {
        Set<String> checkDuplication = new HashSet<>();
        ArrayList<String> carNames = new ArrayList<>();

        for (String input : inputArr) {
            validateCarNameLength(input);
            validateCarNameCharacters(input);
            validateDuplication(input, checkDuplication);
            carNames.add(input);
        }

        return carNames;
    }

    private static void validateCarNameLength(String input) {
        if (input.length() > (int) Constants.MAX_CAR_NAME_LENGTH.getValue()) {
            throw new IllegalArgumentException("자동차 이름이 5자 이하가 아닙니다: " + input);
        }
    }

    private static void validateCarNameCharacters(String input) {
        if (!input.matches((String) Constants.NAME_CHARACTER_PATTERN.getValue())) {
            throw new IllegalArgumentException("특수문자가 포함된 문자열이 입력되었습니다: " + input);
        }
    }

    private static void validateDuplication(String input, Set<String> checkDuplication) {
        if (!checkDuplication.add(input)) {
            throw new IllegalArgumentException("중복된 이름이 입력되었습니다: " + input);
        }
    }
}