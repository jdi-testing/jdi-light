package com.jdiai.jsbuilder;

import com.epam.jdi.tools.ILogger;
import org.apache.logging.log4j.Logger;

import static java.lang.String.format;
import static org.apache.logging.log4j.Level.*;
import static org.apache.logging.log4j.LogManager.getLogger;

public class Slf4JLogger implements ILogger {
    private final String name;
    private final Logger slf4j;

    public Slf4JLogger(String name) {
        this.name = name;
        slf4j = getLogger(name);
    }
    public void trace(String msg, Object... args) {
        if (!slf4j.getLevel().isLessSpecificThan(TRACE)) {
            return;
        }
        slf4j.trace(format(msg, args));
    }
    public void debug(String msg, Object... args) {
        if (!slf4j.getLevel().isLessSpecificThan(DEBUG)) {
            return;
        }
        slf4j.debug(format(msg, args));
    }
    public void info(String msg, Object... args) {
        if (!slf4j.getLevel().isLessSpecificThan(INFO)) {
            return;
        }
        slf4j.info(format(msg, args));
    }
    public void error(String msg, Object... args) {
        if (!slf4j.getLevel().isLessSpecificThan(ERROR)) {
            return;
        }
        slf4j.error(format(msg, args));
    }
}
