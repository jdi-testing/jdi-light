package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.vuetify.asserts.ListItemGroupsAssert;
import com.epam.jdi.light.elements.interfaces.base.HasColor;
import com.epam.jdi.light.vuetify.interfaces.HasIcon;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.IsFlat;

/**
 * To see an example of Lists web element please visit
 * https://vuetifyjs.com/en/components/list-item-groups/
 */

public class ListItemGroup extends UIBaseElement<ListItemGroupsAssert> implements HasClick, HasIcon, IsFlat, HasColor,
        HasTheme {

    @Override
    public ListItemGroupsAssert is() {
        return new ListItemGroupsAssert().set(this);
    }

    @JDIAction("Get if '{name}' is active")
    public boolean isActive() {
        return core().hasClass("v-list-group--active");
    }

    @Override
    @JDIAction("Get if '{name}' is flat")
    public boolean isFlat() {
        return core().hasClass("v-list--flat");
    }

    @Override
    @JDIAction("Get '{name}' theme")
    public String theme() {
        return core().classLike("theme--");
    }

    @JDIAction("Get if '{name}' is subgroup")
    public boolean isSubgroup() {
        return core().hasClass("v-list-group--sub-group");
    }

    @JDIAction("Get if '{name}' have no action")
    public boolean isNoAction() {
        return core().hasClass("v-list-group--no-action");
    }
}


