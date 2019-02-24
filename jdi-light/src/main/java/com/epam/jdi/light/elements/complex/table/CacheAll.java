package com.epam.jdi.light.elements.complex.table;

import com.epam.jdi.tools.CacheValue;
import com.epam.jdi.tools.func.JFunc;

public class CacheAll<T> extends CacheValue<T> {
    public CacheAll() { }
    public CacheAll(JFunc<T> getRule) { setRule(getRule); }
    private boolean gotAll = false;
    protected boolean isGotAll() {
        if (!hasValue())
            gotAll = false;
        return gotAll;
    }
    public void gotAll() { gotAll = true; }
    @Override
    public void clear() { super.clear(); gotAll = false; }
}
