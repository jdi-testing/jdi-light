package com.epam.jdi.light.mobile.elements.common.ios.app;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.light.elements.interfaces.common.IsInput;
import com.epam.jdi.light.mobile.elements.base.MobileAppBaseElement;
import com.epam.jdi.light.mobile.interfaces.HasTouchActions;

import static com.epam.jdi.light.common.TextTypes.VALUE;

public class TextField extends MobileAppBaseElement<TextAssert>
        implements SetValue, IsInput, HasTouchActions {

    public void setValue(String value) {
        input(value);
    }
    public String getValue() {
        return getText();
    }
    @Override
    public String getText() { return core().text(VALUE); }

    @Override
    public TextAssert is() {
        return new TextAssert().set(this);
    }
}
