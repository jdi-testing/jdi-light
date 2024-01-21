package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.asserts.ListItemGroupAssert;
import com.epam.jdi.light.vuetify.elements.common.ListItem;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

/**
 * To see an example of Lists web element please visit
 * https://vuetifyjs.com/en/components/list-item-groups/
 */

public class ListItemGroup extends ListItem {

    @Override
    public ListItemGroupAssert is() {
        return new ListItemGroupAssert().set(this);
    }

    @JDIAction("Get header item for {name}")
    public ListItem header() {
        return new ListItem().setCore(ListItem.class, core().find(".v-list-group__header"));
    }

    @JDIAction("Get if '{name}' is active")
    public boolean isActive() {
        return core().hasClass("v-list-group--active");
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

    @JDIAction("Get items of {name}")
    public List<ListItem> items() {
        return core().finds(By.cssSelector(".v-list-item:not(.v-list-group__header)"))
                .stream().map(e -> new ListItem().setCore(ListItem.class, e))
                .collect(Collectors.toList());
    }
}


