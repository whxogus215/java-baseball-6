package baseball.exception;

import baseball.view.output.ResultOutputWriter;
import java.util.function.Supplier;

public class ExceptionHandler {
    private ExceptionHandler() {
    }

    public static <T> T retryOnBusinessException(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException exception) {
                ResultOutputWriter.println(exception.getMessage());
//                throw new IllegalArgumentException(exception);
            }
        }
    }


}
