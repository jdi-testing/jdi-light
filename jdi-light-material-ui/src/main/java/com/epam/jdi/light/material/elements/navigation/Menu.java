package com.epam.jdi.light.material.elements.navigation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.navigation.MenuAssert;
import com.epam.jdi.light.material.elements.displaydata.MUIListItem;
import java.util.List;
import java.util.stream.Collectors;

/**
 * To see an example of Menu web element please visit
 * https://mui.com/components/menus/
 */

public class Menu extends UIListBase<MenuAssert> {

    @JDIAction("Get '{name}' item '{0}'")
    public MUIListItem item(String name) {
        return items().stream()
                .filter(item -> item.getText().equals(name))
                .findFirst()
                .orElse(new MUIListItem());
    }

    @JDIAction("Get '{name}' item {0}")
    public MUIListItem item(int index) {
        return items().get(index - 1);
    }

    @JDIAction("Get '{name}' items")
    public List<MUIListItem> items() {
        return core().finds(".MuiListItem-root").stream()
            .map(listItem -> new MUIListItem().setCore(MUIListItem.class, listItem))
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
