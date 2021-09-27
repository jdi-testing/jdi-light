package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.ChipAssert;

/**
 * To see an example of Chip web element please visit https://vuetifyjs.com/en/components/chips/
 */

public class Chip extends UIBaseElement<ChipAssert> {

    private static final String TEXT = ".v-chip__content";
    private static final String CLOSE_BUTTON = "span button[aria-label='Close']";
    private static final String FILTER = "span .v-chip__filter";
    private static final String ICON = "span .v-icon";
    private static final String IMAGE = "span .v-image__image";

    @Override
    public ChipAssert is() {
        return new ChipAssert().set(this);
    }

    @JDIAction("Get {name}'s text")
    public String getText() {
        return this.find(TEXT).getText();
    }

    @JDIAction("Close '{name}'")
    public void close() {
        this.find(CLOSE_BUTTON).click();
    }

    @JDIAction("Drag '{name}' and drop to '{0}'")
    public void dragAndDrop(UIElement destination) {
        this.dragAndDropTo(destination);
    }

    @JDIAction("Check that '{name}' has filter")
    public boolean hasFilter() {
        return this.find(FILTER).isExist();
    }

    @JDIAction("Check that '{name}' has filter")
    public boolean hasIcon() {
        return this.find(ICON).isExist();
    }

    @JDIAction("Check that '{name}' has filter")
    public boolean hasImage() {
        return this.find(IMAGE).isExist();
    }

    @JDIAction("Get {name}'s font size")
    public String fontSize() {
        return this.css("font-size");
    }

    @JDIAction("Expand '{name}'")
    public void click() {
        this.core().click();
    }
}
