package com.epam.jdi.light.mobile.elements.base;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.mobile.interfaces.IMobileAppCoreElement;

public abstract class MobileAppBaseElement<A extends UIAssert<?,?>> extends UIBaseElement<A>
        implements IMobileAppCoreElement, HasAssert<A> {

    protected mobileappuielement mobileAppUIElement;
    @Override
    public mobileappuielement core() {
        if (mobileAppUIElement == null)
            mobileAppUIElement = new mobileappuielement();
        return mobileAppUIElement;
    }
}
