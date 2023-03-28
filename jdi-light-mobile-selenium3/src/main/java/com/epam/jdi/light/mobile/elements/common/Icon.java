package com.epam.jdi.light.mobile.elements.common;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasValue;
import com.epam.jdi.light.mobile.elements.base.MobileBaseElement;
import com.epam.jdi.light.mobile.interfaces.HasTouchActions;

public class Icon extends MobileBaseElement<TextAssert> implements HasTouchActions, HasClick, HasValue {
    @Override
    public String getValue() {
        return core().getValue();
    }
}
