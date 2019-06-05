package com.epam.jdi.light.elements.complex;

import com.epam.jdi.light.asserts.UISelectAssert;
import com.epam.jdi.light.elements.base.UISelectBase;

public class Menu extends UISelectBase<UISelectAssert> {
    public void select(String... values) {
        element.select(values);
    }
    public <TEnum extends Enum> void select(TEnum... values) {
        element.select(values);
    }
    public void select(int... values) {
        element.select(values);
    }
    public void hoverAndClick(String... values) {
        element.hoverAndClick(values);
    }
    public void hoverAndClick(String value) {
        element.hoverAndClick(value);
    }
}
