package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;

/**
 * To see an example of Alert web element please visit https://vuetifyjs.com/en/components/alerts/
 */
public class Alert extends UIBaseElement<TextAssert> implements IsText {

    protected static final String DEFAULT_ICON_LOCATOR = ".v-alert__icon";

    @JDIAction("Get icon from '{name}'")
    public UIElement getIcon() {
        return linked(DEFAULT_ICON_LOCATOR, String.format("%s.icon", getName()));
    }

    @Override
    public TextAssert is() {
        return new TextAssert().set(this);
    }
}
