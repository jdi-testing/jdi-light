package com.epam.jdi.light.elements.complex;

public interface IHasSize {
    int size();
    default boolean isEmpty() { return size() == 0; }
    default boolean hasAny() { return size() > 0; }
}
