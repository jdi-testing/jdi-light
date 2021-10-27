package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.vuetify.asserts.NavigationDrawerAssert;

import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.driver.WebDriverFactory.jsExecute;

/**
 *
 * To see an example of Banner web element please visit https://vuetifyjs.com/en/components/navigation-drawers/
 *
 */

public class NavigationDrawer extends UIBaseElement<NavigationDrawerAssert> implements HasClick {

    private WebList getOptions() {
        return this.finds("div.v-list-item");
    }

    @JDIAction("'{name}' has expected number of options")
    public int hasNumberOfOptions() {
        return this.getOptions().size();
    }

    @JDIAction("All options of '{name}' are visible")
    public boolean hasAllOptionsVisible() {
        return this.getOptions().stream()
                .allMatch(UIElement::isVisible);
    }

    @JDIAction("'{name}' option is selected")
    public boolean hasOptionSelected(int optionNumber, Boolean optionStatus) {
        List<Boolean> optionsStatuses = getOptions().stream()
                .map(o -> o.getAttribute("aria-selected")).map(Boolean::valueOf)
                .collect(Collectors.toList());
        return optionsStatuses.get(optionNumber).equals(optionStatus);
    }

    private float getWidth() {
        return Float.parseFloat(this.core().getCssValue("width").replace("px", ""));
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
        return this.core().getAttribute("class")
                .contains("v-navigation-drawer--close");
    }

    @JDIAction("'{name}' is opened")
    public boolean isOpened() {
        return this.core().getAttribute("class")
                .contains("v-navigation-drawer--open");
    }

    @JDIAction("'{name}' located in the expected part of the container")
    public String hasLocation() {
        return this.core().getAttribute("class");
    }

    @JDIAction("'{name}' option is clickable")
    public boolean hasOptionClickable(int optionNumber) {
        return this.getOptions().get(optionNumber).isClickable();
    }

    @JDIAction("'{name}' has background image")
    public boolean hasBackgroundImage() {
        return this.find(".v-image__image").getCssValue("background-image").contains("url");
    }

    @JDIAction("'{name}' has expected background color")
    public String hasBackgroundColor() {
        return this.core().getCssValue("background-color");
    }

    @JDIAction("'{name}' has button")
    public boolean hasButton() {
        return this.core().find("button").isClickable();
    }

    public void selectOption(int optionNumber) {
        this.getOptions().get(optionNumber).click();
    }

    public void collapse() {
        this.find(".v-navigation-drawer__content i").click();
    }

    public void scrollIntoView() {
        jsExecute("arguments[0].scrollIntoView(true);", this.core().getFast());
    }

    public NavigationDrawerAssert is() {
        return new NavigationDrawerAssert().set(this);
    }

    public NavigationDrawerAssert has() {
        return this.is();
    }
}
