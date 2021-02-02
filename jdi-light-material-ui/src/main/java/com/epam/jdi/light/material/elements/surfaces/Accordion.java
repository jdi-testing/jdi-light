package com.epam.jdi.light.material.elements.surfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.surfaces.AccordionAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Accordion extends UIBaseElement<AccordionAssert> {

    @JDIAction("Get summary text for '{name}'")
    public String summaryValue() {
        return this.find(By.xpath("//div[contains(@class,'MuiAccordionSummary-root')]")).getText();
    }

    @JDIAction("Get content text for '{name}'")
    public String contentValue() {
        return content().getText();
    }

    @JDIAction("Click '{name}'")
    public void click() {
        core().click();
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

    public boolean isContentInvisible() {
        return !content().isDisplayed();
    }

    public boolean isContentVisible() {
        return content().isDisplayed();
    }

    @Override
    public AccordionAssert is() {
        return new AccordionAssert().set(this);
    }
}
