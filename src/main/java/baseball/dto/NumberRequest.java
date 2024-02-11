package baseball.dto;

import baseball.exception.BaseballException;

import java.util.List;
import java.util.Objects;

public class NumberRequest {
    private final List<Integer> numbers;

    public NumberRequest(String input) {
        validateFormat(input);
        numbers = mapNumbers(input);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private List<Integer> mapNumbers(String input) {
        return input.chars()
                .mapToObj(Character::getNumericValue)
                .toList();
    }

    private void validateFormat(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new BaseballException("입력은 숫자여야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NumberRequest request)) return false;
        return Objects.equals(getNumbers(), request.getNumbers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumbers());
    }
}
