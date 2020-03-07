package com.epam.jdi.light.ui.html.elements.complex;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.complex.WebList;

import static com.epam.jdi.light.common.TextTypes.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class RadioButtons extends UIListBase<UISelectAssert<?,?>> {
    @Override
    public WebList list() {
        return super.list().setUIElementName(LABEL);
    }
    public RadioButtons() {
        base().setLocator("input[type=radio]");
    }
}
