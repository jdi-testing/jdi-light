package com.epam.jdi.light.mobile.elements.common.app.ios;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.light.elements.interfaces.common.IsInput;
import com.epam.jdi.light.mobile.elements.base.MobileAppBaseElement;
import com.epam.jdi.light.mobile.elements.base.MobileAppUIElement;
import com.epam.jdi.light.mobile.elements.common.app.ITextField;
import com.epam.jdi.light.mobile.interfaces.HasTouchActions;

import static com.epam.jdi.light.common.TextTypes.VALUE;
import static com.epam.jdi.light.mobile.elements.init.MobileAppFactory.$;

public class TextField extends MobileAppBaseElement<TextAssert>
        implements SetValue, IsInput, HasTouchActions, ITextField {

    public void setValue(String value) {
        core().tap();
        MobileAppUIElement continueButton =
                $("//XCUIElementTypeOther[@name='UIContinuousPathIntroductionView']" +
                        "//XCUIElementTypeButton[@name='Continue']");
        if (continueButton.isDisplayed()) {
            continueButton.tap();
        }
        input(value);
    }

    public String getValue() {
        return getText();
    }

    @Override
    public String getText() { return core().text(VALUE); }

    @Override
    @JDIAction("Clear value in {name}")
    public void clear() {
        core().clear();
    }

    @Override
    public TextAssert is() {
        return new TextAssert().set(this);
    }
}
