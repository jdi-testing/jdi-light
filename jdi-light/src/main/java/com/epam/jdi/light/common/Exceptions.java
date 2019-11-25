package com.epam.jdi.light.common;

import static com.epam.jdi.tools.StringUtils.LINE_BREAK;
import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Created by Roman_Iovlev on 3/19/2018.
 */

@SuppressWarnings("PMD.ClassNamingConventions")
public class Exceptions {
    public static RuntimeException exception(String msg, Object... args) {
        String message = args.length == 0 ? msg : format(msg, args);
        return new RuntimeException(LINE_BREAK + message);
    }

    public static RuntimeException exception(Throwable ex, String msg, Object... args) {
        String message = args.length == 0 ? msg : format(msg, args);
        return new RuntimeException(LINE_BREAK + message, ex);
    }

    public static String safeException(Throwable ex) {
        String msg = ex.getMessage();
        return isNotBlank(msg) ? msg : ex.toString();
    }
}
