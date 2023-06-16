package com.epam.jdi.light.mobile.elements.composite.ios.app;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.mobile.interfaces.HasTouchActions;

import static com.epam.jdi.light.mobile.MobileUtils.GET_APP_MENU_ITEM;


public class EditMenu extends Menu {

    private Object pageObject = this;

    public void tapMenuItem(String buttonName) {
        HasTouchActions button = GET_APP_MENU_ITEM.execute(pageObject, buttonName);
        button.tap();
    }

    @JDIAction(value = "Perform tap on '{name} Cut' menu item", timeout = 0)
    public void cut() {
        tapMenuItem("Cut");
    }

    @JDIAction(value = "Perform tap on '{name} Copy' menu item", timeout = 0)
    public void copy() {
        tapMenuItem("Copy");
    }

    @JDIAction(value = "Perform tap on '{name} Paste' menu item", timeout = 0)
    public void paste() {
        tapMenuItem("Paste");
    }

    @JDIAction(value = "Perform tap on '{name} Look Up' menu item", timeout = 0)
    public void lookUp() {
        tapMenuItem("Look Up");
    }

    @JDIAction(value = "Perform tap on '{name} Share' menu item", timeout = 0)
    public void share() {
        tapMenuItem("Share...");
    }
}
