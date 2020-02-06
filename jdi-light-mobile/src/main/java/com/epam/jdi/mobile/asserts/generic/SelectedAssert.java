package com.epam.jdi.mobile.asserts.generic;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public interface SelectedAssert<A> {
    A selected();
    A deselected();
}
