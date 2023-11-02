package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class CarValidationTest {
    private CarValidation carValidation = new CarValidation();

    @Test
    void validateAll_correct() {
        // given
        List<String> validCarNames = Arrays.asList("Car1", "Car2", "Car3");

        // when
        ArrayList<String> carNames = carValidation.carValidateAll(validCarNames);

        // then
        assertThat(carNames).containsExactly("Car1", "Car2", "Car3");
    }

    @Test
    void validateAll_too_longCarNames() {
        // given
        List<String> validCarNames = Arrays.asList("Car123454", "Car5", "Car1");

        // when & then
        assertThatThrownBy(() -> carValidation.carValidateAll(validCarNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 5자 이하가 아닙니다: " + validCarNames.get(0));
    }

    @Test
    void validateAll_invalidCarNames() {
        // given
        List<String> validCarNames = Arrays.asList("Car@4", "Car5$", "Car1");

        // when & then
        assertThatThrownBy(() -> carValidation.carValidateAll(validCarNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("특수문자가 포함된 문자열이 입력되었습니다: " + validCarNames.get(0));
    }

    @Test
    void testValidateDuplication() {
        // given
        List<String> validCarNames = Arrays.asList("Car2", "Car2", "Car1");

        // when & then
        assertThatThrownBy(() -> carValidation.carValidateAll(validCarNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름이 입력되었습니다: " + validCarNames.get(1));
    }

}