package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.asserts.ItemGroupAssert;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.IsMultiple;

public class ItemGroup extends UIBaseElement<ItemGroupAssert> implements HasTheme, IsMultiple {

    public UIElement subheader() {
        return core().find(".v-subheader");
    }

    public WebList items() {
        WebList row = core().finds(".row");
        if (row.isEmpty()) {
            return core().finds("./child::*[not(contains(@class, 'v-subheader'))]");
        } else {
            // skipping columns
            return row.finds("./*[contains(@class, 'col-')]/child::*");
        }
    }

    @Override
    public boolean isMultiple() {
        return core().attr("file").equals("v-item-group/prop-multiple");
    }

    @JDIAction("Click in {0} element in the list")
    public void select(int index) {
        items().get(index).click();
    }

    @JDIAction("Is item '{0}' selected in {name}")
    public boolean selected(int index) {
        return this.items().get(index).hasClass("v-item--active");
    }

    @JDIAction("Is item '{0}' not selected in {name}")
    public boolean notSelected(int index) {
        return !selected(index);
    }

    public WebList selected() {
        return core().finds(".v-item--active");
    }

    @Override
    public ItemGroupAssert is() {
        return new ItemGroupAssert().set(this);
    }
}
