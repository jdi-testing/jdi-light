package com.epam.jdi.light.elements.complex;

import static com.epam.jdi.light.common.Exceptions.*;

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
