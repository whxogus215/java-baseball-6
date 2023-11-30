package baseball.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    public static List<Integer> parseToList(String input) {
        String[] parsedInput = input.split("");
        List<String> inputs = Arrays.asList(parsedInput);
        return inputs.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
