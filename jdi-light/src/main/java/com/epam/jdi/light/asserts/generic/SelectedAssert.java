package com.epam.jdi.light.asserts.generic;

public interface SelectedAssert<A> {
    A selected();
    A deselected();
}
