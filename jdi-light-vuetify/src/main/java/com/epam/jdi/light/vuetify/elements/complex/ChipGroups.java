package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.vuetify.asserts.ChipGroupAssert;

/**
 * To see an example of Chip web element please visit https://vuetifyjs.com/en/components/chip-groups/
 */
public class ChipGroups extends UIBaseElement<ChipGroupAssert> {

    private static final String TEXT1 = ".v-chip__content";
    private static final String TEXT2 = "//span[@class='v-chip__content']/text()";
    private static final String FILTER = "span .v-chip__filter"; //галочка в filter results chip group

    public ChipGroupAssert is() {
        return new ChipGroupAssert().set(this);
    }

    @JDIAction("Get {name}'s text")
    public String getText() {
        if (!this.find(TEXT1).getText().isEmpty()) {
            return this.find(TEXT1).getText();
        } else {
            return this.find(TEXT2).getText();
        }
    }

    @JDIAction("Check that '{name}' has filter")
    public boolean hasFilter() {
        return this.find(FILTER).isExist();
    }

    @JDIAction("Check that '{name}' has no filter")
    public boolean hasNoFilter() {
        return this.find(FILTER).isNotExist();
    }

    @JDIAction("Click on '{name}'")
    public void click() {
        this.core().click();
    }
}
