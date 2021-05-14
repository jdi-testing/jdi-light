package com.jdiai.jsbuilder;

import org.apache.logging.log4j.Level;

import static com.epam.jdi.tools.Timer.nowTimeShort;
import static java.lang.String.format;
import static org.apache.logging.log4j.Level.*;

public class ConsoleLogger implements ILogger {
    private final String name;

    public ConsoleLogger(String name) {
        this.name = name;
    }
    public void trace(String msg, Object... args) {
        if (!LOG_LEVEL.isLessSpecificThan(TRACE)) {
            return;
        }
        printMessage(TRACE, msg, args);
    }
    public void debug(String msg, Object... args) {
        if (!LOG_LEVEL.isLessSpecificThan(DEBUG)) {
            return;
        }
        printMessage(DEBUG, msg, args);
    }
    public void info(String msg, Object... args) {
        if (!LOG_LEVEL.isLessSpecificThan(INFO)) {
            return;
        }
        printMessage(INFO, msg, args);
    }
    public void error(String msg, Object... args) {
        if (!LOG_LEVEL.isLessSpecificThan(ERROR)) {
            return;
        }
        printMessage(ERROR, msg, args);
    }
    private void printMessage(Level logLevel, String msg, Object... args) {
        String message = args.length == 0
            ? msg : format(msg, args);
        long threadId = Thread.currentThread().getId();
        String logInfo = threadId == 1
            ? logLevel.toString()
            : logLevel.toString() + ":" + threadId;
        System.out.printf("[%s] %s %s %n", logInfo, nowTimeShort(), message);
    }
}
