package org.jdiai;

public class Section implements HasCore {
    JS core = new JS(JSTalk::driver);
    public JS core() { return core; }
    public void setCore(JS core) { this.core = core; }
}
