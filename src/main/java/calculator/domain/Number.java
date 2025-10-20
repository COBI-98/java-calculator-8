package calculator.domain;

public class Number {

    private final int number;

    public Number(String number) {
        validateBlank(number);
        this.number = parseInt(number);
    }

    private void validateBlank(String number) {
        if (number.isBlank() || number.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 빈 값은 허용되지 않습니다.");
        }
    }


    private int parseInt(String name) {
        return Integer.parseInt(name);
    }

    public int getNumber() {
        return number;
    }
}
