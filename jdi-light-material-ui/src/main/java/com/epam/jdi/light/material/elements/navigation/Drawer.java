package com.epam.jdi.light.material.elements.navigation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.navigation.DrawerAssert;
import com.epam.jdi.light.material.elements.displaydata.MUIList;
import com.epam.jdi.light.material.elements.utils.enums.Position;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

import static com.epam.jdi.light.common.Exceptions.runtimeException;

/**
 * To see an example of Drawer web element please visit
 * https://mui.com/components/drawers/
 */

public class Drawer extends UIBaseElement<DrawerAssert> {

    @JDIAction("Get '{name}'s lists of items")
    public List<MUIList> lists() {
        return finds(".MuiList-root").stream()
                .map(MUIList::new)
                .collect(Collectors.toList());
    }

    @JDIAction("Get list on the top of '{name}'")
    public MUIList topList() {
        return lists().get(0);
    }

    @JDIAction("Get list on the bottom of '{name}'")
    public MUIList bottomList() {
        java.util.List<MUIList> menuLists = lists();
        return menuLists.get(menuLists.size() - 1);
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
    public Position getPosition() {
        String position = Arrays.stream(attr("class")
                        .split("[^a-zA-Z0-9]"))
                .map(String::toLowerCase)
                .filter(s -> s.contains("anchor"))
                .findAny().orElse("Unknown position")
                .replace("paperanchor", "")
                .replace("docked", "");
        if (!position.isEmpty()) {
            return Position.fromString(position);
        } else {
            throw runtimeException("Unknown position");
        }
    }

    @Override
    public DrawerAssert is() {
        return new DrawerAssert().set(this);
    }
}
