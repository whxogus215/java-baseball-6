package baseball.view.output;

import baseball.config.Message;

public class OutputWriter {

    public static void print(Object object) {
        System.out.printf(object.toString());
    }

    public static void println(Object object) {
        System.out.println(object);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printMessage(Message message) {
        println(message.getDetail());
    }
}
