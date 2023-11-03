package racingcar.model;

import racingcar.constants.Constants;
import racingcar.constants.ErrorMessages;

public class NumberValidation {
    public static int numbervalidateAll(String inputNumber) {
        int tryNumber = validateNotNumber(inputNumber);
        validateMinimumCount(tryNumber);
        return tryNumber;
    }

    private static int validateNotNumber(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.NOT_A_NUMBER.getMessage());
        }
    }

    private static void validateMinimumCount(int tryNumber) {
        if (tryNumber < (int) Constants.MIN_TRY_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessages.MINIMUM_TRY_NUMBER.getMessage());
        }
    }
}
