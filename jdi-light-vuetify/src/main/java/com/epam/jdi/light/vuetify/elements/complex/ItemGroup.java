package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.vuetify.asserts.ItemGroupAssert;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;

public class ItemGroup extends UIListBase<ItemGroupAssert> implements HasTheme {

    //Interface IsMultiple is not applicable here, as there is no "--is-multi"

    @Override
    @JDIAction("Is item '{0}' selected in {name}")
    public boolean selected(int index) {
        return get(index).hasClass("v-item--active");
    }

    @JDIAction("Is item '{0}' not selected in {name}")
    public boolean notSelected(int index) {
        return !selected(index);
    }

    @JDIAction("Get icon of item {0} in {name}")
    public Icon itemIcon(int index) {
        return new Icon().setCore(Icon.class, get(index).find(".v-icon"));
    }

    @Override
    public ItemGroupAssert is() {
        return new ItemGroupAssert().set(this);
    }
}
