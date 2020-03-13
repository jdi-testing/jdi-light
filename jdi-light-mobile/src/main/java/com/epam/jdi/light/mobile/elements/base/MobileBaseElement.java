package com.epam.jdi.light.mobile.elements.base;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.mobile.interfaces.IMobileCoreElement;

public abstract class MobileBaseElement<A extends UIAssert> extends UIBaseElement<A>
        implements IMobileCoreElement {

    protected MobileElement mobileElement;
    @Override
    public MobileElement core() {
        if (mobileElement == null)
            mobileElement = new MobileElement();
        return mobileElement;
    }
}
