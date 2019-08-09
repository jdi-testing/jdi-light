package com.epam.jdi.light.common;

import com.epam.jdi.tools.Safe;
import com.epam.jdi.tools.func.JAction1;
import com.epam.jdi.tools.func.JFunc;

import java.util.concurrent.TimeUnit;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.settings.WebSettings.logger;

public class Timeout {
    private int INITIAL;
    private Safe<Integer> DEFAULT;
    public Safe<Integer> current;
    private Safe<Integer> freeze;

    public Timeout(int timeoutSec) {
        INITIAL = timeoutSec;
        DEFAULT = new Safe<>(timeoutSec);
        current = new Safe<>(timeoutSec);
        freeze = new Safe<>(0);
    }
    public int get() {
        int result = current.get();
        reset();
        return result;
    }
    public void freeze() {
        freeze.update(v->v+1);
    }
    public void unfreeze() {
        if (freeze.get() > 0)
            freeze.update(v->v-1);
        reset();
    }
    public void setUp(int seconds) {
        DEFAULT.set(seconds);
        current.set(seconds);
        logger.info("Setup timeout " + seconds + " seconds");
    }
    public void set(int seconds) {
        if (freeze.get() > 0) return;
        if (freeze.get() < 0) throw exception("Timeout freeze broken");
        current.set(seconds);
        logger.info("Set timeout " + seconds + " seconds");
    }
    public void reset() {
        if (freeze.get() > 0) return;
        if (freeze.get() < 0) throw exception("Timeout freeze broken");
        current.set(DEFAULT.get());
    }
    public void drop() {
        freeze.set(0);
        current.set(INITIAL);
        DEFAULT.set(INITIAL);
    }
}
