package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.SelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasPlaceholder;
import com.epam.jdi.light.elements.interfaces.base.IClickable;

public class Select extends UIBaseElement<SelectAssert> implements HasPlaceholder, IClickable {

    @JDIAction
    public boolean expanded() {
        return core().getAttribute("aria-expanded").equalsIgnoreCase("true");
    }

    @JDIAction
    public boolean collapsed() {
        return !expanded();
    }

    @JDIAction
    public void expand() {
        click();
    }

    @JDIAction
    public String name() {
        return core().getAttribute("name");
    }

    @JDIAction
    public String role() {
        return core().getAttribute("name");
    }

    @JDIAction
    public boolean required() {
        return attrs().has("required");
    }

    @JDIAction
    public boolean disableRipple() {
        return attrs().has("disableripple");
    }

    @JDIAction
    public boolean disabled() {
        return attrs().has("disabled");
    }

    @JDIAction
    public boolean multiple() {
        return attrs().has("multiple");
    }

    @JDIAction
    public boolean hideSingleSelectionIndicator() {
        return attrs().has("hidesingleselectionindicator");
    }

    @JDIAction()
    public boolean labelDisabled() {
        return core().getAttribute("aria-disabled").equalsIgnoreCase("true");
    }

    @JDIAction
    public boolean labelRequired() {
        return core().getAttribute("aria-required").equalsIgnoreCase("true");
    }

    @JDIAction
    public String label() {
        return core().getAttribute("aria-label");
    }

    @Override
    public void click() {
        core().click();
    }

    @Override
    public SelectAssert is() {
        return new SelectAssert().set(this);
    }
}
