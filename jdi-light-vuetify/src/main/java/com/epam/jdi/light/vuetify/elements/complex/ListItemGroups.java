package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.vuetify.asserts.ListItemGroupsAssert;
import com.epam.jdi.light.vuetify.interfaces.HasColor;
import com.epam.jdi.light.vuetify.interfaces.HasIcon;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.IsFlat;

/**
 * To see an example of Lists web element please visit
 * https://vuetifyjs.com/en/components/list-item-groups/
 */

public class ListItemGroups extends UIBaseElement<ListItemGroupsAssert> implements HasClick, HasIcon, IsFlat, HasColor,
        HasTheme {

    private static final String CONTENT = ".v-list-item__content";
    private static final String TITLE = ".v-list-item__title";
    private static final String LIST = "//ancestor::div[@role='list']";
    private static final String LIST_ITEM_GROUP = "//ancestor::div[contains(@class, 'v-list-item-group')]";

    @Override
    public ListItemGroupsAssert is() {
        return new ListItemGroupsAssert().set(this);
    }

    public UIElement list() {
        return find(LIST);
    }

    public UIElement listItemGroup() {
        return find(LIST_ITEM_GROUP);
    }

    @JDIAction("Get if '{name}' is active")
    public boolean isActive() {
        return core().hasClass("v-list-item--active");
    }

    @JDIAction("Get if '{name}' has border")
    public boolean hasBorder() {
        return core().hasClass("border");
    }

    @JDIAction("Get if '{name}' has filter")
    public boolean hasTitle() {
        return find(TITLE).isExist();
    }

    @JDIAction("Get {name}'s text")
    public String getText() {
        if (!find(CONTENT).getText().isEmpty()) {
            return find(CONTENT).getText();
        } else {
            return find(TITLE).getText();
        }
    }

    @Override
    @JDIAction("Get if '{name}' is flat")
    public boolean isFlat() {
        return list().hasClass("v-list--flat");
    }

    @Override
    @JDIAction("Get '{name}' theme")
    public String theme() {
        if (listItemGroup().isExist()) {
            return listItemGroup().classLike("theme--");
        } else {
            return list().classLike("theme--");
        }
    }

    @JDIAction("Get if '{name}' is subgroup")
    public boolean isSubgroup() {
        return core().attr("class").contains("--sub-group");
    }

    @JDIAction("Get if '{name}' is subgroup")
    public boolean isNoAction() {
        return core().attr("class").contains("--no-action");
    }
}


