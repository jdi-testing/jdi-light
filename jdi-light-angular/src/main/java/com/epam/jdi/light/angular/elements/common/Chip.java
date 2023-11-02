package com.epam.jdi.light.angular.elements.common;

import com.epam.jdi.light.angular.asserts.ChipAssert;
import com.epam.jdi.light.angular.elements.interfaces.HasColor;
import com.epam.jdi.light.angular.elements.interfaces.HasIcon;
import com.epam.jdi.light.angular.elements.interfaces.HasImage;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.ui.html.elements.common.Image;

public class Chip extends UIBaseElement<ChipAssert> implements HasClick, HasColor, HasIcon, HasImage {


    @JDIAction("Get if '{name} is selected'")
    public boolean selected() {
        return hasClass("mat-mdc-chip-selected");
    }

    @JDIAction("Close '{name}'")
    public void close() {
        find("[matChipRemove]").click();
    }

    @JDIAction("Get if '{name}' is removable")
    public boolean removable() {
        return find("[matChipRemove]").isDisplayed();
    }

    @JDIAction("Get if '{name}' background-color")
    public String getBackgroundColor() {
        return css("background-color");
    }

    @JDIAction("Get if '{name} is focused'")
    public boolean focused() {
        return hasClass("cdk-focused");
    }

    @JDIAction("Get if '{name} checkmark is visible'")
    public boolean showCheckMark() {
        return find("mdc-evolution-chip__checkmark").isVisible();
    }

    @JDIAction("Get '{name} label text")
    public String getText() {
        return find(".mdc-evolution-chip__text-label").getText();
    }

    @JDIAction("Get '{name} avatar image")
    public Image leadingIcon() {
        return new Image().setCore(Image.class, find("[matchipavatar]"));
    }

    @Override
    public ChipAssert is() {
        return new ChipAssert().set(this);
    }

}
