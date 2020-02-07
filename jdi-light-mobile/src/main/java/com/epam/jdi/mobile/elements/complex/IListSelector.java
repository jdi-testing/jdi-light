package com.epam.jdi.mobile.elements.complex;

import static com.epam.jdi.mobile.common.Exceptions.exception;
import static com.epam.jdi.mobile.common.Exceptions.safeException;

public interface IListSelector<T> extends ISelector, IList<T> {
    @Override
    default int size() {
        try {
            return base().noWait(() -> base().getList(0).size());
        } catch (Exception ex) {
            throw exception(ex, "Get size failed");
        }
    }
    @Override
    default boolean isEmpty() { return size() == 0; }
}
