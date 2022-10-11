package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.asserts.NavigationDrawerAssert;
import com.epam.jdi.light.vuetify.elements.common.Image;
import com.epam.jdi.light.vuetify.elements.common.ListItem;
import com.epam.jdi.light.vuetify.elements.common.Overlay;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;

import java.util.List;
import java.util.stream.Collectors;

/**
 * To see an example of Navigation Drawer web element please visit https://vuetifyjs.com/en/components/navigation-drawers/
 */

public class NavigationDrawer extends UIBaseElement<NavigationDrawerAssert>
        implements HasClick, HasTheme {

    @JDIAction("Get '{name}'s list items")
    public List<ListItem> items() {
        return finds("div.v-list-item").stream()
                .map(element -> new ListItem().setCore(ListItem.class, element))
                .collect(Collectors.toList());
    }

    @JDIAction("Get '{name}'s list items text")
    public List<String> itemsText() {
        return items().stream().map(IsText::getText).collect(Collectors.toList());
    }

    @JDIAction("Get '{name}' overlay")
    public Overlay overlay() {
        return new Overlay().setCore(Overlay.class, find("//preceding-sibling::*[contains(@class, 'v-overlay')]"));
    }

    @JDIAction("Get '{name}'s list item on index {0}")
    public ListItem get(int index) {
        return items().get(index-1);
    }

    @JDIAction("Get '{name}'s number of items")
    public int size() {
        return items().size();
    }

    @JDIAction("Check that '{name}' is expanded")
    public boolean isExpanded() {
        return !isMiniVariant();
    }

    @JDIAction("Check that '{name}' is collapsed")
    public boolean isCollapsed() {
        return isMiniVariant();
    }

    @JDIAction("Check that '{name}' is closed")
    public boolean isClosed() {
        return core().hasClass("v-navigation-drawer--close");
    }

    @JDIAction("Check that '{name}' is opened")
    public boolean isOpened() {
        return core().hasClass("v-navigation-drawer--open");
    }

    @JDIAction("Check that '{name}' is located on the right")
    public boolean isRight() {
        return core().hasClass("v-navigation-drawer--right");
    }

    @JDIAction("Get '{name}'s background image")
    public Image backgroundImage() {
        return new Image().setCore(Image.class, find(".v-image"));
    }

    @JDIAction("Get '{name}'s background color")
    public String backgroundColor() {
        return css("background-color");
    }

    @JDIAction("Get '{name}'s button")
    public VuetifyButton button() {
        return new VuetifyButton(find("button"));
    }

    @JDIAction("Get '{name}'s width")
    public int width() {
        return Integer.parseInt(css("width")
                .replace("px", ""));
    }

    @JDIAction("Get '{name}'s height")
    public int height() {
        return Integer.parseInt(css("height")
                .replace("px", ""));
    }

    @JDIAction("Check that {name} is absolute")
    public boolean isAbsolute() {
        return core().hasClass("v-navigation-drawer--absolute");
    }

    @JDIAction("Check that {name} is bottom")
    public boolean isBottom() {
        return core().hasClass("v-navigation-drawer--bottom");
    }

    @JDIAction("Check that {name} is clipped")
    public boolean isClipped() {
        return core().hasClass("v-navigation-drawer--clipped");
    }

    @JDIAction("Check that {name} is expanded on hover")
    public boolean isExpandedOnHover() {
        return core().hasClass("v-navigation-drawer--open-on-hover");
    }

    @JDIAction("Check that {name} is floating")
    public boolean isFloating() {
        return core().hasClass("v-navigation-drawer--floating");
    }

    @JDIAction("Check that {name} is mini-variant")
    public boolean isMiniVariant() {
        return core().hasClass("v-navigation-drawer--mini-variant");
    }

    @JDIAction("Check that {name} is temporary")
    public boolean isTemporary() {
        return core().hasClass("v-navigation-drawer--temporary");
    }

    @Override
    public NavigationDrawerAssert is() { return new NavigationDrawerAssert().set(this); }

    @Override
    public NavigationDrawerAssert has() { return is(); }
}
