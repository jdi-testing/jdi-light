package org.jdiai.jsdriver;

import java.util.function.Consumer;

import static java.lang.String.format;

public class JSException extends RuntimeException {
    public static Consumer<String> THROW_EXCEPTION = detailMessage -> { throw new AssertionError(detailMessage); };
    public JSException(String message) { super(message); }
    public JSException(String message, Object... args) { super(format(message, args)); }

    public JSException(Throwable ex, String msg, Object... args) {
        super(getExceptionMessage(ex, msg, args));
    }
    private static String getExceptionMessage(Throwable ex, String msg, Object... args) {
        String message = args.length == 0 ? msg : format(msg, args);
        String exMsg = ex.getMessage();
        if (exMsg == null)
            exMsg = ex.getCause().getMessage();
        return message + "Exception: " + exMsg;
    }
}
