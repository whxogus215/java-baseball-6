package baseball.view.output;

import baseball.dto.Result;
import baseball.dto.ResultType;

public class ResultOutputWriter extends OutputWriter {
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private ResultOutputWriter() {

    }

    public static void printResult(Result result) {
        ResultType resultType = result.getResultType();
        int countOfBall = result.getCountOfBall();
        int countOfStrike = result.getCountOfStrike();
        if (resultType.equals(ResultType.BALL_AND_STRIKE)) {
            println(String.format(resultType.getPrintFormat(), countOfBall, countOfStrike));
        }
        if (resultType.equals(ResultType.ONLY_STRIKE)) {
            println(String.format(resultType.getPrintFormat(), countOfStrike));
        }
        if (resultType.equals(ResultType.ONLY_BALL)) {
            println(String.format(resultType.getPrintFormat(), countOfBall));
        }
        if (resultType.equals(ResultType.ALL_STRIKE) || resultType.equals(ResultType.NOTHING)) {
            println(resultType.getPrintFormat());
        }
    }

    public static void printEnding() {
        println(END_MESSAGE);
    }




}
