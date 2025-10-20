package calculator.domain;

public class Number {

    private static final String POSITIVE_NUMBER_PATTERN = "^[1-9]\\d*$";
    private final int number;

    public Number(String number) {
        validateBlank(number);
        validateIntegerFormat(number);
        this.number = parseInt(number);
    }

    private void validateBlank(String number) {
        if (number.isBlank() || number.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 빈 값은 허용되지 않습니다.");
        }
    }

    private void validateIntegerFormat(String number) {
        if (!number.matches(POSITIVE_NUMBER_PATTERN)) {
            throw new IllegalArgumentException("[ERROR] 양수 형식이 아닙니다.");
        }
    }

    private int parseInt(String name) {
        return Integer.parseInt(name);
    }

    public int getNumber() {
        return number;
    }
}
