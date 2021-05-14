package com.jditest;

import com.jditest.interfaces.HasCore;

public class JSCore implements HasCore {
    private JS core = new JS(JDI::driver);
    public JS core() { return core; }
    public void setCore(JS core) { this.core = core; }
}
