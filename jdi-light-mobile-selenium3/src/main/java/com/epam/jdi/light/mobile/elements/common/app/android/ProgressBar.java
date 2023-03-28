package com.epam.jdi.light.mobile.elements.common.app.android;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.mobile.elements.base.MobileAppBaseElement;
import com.epam.jdi.light.mobile.interfaces.HasTouchActions;

public class ProgressBar extends MobileAppBaseElement<TextAssert> implements HasTouchActions, IsText {

    @JDIAction("Get the default value")
    public String getProgressValue() {
        return core().getText();
    }

    @Override
    public TextAssert is() {
        return new TextAssert().set(this);
    }
}
