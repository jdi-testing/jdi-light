package org.jdiai;

import org.jdiai.interfaces.HasCore;

public class JSElement implements HasCore {
    private JS core = new JS(JDI::driver);
    public JS core() { return core; }
    public void setCore(JS core) { this.core = core; }
}
