package com.epam.jdi.light.common;

import java.lang.reflect.InvocationTargetException;

import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;
import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Created by Roman_Iovlev on 3/19/2018.
 */
public class Exceptions {
    public static RuntimeException exception(String msg, Object... args) {
        String message = args.length == 0 ? msg : format(msg, args);
        return new RuntimeException(LINE_BREAK + message);
    }
    public static RuntimeException exception(Throwable ex, String msg, Object... args) {
        String message = args.length == 0 ? msg : format(msg, args);
        return new RuntimeException(LINE_BREAK + message + LINE_BREAK + "Exception: " + safeException(ex));
    }

    public static String safeException(Throwable ex) {
        String msg = ex.getMessage();
        if (isBlank(msg) && isClass(ex.getClass(), InvocationTargetException.class))
            msg = ((InvocationTargetException) ex).getTargetException().getMessage();
        return isNotBlank(msg) ? msg : ex.toString();
    }
}
