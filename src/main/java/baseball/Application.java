package baseball;

import baseball.controller.Controller;
import baseball.service.BaseballService;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(new BaseballService());

        controller.gameStart();
    }
}
