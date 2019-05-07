package com.epam.jdi.light.common;

import static com.epam.jdi.light.common.Exceptions.exception;

public class Timeout {
    private int DEFAULT;
    private int CURRENT;
    private int freeze = 0;

    public Timeout(int timeoutSec) {
        DEFAULT = timeoutSec;
        CURRENT = timeoutSec;
    }

    public int get() {
        int result = CURRENT;
        reset();
        return result;
    }
    public void freeze() {
        freeze ++;
    }
    public void stopFreeze() {
        freeze --;
        reset();
    }
    public void set(int seconds) {
        if (freeze > 0) return;
        if (freeze < 0) throw exception("Timeout freeze broken");
        CURRENT = seconds;
    }
    public void reset() {
        if (freeze > 0) return;
        if (freeze < 0) throw exception("Timeout freeze broken");
        CURRENT = DEFAULT;
    }
}
