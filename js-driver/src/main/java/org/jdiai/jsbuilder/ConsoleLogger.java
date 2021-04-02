package org.jdiai.jsbuilder;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

import static com.epam.jdi.tools.Timer.nowTimeShort;
import static java.lang.String.format;
import static org.apache.logging.log4j.Level.*;
import static org.apache.logging.log4j.LogManager.getLogger;

public class ConsoleLogger implements ILogger {
    private final String name;
    public static Level LOG_LEVEL = INFO;

    public ConsoleLogger(String name) {
        this.name = name;
    }
    public void trace(String msg, Object... args) {
        if (!LOG_LEVEL.isLessSpecificThan(TRACE)) {
            return;
        }
        System.out.printf(format("[TRACE] %s %s ", nowTimeShort(), msg) + "%n", args);
    }
    public void debug(String msg, Object... args) {
        if (!LOG_LEVEL.isLessSpecificThan(DEBUG)) {
            return;
        }
        System.out.printf(format("[DEBUG] %s %s ", nowTimeShort(), msg) + "%n", args);
    }
    public void info(String msg, Object... args) {
        if (!LOG_LEVEL.isLessSpecificThan(INFO)) {
            return;
        }
        System.out.printf(format("[INFO] %s %s ", nowTimeShort(), msg) + "%n", args);
    }
    public void error(String msg, Object... args) {
        if (!LOG_LEVEL.isLessSpecificThan(ERROR)) {
            return;
        }
        System.out.printf(format("[ERROR] %s %s ", nowTimeShort(), msg) + "%n", args);
    }
}
