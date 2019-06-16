package com.epam.jdi.light.ui.html.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;

// Implements TextField + Droplist
// https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_datalist
public class Combobox extends Dropdown {
    @Override
    public UIElement core() {
        if (value != null)
            return value;
        return super.core();
    }
    // region Actions
    @JDIAction("Input '{0}' in '{name}'")
    public void sendKeys(CharSequence... value) { core().sendKeys(value); }
    @JDIAction("Set '{0}' in '{name}'")
    public void setText(String value) {
        core().setText(value);
    }
    @JDIAction("Clear '{name}'")
    public void clear() { core().clear(); }
    @JDIAction("Input '{0}' in '{name}'")
    public void input(String value) {
        core().input(value);
    }
    @JDIAction(level = DEBUG)
    public void focus(){ sendKeys(""); }
    @JDIAction(value = "Get '{name}' placeholder", level = DEBUG)
    public String placeholder() { return core().placeholder(); }
    @JDIAction("Get '{name}' text") @Override
    public String getText() {
        return core().getText();
    }
    // endregion

}
