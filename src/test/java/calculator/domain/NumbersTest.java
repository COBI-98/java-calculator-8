package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NumbersTest {

    @DisplayName("constructor() : 구분자를 기준으로 양수가 분리된 경우")
    @ParameterizedTest
    @CsvSource({"1,2,3","1,4,5"})
    void constructor_numbers_success(String number1,
                                     String number2,
                                     String number3) throws Exception {
        //given
        List<Number> numbers = List.of(new Number(number1), new Number(number2), new Number(number3));

        // when & then
        assertThatCode(() -> {
            new Number(number1);
            new Number(number2);
            new Number(number3);
        }).doesNotThrowAnyException();
    }

    @DisplayName("calculateSum() : 각 숫자의 합을 계산한 경우")
    @ParameterizedTest
    @CsvSource({"1,2,3,6","1,4,5,10"})
    void calculateSum_numbers(String number1,
                              String number2,
                              String number3,
                              int summation) throws Exception {
        //given
        Numbers numbers = new Numbers(List.of(new Number(number1), new Number(number2), new Number(number3)));

        // when
        int calculateValue = numbers.calculateSum();

        // then
        assertThat(calculateValue).isEqualTo(summation);
    }
}