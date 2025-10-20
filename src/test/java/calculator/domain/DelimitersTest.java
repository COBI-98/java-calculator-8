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
                new Delimiters(List.of(new Delimiter(symbolComma),
                        new Delimiter(symbolColon)))
        ).doesNotThrowAnyException();
    }

    @DisplayName("uniqueDelimiters() : 구분자들은 고유한 값을 가진다.")
    @ParameterizedTest
    @CsvSource({"',',:,:"})
    void uniqueDelimiters_delimiters_success(
            String symbolComma
            , String duplicationSymbol1
            , String duplicationSymbol2) throws Exception {
        //given
        Delimiters delimiterManager = new Delimiters(List.of(
                new Delimiter(symbolComma),
                new Delimiter(duplicationSymbol1),
                new Delimiter(duplicationSymbol2)));

        // when
        List<Delimiter> uniqueDelimiters = delimiterManager.getDelimiters();

        // then
        assertThat(uniqueDelimiters)
                .hasSize(2)
                .extracting(Delimiter::getSymbol)
                .containsExactlyInAnyOrder(symbolComma, duplicationSymbol1);
    }
}