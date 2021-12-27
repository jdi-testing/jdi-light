package com.epam.jdi.light.material.elements.navigation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.navigation.DrawerAssert;
import com.epam.jdi.light.material.elements.displaydata.List;
import com.epam.jdi.light.material.elements.displaydata.ListItem;
import org.openqa.selenium.Keys;

import java.util.Arrays;
import java.util.stream.Collectors;

import static com.epam.jdi.light.common.Exceptions.exception;

/**
 * To see an example of Drawer web element please visit
 * https://mui.com/components/drawers/
 */

public class Drawer extends UIBaseElement<DrawerAssert> {

    private static final String LEFT = "left";
    private static final String RIGHT = "right";
    private static final String TOP = "top";
    private static final String BOTTOM = "bottom";

    @JDIAction("Get {name}'s elements")
    public java.util.List<ListItem> listItems() {
        return finds(".MuiListItem-root").stream()
                .map(element -> new ListItem().setCore(ListItem.class, element))
                .collect(Collectors.toList());
    }

    @JDIAction("Get {name}'s elements")
    public java.util.List<List> lists() {
        return finds(".MuiList-root").stream()
                .map(List::new)
                .collect(Collectors.toList());
    }

    @JDIAction("Get {name}'s elements")
    public List topList() {
        return lists().get(0);
    }

    @JDIAction("Get {name}'s elements")
    public List bottomList() {
        return lists().get(1);
    }

    @JDIAction("Get {name}'s elements")
    public String getWidth() {
        return css("width");
    }

    @Override
    @JDIAction("Get {name}'s elements")
    public boolean isHidden() {
        return find(".MuiDrawer-paper").css("visibility").equals("hidden");
    }

    @JDIAction("Close {name}")
    public void close() {
        UIElement closeButton = find("button");
        if (closeButton.isExist()) {
            closeButton.click();
        } else {
            core().sendKeys(Keys.ESCAPE);
        }
    }

    @JDIAction("Get '{name}'s position")
    public String getPosition() {
        String position = Arrays.stream(find(".MuiDrawer-paper")
                        .attr("class")
                        .split("[^a-zA-Z0-9]"))
                .map(String::toLowerCase)
                .filter(s -> s.contains("anchor"))
                .findAny().orElse("Unknown position")
                .replaceAll("paperanchor", "")
                .replaceAll("docked", "");
        switch (position) {
            case (LEFT) :
                return LEFT;
            case (RIGHT) :
                return RIGHT;
            case (TOP) :
                return TOP;
            case (BOTTOM) :
                return BOTTOM;
            default :
                throw exception("Unknown position");
        }
    }

    @Override
    public DrawerAssert is() {
        return new DrawerAssert().set(this);
    }
}
