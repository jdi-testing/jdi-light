package com.epam.jdi.light.common;

import org.apache.commons.lang3.exception.ExceptionUtils;

import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.jdiai.tools.ReflectionUtils.isClass;
import static com.jdiai.tools.StringUtils.LINE_BREAK;
import static com.jdiai.tools.StringUtils.format;

/**
 * Created by Roman_Iovlev on 3/19/2018.
 */
public class Exceptions {
    public static RuntimeException runtimeException(String msg, Object... args) {
        String message = args.length == 0 ? msg : format(msg, args);
        logger.debug("ERROR: " + message);
        return new RuntimeException(LINE_BREAK + message);
    }

    public static RuntimeException exception(Throwable ex, String msg, Object... args) {
        String message = args.length == 0 ? msg : format(msg, args);
        String exMsg = ex.getMessage();
        if (exMsg == null) {
            exMsg = ex.getCause().getMessage();
        }
        String stacktrace = ExceptionUtils.getStackTrace(ex);
        logger.debug("ERROR: " + message + ". Exception: " + exMsg);
        logger.trace("ERROR STACKTRACE: " + message + ". Stacktrace: " + stacktrace);
        final Class<?> exceptionClass = ex.getClass();
        message = "\n" + message;
        if (isClass(exceptionClass, AssertionError.class)) {
            throw new AssertionError(message, ex);
        }
        if (ex.getClass().getSimpleName().equals("RuntimeException")) {
            return new RuntimeException(message, ex);
        }
        message = ex.getClass().getName() + "\n" + message;
        return new RuntimeException(message, ex);
    }
}
