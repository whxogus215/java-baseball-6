package baseball.dto;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public enum ResultType {

    ALL_STRIKE(true, "게임 세트 종료", (ball, strike) -> ball == 0 && strike == 3),
    BALL_AND_STRIKE(false, "볼과 스트라이크 존재",
            (ball, strike) -> (ball > 0 && ball < 3) && (strike > 0 && strike < 3)),
    ONLY_STRIKE(false, "스트라이크만 존재", (ball, strike) -> ball == 0 && (strike > 0 && strike < 3)),
    ONLY_BALL(false, "볼만 존재", (ball, strike) -> (ball > 0 && ball <= 3) && strike == 0),
    NOTHING(false, "낫싱", (ball, strike) -> ball == 0 && strike == 0);

    private boolean isEnd;
    private String detail;
    private BiFunction<Integer, Integer, Boolean> resultTypeFunction;

    ResultType(boolean isEnd, String detail,
               BiFunction<Integer, Integer, Boolean> resultTypeFunction) {
        this.isEnd = isEnd;
        this.detail = detail;
        this.resultTypeFunction = resultTypeFunction;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public static ResultType findResultTypeByCount(Integer countOfBall, Integer countOfStrike) {
        return Arrays.stream(ResultType.values())
                .filter(resultType -> resultType
                        .resultTypeFunction
                        .apply(countOfBall, countOfStrike))
                .findAny()
                .get();
    }
}
