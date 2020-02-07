package com.epam.jdi.mobile.ui.html.elements.complex;

import com.epam.jdi.mobile.asserts.generic.UISelectAssert;
import com.epam.jdi.mobile.elements.base.UIListBase;
import com.epam.jdi.mobile.elements.complex.WebList;

import static com.epam.jdi.mobile.common.TextTypes.LABEL;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class RadioButtons extends UIListBase<UISelectAssert> {
    @Override
    public WebList list() {
        return super.list().setUIElementName(LABEL);
    }
    public RadioButtons() {
        base().setLocator("input[type=radio]");
    }
}
