package com.epam.jdi.light.logger;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public interface IJDILogger {
    void trace(String msg);
    void debug(String msg);
    void info(String msg);
    void step(String msg);
    void error(String msg);
}
