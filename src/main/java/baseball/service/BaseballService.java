package baseball.service;

import baseball.domain.Numbers;
import baseball.dto.Result;
import baseball.dto.ResultType;
import java.util.List;

public class BaseballService {
    /**
     * 1. 컨트롤러에게 출력용 DTO 전달
     * 2. 스트라이크 DTO 추가
     * 3. 볼 DTO 추가
     */
    public Result getResult(Numbers playerNumbers, Numbers computerNumbers) {
        int countOfStrike = playerNumbers.calculateStrikeCount(computerNumbers);
        int countOfBall = playerNumbers.calculateBallCount(computerNumbers);
        if (countOfStrike == 3) {
            return new Result(countOfStrike, countOfBall, ResultType.ALL_STRIKE);
        }
        return new Result(countOfStrike, countOfBall, ResultType.NOT_END);
    }
}
