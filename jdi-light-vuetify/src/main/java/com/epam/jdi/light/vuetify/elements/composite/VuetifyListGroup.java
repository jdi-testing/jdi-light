package com.epam.jdi.light.vuetify.elements.composite;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.vuetify.asserts.VuetifyListGroupAssert;
import com.epam.jdi.light.vuetify.elements.common.ListItem;

import java.util.List;
import java.util.stream.Collectors;

public class VuetifyListGroup extends UIBaseElement<VuetifyListGroupAssert> implements HasClick {
    public boolean isActive() {
        return hasClass("v-list-group--active");
    }

    public WebList items() {
        return core().finds(".v-list-item");
    }

    public List<ListItem> listItems() {
        return items().stream().map(e -> new ListItem().setCore(ListItem.class, e)).collect(Collectors.toList());
    }

    public ListItem header() {
        return new ListItem().setCore(ListItem.class, core().find(".v-list-group__header"));
    }

    public void click() {
        header().click();
    }

    public VuetifyListGroupAssert is() {
        return new VuetifyListGroupAssert().set(this);
    }
}
