package com.epam.jdi.light.logger;

import org.apache.logging.log4j.*;

import static org.apache.logging.log4j.MarkerManager.*;

public class Log4JLogger implements IJDILogger {
    private Logger log4J;
    private static Marker jdiMarker = getMarker("JDI");
    public Log4JLogger(String name) {
      log4J = LogManager.getLogger(name);
    }

    public void trace(String msg) {
        log4J.trace(jdiMarker, msg);
    }

    public void debug(String msg) {
        log4J.debug(jdiMarker, msg);
    }

    public void info(String msg) {
        log4J.info(jdiMarker, msg);
    }

    public void step(String msg) {
        log4J.log(Level.forName("STEP", 350), jdiMarker, msg);
    }

    public void error(String msg) {
        log4J.error(jdiMarker, msg);
    }
}
