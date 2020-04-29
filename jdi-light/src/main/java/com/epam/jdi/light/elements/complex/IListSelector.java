package com.epam.jdi.light.elements.complex;

public interface IListSelector<T> extends ISelector, IList<T> {
    @Override
    default int size() {
        return IList.super.size();
    }
    @Override
    default boolean isEmpty() { return size() == 0; }
}
