package com.epam.jdi.light.ui.html.elements.complex;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.complex.WebList;

import static com.epam.jdi.light.common.TextTypes.LABEL;

public class RadioButtons extends UIListBase<UISelectAssert> {
    @Override
    public WebList list() {
        return super.list().setUIElementName(LABEL);
    }
    public RadioButtons() {
        base().setLocator("input[type=radio]");
    }
}
