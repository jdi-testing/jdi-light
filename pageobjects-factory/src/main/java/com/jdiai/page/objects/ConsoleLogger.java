package com.jdiai.page.objects;

import com.jdiai.tools.ILogger;

import static com.jdiai.tools.Timer.nowTimeShort;
import static java.lang.String.format;

public class ConsoleLogger implements ILogger {
    private final String name;
    public int logLevel = 2;

    public ConsoleLogger(String name) {
        this.name = name;
    }

    public void trace(String msg, Object... args) {
        if (logLevel == 4) {
            return;
        }
        printMessage("trace", msg, args);
    }
    public void debug(String msg, Object... args) {
        if (logLevel >= 3) {
            return;
        }
        printMessage("debug", msg, args);
    }
    public void info(String msg, Object... args) {
        if (logLevel >= 2) {
            return;
        }
        printMessage("info", msg, args);
    }
    public void error(String msg, Object... args) {
        if (logLevel >= 1) {
            return;
        }
        printMessage("error", msg, args);
    }

    private void printMessage(String logLevel, String msg, Object... args) {
        String message = args.length == 0
            ? msg : format(msg, args);
        long threadId = Thread.currentThread().getId();
        String logInfo = threadId == 1 ? logLevel : logLevel + ":" + threadId;
        System.out.printf("[%s] %s %s %n", logInfo, nowTimeShort(), message);
    }
}
