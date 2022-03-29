package com.epam.jdi.light.vuetify.elements.composite;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.vuetify.asserts.VuetifyListAssert;
import com.epam.jdi.light.vuetify.elements.common.Divider;
import com.epam.jdi.light.vuetify.elements.common.ListItem;
import com.epam.jdi.light.vuetify.elements.common.Subheader;
import org.openqa.selenium.By;

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

    private WebList itemsWebList() {
        return core().finds(".v-list-item");
    }

    @JDIAction("Get '{name}' subheader with index '{0}'")
    public Subheader subheader(int index) {
        return new Subheader().setCore(Subheader.class, core().finds(".v-subheader").get(index));
    }

    @JDIAction("Get '{name}' divider with index '{0}'")
    public Divider divider(int index) {
        return new Divider().setCore(Divider.class, core().finds(".v-divider").get(index));
    }

    @JDIAction("Get '{name}' group with title '{0}'")
    public ListItem group(String title) {
        return new ListItem().setCore(ListItem.class, groupsWebList().get(title));
    }

    private WebList groupsWebList() {
        return core().finds(".v-list-group");
    }

    @JDIAction("Get '{name}' items")
    public List<ListItem> items() {
        return itemsWebList().stream()
            .map(webElement -> new ListItem().setCore(ListItem.class, webElement))
            .collect(Collectors.toList());
    }

    @JDIAction("Check that '{name}' is two-line")
    public boolean isTwoLine() {
        return hasClass("v-list--two-line");
    }

    @JDIAction("Check that '{name}' is three-line")
    public boolean isThreeLine() {
        return hasClass("v-list--three-line");
    }

    @JDIAction("Check that '{name}' item with title '{0}' is displayed")
    public boolean isItemDisplayed(String title) {
        return core().findElements(By.cssSelector(".v-list-item"))
            .stream()
            .anyMatch(webElement -> webElement.getText().equals("Admin"));
    }

    @Override
    public VuetifyListAssert is() {
        return new VuetifyListAssert().set(this);
    }
}