package com.jdiai.jsbuilder;

import com.jdiai.tools.ILogger;
import org.apache.logging.log4j.Logger;

import static com.jdiai.tools.StringUtils.format;
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
        try {
            if (!slf4j.getLevel().isLessSpecificThan(TRACE)) {
                return;
            }
            slf4j.trace(format(msg, args));
        } catch (Throwable ex) {
            System.out.println("[Warning] Failed to log '" + msg + "'. Please report to https://github.com/jdi-testing/jdi-nova/issues/new");
        }
    }
    public void debug(String msg, Object... args) {
        try {
            if (!slf4j.getLevel().isLessSpecificThan(DEBUG)) {
                return;
            }
            slf4j.debug(format(msg, args));
        } catch (Throwable ex) {
            System.out.println("[Warning] Failed to log '" + msg + "'. Please report to https://github.com/jdi-testing/jdi-nova/issues/new");
        }
    }
    public void info(String msg, Object... args) {
        try {
            if (!slf4j.getLevel().isLessSpecificThan(INFO)) {
                return;
            }
            slf4j.info(format(msg, args));
        } catch (Throwable ex) {
            System.out.println("[Warning] Failed to log '" + msg + "'. Please report to https://github.com/jdi-testing/jdi-nova/issues/new");
        }
    }
    public void error(String msg, Object... args) {
        try {
            if (!slf4j.getLevel().isLessSpecificThan(ERROR)) {
                return;
            }
            slf4j.error(format(msg, args));
        } catch (Exception ex) {
            System.out.println("[Warning] Failed to log '" + msg + "'. Please report to https://github.com/jdi-testing/jdi-nova/issues/new");
        }
    }
}
