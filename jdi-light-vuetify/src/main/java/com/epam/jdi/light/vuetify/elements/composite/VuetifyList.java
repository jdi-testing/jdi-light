package com.epam.jdi.light.vuetify.elements.composite;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.vuetify.asserts.VuetifyListAssert;
import com.epam.jdi.light.vuetify.elements.common.Divider;
import com.epam.jdi.light.vuetify.elements.common.ListItem;
import com.epam.jdi.light.vuetify.elements.common.Subheader;

import java.util.List;
import java.util.stream.Collectors;

/**
 * To see an example of Lists web element please visit https://vuetifyjs.com/en/components/lists/
 */

public class VuetifyList extends UIBaseElement<VuetifyListAssert> implements ICoreElement {

    @JDIAction("Get '{name}' item with index '{0}'")
    public ListItem item(int index) {
        return new ListItem().setCore(ListItem.class, itemsWebList().get(index));
    }

    @JDIAction("Get '{name}' item with title '{0}'")
    public ListItem item(String title) {
        return new ListItem().setCore(ListItem.class, itemsWebList().get(title));
    }

    @JDIAction("Check that '{name}' is expanded")
    public boolean isExpanded(int elementIndex) {
        return isExpanded(item(elementIndex));
    }

    @JDIAction("Check that '{name}' is expanded")
    public boolean isExpanded(String title) {
        return isExpanded(item(title));
    }

    private boolean isExpanded(ListItem item) {
        return item.attr("aria-expanded").equalsIgnoreCase("true");
    }

    @JDIAction("Get '{name}' subheader with index '{0}'")
    public Subheader subheader(int index) {
        return new Subheader().setCore(Subheader.class, this.core().finds(".v-subheader").get(index));
    }

    @JDIAction("Get '{name}' divider with index '{0}'")
    public Divider divider(int index) {
        return new Divider().setCore(Divider.class, this.core().finds(".v-divider").get(index));
    }

    private WebList itemsWebList() {
        return this.core().finds(".v-list-item");
    }

    @JDIAction("Get '{name}' items")
    public List<ListItem> items() {
        return itemsWebList().stream()
            .map(webElement -> new ListItem().setCore(ListItem.class, webElement))
            .collect(Collectors.toList());
    }

    @Override
    public VuetifyListAssert is() {
        return new VuetifyListAssert().set(this);
    }
}
