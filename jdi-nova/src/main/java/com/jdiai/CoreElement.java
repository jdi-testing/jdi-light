package com.jdiai;

import com.jdiai.asserts.Condition;
import com.jdiai.interfaces.HasCore;

public class CoreElement<T extends HasCore> implements HasCore {
    private JS core = new JS(JDI::driver);
    public JS core() { return core; }
    public void setCore(JS core) { this.core = core; }

    @Override
    public T shouldBe(Condition... conditions) {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public T setName(String name) {
        return null;
    }
}
