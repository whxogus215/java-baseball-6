package baseball.dto;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum ResultType {

    ALL_STRIKE(true, "3스트라이크", (ball, strike) -> ball == 0 && strike == 3),
    BALL_AND_STRIKE(false, "%d볼 %d스트라이크",
            (ball, strike) -> (ball > 0 && ball < 3) && (strike > 0 && strike < 3)),
    ONLY_STRIKE(false, "%d스트라이크", (ball, strike) -> ball == 0 && (strike > 0 && strike < 3)),
    ONLY_BALL(false, "%d볼", (ball, strike) -> (ball > 0 && ball <= 3) && strike == 0),
    NOTHING(false, "낫싱", (ball, strike) -> ball == 0 && strike == 0);

    private boolean isEnd;
    private String printFormat;
    private BiFunction<Integer, Integer, Boolean> resultTypeFunction;

    ResultType(boolean isEnd, String detail,
               BiFunction<Integer, Integer, Boolean> resultTypeFunction) {
        this.isEnd = isEnd;
        this.printFormat = detail;
        this.resultTypeFunction = resultTypeFunction;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public String getPrintFormat() {
        return printFormat;
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
