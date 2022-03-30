package io.github.com.custom.elements.table;

import com.epam.jdi.light.elements.complex.table.CacheAll;
import com.jdiai.tools.func.JFunc;

/**
 * Class for rows extraction from table.
 * Extend from CacheAll for use method isGotAll()
 *
 * @param <T>
 */
public class MuiCacheAll<T> extends CacheAll<T> {

    public MuiCacheAll() {

    }

    public MuiCacheAll(JFunc<T> getRule) {
        setRule(getRule);
    }

    /**
     * Check is more row exists
     *
     * @return {@code true} if no more rows in table, otherwise {@code false}
     */
    @Override
    protected boolean isGotAll() {
        return super.isGotAll();
    }
}
