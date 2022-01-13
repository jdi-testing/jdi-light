package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.vuetify.asserts.NavigationDrawerAssert;
import com.epam.jdi.light.vuetify.elements.common.Image;
import com.epam.jdi.light.vuetify.elements.common.ListItem;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;

import java.util.List;
import java.util.stream.Collectors;

/**
 * To see an example of Navigation Drawer web element please visit https://vuetifyjs.com/en/components/navigation-drawers/
 */

public class NavigationDrawer extends UIBaseElement<NavigationDrawerAssert> implements HasClick {

    @JDIAction("Get '{name}'s list items")
    public List<ListItem> listItems() {
        return finds("div.v-list-item").stream()
                .map(element -> new ListItem().setCore(ListItem.class, element))
                .collect(Collectors.toList());
    }

    @JDIAction("Get '{name}'s list item on index {0}")
    public ListItem getListItemByIndex(int index) {
        return listItems().get(index-1);
    }

    @JDIAction("Get '{name}'s number of items")
    public int getNumberOfListItems() {
        return listItems().size();
    }

    @JDIAction("Is '{name}' expanded")
    public boolean isExpanded() {
        return getWidth() > 56;
    }

    @JDIAction("Is '{name}' collapsed")
    public boolean isCollapsed() {
        return getWidth() <= 56;
    }

    @JDIAction("Is '{name}' closed")
    public boolean isClosed() {
        return attr("class").contains("v-navigation-drawer--close");
    }

    @JDIAction("Is '{name}' opened")
    public boolean isOpened() {
        return attr("class").contains("v-navigation-drawer--open");
    }

    @JDIAction("Is '{name}' located on the right side of the container")
    public boolean isOnTheRightSide() {
        return attr("class").contains("right");
    }

    @JDIAction("Get '{name}'s background image")
    public Image backgroundImage() {
        return new Image().setCore(Image.class, find(".v-image"));
    }

    @JDIAction("Get '{name}'s background color")
    public String getBackgroundColor() {
        return css("background-color");
    }

    @JDIAction("Get '{name}'s button")
    public VuetifyButton button() {
        return new VuetifyButton(find("button"));
    }

    @JDIAction("Collapse '{name}'")
    public void collapse() {
        find(".v-navigation-drawer__content i").click();
    }

    @JDIAction("Get '{name}'s width")
    private float getWidth() {
        return Float.parseFloat(css("width")
                .replace("px", ""));
    }

    public NavigationDrawerAssert is() {
        return new NavigationDrawerAssert().set(this);
    }
}
