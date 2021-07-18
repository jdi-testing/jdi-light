package com.jdiai;

import com.jdiai.interfaces.HasCore;

import static com.jdiai.JDI.*;

public class CoreElement implements HasCore {
    private JS core;

    public JS core() {
        return core != null ? core : initJSFunc.execute(null, null, null);
    }

    public void setCore(JS core) { this.core = core; }

}
