package com.epam.jdi.light.asserts.generic;

import com.epam.jdi.light.elements.interfaces.base.IBaseElement;

/**
 * Class to extend Assertion interface
 * @param <E>
 */
public interface IBaseAssert<E extends IBaseElement> extends IBaseElement {
    E element();
}
