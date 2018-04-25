package com.epam.jdi.light.common;

import static com.epam.jdi.light.settings.WebSettings.logger;
import static java.lang.String.format;

/**
 * Created by Roman_Iovlev on 3/19/2018.
 */
public class Exceptions {
    public static RuntimeException exception(String msg, Object... args) {
        String message = format(msg, args);
        logger.dropLogOff();
        return new RuntimeException(message);
    }
}
