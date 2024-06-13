package com.epam.jdi.light.material.elements.navigation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.navigation.MenuAssert;
import com.epam.jdi.light.material.elements.displaydata.list.ListItem;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents Menu MUI component on GUI. A menu displays a list of choices on a temporary surface.
 * It appears when the user interacts with a button, or other control.
 *
 * @see <a href="https://v4.mui.com/components/menus/">Menu MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class Menu extends UIListBase<MenuAssert> {

    /**
     * Gets item of this menu matching given name (full equality is used by searching).
     *
     * @param name full text content of item to be found
     * @return item as {@link ListItem}
     */
    @JDIAction("Get '{name}' item '{0}'")
    public ListItem item(String name) {
        return items().stream()
                .filter(item -> item.getText().equals(name))
                .findFirst()
                .orElse(new ListItem());
    }

    /**
     * Gets specific item of this menu using its index.
     *
     * @param index expected item index
     * @return item as {@link ListItem}
     */
    @JDIAction("Get '{name}' item {0}")
    public ListItem item(int index) {
        return items().get(index - 1);
    }

    /**
     * Gets a list of this menu items.
     *
     * @return items as {@link List} of {@link ListItem}
     */
    @JDIAction("Get '{name}' items")
    public List<ListItem> items() {
        return core().finds(".MuiListItem-root").stream()
            .map(listItem -> new ListItem().setCore(ListItem.class, listItem))
            .collect(Collectors.toList());
    }

    /**
     * Gets items texts
     *
     * @return texts as {@link List}
     */
    @JDIAction("Get '{name}' items texts")
    public List<String> itemsTexts() {
        return list().stream().map(UIElement::getText).collect(Collectors.toList());
    }

    @Override
    @JDIAction("Get selected '{name}' item")
    public String selected() {
        return core().find(".Mui-selected").text();
    }

    /**
     * Scrolls menu to the item with given name. The given name and item text must match exactly.
     *
     * @param menuItemName expected item name to scroll to
     */
    @JDIAction("Scroll to '{name}' item {0}")
    public void scrollToItem(String menuItemName) {
        get(menuItemName).core().jsExecute("scrollIntoView()");
    }

    public boolean isDisplayed() {
        return core().isDisplayed();
    }

    @Override
    public MenuAssert is() {
        return new MenuAssert().set(this);
    }
}
