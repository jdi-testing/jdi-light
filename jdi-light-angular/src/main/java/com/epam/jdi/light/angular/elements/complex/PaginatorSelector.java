package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import org.openqa.selenium.By;

import java.util.NoSuchElementException;

public class PaginatorSelector extends MaterialSelector {

    public PaginatorSelector() {
        super();
        cdkOverlayContainer.backdropSelectPanel = "div.mat-mdc-select-panel";
    }

    @Override
    @JDIAction("Get 'name' toggle")
    protected UIElement toggle() {
        return this.core();
    }

    @JDIAction("Get '{name}' toggle value")
    public String toggleValue() {
        return toggle().getText();
    }

    @Override
    @JDIAction(value = "Is '{name}' expanded")
    public boolean isExpanded() {
        return toggle().attr("aria-expanded").equals("true");
    }

    @Override
    @JDIAction(value = "Is '{name}' collapsed")
    public boolean isCollapsed() {
        return !isExpanded();
    }

    @JDIAction("Get '{name}' selected UIElement from the list")
    public UIElement selectedOptionFromList() {
        return cdkOverlayContainer.list().stream()
                .filter(el -> el.find(By.xpath(".."))
                        .attr("aria-selected").equals("true"))
                .findFirst()
                .orElseThrow(
                        () -> new NoSuchElementException("No element with attribute aria-selected = true")
                );
    }

    @Override
    @JDIAction(value = "Check that '{name}' is enabled", timeout = 0)
    public boolean isEnabled() {
        return toggle().isEnabled() && toggle().attr("aria-disabled").equals("false");
    }

    @Override
    @JDIAction(value = "Check that '{name}' is disabled", timeout = 0)
    public boolean isDisabled() {
        return !isEnabled();
    }

    @Override
    @JDIAction("Expand '{name}'")
    public void expand() {
        if (isCollapsed()) {
            super.expand();
        }
    }
}

