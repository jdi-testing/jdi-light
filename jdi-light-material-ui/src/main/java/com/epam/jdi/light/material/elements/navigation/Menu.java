package com.epam.jdi.light.material.elements.navigation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.material.asserts.navigation.MenuAssert;
import com.epam.jdi.light.material.elements.displaydata.List;
import com.epam.jdi.light.material.elements.displaydata.ListItem;

import java.util.stream.Collectors;

/**
 * To see an example of Menu web element please visit
 * https://mui.com/components/menus/
 */

public class Menu extends UIBaseElement<MenuAssert> implements HasClick {

    @JDIAction("Scroll to menu item")
    public void scrollToMenuItem(List listLocator, String menuItem) {
        listLocator.getItemByText(menuItem).core().jsExecute("scrollIntoView()");
    }

    @Override
    public MenuAssert is() {
        return new MenuAssert().set(this);
    }

    @JDIAction("Check if '{name}' is displayed")
    @Override
    public boolean isDisplayed() {
        return core().isDisplayed();
    }

    @Override
    public MenuAssert has() {
        return this.is();
    }

    @JDIAction("Get text in '{name}'")
    public String getText() {
        return core().getText();
    }

    @JDIAction("Get list of menu items")
    public java.util.List<String> getMenuItems(List listLocator){
        return listLocator.items().stream().map(ListItem::getText).collect(Collectors.toList());
    }
}
