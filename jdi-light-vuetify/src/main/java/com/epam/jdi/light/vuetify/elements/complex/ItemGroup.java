package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.vuetify.asserts.ItemGroupAssert;

public class ItemGroup extends UIListBase<ItemGroupAssert> {

    @Override
    @JDIAction("Is item '{0}' selected in {name}")
    public boolean selected(int index) {
        return get(index).hasClass("v-item--active");
    }

    @JDIAction("Is item '{0}' not selected in {name}")
    public boolean notSelected(int index) {
        return !selected(index);
    }

    @Override
    public ItemGroupAssert is() {
        return new ItemGroupAssert().set(this);
    }
}
