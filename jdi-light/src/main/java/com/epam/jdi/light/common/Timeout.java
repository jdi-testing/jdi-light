package com.epam.jdi.light.common;

import static com.epam.jdi.light.common.Exceptions.exception;
import com.epam.jdi.tools.Safe;

public class Timeout {
    private static int DEFAULT;
    private Safe<Integer> current = new Safe<>(DEFAULT);
    private Safe<Integer> freeze = new Safe<>(0);

    public Timeout(int timeoutSec) {
        DEFAULT = timeoutSec;
        current.set(timeoutSec);
    }
    public int get() {
        int result = current.get();
        reset();
        return result;
    }
    public void freeze() {
        freeze.update(v->v+1);
    }
    public void stopFreeze() {
        freeze.update(v->v-1);
        reset();
    }
    public void set(int seconds) {
        if (freeze.get() > 0) return;
        if (freeze.get() < 0) throw exception("Timeout freeze broken");
        current.set(seconds);
    }
    public void reset() {
        if (freeze.get() > 0) return;
        if (freeze.get() < 0) throw exception("Timeout freeze broken");
        current.set(DEFAULT);
    }
}
