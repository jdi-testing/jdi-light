package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.CanBeSelected;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.IClickable;
import com.epam.jdi.light.material.asserts.inputs.RadioAssert;

//.MuiFormGroup-root
public class RadioGroup extends UIListBase<UISelectAssert<?,?>> {

    public RadioGroup() {
        base().setLocator(".MuiRadio-root");
    }

    @Override
    @JDIAction("aaaa")
    public UIElement get(String d) {
        return list()
                .map(element -> element.find("../*[contains(@class,'MuiTypography-root')]"))
                .stream()
                .filter(element -> element.getText().equalsIgnoreCase(d))
                .findFirst().get();
    }
}
