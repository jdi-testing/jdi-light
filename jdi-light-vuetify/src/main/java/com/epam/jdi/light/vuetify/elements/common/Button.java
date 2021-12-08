package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.asserts.ButtonAssert;

/**
 * To see the example of Buttons web element please visit https://vuetifyjs.com/en/components/buttons/
 */

public class Button extends UIBaseElement<ButtonAssert> implements HasClick, IsText {

    Button() {
    }

    public Button(UIElement element) {
        core().setCore(element);
    }

    @Override
    public ButtonAssert is() {
        return new ButtonAssert().set(this);
    }

    @JDIAction("Check if '{name}' is loading")
    public boolean isLoading() {
        return hasClass("v-btn--loading");
    }

    @JDIAction("Check if '{name}' is loading")
    public String getColor() {
        return css("background-color");
    }

    @JDIAction("Check if {name} is disabled")
    @Override
    public boolean isDisabled() {
        return hasClass("v-btn--disabled");
    }

    @JDIAction("Check if {name} is displayed")
    @Override
    public boolean isDisplayed() {
        return !isHidden();
    }

    @JDIAction("Check if {name} is hidden")
    @Override
    public boolean isHidden() {
        return attr("style").contains("display: none");
    }
}
