package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.ArrayList;

abstract class Opponent {
    Balls answer;

    public abstract void createAnswer();
}

public class Computer extends Opponent {

    private static final Computer INSTANCE = new Computer();

    private Computer() {
    }

    public static Computer getInstance() {
        return INSTANCE;
    }

    public void createAnswer() {
        Set<Integer> uniqueNumbers = new HashSet<>();
        while (uniqueNumbers.size() != 3) {
            uniqueNumbers.add(Randoms.pickNumberInRange(1, 9));
        }
        answer = new Balls(new ArrayList<>(uniqueNumbers));
    }

    public Balls getAnswer() {
        return answer;
    }
}