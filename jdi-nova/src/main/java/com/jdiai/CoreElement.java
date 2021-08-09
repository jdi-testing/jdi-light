package com.jdiai;

import com.jdiai.interfaces.HasCore;

import static com.jdiai.JDI.initCoreFunc;

public class CoreElement implements HasCore {
    private JS core;

    public JS core() {
        return core != null ? core : initCoreFunc.apply(null);
    }

    public JS setCore(JS core) { this.core = core; return core; }

}
