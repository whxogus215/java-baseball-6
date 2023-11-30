package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final List<Integer> numbers;

    private Numbers(List<Integer> numbers) {
        validateNumberNotZero(numbers);
        this.numbers = numbers;
    }

    public static Numbers createPlayerNumbers(List<Integer> numbers) {
        return new Numbers(numbers);
    }

    public static Numbers createComputerNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return new Numbers(computer);
    }

    public int calculateBallCount(List<Integer> comparedNumbers) {
        int countOfBall = 0;
        for (int i = 0; i < comparedNumbers.size(); i++) {
            if (isBall(comparedNumbers, i)){
                countOfBall += 1;
            }
        }
        return countOfBall;
    }

    public int calculateStrikeCount(List<Integer> comparedNumbers) {
        int countOfStrike = 0;
        for (int i = 0; i < comparedNumbers.size(); i++) {
            if (isStrike(comparedNumbers, i)) {
                countOfStrike += 1;
            }
        }
        return countOfStrike;
    }

    private boolean isStrike(List<Integer> comparedNumbers, int index) {
        return numbers.get(index).equals(comparedNumbers.get(index));
    }

    private boolean isBall(List<Integer> comparedNumbers, int index) {
        return comparedNumbers.contains(numbers.get(index)) && !isStrike(comparedNumbers, index);
    }

    private void validateNumberNotZero(List<Integer> numbers) {
        boolean hasZero = numbers.stream().anyMatch(integer -> integer == 0);
        if (hasZero) {
            throw new IllegalArgumentException("숫자에 0이 포함되어서는 안됩니다.");
        }
    }
}
