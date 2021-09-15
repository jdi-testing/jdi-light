package com.epam.jdi.light.elements.complex.table;

import com.epam.jdi.tools.CacheValue;
import com.epam.jdi.tools.Safe;
import com.epam.jdi.tools.func.JFunc;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class CacheAll<T> extends CacheValue<T> {
    private Safe<Boolean> gotAll = new Safe<>(() -> false);

    public CacheAll() { }

    public CacheAll(JFunc<T> getRule) { setRule(getRule); }

    protected boolean isGotAll() {
        if (!hasValue()) {
            gotAll.set(false);
        }
        return gotAll.get();
    }

    public void gotAll() {
        if (isUseCache()) {
            gotAll.set(true);
        }
    }

    @Override
    public void clear() { super.clear(); gotAll.set(false); }
}
