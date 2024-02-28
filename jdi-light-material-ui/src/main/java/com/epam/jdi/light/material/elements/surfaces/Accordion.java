package com.epam.jdi.light.material.elements.surfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.asserts.surfaces.AccordionAssert;
import com.epam.jdi.light.material.elements.displaydata.Typography;
import com.epam.jdi.light.material.interfaces.CanBeDisabled;
import com.epam.jdi.light.ui.html.elements.common.Button;

/**
 * Represents accordion MUI component on GUI.
 *
 * @see <a href="https://v4.mui.com/components/accordion/">Accordion MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class Accordion extends UIBaseElement<AccordionAssert> implements CanBeDisabled {

    /**
     * Button that expands this accordion.
     */
    @UI(".MuiAccordionSummary-expandIcon")
    public Button expandButton;

    /**
     * Content of this accordion.
     */
    @UI(".MuiAccordionDetails-root")
    public UIElement details;

    /**
     * First header of this accordion.
     */
    @UI(".MuiAccordionSummary-content .MuiTypography-root[1]")
    public Typography firstHeader;

    /**
     * Second header of this accordion.
     */
    @UI(".MuiAccordionSummary-content .MuiTypography-root[2]")
    public Typography secondHeader;

    /**
     * Expands this accordion, if possible. If not possible, does nothing.
     */
    @JDIAction("Expand '{name}'")
    public void expand() {
        if (isCollapsed()) {
            expandButton.click();
        }
    }

    /**
     * Collapses this accordion, if possible. If not possible, does nothing.
     */
    @JDIAction("Collapse '{name}'")
    public void collapse() {
        if (isExpanded()) {
            expandButton.click();
        }
    }

    /**
     * Checks if this accordion is expanded or not.
     *
     * @return {@code true} if this accordion is expanded, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' is expanded")
    public boolean isExpanded() {
        return core().hasClass("Mui-expanded");
    }

    /**
     * Checks if this accordion is collapsed or not.
     *
     * @return {@code true} if this accordion is collapsed, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' is collapsed")
    public boolean isCollapsed() {
        return !isExpanded();
    }

    @Override
    public AccordionAssert is() {
        return new AccordionAssert().set(this);
    }
}
