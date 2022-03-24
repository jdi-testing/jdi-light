package com.epam.jdi.light.material.elements.navigation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.navigation.DrawerAssert;
import com.epam.jdi.light.material.elements.displaydata.MUIList;
import com.epam.jdi.light.material.elements.utils.enums.Position;
import org.openqa.selenium.Keys;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.common.Exceptions.runtimeException;

/**
 * Represents drawer MUI component on GUI.
 *
 * @see <a href="https://mui.com/components/drawers/">Drawer MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class Drawer extends UIBaseElement<DrawerAssert> {

    /**
     * Gets lists included in this drawer.
     *
     * @return lists included in this drawer as {@link List}
     * @see MUIList
     */
    @JDIAction("Get '{name}'s lists of items")
    public List<MUIList> lists() {
        return finds(".MuiList-root").stream()
                .map(MUIList::new)
                .collect(Collectors.toList());
    }

    /**
     * Gets the top (first) list of this drawer.
     *
     * @return top list of this drawer as {@link MUIList}
     * @see MUIList
     */
    @JDIAction("Get list on the top of '{name}'")
    public MUIList topList() {
        return lists().get(0);
    }

    /**
     * Gets the bottom (last) list of this drawer.
     *
     * @return bottom list of this drawer as {@link MUIList}
     * @see MUIList
     */
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

    /**
     * Closes (hides or collapses) this drawer, if possible. If not possible, does nothing.
     */
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
     * Gets positions of this drawer on GUI (left, right, top, bottom).
     *
     * @return position of this drawer on GUI as {@link Position}
     * @throws RuntimeException if position can't be obtained
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
