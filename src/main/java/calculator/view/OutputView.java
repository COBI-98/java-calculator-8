package calculator.view;

public class OutputView {
    private static final String CALCULATE_SUM_RESULT = "결과 : ";

    public void printResult(int value) {
        System.out.print(CALCULATE_SUM_RESULT);
        System.out.println(value);
    }

    public static void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }
}