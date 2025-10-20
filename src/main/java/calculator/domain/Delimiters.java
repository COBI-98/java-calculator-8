package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Delimiters {
    private List<Delimiter> delimiters;

    public Delimiters(List<Delimiter> delimiters) {
        this.delimiters = uniqueDelimiters(delimiters);
    }

    private List<Delimiter> uniqueDelimiters(List<Delimiter> delimiters) {
        return delimiters.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public Delimiters addDelimiter(String delimiter) {
        List<Delimiter> next = new ArrayList<>(delimiters);
        next.add(new Delimiter(delimiter));
        return new Delimiters(next);
    }

    public List<Delimiter> getDelimiters() {
        return delimiters;
    }
}