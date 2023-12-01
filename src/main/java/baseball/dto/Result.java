package baseball.dto;

public class Result {
    private int countOfStrike;
    private int countOfBall;
    private ResultType resultType;

    public Result(int countOfStrike, int countOfBall, ResultType gameResult) {
        this.countOfStrike = countOfStrike;
        this.countOfBall = countOfBall;
        this.resultType = gameResult;
    }

    public int getCountOfStrike() {
        return countOfStrike;
    }

    public int getCountOfBall() {
        return countOfBall;
    }

    public ResultType getResultType() {
        return resultType;
    }
}
