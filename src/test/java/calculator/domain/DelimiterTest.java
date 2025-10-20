package calculator.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DelimiterTest {

    @DisplayName("constructor() : 구분자를 정상적으로 입력한 경우")
    @ParameterizedTest
    @ValueSource(strings = {"n", ":"})
    void constructor_delimiter_success(String symbol) throws Exception {
        //given & when & then
        assertThatCode(() -> new Delimiter(symbol))
                .doesNotThrowAnyException();;
    }

    @DisplayName("validateNotBlank() : 구분자가 빈 문자열인 경우")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    void validateNotBlank_delimiter_fail(String symbol) throws Exception{
        //given
        String errorMessage = "[ERROR] 구분자가 빈 문자열일 수 없습니다.";

        //when & then
        assertThatThrownBy(() -> new Delimiter(symbol))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }

    @DisplayName("validateNoDigits() : 구분자에 양수가 지정된 경우")
    @ParameterizedTest
    @ValueSource(strings = {"369", "36", "9"})
    void validateNoDigits_delimiter_fail(String symbol) throws Exception{
        //given
        String errorMessage = "[ERROR] 구분자는 양수가 지정될 수 없습니다.";

        //when & then
        assertThatThrownBy(() -> new Delimiter(symbol))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }
}