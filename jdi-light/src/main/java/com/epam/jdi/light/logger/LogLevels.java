package com.epam.jdi.light.logger;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import org.apache.logging.log4j.Level;

import java.util.List;

import static com.epam.jdi.tools.LinqUtils.first;
import static java.lang.Integer.MAX_VALUE;
import static java.util.Arrays.asList;

public enum LogLevels {
    OFF(0),           // No logging
    FATAL(100),       // Unexpected errors
    ERROR(200),       // Critical errors
    WARNING(300),     // Errors due to wrong params
    STEP(350),        // Business related info
    INFO(400),        // Actions Info
    DEBUG(500),       // Debug info (not for prod)
    TRACE(600),       // Trace info (not for prod)
    ALL(MAX_VALUE);   // All log messages

    private int level;
    LogLevels(int level) {
        this.level = level;
    }
    public int getLevel() {
        return level;
    }
    public boolean equalOrLessThan(LogLevels level) {
        return getLevel() >= level.getLevel();
    }
    public boolean equalOrMoreThan(LogLevels level) {
        return getLevel() <= level.getLevel();
    }

    private static final List<Level> allLog4J2Levels =
        asList(Level.OFF,  Level.FATAL, Level.ERROR, Level.WARN, Level.INFO,
                Level.DEBUG, Level.TRACE, Level.ALL);
    public static Level getLog4j2Level(LogLevels level) {
        return first(allLog4J2Levels, l -> l.intLevel() >= level.level);
    }
}