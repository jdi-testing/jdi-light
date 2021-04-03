package org.jdiai.jsbuilder;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public interface ILogger {
    void trace(String msg, Object... args);
    void debug(String msg, Object... args);
    void info(String msg, Object... args);
    void error(String msg, Object... args);
}
