package baseball.exception;

import baseball.view.OutputView;
import java.util.function.Supplier;

public class ExceptionHandler {
    private ExceptionHandler() {
    }

    public static <T> T retryOnBusinessException(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException exception) {
                OutputView.println(exception.getMessage());
            }
        }
    }


}
