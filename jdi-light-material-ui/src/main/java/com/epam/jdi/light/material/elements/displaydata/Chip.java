package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.HasLink;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.asserts.displaydata.ChipAssert;
import com.epam.jdi.light.material.interfaces.CanBeDisabled;
import com.epam.jdi.light.material.interfaces.HasColor;

import static com.epam.jdi.light.common.Exceptions.runtimeException;

/**
 * Represent chip MUI component on GUI. Chips allow users to enter information, make selections,
 * filter content, or trigger actions.
 *
 * @see <a href="https://v4.mui.com/components/chips/">Chip MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class Chip extends UIBaseElement<ChipAssert> implements HasClick, CanBeDisabled, HasLabel, HasColor, HasLink {

    /**
     * Label that represents the text over element.
     */
    @UI(".MuiChip-label")
    public Label label;

    /**
     * Icon that represents the ornament that deletes the chip when clicked.
     */
    @UI(".MuiChip-deleteIcon")
    public Icon deleteIcon;

    /**
     * Avatar that represents the ornament at the beginning of the component.
     */
    @UI(".MuiChip-avatar")
    public Avatar avatar;

    /**
     * Icon that that represents the ornament at the beginning of the component.
     */
    @UI(".MuiChip-icon")
    public Icon icon;

    @Override
    @JDIAction("Get '{name}' label")
    public Label label() {
        return label;
    }

    /**
     * Gets a href that will be navigated to when the chip is clicked.
     *
     * @return href as {@link String}
     * @throws RuntimeException if the element is not a link
     */
    @Override
    @JDIAction("Get '{name}' href")
    public String ref() {
        if (hasLink()) {
            return core().attr("href");
        } else {
            throw runtimeException("Element is not a link");
        }
    }

    /**
     * Deletes the chip using the 'Delete' icon.
     *
     * @throws RuntimeException chip does not have 'Delete' icon
     */
    @JDIAction("Delete '{name}'")
    public void delete() {
        if (deleteIcon.isDisplayed()) {
            deleteIcon.click();
        } else {
            throw runtimeException("Chip does not have 'Delete' icon");
        }
    }

    /**
     * Checks if the chip is clickable or not.
     *
     * @return {@code true} if the chip is clickable, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' is clickable")
    public boolean isClickable() {
        return core().hasClass("MuiChip-clickable");
    }

    /**
     * Checks if the chip is deletable or not.
     *
     * @return {@code true} if the chip is deletable, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' is deletable")
    public boolean isDeletable() {
        return core().hasClass("MuiChip-deletable") && deleteIcon.isDisplayed();
    }

    @Override
    public ChipAssert is() {
        return new ChipAssert().set(this);
    }
}
