package com.jdiai.jsdriver;

import java.util.function.Consumer;

import static com.jdiai.jsbuilder.QueryLogger.logger;
import static java.lang.String.format;

public class JDINovaException extends RuntimeException {
    public static Consumer<String> THROW_ASSERT = msg -> { throw new AssertionError(msg); };

    public static RuntimeException throwAssert(String message) {
        THROW_ASSERT.accept(message);
        return new RuntimeException();
    }

    public static RuntimeException throwAssert(Throwable ex, String msg, Object... args) {
        return throwAssert(getExceptionMessage(ex, msg, args));
    }

    public static RuntimeException throwAssert(String msg, Object... args) {
        return throwAssert(format(msg, args));
    }

    public static void assertEquals(String name, Object actual, Object expected) {
        logger.info("Assert that '%s' equals to '%s'", name, expected);
        if (actual == null && expected != null || actual != null && !actual.equals(expected)) {
            throw throwAssert("Expected: '%s'\nbut found\nActual: '%s'", expected, actual);
        }
    }

    public static void assertContains(String name, String actual, String expected) {
        logger.info("Assert that '%s' contains '%s'", name, expected);
        if (actual == null || expected == null || !actual.contains(expected)) {
            throw throwAssert("Expected that '%s'\ncontains '%s'\nbut failed", actual, expected);
        }
    }
    public static void assertContainsIgnoreCase(String name, String actual, String expected) {
        logger.info("Assert that '%s' contains ignore case '%s'", name, expected);
        if (actual == null || expected == null || !actual.toLowerCase().contains(expected.toLowerCase())) {
            throw throwAssert("Expected that '%s'\ncontains ignore-case '%s'\nbut failed", actual, expected);
        }
    }

    public JDINovaException(String message) { super(logException(message)); }

    public JDINovaException(String message, Object... args) { this(format(message, args)); }

    public JDINovaException(Throwable ex, String msg, Object... args) {
        this(getExceptionMessage(ex, msg, args));
    }

    private static String getExceptionMessage(Throwable ex, String msg, Object... args) {
        String message = args.length == 0 ? msg : format(msg, args);
        String exMsg = ex.getMessage();
        if (exMsg == null) {
            exMsg = ex.getCause().getMessage();
        }
        return message + "\nException: " + exMsg;
    }

    private static String logException(String message) {
        // logger.error(message);
        return message;
    }
}
