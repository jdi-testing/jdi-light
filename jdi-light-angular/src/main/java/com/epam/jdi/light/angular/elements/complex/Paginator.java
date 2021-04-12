package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.PaginatorAssert;
import com.epam.jdi.light.angular.elements.composite.MaterialSelectorContainer;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.uiElement;

import java.util.List;
import java.util.stream.Collectors;

/**
 * To see an example of Paginator web element please visit https://material.angular.io/components/paginator/overview.
 */

public class Paginator extends UIBaseElement<PaginatorAssert> {

    protected com.epam.jdi.light.elements.common.uiElement label;
    protected String labelLocator = ".mat-paginator-page-size-label";

    protected com.epam.jdi.light.elements.common.uiElement select;
    protected String selectLocator = ".mat-select";

    protected MaterialSelectorContainer container;

    protected com.epam.jdi.light.elements.common.uiElement range;
    protected String rangeLocator = ".mat-paginator-range-label";

    protected com.epam.jdi.light.elements.common.uiElement previous;
    protected String previousLocator = ".mat-paginator-navigation-previous";

    protected com.epam.jdi.light.elements.common.uiElement next;
    protected String nextLocator = ".mat-paginator-navigation-next";

    public Paginator() {
        label = new uiElement();
        label.setLocator(labelLocator);

        select = new uiElement();
        select.setLocator(selectLocator);

        container = new MaterialSelectorContainer();

        range = new uiElement();
        range.setLocator(rangeLocator);

        previous = new uiElement();
        previous.setLocator(previousLocator);

        next = new uiElement();
        next.setLocator(nextLocator);
    }

    @JDIAction("Get label for '{name}'")
    public String label() {
        return label.getText();
    }

    @JDIAction("Select option for '{name}'")
    public void select(int number) {
        select.click();
        container.select(String.valueOf(number));
    }

    @JDIAction("Get selected option for '{name}'")
    public int selected() {
        return Integer.parseInt(select.getText());
    }

    @JDIAction("Get options for '{name}'")
    public List<Integer> options() {
        select.click();
        return container
                .values()
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    @JDIAction("Get range for '{name}'")
    public String range() {
        return range.getText();
    }

    @JDIAction("Is previous button enabled for '{name}'")
    public boolean isPreviousEnabled() {
        return previous.isEnabled();
    }

    @JDIAction("Click previous for '{name}'")
    public void previous() {
        previous.click();
    }

    @JDIAction("Is next button enabled for '{name}'")
    public boolean isNextEnabled() {
        return next.isEnabled();
    }

    @JDIAction("Click next for '{name}'")
    public void next() {
        next.click();
    }

    @Override
    public PaginatorAssert is() {
        return new PaginatorAssert().set(this);
    }
}
