package com.epam.jdi.light.mobile.elements.base;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.mobile.interfaces.IMobileCoreElement;

public abstract class MobileBaseElement<A extends UIAssert<?,?>> extends UIBaseElement<A>
        implements IMobileCoreElement {

    protected mobileUIElement mobileElement;
    @Override
    public mobileUIElement core() {
        if (mobileElement == null)
            mobileElement = new mobileUIElement();
        return mobileElement;
    }
}
