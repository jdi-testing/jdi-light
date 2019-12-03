package com.epam.jdi.light.logger;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.tools.Safe;
import com.epam.jdi.tools.func.JAction;
import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.map.MapArray;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverFactory.INIT_THREAD_ID;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.light.logger.LogLevels.INFO;
import static com.epam.jdi.light.logger.LogLevels.OFF;
import static com.epam.jdi.light.logger.LogLevels.STEP;
import static com.epam.jdi.light.logger.LogLevels.TRACE;
import static com.epam.jdi.light.logger.LogLevels.getLog4j2Level;
import static com.epam.jdi.tools.StringUtils.format;
import static io.qameta.allure.aspects.StepsAspects.getLifecycle;
import static io.qameta.allure.model.Status.PASSED;
import static io.qameta.allure.model.Status.FAILED;
import static java.lang.Thread.currentThread;
import static org.apache.logging.log4j.LogManager.getLogger;
import static org.apache.logging.log4j.core.config.Configurator.setLevel;
import static org.apache.logging.log4j.core.config.Configurator.setRootLevel;
import static com.epam.jdi.light.driver.ScreenshotMaker.takeScreen;

public class JDILogger implements ILogger {
    private Safe<Integer> logOffDeepness = new Safe<>(0);
    private String name;
    private Logger logger;
    private List<Long> multiThread = new ArrayList<>();
    private static MapArray<String, JDILogger> loggers = new MapArray<>();
    private static Marker jdiMarker = MarkerManager.getMarker("JDI");
    public static boolean writeToAllure = true;
    private Safe<LogLevels> logLevel = new Safe<>(INFO);
    private static String screenshotStrategy = "on fail";

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
    }
    public JDILogger(Class clazz) {
        this(clazz.getSimpleName());
    }

    public LogLevels getLogLevel() {
        return logLevel.get();
    }
    public void setLogLevel(LogLevels level) {
        logLevel = new Safe<>(level);
        setRootLevel(getLog4j2Level(level));
        setLevel(name, getLog4j2Level(level));
    }

    public String getScreenshotStrategy() {
        return screenshotStrategy;
    }
    public void setScreenshotStrategy(String strategy) {
        screenshotStrategy = strategy;
    }

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
            throw exception("Log Off Deepness to high. Please check that each logOff has appropriate logOn");
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
                throw exception(ex, ex.getMessage());
            }
        }
        logLevel.set(OFF);
        T result;
        try {
            result = func.invoke();
        } catch (Exception ex) {
            throw exception(ex, ex.getMessage());
        }
        logLevel.set(tempLevel);
        return result;
    }
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

    private static void writeToAllure(String message, Status status) {
        if (!writeToAllure) return;
        final String uuid = UUID.randomUUID().toString();
        StepResult step = new StepResult().withName(message).withStatus(status);
        getLifecycle().startStep(uuid, step);
        if (FAILED.equals(status) && ("on fail".equals(screenshotStrategy))) {
            try {
                takeScreenshot();
            } catch (IOException ex) {
                throw exception(ex, ex.getMessage());
            }
        }
        getLifecycle().stopStep(uuid);
    }

    private static void takeScreenshot() throws IOException {
        String screenName = takeScreen();
        if (!writeToAllure) return;
        Allure.addAttachment("Page screenshot", new ByteArrayInputStream(Files.readAllBytes(Paths.get(screenName))));
    }

    public void step(String s, Object... args) {
        if (logLevel.get().equalOrLessThan(STEP)) {
            logger.log(Level.forName("STEP", 350), jdiMarker, getRecord(s, args));
            writeToAllure(getRecord(s, args), PASSED);
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
        writeToAllure(getRecord(s, args), FAILED);
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
                default:
                    throw exception("Unknown log level: " + level);
            }
    }
}
