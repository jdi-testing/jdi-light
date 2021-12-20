package com.epam.jdi.light.material.elements.navigation;

import static com.epam.jdi.light.elements.init.UIFactory.$;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.material.asserts.navigation.DrawerAssert;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.Keys;

import java.util.LinkedList;
import java.util.List;

/**
 * To see an example of Drawer web element please visit
 * https://mui.com/components/drawers/
 */

public class Drawer extends UIBaseElement<DrawerAssert> {

    public WebList elements() {
        return finds(".MuiListItem-root");
    }

    @JDIAction("Get {name}'s container title")
    public String containerTitle() {
        return drawerContent().find(".MuiContainer-root header").text();
    }

    private UIElement drawerContent() {
        return $("div.MuiGrid-container");
    }

    @JDIAction("Get {name}'s container text")
    public List<String> containerText() {
        List<String> contentText = new LinkedList<>();
        drawerContent().finds(".MuiContainer-root p").forEach(element -> contentText.add(element.text()));
        return contentText;
    }

    @JDIAction("Open {name}")
    public void open() {
        drawerContent().find("[aria-label='open drawer']").click();
    }

    @JDIAction("Close {name}")
    public void close() {
        UIElement closeButton = find(".MuiIconButton-root");
        if (closeButton.isExist()) {
            closeButton.click();
        } else {
            core().sendKeys(Keys.ESCAPE);
        }
    }

    @JDIAction("Get {name}'s element text")
    public String elementText(int elNum) {
        return element(elNum).find(".MuiListItemText-root").text();
    }

    private UIElement element(int elNum) {
        return finds(".MuiListItem-root").get(elNum);
    }

    @JDIAction("Show that {name}'s element has icon")
    public boolean elementHasIcon(int elNum) {
        return element(elNum).find(".MuiSvgIcon-root").isVisible();
    }

    @JDIAction("Show that {name} has position")
    public boolean hasPosition(String position) {
        return attr("class").contains(String.format("MuiDrawer-paperAnchor%s", StringUtils.capitalize(position)));
    }

    @Override
    public DrawerAssert is() {
        return new DrawerAssert().set(this);
    }
}
