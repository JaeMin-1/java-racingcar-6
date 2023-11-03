package racingcar.constants;

public enum ErrorMessages {
    CAR_NAME_LENGTH_EXCEED("자동차 이름이 5자 이하가 아닙니다: "),
    NAME_CHARACTER_PATTERN_MISMATCH("특수문자가 포함된 문자열이 입력되었습니다: "),
    DUPLICATE_NAME("중복된 이름이 입력되었습니다: "),
    NOT_A_NUMBER("숫자가 아닌 값을 입력하셨습니다."),
    MINIMUM_TRY_NUMBER("잘못된 시도 횟수입니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
