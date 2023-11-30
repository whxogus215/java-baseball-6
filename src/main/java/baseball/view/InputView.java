package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT = "숫자를 입력해주세요 : ";

    public static String readInput() {
        System.out.println(INPUT);
        return Console.readLine();
    }
}
