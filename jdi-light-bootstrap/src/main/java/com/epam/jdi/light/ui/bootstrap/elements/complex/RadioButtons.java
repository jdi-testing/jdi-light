package com.epam.jdi.light.ui.bootstrap.elements.complex;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.complex.WebList;

import static com.epam.jdi.light.common.TextTypes.INNER;

public class RadioButtons extends UIListBase<UISelectAssert> {
    @Override
    public WebList list() {
        return super.list().setUIElementName(INNER);
    }
    public RadioButtons() {
        base().setLocator("input[type=radio]");
    }
}
