package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.HasPlaceholder;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.light.elements.interfaces.common.IsInput;
import com.epam.jdi.light.ui.bootstrap.asserts.TextFieldAssert;

import static com.epam.jdi.light.common.TextTypes.VALUE;

public class TextField extends UIBaseElement<TextFieldAssert>
        implements HasLabel, SetValue, HasPlaceholder, IsInput {

    public void setValue(String value) {
        input(value);
    }
    public String getValue() {
        return getText();
    }
    @Override
    public String getText() { return core().text(VALUE); }

    @Override
    public TextFieldAssert is() {
        return new TextFieldAssert().set(this);
    }

}
