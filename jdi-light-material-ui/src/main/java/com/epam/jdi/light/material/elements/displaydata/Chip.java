package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.asserts.displaydata.ChipAssert;
import com.epam.jdi.light.material.interfaces.base.CanBeDisabled;

import static com.epam.jdi.light.common.Exceptions.runtimeException;

/**
 * To see an example of Chip web element please visit
 * https://mui.com/components/chips/
 */

public class Chip extends UIBaseElement<ChipAssert> implements HasClick, CanBeDisabled, HasLabel {

    @UI(".MuiChip-label")
    public Label label;

    @UI(".MuiChip-deleteIcon")
    public Icon deleteIcon;

    @UI(".MuiChip-avatar")
    public Avatar avatar;

    @UI(".MuiChip-icon")
    public Icon icon;

    @Override
    @JDIAction("Get '{name}' label")
    public Label label() {
        return label;
    }

    @JDIAction("Get '{name}' href")
    public String href() {
        if (isLink()) {
            return core().attr("href");
        } else {
            throw runtimeException("Element is not a link");
        }
    }

    @JDIAction("Delete '{name}'")
    public void delete() {
        if (deleteIcon.isDisplayed()) {
            deleteIcon.click();
        } else {
            throw runtimeException("Chip does not have delete icon");
        }
    }

    @JDIAction("Check that '{name}' is clickable")
    public boolean isClickable() {
        return core().hasClass("MuiChip-clickable");
    }

    @JDIAction("Check that '{name}' is deletable")
    public boolean isDeletable() {
        return core().hasClass("MuiChip-deletable") && deleteIcon.isDisplayed();
    }

    @JDIAction("Check that '{name}' is link")
    public boolean isLink() {
        return core().hasAttribute("href") && core().getTagName().equals("a");
    }

    @Override
    public ChipAssert is() {
        return new ChipAssert().set(this);
    }
}
