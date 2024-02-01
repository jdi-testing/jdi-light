package com.epam.jdi.light.angular.elements.common;

import com.epam.jdi.light.angular.asserts.ChipAssert;
import com.epam.jdi.light.angular.elements.interfaces.HasColor;
import com.epam.jdi.light.angular.elements.interfaces.HasIcon;
import com.epam.jdi.light.angular.elements.interfaces.HasImage;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;

public class Chip extends UIBaseElement<ChipAssert> implements HasClick, HasColor, HasIcon, HasImage, HasLabel {

    public static final String MAT_CHIP_REMOVE = "[matChipRemove]";

    @JDIAction("Get if '{name} is selected'")
    public boolean selected() {
        return hasClass("mat-mdc-chip-selected");
    }

    @JDIAction("Close '{name}'")
    public void remove() {
        find(MAT_CHIP_REMOVE).click();
    }

    @JDIAction("Get if '{name}' is removable")
    public boolean removable() {
        return find(MAT_CHIP_REMOVE).isDisplayed();
    }

    @JDIAction("Get if '{name}' is focused")
    public boolean focused() {
        return hasClass("cdk-focused");
    }

    @JDIAction("Get if '{name}' checkmark is visible")
    public boolean hasCheckMark() {
        return find("mdc-evolution-chip__checkmark").isVisible();
    }

    @JDIAction("Get if '{name}' is highlighted")
    public boolean highlighted() {
        return hasClass("mat-mdc-chip-highlighted");
    }

    @JDIAction()
    public void select() {
        if (!selected()) {
            label().click();
        }
    }

    @JDIAction()
    public void unselect() {
        if (selected()) {
            label().click();
        }
    }

    @Override
    public Label label() {
        return new Label().setCore(Label.class, find(".mdc-evolution-chip__text-label"));
    }

    @Override
    @JDIAction("Get '{name}' label text")
    public String labelText() {
        return label().getText();
    }

    @Override
    public ChipAssert is() {
        return new ChipAssert().set(this);
    }

}
