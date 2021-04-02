package org.jdiai.jsdriver;

import java.util.function.Consumer;

import static java.lang.String.format;
import static org.jdiai.jsbuilder.QueryLogger.logger;

public class JSException extends RuntimeException {
    public static Consumer<String> THROW_ASSERT = msg -> { throw new AssertionError(msg); };
    public JSException(String message) { super(logException(message)); }
    public JSException(String message, Object... args) { this(format(message, args)); }
    public JSException(Throwable ex, String msg, Object... args) {
        this(getExceptionMessage(ex, msg, args));
    }

    private static String getExceptionMessage(Throwable ex, String msg, Object... args) {
        String message = args.length == 0 ? msg : format(msg, args);
        String exMsg = ex.getMessage();
        if (exMsg == null) {
            exMsg = ex.getCause().getMessage();
        }
        return message + "Exception: " + exMsg;
    }
    private static String logException(String message) {
        logger.error(message);
        return message;
    }
}
