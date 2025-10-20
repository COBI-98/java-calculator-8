package calculator.domain;

import java.util.Objects;
import java.util.regex.Pattern;

public class Delimiter {

    private static final Pattern PURE_POSITIVE_INT = Pattern.compile("^[1-9]\\d*$");
    private final String symbol;

    public Delimiter(String symbol) {
        validateNotBlank(symbol);
        validateNoDigits(symbol);
        this.symbol = symbol;
    }

    private void validateNotBlank(String symbol) {
        if(symbol == null || symbol.isBlank()){
            throw new IllegalArgumentException("[ERROR] 구분자가 빈 문자열일 수 없습니다.");
        }
    }

    private void validateNoDigits(String symbol) {
        if (PURE_POSITIVE_INT.matcher(symbol).matches()) {
            throw new IllegalArgumentException("[ERROR] 구분자는 양수가 지정될 수 없습니다.");
        }
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Delimiter delimiter = (Delimiter) o;
        return Objects.equals(symbol, delimiter.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol);
    }
}
