package com.epam.jdi.light.mobile.elements.common.app;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.elements.interfaces.common.IsButton;
import com.epam.jdi.light.mobile.elements.base.MobileAppBaseElement;
import com.epam.jdi.light.mobile.interfaces.HasTouchActions;

public class Button extends MobileAppBaseElement<TextAssert>
        implements HasTouchActions, IsButton {

    @Override
    public TextAssert is() { return new TextAssert().set(this); }
}
