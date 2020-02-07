package com.epam.jdi.mobile.ui.html.elements.common;

import com.epam.jdi.mobile.asserts.generic.TextAssert;
import com.epam.jdi.mobile.elements.base.UIBaseElement;
import com.epam.jdi.mobile.elements.interfaces.base.HasLabel;
import com.epam.jdi.mobile.elements.interfaces.base.HasPlaceholder;
import com.epam.jdi.mobile.elements.interfaces.base.SetValue;
import com.epam.jdi.mobile.elements.interfaces.common.IsInput;

import static com.epam.jdi.mobile.common.TextTypes.VALUE;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class TextField extends UIBaseElement<TextAssert>
        implements HasLabel, SetValue, HasPlaceholder, IsInput {
    // region Set and get value for Forms
    public void setValue(String value) {
        input(value);
    }
    public String getValue() {
        return getText();
    }
    @Override
    public String getText() { return core().text(VALUE); }
    // endregion

    @Override
    public TextAssert is() {
        return new TextAssert().set(this);
    }

}
