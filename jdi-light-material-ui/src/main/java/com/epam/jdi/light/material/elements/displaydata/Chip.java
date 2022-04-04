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
 * Represent chip MUI component on GUI. Chips allow users to enter information, make selections,
 * filter content, or trigger actions.
 *
 * @see <a href="https://mui.com/components/chips/">Chip MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class Chip extends UIBaseElement<ChipAssert> implements HasClick, CanBeDisabled, HasLabel {

    /**
     * Label that represents the text over element.
     */
    @UI(".MuiChip-label")
    public Label label;

    /**
     * Icon that represents the ornaments that, when clicked, deletes.
     */
    @UI(".MuiChip-deleteIcon")
    public Icon deleteIcon;

    /**
     * Avatar that represents the ornaments at the beginning of the component.
     */
    @UI(".MuiChip-avatar")
    public Avatar avatar;

    /**
     * Icon that that represents the ornaments at the beginning of the component.
     */
    @UI(".MuiChip-icon")
    public Icon icon;

    /**
     * Get label of the chip.
     *
     * @return label as {@link Label}
     */
    @Override
    @JDIAction("Get '{name}' label")
    public Label label() {
        return label;
    }

    /**
     * Get a href that will be navigated to when the chip is clicked.
     * If the element is not a link, then an exception is thrown.
     *
     * @return href as {@link String}
     */
    @JDIAction("Get '{name}' href")
    public String href() {
        if (isLink()) {
            return core().attr("href");
        } else {
            throw runtimeException("Element is not a link");
        }
    }

    /**
     * Delete the chip using the deleteIcon.
     */
    @JDIAction("Delete '{name}'")
    public void delete() {
        if (deleteIcon.isDisplayed()) {
            deleteIcon.click();
        } else {
            throw runtimeException("Chip does not have delete icon");
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

    /**
     * Checks if the chip is a link or not.
     *
     * @return {@code true} if the chip is a link, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' is a link")
    public boolean isLink() {
        return core().hasAttribute("href") && core().getTagName().equals("a");
    }

    @Override
    public ChipAssert is() {
        return new ChipAssert().set(this);
    }
}
