package com.epam.jdi.light.material.elements.navigation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.navigation.MenuAssert;
import com.epam.jdi.light.material.elements.displaydata.ListItem;
import java.util.List;
import java.util.stream.Collectors;

/**
 * To see an example of Menu web element please visit
 * https://mui.com/components/menus/
 */

public class Menu extends UIListBase<MenuAssert> {

    @JDIAction("Get '{name}' item {0}")
    public ListItem item(String name) {
        return new ListItem().setCore(ListItem.class, get(name));
    }

    @JDIAction("Get '{name}' item {0}")
    public ListItem item(int index) {
        return items().get(index - 1);
    }

    @JDIAction("Get '{name}' items")
    public List<ListItem> items() {
        return core().finds(".MuiListItem-root").stream()
            .map(listItem -> new ListItem().setCore(ListItem.class, listItem))
            .collect(Collectors.toList());
    }

    @JDIAction("Get '{name}' items texts")
    public List<String> itemsTexts() {
        return list().stream().map(UIElement::getText).collect(Collectors.toList());
    }

    @Override
    @JDIAction("Get selected '{name}' item")
    public String selected() {
        return list().filter(e -> e.core().hasClass("Mui-selected")).get(0).text();
    }

    @JDIAction("Scroll to '{name}' item {0}")
    public void scrollToItem(String menuItem) {
        get(menuItem).core().jsExecute("scrollIntoView()");
    }

    @Override
    public MenuAssert is() {
        return new MenuAssert().set(this);
    }
}
