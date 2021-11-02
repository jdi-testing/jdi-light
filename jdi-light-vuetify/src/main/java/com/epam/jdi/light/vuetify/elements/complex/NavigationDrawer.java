package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.vuetify.asserts.NavigationDrawerAssert;

/**
 * To see an example of Navigation Drawer web element please visit https://vuetifyjs.com/en/components/navigation-drawers/
 */

public class NavigationDrawer extends UIBaseElement<NavigationDrawerAssert> implements HasClick {

    private WebList getOptions() {
        return finds("div.v-list-item");
    }

    @JDIAction("'{name}' has expected number of options")
    public int hasNumberOfOptions() {
        return getOptions().size();
    }

    @JDIAction("All options of '{name}' are visible")
    public boolean hasAllOptionsVisible() {
        return getOptions().stream()
                .allMatch(UIElement::isVisible);
    }

    @JDIAction("Get '{name}' option by index")
    private UIElement getOptionByIndex(int index) {
        return getOptions().get(index);
    }

    @JDIAction("'{name}'s option on index{0} is selected")
    public boolean optionIsSelected(int index) {
        return getOptionByIndex(index).getAttribute("aria-selected").contains("true");
    }

    private float getWidth() {
        return Float.parseFloat(core().getCssValue("width").replace("px", ""));
    }

    @JDIAction("'{name}' is expanded")
    public boolean isExpanded() {
        return getWidth() > 56;
    }

    @JDIAction("'{name}' is collapsed")
    public boolean isCollapsed() {
        return getWidth() <= 56;
    }

    @JDIAction("'{name}' is closed")
    public boolean isClosed() {
        return core().getAttribute("class")
                .contains("v-navigation-drawer--close");
    }

    @JDIAction("'{name}' is opened")
    public boolean isOpened() {
        return core().getAttribute("class")
                .contains("v-navigation-drawer--open");
    }

    @JDIAction("'{name}' is located on the right side of the container")
    public boolean isOnTheRightSide() {
        return core().getAttribute("class").contains("right");
    }

    @JDIAction("'{name}'s option is clickable")
    public boolean hasOptionClickable(int index) {
        return getOptions().get(index).isClickable();
    }

    @JDIAction("'{name}' has background image")
    public boolean hasBackgroundImage() {
        return find(".v-image__image").getCssValue("background-image").contains("url");
    }

    @JDIAction("'{name}' has background color")
    public String hasBackgroundColor() {
        return core().getCssValue("background-color");
    }

    @JDIAction("'{name}' has button")
    public boolean hasButton() {
        return core().find("button").isClickable();
    }

    public void selectOptionByIndex(int index) {
        getOptionByIndex(index).click();
    }

    public void collapse() {
        find(".v-navigation-drawer__content i").click();
    }

    public NavigationDrawerAssert is() {
        return new NavigationDrawerAssert().set(this);
    }

    public NavigationDrawerAssert has() {
        return is();
    }
}
