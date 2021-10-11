package com.epam.jdi.light.vuetify.elements.composite;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.IClickable;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.elements.interfaces.composite.PageObject;
import com.epam.jdi.light.vuetify.asserts.SheetAssert;

/**
 * To see an example of Sheet web element please visit https://jdi-testing.github.io/jdi-light/vuetify/sheets
 */
public class Sheet extends UIBaseElement<SheetAssert> implements PageObject, IsText, IClickable {

    @Override
    public void click() {
        core().click();
    }

    @Override
    public SheetAssert is() {
        return new SheetAssert().set(this);
    }

    @JDIAction("Get elevation class from '{name}'")
    public String elevation() {
        return core().classes().stream().filter(cls -> cls.matches("elevation-\\d{1,2}"))
                .findFirst().orElse("");
    }

    @JDIAction("Get rounded class from '{name}'")
    public String rounded() {
        return core().classes().stream().filter(cls -> cls.matches("rounded.*"))
                .findFirst().orElse("");
    }
}
