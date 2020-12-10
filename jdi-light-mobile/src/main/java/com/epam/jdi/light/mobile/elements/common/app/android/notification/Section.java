package com.epam.jdi.light.mobile.elements.common.app.android.notification;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.elements.interfaces.composite.PageObject;
import com.epam.jdi.light.mobile.elements.base.MobileAppBaseElement;

import static com.epam.jdi.light.mobile.elements.init.PageFactory.initElements;

public class Section extends MobileAppBaseElement<TextAssert> implements PageObject{

    public Section() {
        initElements(this);
    }
}
