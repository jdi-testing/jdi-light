package com.epam.jdi.light.logger;

import com.jdiai.tools.Timer;

public class ConsoleLogger implements IJDILogger {
    public ConsoleLogger() { }

    public void trace(String msg) {
        System.out.printf("[TRACE %s]: %s%n", nowTime(), msg);
    }

    public void debug(String msg) {
        System.out.printf("[DEBUG %s]: %s%n", nowTime(), msg);
    }

    public void info(String msg) {
        System.out.printf("[INFO %s]: %s%n", nowTime(), msg);
    }

    public void step(String msg) {
        System.out.printf("[STEP %s]: %s%n", nowTime(), msg);
    }

    public void error(String msg) {
        System.out.printf("[ERROR %s]: %s%n", nowTime(), msg);
    }

    private String nowTime() {
        return Timer.nowTime("mm:ss.SSS");
    }
}
