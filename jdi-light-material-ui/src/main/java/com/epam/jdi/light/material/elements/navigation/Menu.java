package com.epam.jdi.light.material.elements.navigation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.navigation.MenuAssert;
import com.epam.jdi.light.material.elements.displaydata.Icon;
import java.util.stream.Collectors;

/**
 * To see an example of Menu web element please visit
 * https://mui.com/components/menus/
 */

public class Menu extends UIListBase<MenuAssert> {

    @JDIAction("Get icon of '{name}' item {0}")
    public Icon itemIcon(String menuItem) {
        return new Icon().setCore(Icon.class, get(menuItem).core().find(".MuiListItemIcon-root"));
    }

    @JDIAction("Get list of '{name}' items")
    public java.util.List<String> itemsTexts() {
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
