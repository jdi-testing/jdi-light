package com.epam.jdi.light.material.elements.surfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.asserts.surfaces.AccordionAssert;
import com.epam.jdi.light.material.elements.displaydata.Typography;
import com.epam.jdi.light.material.interfaces.base.CanBeDisabled;
import com.epam.jdi.light.ui.html.elements.common.Button;

/**
 * To see an example of Accordion web element please visit
 * https://mui.com/components/accordion/
 */

public class Accordion extends UIBaseElement<AccordionAssert> implements CanBeDisabled {

    @UI(".MuiAccordionSummary-expandIcon")
    public Button expandButton;

    @UI(".MuiAccordionDetails-root .MuiTypography-root")
    public Typography content;

    @UI(".MuiAccordionSummary-content .MuiTypography-root[1]")
    public Typography firstHeader;

    @UI(".MuiAccordionSummary-content .MuiTypography-root[2]")
    public Typography secondHeader;

    @JDIAction("Expand '{name}'")
    public void expand() {
        if (!isExpanded()) {
            expandButton.click();
        }
    }

    @JDIAction("Collapse '{name}'")
    public void collapse() {
        if (!isCollapsed()) {
            expandButton.click();
        }
    }

    @JDIAction("Check that '{name}' is expanded")
    public boolean isExpanded() {
        return core().hasClass("Mui-expanded");
    }

    @JDIAction("Check that '{name}' is collapsed")
    public boolean isCollapsed() {
        return !isExpanded();
    }

    @Override
    public AccordionAssert is() {
        return new AccordionAssert().set(this);
    }
}
