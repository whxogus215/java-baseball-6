package baseball.controller;

import baseball.config.Global;
import baseball.config.Message;
import baseball.domain.Numbers;
import baseball.dto.Result;
import baseball.dto.ResultType;
import baseball.exception.ExceptionHandler;
import baseball.service.BaseballService;
import baseball.utils.Parser;
import baseball.view.input.InputReader;
import baseball.view.output.ResultOutputWriter;
import java.util.List;

public class Controller {
    private final String START = "숫자 야구 게임을 시작합니다.";
    private final String RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final BaseballService service;

    public Controller(BaseballService service) {
        this.service = service;
    }

    public void gameStart() {
        System.out.println(START);
        gameSet();

        while (true) {
            System.out.println(RESTART);
            String input = InputReader.readInput();
            if (input.equals("1")) {
                gameSet();
            }
            if (input.equals("2")) {
                break;
            }
        }
    }

    public void gameSet() {
        Numbers computerNumbers = Numbers.createComputerNumbers();
        while (true) {
            Numbers playerNumbers = requestPlayerNumbers();
            ResultType gameResult = gameRun(playerNumbers, computerNumbers);
            if (gameResult.equals(ResultType.ALL_STRIKE)) {
                ResultOutputWriter.printEnding();
                break;
            }
        }
    }

    private static Numbers requestPlayerNumbers() {
        ResultOutputWriter.print(Message.REQUEST_INPUT.getDetail());
        return ExceptionHandler.retryOnBusinessException(Controller::createPlayerNumbers);
    }

    private static Numbers createPlayerNumbers() {
        /**
         * 예외가 발생할 수 있는 메서드
         * 1. 입력받기
         * 2. 입력 값 검증
         * 3. 입력 값을 리스트로 변환
         * 4. 사용자의 Numbers로 생성
         */
        String input = InputReader.readInput();
        validateInputFormat(input);
        validateInputRange(input);
        List<Integer> parsedInput = Parser.parseToList(input);
        return Numbers.createPlayerNumbers(parsedInput);
    }

    private ResultType gameRun(Numbers playerNumbers, Numbers computerNumbers) {
        Result gameResult = service.getResult(playerNumbers, computerNumbers);
        ResultOutputWriter.printResult(gameResult);
        return gameResult.getResultType();
    }

    private static void validateInputFormat(String input) {
        if (!input.matches("^\\d+$")) {
            throw new IllegalArgumentException("올바른 숫자 형식이 아닙니다.");
        }
    }

    private static void validateInputRange(String input) {
        if (input.length() != Global.NUMBER_SIZE) {
            throw new IllegalArgumentException("숫자 크기는 " + Global.NUMBER_SIZE + "이어야 합니다.");
        }
    }
}
