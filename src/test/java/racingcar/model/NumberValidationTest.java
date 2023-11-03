package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NumberValidationTest {
    private NumberValidation numberValidation = new NumberValidation();

    @Test
    void numbervalidateAll_correct() {
        // given
        String inputNumber = "5";

        // when
        int tryNumber = numberValidation.numbervalidateAll(inputNumber);

        // then
        assertThat(5).isEqualTo(tryNumber);
    }

    static Stream<Arguments> invalidParameters() {
        return Stream.of(
                Arguments.of("abc", "숫자가 아닌 값을 입력하셨습니다."),
                Arguments.of("-1", "잘못된 시도 횟수입니다.")
        );
    }

    @ParameterizedTest
    @MethodSource("invalidParameters")
    void validateAll(String number, String errorMessage) {
        // given
        String inputNumber = number;

        // when & then
        assertThatThrownBy(() -> NumberValidation.numbervalidateAll(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }
}