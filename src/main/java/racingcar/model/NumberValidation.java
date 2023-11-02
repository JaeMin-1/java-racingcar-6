package racingcar.model;

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
            throw new IllegalArgumentException("숫자가 아닌 값을 입력하셨습니다.");
        }
    }

    private static void validateMinimumCount(int tryNumber) {
        if (tryNumber < Constants.MIN_TRY_NUMBER) {
            throw new IllegalArgumentException("잘못된 시도 횟수입니다.");
        }
    }
}
