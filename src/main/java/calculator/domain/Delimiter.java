package calculator.domain;

import java.util.regex.Pattern;

public class Delimiter {

    private final String symbol;

    public Delimiter(String symbol) {
        this.symbol = symbol;
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
