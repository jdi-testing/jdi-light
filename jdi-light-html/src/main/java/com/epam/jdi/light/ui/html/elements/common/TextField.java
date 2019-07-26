package com.epam.jdi.light.ui.html.elements.common;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.HasInput;
import com.epam.jdi.light.elements.interfaces.HasLabel;
import com.epam.jdi.light.elements.interfaces.HasPlaceholder;
import com.epam.jdi.light.elements.interfaces.SetValue;

public class TextField extends UIBaseElement<TextAssert>
        implements HasLabel, SetValue, HasPlaceholder, HasInput {
    // region Set and get value for Forms
    public void setValue(String value) {
        input(value);
    }
    public String getValue() {
        return getText();
    }
    // endregion

    @Override
    public TextAssert is() {
        return new TextAssert().set(this);
    }

}
