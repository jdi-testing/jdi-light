package com.jdiai;

import com.jdiai.interfaces.HasCore;

public class CoreElement implements HasCore {
    private JS core;

    public JS core() {
        return core != null ? core : JDI.initJSFunc.get();
    }

    public void setCore(JS core) { this.core = core; }

}
