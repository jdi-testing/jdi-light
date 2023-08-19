package com.epam.jdi.light.logger;

import com.jdiai.tools.func.JFunc;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public interface ILogger {
    <T> T logOff(JFunc<T> action);
    void trace(String msg, Object... args);
    void debug(String msg, Object... args);
    void info(String msg, Object... args);
    void step(String msg, Object... args);
    void error(String msg, Object... args);
    void toLog(String msg, LogLevels level);
    void toLog(String msg);
    void setLogLevel(LogLevels levels);
    LogLevels getLogLevel();
}
