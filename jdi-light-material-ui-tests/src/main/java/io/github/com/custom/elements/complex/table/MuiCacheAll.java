package io.github.com.custom.elements.complex.table;

import com.epam.jdi.light.elements.complex.table.CacheAll;
import com.jdiai.tools.func.JFunc;

public class MuiCacheAll<T> extends CacheAll<T> {
    public MuiCacheAll() {

    }

    public MuiCacheAll(JFunc<T> getRule) { setRule(getRule); }

    @Override
    protected boolean isGotAll() {
        return super.isGotAll();
    }
}
