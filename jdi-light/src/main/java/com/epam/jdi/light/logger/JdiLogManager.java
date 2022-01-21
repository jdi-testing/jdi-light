package com.epam.jdi.light.logger;

import com.jdiai.tools.FixedQueue;
import com.jdiai.tools.Safe;
import com.jdiai.tools.func.JAction;
import com.jdiai.tools.func.JFunc;
import com.jdiai.tools.map.MapArray;

import java.util.Properties;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverFactory.MULTI_THREAD;
import static com.epam.jdi.light.logger.LogLevels.*;
import static com.epam.jdi.light.settings.JDISettings.COMMON;
import static com.epam.jdi.light.settings.WebSettings.getProperties;
import static com.jdiai.tools.PrintUtils.print;
import static com.jdiai.tools.StringUtils.LINE_BREAK;
import static com.jdiai.tools.StringUtils.format;
import static java.lang.Thread.currentThread;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class JdiLogManager implements ILogger {
    public Safe<FixedQueue<String>> debugLog = new Safe<>(() -> new FixedQueue<>(debugBufferSize));
    private String name;

    public static MapArray<String, IJDILogger> loggers = new MapArray<>();
    public static int debugBufferSize = 0;
    public static void registerNewLogger(String name, IJDILogger logger) {
        loggers.add(name, logger);
    }
    public static void setLogger(String name, IJDILogger logger) {
        loggers.clear();
        loggers.add(name, logger);
    }

    public JdiLogManager() {
        this("JDI");
    }
    public JdiLogManager(String name) {
        if (!loggers.has(name)) {
            loggers.add(name, new Slf4JLogger(name));
        }
        this.name = name;
        setLogLevel(initialLogLevel());
    }
    public JdiLogManager(Class<?> clazz) {
        this(clazz.getSimpleName());
    }

    private Safe<LogLevels> logLevel = new Safe<>(INFO);

    public LogLevels getLogLevel() {
        return logLevel.get();
    }
    private LogLevels initialLogLevel() {
        Properties properties = getProperties(COMMON.testPropertiesPath);
        String logLevelProp = properties.getProperty("log.level");
        return isNotBlank(logLevelProp)
            ? parseLogLevel(logLevelProp)
            : INFO;
    }
    public void setLogLevel(LogLevels level) {
        logLevel = new Safe<>(level);
        // For Log4J that is removed for security reasons
        // setRootLevel(getLog4j2Level(level));
        // setLevel(name, getLog4j2Level(level));
    }
    private Safe<Integer> logOffDeepness = new Safe<>(0);

    public void logOff() {
        logLevel.set(OFF);
        logOffDeepness.update(v->v+1);
    }
    public void logOn() {
        logOffDeepness.update(v->v-1);
        if (logOffDeepness.get() > 0) return;
        if (logOffDeepness.get() == 0) {
            logLevel.reset();
        }
        if (logOffDeepness.get() < 0) {
            throw new RuntimeException("Log Off Deepness to high. Please check that each logOff has appropriate logOn");
        }
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
        if (logLevel.get() == TRACE) {
            try {
                return func.invoke();
            } catch (Throwable ex) {
                throw exception(ex, "");
            }
        }
        logLevel.set(TRACE);
        try {
            return func.invoke();
        } catch (Throwable ex) {
            throw exception(ex, "");
        }
        finally {
            logLevel.set(tempLevel);
        }
    }
    private String getRecord(String record, Object... args) {
        String prefix = MULTI_THREAD ? "[" + currentThread().getId() + "] " : "";
        return format(prefix + record, args);
    }

    public void throwDebugInfo() {
        if (debugBufferSize == 0) return;
        String prefix = MULTI_THREAD ? "[" + currentThread().getId() + "] " : "";
        error(prefix + "DEBUG INFO: " + LINE_BREAK + print(debugLog.get().values(), LINE_BREAK));
    }
    public String getName() {
        return name;
    }

    public void step(String s, Object... args) {
        debugLog.get().push(format(s, args));
        if (logLevel.get().equalOrLessThan(STEP)) {
            loggers.foreach((n, l) -> l.step(getRecord(s, args)));
        }
    }

    public void trace(String s, Object... args) {
        debugLog.get().push(format(s, args));
        if (logLevel.get().equalOrLessThan(TRACE)) {
            loggers.foreach((n, l) -> l.trace(getRecord(s, args)));
        }
    }
    public void debug(String s, Object... args) {
        debugLog.get().push(format(s, args));
        if (logLevel.get().equalOrLessThan(DEBUG)) {
            loggers.foreach((n, l) -> l.debug(getRecord(s, args)));
        }
    }
    public void info(String s, Object... args) {
        debugLog.get().push(format(s, args));
        if (logLevel.get().equalOrLessThan(INFO)) {
            loggers.foreach((n, l) -> l.info(getRecord(s, args)));
        }
    }
    public void error(String s, Object... args) {
        debugLog.get().push(format(s, args));
        loggers.foreach((n, l) -> l.error(getRecord(s, args)));
    }

    public void toLog(String msg) {
        toLog(msg, logLevel.getDefault());
    }

    public void toLog(String msg, LogLevels level) {
        if (logLevel.get().equalOrLessThan(level)) {
            switch (level) {
                case ERROR: error(msg); break;
                case STEP: step(msg); break;
                case INFO: info(msg); break;
                case DEBUG: debug(msg); break;
                case TRACE: trace(msg); break;
                case OFF: break;
                default: throw new RuntimeException("Unknown log level: " + level);
            }
        } else {
            debugLog.get().push(msg);
        }
    }
}
