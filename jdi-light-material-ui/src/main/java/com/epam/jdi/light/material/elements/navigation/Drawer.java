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

    private static final String ITEMS_LOCATOR = ".MuiList-root";
    private static final String CONTENT_LOCATOR = ".MuiDrawer-paper";
    /**
     * Gets the content element.
     *
     * @return lists included in this drawer as {@link List}
     * @see SimpleList
     */
    @JDIAction("Get '{name}'s content element")
    public UIElement content() {
        return core().find(CONTENT_LOCATOR);
    }

    /**
     * Gets lists within this drawer.
     *
     * @return lists included in this drawer as {@link List}
     * @see SimpleList
     */
    @JDIAction("Get '{name}'s lists of items")
    public List<SimpleList> lists() {
        return core().finds(ITEMS_LOCATOR).stream()
                .map(list -> new SimpleList().setCore(SimpleList.class, list))
                .collect(Collectors.toList());
    }

    /**
     * Gets lists within this drawer.
     * Index is based on 1
     *
     * @return lists included in this drawer as {@link List}
     * @see SimpleList
     */
    @JDIAction("Get '{name}'s {0} list of items")
    public SimpleList list(int index) {
        return new SimpleList().setCore(SimpleList.class, core().finds(ITEMS_LOCATOR).get(index));
    }

    /**
     * Gets the top (first) list of this drawer.
     *
     * @return top list of this drawer as {@link SimpleList}
     */
    @JDIAction("Get list on the top of '{name}'")
    public SimpleList topList() {
        return list(1);
    }

    /**
     * Gets the bottom (last) list of this drawer.
     *
     * @return bottom list of this drawer as {@link SimpleList}
     */
    @JDIAction("Get list on the bottom of '{name}'")
    public SimpleList bottomList() {
        return new SimpleList().setCore(SimpleList.class, core().finds(ITEMS_LOCATOR).last());
    }

    @Override
    @JDIAction("Check that '{name}' is displayed")
    public boolean isDisplayed() {
        return content().css("visibility").equals("visible") || content().isDisplayed();
    }

    /**
     * Closes (hides or collapses) this drawer, if possible. If not possible, does nothing.
     */
    @JDIAction("Close '{name}'")
    public void close() {
        if (core().hasClass("MuiDrawer-modal")) {
            core().actions(a -> a.sendKeys(Keys.ESCAPE));
        } else {
            throw runtimeException("Can't close not modal Drawer");
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
        return getPositionFromClass(content(), "MuiDrawer-paperAnchor");
    }

    @Override
    public DrawerAssert is() {
        return new DrawerAssert().set(this);
    }
}
