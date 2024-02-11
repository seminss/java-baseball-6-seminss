package baseball.dto;

import java.util.List;
import java.util.ArrayList;

public class NumberRequest {
    private final List<Integer> numbers;

    public NumberRequest(String input) {
        numbers = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            numbers.add(Character.getNumericValue(ch));
        }
    }
}
