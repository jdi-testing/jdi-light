package com.epam.jdi.light.common;

public class Timeout {
    private int DEFAULT;
    private int CURRENT;

    public Timeout(int timeoutSec) {
        DEFAULT = timeoutSec;
        CURRENT = timeoutSec;
    }

    public int get() {
        int result = CURRENT;
        reset();
        return result;
    }
    public void set(int seconds) {
        CURRENT = seconds;
    }
    public void reset() { CURRENT = DEFAULT; }
}
