package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class DelimitersTest {

    @DisplayName("constructor() : 생성된 구분자들을 관리할 수 있다.")
    @ParameterizedTest
    @CsvSource({"',', ':'"})
    void constructor_delimiters_success(
            String symbolComma,
            String symbolColon) throws Exception {
        //given & when & then
        assertThatCode(() ->
                new Delimiters(List.of(new Delimiter(symbolComma), new Delimiter(symbolColon)))
        ).doesNotThrowAnyException();
    }

}