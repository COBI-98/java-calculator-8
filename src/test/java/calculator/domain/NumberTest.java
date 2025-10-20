package calculator.domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {


    @DisplayName("validateBlank() : 양수가 빈 값인 경우")
    @ParameterizedTest
    @ValueSource(strings = {"  ", " ", ""})
    void validateBlank_number_fail(String number) throws Exception{
        //given
        String errorMessage = "[ERROR] 빈 값은 허용되지 않습니다.";

        //when & then
        assertThatThrownBy(() -> new Number(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }

    @DisplayName("validateIntegerFormat() : 양수 형식이 아닌 경우")
    @ParameterizedTest
    @ValueSource(strings = {"+369,", "-3", "&6", ".9"})
    void validateIntegerFormat_number_fail(String number) throws Exception{
        //given
        String errorMessage = "[ERROR] 양수 형식이 아닙니다.";

        //when & then
        assertThatThrownBy(() -> new Number(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }
}