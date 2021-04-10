package org.jdiai;

import org.jdiai.interfaces.HasCore;

public class Section implements HasCore {
    JS core = new JS(JDI::driver);
    public JS core() { return core; }
    public void setCore(JS core) { this.core = core; }
}
