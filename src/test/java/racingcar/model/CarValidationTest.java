package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarValidationTest {
    @Test
    void validateAll_correct() {
        // given
        List<String> validCarNames = Arrays.asList("Car1", "Car2", "Car3");

        // when
        ArrayList<String> carNames = CarValidation.carValidateAll(validCarNames);

        // then
        assertThat(carNames).containsExactly("Car1", "Car2", "Car3");
    }

    static Stream<Arguments> invalidParameters() {
        return Stream.of(
                Arguments.of("Car1", "Car123454", "Car3", "자동차 이름이 5자 이하가 아닙니다: Car123454"),
                Arguments.of("Car1", "Car@4", "Car3", "특수문자가 포함된 문자열이 입력되었습니다: Car@4"),
                Arguments.of("Car1", "Car1", "Car2", "중복된 이름이 입력되었습니다: Car1")
        );
    }

    @ParameterizedTest
    @MethodSource("invalidParameters")
    void validateAll(String car1, String car2, String car3, String errorMessage) {
        // given
        List<String> validCarNames = Arrays.asList(car1, car2, car3);

        // when & then
        assertThatThrownBy(() -> CarValidation.carValidateAll(validCarNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }
}