package com.epam.jdi.light.logger;

import com.epam.jdi.tools.Safe;
import com.epam.jdi.tools.func.JAction;
import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.map.MapArray;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.driver.WebDriverFactory.INIT_THREAD_ID;
import static com.epam.jdi.light.logger.LogLevels.*;
import static com.epam.jdi.tools.StringUtils.format;
import static java.lang.Thread.currentThread;
import static org.apache.logging.log4j.LogManager.getLogger;
import static org.apache.logging.log4j.core.config.Configurator.setLevel;
import static org.apache.logging.log4j.core.config.Configurator.setRootLevel;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class JDILogger implements ILogger {
    private static MapArray<String, JDILogger> loggers = new MapArray<>();
    private static Marker jdiMarker = MarkerManager.getMarker("JDI");

    public static JDILogger instance(String name) {
        if (!loggers.has(name))
            loggers.add(name, new JDILogger(name));
        return loggers.get(name);
    }

    public JDILogger() {
        this("JDI");
    }
    public JDILogger(String name) {
        logger = getLogger(name);
        this.name = name;
        setLogLevel(INFO);
    }
    public JDILogger(Class clazz) {
        this(clazz.getSimpleName());
    }

    private Safe<LogLevels> logLevel = new Safe<>(INFO);

    public LogLevels getLogLevel() {
        return logLevel.get();
    }
    public void setLogLevel(LogLevels level) {
        logLevel = new Safe<>(level);
        setRootLevel(getLog4j2Level(level));
        setLevel(name, getLog4j2Level(level));
    }
    private Safe<Integer> logOffDeepness = new Safe<>(0);

    public void logOff() {
        logLevel.set(OFF);
        logOffDeepness.update(v->v+1);
    }
    public void logOn() {
        logOffDeepness.update(v->v-1);
        if (logOffDeepness.get() > 0) return;
        if (logOffDeepness.get() == 0)
            logLevel.reset();
        if (logOffDeepness.get() < 0)
            throw new RuntimeException("Log Off Deepness to high. Please check that each logOff has appropriate logOn");
    }
    public void dropLogOff() {
        logOffDeepness.set(0);
        logLevel.reset();
    }
    public void logOff(JAction action) {
        logOff(() -> { action.invoke(); return null; });
    }
    public <T> T logOff(JFunc<T> func) {
        LogLevels tempLevel = logLevel.get();
        if (logLevel.get() == OFF) {
            try { return func.invoke();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        logLevel.set(OFF);
        T result;
        try{ result = func.invoke(); }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        logLevel.set(tempLevel);
        return result;
    }
    private String name;
    private Logger logger;
    private List<Long> multiThread = new ArrayList<>();
    private String getRecord(String record, Object... args) {
        long currentThreadId = currentThread().getId();
        if (currentThreadId != INIT_THREAD_ID  && !multiThread.contains(currentThreadId))
            multiThread.add(currentThreadId);
        return format(multiThread.size() > 1
                ? "[" + currentThread().getId() + "]" + record
                : record, args);
    }

    public String getName() {
        return name;
    }

    public void step(String s, Object... args) {
        if (logLevel.get().equalOrLessThan(STEP)) {
            logger.log(Level.forName("STEP", 350), jdiMarker, getRecord(s, args));
        }
    }

    public void trace(String s, Object... args) {
        if (logLevel.get().equalOrLessThan(TRACE)) {
            logger.trace(jdiMarker, getRecord(s, args));
        }
    }
    public void debug(String s, Object... args) {
        if (logLevel.get().equalOrLessThan(DEBUG)) {
            logger.debug(jdiMarker, getRecord(s, args));
        }
    }
    public void info(String s, Object... args) {
        if (logLevel.get().equalOrLessThan(INFO)) {
            logger.info(jdiMarker, getRecord(s, args));
        }
    }
    public void error(String s, Object... args) {
        logger.error(jdiMarker, getRecord(s, args));
    }

    public void toLog(String msg) {
        toLog(msg, logLevel.getDefault());
    }
    public void toLog(String msg, LogLevels level) {
        if (logLevel.get().equalOrLessThan(level))
            switch (level) {
                case ERROR: error(msg); break;
                case STEP: step(msg); break;
                case INFO: info(msg); break;
                case DEBUG: debug(msg); break;
                case OFF: break;
                default: throw new RuntimeException("Unknown log level: " + level);
            }
    }
}
