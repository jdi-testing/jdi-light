package com.jdiai;

import com.jdiai.interfaces.HasCore;

import static com.jdiai.JDI.initJSFunc;

public class CoreElement implements HasCore {
    private JS core;

    public JS core() {
        return core != null ? core : initJSFunc.execute(null, null, null);
    }

    public JS setCore(JS core) { this.core = core; return core; }

}
