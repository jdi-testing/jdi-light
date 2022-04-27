package com.epam.jdi.light.material.elements.navigation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.navigation.MenuAssert;
import com.epam.jdi.light.material.elements.displaydata.MUIListItem;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents Menu MUI component on GUI. A menu displays a list of choices on a temporary surface.
 * It appears when the user interacts with a button, or other control.
 *
 * @see <a href="https://mui.com/components/menus/">Menu MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class Menu extends UIListBase<MenuAssert> {

    /**
     * Gets item of this menu matching given name (full equality is used by searching).
     *
     * @param name expected item name
     * @return item as {@link MUIListItem}
     */
    @JDIAction("Get '{name}' item '{0}'")
    public MUIListItem item(String name) {
        return new MUIListItem().setCore(MUIListItem.class, get(name));
    }

    /**
     * Gets specific item of this menu using its index.
     *
     * @param index expected item index
     * @return item as {@link MUIListItem}
     */
    @JDIAction("Get '{name}' item {0}")
    public MUIListItem item(int index) {
        return items().get(index - 1);
    }

    /**
     * Gets a list of this menu items.
     *
     * @return items as {@link List} of {@link MUIListItem}
     */
    @JDIAction("Get '{name}' items")
    public List<MUIListItem> items() {
        return core().finds(".MuiListItem-root").stream()
            .map(listItem -> new MUIListItem().setCore(MUIListItem.class, listItem))
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
        return list().filter(e -> e.core().hasClass("Mui-selected")).get(0).text();
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

    @Override
    public MenuAssert is() {
        return new MenuAssert().set(this);
    }
}
