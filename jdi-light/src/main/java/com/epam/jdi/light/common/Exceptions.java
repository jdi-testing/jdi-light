package com.epam.jdi.light.common;

import static java.lang.String.format;

/**
 * Created by Roman_Iovlev on 3/19/2018.
 */
public class Exceptions {
    public static AssertionError exception(String msg, Object... args) {
        String message = format(msg, args);
        return new AssertionError(message);
    }
}
