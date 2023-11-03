package racingcar.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.constants.Constants;
import racingcar.constants.ErrorMessages;

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
            throw new IllegalArgumentException(ErrorMessages.CAR_NAME_LENGTH_EXCEED.getMessage() + input);
        }
    }

    private static void validateCarNameCharacters(String input) {
        if (!input.matches((String) Constants.NAME_CHARACTER_PATTERN.getValue())) {
            throw new IllegalArgumentException(ErrorMessages.NAME_CHARACTER_PATTERN_MISMATCH.getMessage() + input);
        }
    }

    private static void validateDuplication(String input, Set<String> checkDuplication) {
        if (!checkDuplication.add(input)) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_NAME.getMessage() + input);
        }
    }
}