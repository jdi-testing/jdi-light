package com.epam.jdi.light.material.elements.navigation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.navigation.DrawerAssert;
import com.epam.jdi.light.material.elements.displaydata.list.SimpleList;
import com.epam.jdi.light.material.elements.utils.enums.Position;
import com.epam.jdi.light.material.interfaces.HasPosition;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.stream.Collectors;


import static com.epam.jdi.light.common.Exceptions.runtimeException;
/**
 * Represents drawer MUI component on GUI.
 *
 * @see <a href="https://mui.com/components/drawers/">Drawer MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class Drawer extends UIBaseElement<DrawerAssert> implements HasPosition {

    /**
     * Gets lists within this drawer.
     *
     * @return lists included in this drawer as {@link List}
     * @see SimpleList
     */
    @JDIAction("Get '{name}'s lists of items")
    public List<SimpleList> lists() {
        return core().finds(".MuiList-root").stream()
                .map(list -> new SimpleList().setCore(SimpleList.class, list))
                .collect(Collectors.toList());
    }

    /**
     * Gets the top (first) list of this drawer.
     *
     * @return top list of this drawer as {@link SimpleList}
     */
    @JDIAction("Get list on the top of '{name}'")
    public SimpleList topList() {
        return lists().get(0);
    }

    /**
     * Gets the bottom (last) list of this drawer.
     *
     * @return bottom list of this drawer as {@link SimpleList}
     */
    @JDIAction("Get list on the bottom of '{name}'")
    public SimpleList bottomList() {
        List<SimpleList> menuLists = lists();
        return menuLists.get(menuLists.size() - 1);
    }

    @Override
    @JDIAction("Check that '{name}' is displayed")
    public boolean isDisplayed() {
        return core().css("visibility").equals("visible") || super.isDisplayed();
    }

    /**
     * Closes (hides or collapses) this drawer, if possible. If not possible, does nothing.
     */
    @JDIAction("Close '{name}'")
    public void close() {
        if (core().hasClass("MuiDrawer-modal")) {
            core().sendKeys(Keys.ESCAPE);
        }
        else {
            runtimeException("Can't close not modal Drawer");
        }
    }

    /**
     * Gets positions of this drawer on GUI (left, right, top, bottom).
     *
     * @return position of this drawer on GUI as {@link Position}
     */
    @Override
    @JDIAction("Get '{name}'s position")
    public Position position() {
        return getPositionFromClass("MuiDrawer-paperAnchor");
    }

    @Override
    public DrawerAssert is() {
        return new DrawerAssert().set(this);
    }
}
