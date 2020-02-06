package com.epam.jdi.mobile.elements.complex;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public interface IHasSize {
    int size();
    default boolean isEmpty() { return size() == 0; }
    default boolean isNotEmpty() { return size() > 0; }
}
