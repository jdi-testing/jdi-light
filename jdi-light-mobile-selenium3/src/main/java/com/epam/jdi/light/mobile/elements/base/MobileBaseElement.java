package com.epam.jdi.light.mobile.elements.base;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.mobile.interfaces.IMobileCoreElement;

public abstract class MobileBaseElement<A extends UIAssert<?,?>> extends UIBaseElement<A>
        implements IMobileCoreElement {

    protected MobileUIElement mobileElement;
    @Override
    public MobileUIElement core() {
        if (mobileElement == null)
            mobileElement = new MobileUIElement();
        return mobileElement;
    }
}
