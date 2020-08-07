package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.PaginatorAssert;
import com.epam.jdi.light.angular.elements.composite.CdkOverlayContainer;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;

import java.util.List;
import java.util.stream.Collectors;

public class Paginator extends UIBaseElement<PaginatorAssert> {

    protected UIElement label;
    protected String labelLocator = ".mat-paginator-page-size-label";

    protected UIElement select;
    protected String selectLocator = ".mat-select";

    protected CdkOverlayContainer container;

    protected UIElement range;
    protected String rangeLocator = ".mat-paginator-range-label";

    protected UIElement previous;
    protected String previousLocator = ".mat-paginator-navigation-previous";

    protected UIElement next;
    protected String nextLocator = ".mat-paginator-navigation-next";

    public Paginator() {
        label = new UIElement();
        label.setLocator(labelLocator);

        select = new UIElement();
        select.setLocator(selectLocator);

        container = new CdkOverlayContainer();

        range = new UIElement();
        range.setLocator(rangeLocator);

        previous = new UIElement();
        previous.setLocator(previousLocator);

        next = new UIElement();
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
