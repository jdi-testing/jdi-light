package com.epam.jdi.light.angular.elements.common;

import com.epam.jdi.light.angular.asserts.ChipAssert;
import com.epam.jdi.light.angular.elements.interfaces.HasColor;
import com.epam.jdi.light.angular.elements.interfaces.HasIcon;
import com.epam.jdi.light.angular.elements.interfaces.HasImage;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;

public class Chip extends UIBaseElement<ChipAssert> implements HasClick, HasColor, HasIcon, HasImage {

//    @Override
//    @JDIAction("Get if '{name}' is enabled")
//    public boolean isEnabled() {
//        return hasAttribute("disabled");
//    }

    @JDIAction("Close '{name}'")
    public void close() {
        find("matChipRemove").click();
    }

    @JDIAction ("Get if '{name}' is removable")
    public boolean isRemovable() {
    return hasAttribute("matchipremove");
    }

    @JDIAction("Get if '{name} is focused'")
    public boolean isFocused() {
        return hasClass("cdk-focused");
    }

    @JDIAction("Get if '{name} is selected'")
    public boolean isSelected() {
        return hasClass("mat-mdc-chip-selected");
    }

    @JDIAction("Get if '{name} checkmark is visible'")
    public boolean showCheckMark() {
        return find("mdc-evolution-chip__checkmark").isVisible();
    }

    public String getText() {
        return find(".mdc-evolution-chip__text-label").getText();
    }

    public void click() {
        core().click();
    }

//    @JDIAction("Get '{name}' text")
//    public String getText() {
//        return
//    }

    @Override
    public ChipAssert is() {
        return new ChipAssert().set(this);
    }

}
