package com.epam.jdi.light.material.elements.surfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.surfaces.AccordionAssert;
import org.openqa.selenium.By;

public class Accordion extends UIBaseElement<AccordionAssert> {

    @JDIAction("Get summary text for '{name}'")
    public String summaryValue() {
        return summary().getText();
    }

    @JDIAction("Get content text for '{name}'")
    public String contentValue() {
        return content().getText();
    }

    @JDIAction("Click '{name}'")
    public void click() {
        core().click();
    }

    public void expand() {
        if (isCollapsed()) {
            summary().click();
            this.is().expanded();
        }
    }

    public void collapse() {
        if (isExpanded()) {
            summary().click();
            this.is().collapsed();
        }
    }

    @JDIAction("Is '{name}' is expanded")
    public Boolean isExpanded() {
        return hasClass("Mui-expanded");
    }

    @JDIAction("Is '{name}' is collapsed")
    public Boolean isCollapsed() {
        return !isExpanded();
    }

    @JDIAction("Is '{name} disabled")
    @Override
    public boolean isDisabled() {
        return hasClass("Mui-disabled");
    }

    @JDIAction("Is '{name} enabled")
    @Override
    public boolean isEnabled() {
        return !isDisabled();
    }

    public UIElement content() {
        return this.find(By.xpath("//div[contains(@class,'MuiAccordionDetails-root')]"));
    }

    public UIElement summary() {
        return this.find(By.xpath("//div[contains(@class,'MuiAccordionSummary-root')]"));
    }

    @Override
    public AccordionAssert is() {
        return new AccordionAssert().set(this);
    }
}
