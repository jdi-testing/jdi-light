package com.epam.jdi.light.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;

import static org.slf4j.MarkerFactory.getMarker;

public class Slf4JLogger implements IJDILogger {
    private Logger slf4j;
    private static Marker stepMarker = getMarker("STEP");
    public Slf4JLogger(String name) {
        slf4j = LoggerFactory.getLogger(name);
    }

    public void trace(String msg) {
        slf4j.trace(msg);
    }

    public void debug(String msg) {
        slf4j.debug(msg);
    }

    public void info(String msg) {
        slf4j.info(msg);
    }

    public void step(String msg) {
        slf4j.info(stepMarker, msg);
    }

    public void error(String msg) {
        slf4j.error(msg);
    }
}
