package racingcar.model;

public class Constants {
    public static final int MAX_CAR_NAME_LENGTH = 5;

    public static final int MIN_TRY_NUMBER = 1;

    public static final int MIN_RANDOM_NUMBER = 0;
    public static final int MAX_RANDOM_NUMBER = 9;

    public static final int FORWARD_CONDITION = 4;

    public static final String NAME_CHARACTER_PATTERN = "^[a-zA-Z0-9]*$";

    public static final String CAR_NAMES_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String TRY_NUMBER_PROMPT = "시도할 회수는 몇회인가요?";

    public static final String EXECUTION_RESULTS_HEADER = "실행 결과";
    public static final String WINNER_MESSAGE = "최종 우승자 : ";
}