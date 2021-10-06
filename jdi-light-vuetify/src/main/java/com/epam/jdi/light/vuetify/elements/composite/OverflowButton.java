package com.epam.jdi.light.vuetify.elements.composite;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.asserts.OverflowButtonAssert;

public class OverflowButton extends UIBaseElement<OverflowButtonAssert> {

    protected String caretLocator = ".v-input__append-inner";
    protected String openPanelClass = "v-select--is-menu-active";
    protected String listLocator = "//ancestor::div[@id = 'app']//div[@id = '" + listID() + "']//div[@class = 'v-list-item__title']";

    protected String listID() {
        return core().find(".v-input__slot").getAttribute("aria-owns");
    }

    public UIElement expander() {
        return core().find(caretLocator);
    }

    public WebList dropDownList() {
        return finds(listLocator);
    }


    public void expand() {
        if (isClosed()) {
            expander().click();
        }
    }

    public void close() {
        if (isExpanded()) {
            expander().click();
        }
    }

    public void select(String text) {
        expand();
        dropDownList().select(text);
    }

    public void select(int index) {

    }

    public Boolean isExpanded() {
        return core().hasClass(openPanelClass);
    }

    public Boolean isClosed() {
        return !isExpanded();
    }

}
