package racingcar.constants;

public enum Constants {
    MAX_CAR_NAME_LENGTH(5),
    MIN_TRY_NUMBER(1),
    MIN_RANDOM_NUMBER(0),
    MAX_RANDOM_NUMBER(9),
    FORWARD_CONDITION(4),
    NAME_CHARACTER_PATTERN("^[a-zA-Z0-9]*$"),
    CAR_NAMES_PROMPT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    TRY_NUMBER_PROMPT("시도할 회수는 몇회인가요?"),
    EXECUTION_RESULTS_HEADER("실행 결과"),
    WINNER_MESSAGE("최종 우승자 : ");

    private final Object value;

    Constants(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }
}