package com.epam.jdi.light.material.elements.datadisplay;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.datadisplay.ListsAssert;

public class Lists extends UIBaseElement<ListsAssert> {

    @JDIAction("Toggle '{name}'")
    public void toggle() {
        core().click();
    }

    public void check() {
        if (isUnchecked()) {
            toggle();
        }
    }

    public void uncheck() {
        if (isChecked()) {
            toggle();
        }
    }

    @JDIAction("Is '{name}' checked")
    public Boolean isChecked() {
        return core().hasClass("Mui-checked");
    }

    @JDIAction("Is '{name}' unchecked")
    public Boolean isUnchecked() {
        return !isChecked();
    }

    @JDIAction("Is '{name} disabled")
    @Override
    public boolean isDisabled() {
        return core().hasClass("Mui-disabled");
    }

    @JDIAction("Is '{name} enabled")
    @Override
    public boolean isEnabled() {
        return !isDisabled();
    }

    @Override
    public ListsAssert is() {
        return new ListsAssert().set(this);
    }

}
