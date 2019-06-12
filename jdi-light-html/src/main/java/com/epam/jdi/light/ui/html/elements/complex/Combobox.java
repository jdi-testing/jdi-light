package com.epam.jdi.light.ui.html.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIElement;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;

// Implements TextField + Droplist
// https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_datalist
public class Combobox extends Dropdown {
    @Override
    public UIElement element() {
        if (value != null)
            return value;
        return super.element();
    }
    // region Actions
    @JDIAction("Input '{0}' in '{name}'")
    public void sendKeys(CharSequence... value) { element().sendKeys(value); }
    @JDIAction("Set '{0}' in '{name}'")
    public void setText(String value) {
        element().setText(value);
    }
    @JDIAction("Clear '{name}'")
    public void clear() { element().clear(); }
    @JDIAction("Input '{0}' in '{name}'")
    public void input(String value) {
        element().input(value);
    }
    @JDIAction(level = DEBUG)
    public void focus(){ sendKeys(""); }
    @JDIAction(value = "Get '{name}' placeholder", level = DEBUG)
    public String placeholder() { return element().placeholder(); }
    @JDIAction("Get '{name}' text") @Override
    public String getText() {
        return element().getText();
    }
    // endregion

}
