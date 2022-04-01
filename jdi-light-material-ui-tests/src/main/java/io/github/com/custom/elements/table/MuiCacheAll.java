package io.github.com.custom.elements.table;

import com.epam.jdi.light.elements.complex.table.CacheAll;
import com.jdiai.tools.func.JFunc;

/**
 * Class for rows extraction from table.
 *
 * @param <T> type which class contains in Supplier getRule {@link com.jdiai.tools.CacheValue}
 */
public class MuiCacheAll<T> extends CacheAll<T> {

    /**
     * Default constructor
     */
    public MuiCacheAll() {

    }

    /**
     * Constructor
     * @param getRule type will be set in Supplier getRule {@link com.jdiai.tools.CacheValue}
     */
    public MuiCacheAll(JFunc<T> getRule) {
        setRule(getRule);
    }

    @Override
    protected boolean isGotAll() {
        return super.isGotAll();
    }
}
