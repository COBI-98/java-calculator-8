package calculator.controller;

import calculator.domain.Delimiter;
import calculator.domain.Delimiters;
import calculator.domain.Number;
import calculator.domain.Numbers;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CalculatorController {

    private static final String SETUP_SYMBOL_COMMA = ",";
    private static final String SETUP_SYMBOL_COLON = ":";
    private static final String CUSTOM_DELIMITER_END = "\\n";
    private static final String NEWLINE = "\n";

    private static final String HEADER_CAPTURE_REGEX = "//(.*?)\\n";
    private static final String HEADER_REMOVE_REGEX  = "//.*?\\n";
    private static final String REGEX_OR = "|";

    private static final Pattern DELIMITER_PATTERN = Pattern.compile(HEADER_CAPTURE_REGEX);

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Delimiters delimiters;

    public CalculatorController() {
        delimiters = new Delimiters(List.of(
                new Delimiter(SETUP_SYMBOL_COMMA),
                new Delimiter(SETUP_SYMBOL_COLON)
        ));
    }

    public void run() {
        try {
            startCalculator();
        } catch (IllegalArgumentException exception){
            outputView.printException(exception);
            throw exception;
        }
    }

    public void startCalculator(){
        String inputString = inputView.createString();
        Delimiters delimiters = extractCustomDelimiters(inputString);
        Numbers number = createNumbers(inputString, delimiters);
        outputView.printResult(number.calculateSum());
    }

    private Delimiters extractCustomDelimiters(String input) {
        input = input.replace(CUSTOM_DELIMITER_END, NEWLINE);
        Matcher matcher = DELIMITER_PATTERN.matcher(input);

        while (matcher.find()) {
            String delimiterBlock = matcher.group(1);
            delimiters.addDelimiter(delimiterBlock);
        }

        return delimiters;
    }

    private Numbers createNumbers(String inputString, Delimiters delimiters) {
        String numberPart = removeDelimiterDefinition(inputString);

        String delimiterPattern = delimiters.getDelimiters().stream()
                .map(Delimiter::getSymbol)
                .reduce((a, b) -> a + REGEX_OR + b)
                .orElse(SETUP_SYMBOL_COMMA);

        return new Numbers(Arrays.stream(numberPart.split(delimiterPattern))
                .map(String::trim)
                .map(Number::new)
                .collect(Collectors.toList()));
    }

    private String removeDelimiterDefinition(String inputString) {
        inputString = inputString.replace(CUSTOM_DELIMITER_END, NEWLINE);
        return inputString.replaceAll(HEADER_REMOVE_REGEX, "");
    }
}