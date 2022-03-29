package com.epam.jdi.light.vuetify.elements.composite;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.logger.LogLevels;
import com.epam.jdi.light.vuetify.asserts.VuetifyListAssert;
import com.epam.jdi.light.vuetify.elements.common.ListItem;
import com.epam.jdi.light.vuetify.elements.common.Subheader;
import java.util.List;
import java.util.stream.Collectors;

/**
 * To see an example of Lists web element please visit https://vuetifyjs.com/en/components/lists/
 */

public class VuetifyList extends UIBaseElement<VuetifyListAssert> implements ICoreElement {

    @JDIAction(level = LogLevels.DEBUG)
    public ListItem item(int index) {
        return new ListItem().setCore(ListItem.class, itemsWebList().get(index));
    }

    @JDIAction(level = LogLevels.DEBUG)
    public ListItem item(String title) {
        return new ListItem().setCore(ListItem.class, itemsWebList().get(title));
    }

    @JDIAction("'{name}' is expanded")
    public boolean isExpanded(int elementIndex) {
        return isExpanded(item(elementIndex));
    }

    @JDIAction("'{name}' is expanded")
    public boolean isExpanded(String title) {
        return isExpanded(item(title));
    }

    private boolean isExpanded(ListItem item) {
        return item.attr("aria-expanded").equalsIgnoreCase("true");
    }

    @JDIAction(level = LogLevels.DEBUG)
    public Subheader subheader(int index) {
        return new Subheader().setCore(Subheader.class, this.finds(".v-subheader").get(index));
    }

    private WebList itemsWebList() {
        return this.finds(".v-list-item");
    }

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
