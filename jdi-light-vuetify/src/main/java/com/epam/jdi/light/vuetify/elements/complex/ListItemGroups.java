package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.vuetify.asserts.ListItemGroupsAssert;

/**
 * To see an example of Lists web element please visit
 * https://vuetifyjs.com/en/components/list-item-groups/
 */

public class ListItemGroups extends UIBaseElement<ListItemGroupsAssert> implements HasClick {

    private static final String TEXT1 = ".v-list-item__content";
    private static final String TITLE = ".v-list-item__title";
    private static final String ICON = ".v-icon";

    @Override
    public ListItemGroupsAssert is() {
        return new ListItemGroupsAssert().set(this);
    }

    @Override
    public ListItemGroupsAssert has() {
        return this.is();
    }

    @JDIAction("Check that '{name}' is active")
    public boolean isActive() {
        return core().hasClass("v-list-item--active");
    }

    @JDIAction("Check that '{name}' has border")
    public boolean hasBorder() {
        return core().hasClass("border");
    }

    @JDIAction("Check that '{name}' has filter")
    public boolean hasTitle() {
        return this.find(TITLE).isExist();
    }

    @JDIAction("Check that '{name}' has filter")
    public boolean hasIcon() {
        return this.find(ICON).isExist();
    }

    @JDIAction("Get {name}'s text")
    public String getText() {
        if (!this.find(TEXT1).getText().isEmpty()) {
            return this.find(TEXT1).getText();
        } else {
            return this.find(TITLE).getText();
        }
    }
}


