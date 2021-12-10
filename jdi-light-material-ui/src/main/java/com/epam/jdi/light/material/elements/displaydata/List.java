package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.displaydata.ListAssert;

public class List extends UIBaseElement<ListAssert> {

    @Override
    public ListAssert is() { return new ListAssert().set(this); }
}
