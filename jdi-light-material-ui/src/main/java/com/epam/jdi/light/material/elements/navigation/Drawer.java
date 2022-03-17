package com.epam.jdi.light.material.elements.navigation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.asserts.navigation.DrawerAssert;
import com.epam.jdi.light.material.elements.displaydata.List;
import com.epam.jdi.light.material.elements.displaydata.ListItem;
import org.openqa.selenium.Keys;

import java.util.Arrays;
import java.util.stream.Collectors;

import static com.epam.jdi.light.common.Exceptions.runtimeException;

/**
 * To see an example of Drawer web element please visit
 * https://mui.com/components/drawers/
 */

public class Drawer extends UIBaseElement<DrawerAssert> {

    @UI(".MuiList-root")
    public java.util.List<List> lists;

    @JDIAction("Get '{name}'s list items")
    public java.util.List<ListItem> listItems() {
        return finds(".MuiListItem-root").stream()
                .map(element -> new ListItem().setCore(ListItem.class, element))
                .collect(Collectors.toList());
    }

    @JDIAction("Get list on the top of '{name}'")
    public List topList() {
        return lists.get(1);
    }

    @JDIAction("Get list on the bottom of '{name}'")
    public List bottomList() {
        return lists.get(lists.size());
    }

    @Override
    @JDIAction("Check that '{name}' is displayed")
    public boolean isDisplayed() {
        return css("visibility").equals("visible") || super.isDisplayed();
    }

    @JDIAction("Close '{name}'")
    public void close() {
        UIElement closeButton = find("button");
        if (closeButton.isExist()) {
            closeButton.click();
        } else {
            core().sendKeys(Keys.ESCAPE);
        }
    }

    /**
     * Method returns 1 of 4 possible positions of drawer (left, right, top, bottom)
     * or throws exception if attribute was not found.
     */
    @JDIAction("Get '{name}'s position")
    public String getPosition() {
        String position = Arrays.stream(attr("class")
                        .split("[^a-zA-Z0-9]"))
                .map(String::toLowerCase)
                .filter(s -> s.contains("anchor"))
                .findAny().orElse("Unknown position")
                .replaceAll("paperanchor", "")
                .replaceAll("docked", "");
        if (position.length() > 0) {
            return position;
        } else {
            throw runtimeException("Unknown position");
        }
    }

    @Override
    public DrawerAssert is() {
        return new DrawerAssert().set(this);
    }
}
