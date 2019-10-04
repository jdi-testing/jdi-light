package com.epam.jdi.light.elements.complex;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.Exceptions.safeException;

public interface IListSelector<T> extends ISelector, IList<T> {
    @Override
    default int size() {
        try {
            return base().noWait(() -> base().getList(0).size());
        } catch (Exception ex) {
            throw exception("Get size failed: "+ safeException(ex));
        }
    }
    @Override
    default boolean isEmpty() { return size() == 0; }
}
