package com.epam.jdi.light.mobile.elements.common.app.android.notification;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.elements.interfaces.composite.PageObject;
import com.epam.jdi.light.mobile.elements.base.MobileAppBaseElement;

import static com.epam.jdi.light.mobile.elements.init.PageFactory.initElements;

public class BaseNotification extends MobileAppBaseElement<TextAssert> implements PageObject, IsText {
    BaseNotification() {
        initElements(this);
    }

    @Override
    public TextAssert is() {
        return new TextAssert().set(this);
    }

    //actions:
    public void tap() {}
    public void swipLeft() {}
    public void swipRight() {}
}
