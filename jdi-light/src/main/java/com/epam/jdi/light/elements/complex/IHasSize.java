package com.epam.jdi.light.elements.complex;

import com.epam.jdi.light.elements.base.BaseElement;
import com.epam.jdi.light.elements.interfaces.INamed;

import java.util.List;

public interface IHasSize {
    int size();
    default boolean isEmpty() { return size() == 0; }
    default boolean hasAny() { return size() > 0; }
}
