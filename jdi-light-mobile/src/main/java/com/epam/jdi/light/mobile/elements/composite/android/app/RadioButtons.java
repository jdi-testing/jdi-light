package com.epam.jdi.light.mobile.elements.composite.android.app;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.mobile.elements.complex.MobileAppListBase;
import com.epam.jdi.light.mobile.elements.complex.MobileList;
import com.epam.jdi.light.mobile.elements.complex.MobileSelectAssert;
import com.epam.jdi.light.mobile.elements.complex.MobileTextTypes;

import static com.epam.jdi.light.common.TextTypes.LABEL;

public class RadioButtons extends MobileAppListBase<MobileSelectAssert<MobileSelectAssert<?,?>, RadioButtons>> {
    public RadioButtons() {
        base().setLocator("com.android.permissioncontroller:id/radiogroup");
    }
    @Override
    public MobileList mobileList() {
        return super.mobileList().setMobileElementName(MobileTextTypes.MOBILE_LABEL);
    }
}
