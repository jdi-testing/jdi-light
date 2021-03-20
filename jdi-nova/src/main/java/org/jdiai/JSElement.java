package org.jdiai;

public class JSElement implements HasCore {
    JS core = new JS(JSTalk::driver);
    public JS core() { return core; }
    public void setCore(JS core) { this.core = core; }
}
