package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.vuetify.asserts.ChipAssert;
import com.epam.jdi.light.elements.interfaces.base.HasColor;
import com.epam.jdi.light.vuetify.interfaces.HasIcon;
import com.epam.jdi.light.vuetify.interfaces.HasImage;
import com.epam.jdi.light.vuetify.interfaces.HasMeasurement;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.IsOutlined;
import com.jdiai.tools.Timer;

/**
 * To see an example of Chip web element please visit https://vuetifyjs.com/en/components/chips/
 */

public class Chip extends UIBaseElement<ChipAssert> implements HasClick, HasColor, HasIcon, HasImage,
        HasTheme, IsOutlined, HasMeasurement {

    private static final String CONTENT_LOCATOR = ".v-chip__content";
    private static final String CLOSE_BUTTON_LOCATOR = "button.v-chip__close";
    private static final String FILTER_LOCATOR = ".v-chip__filter";
    private static final String IMAGE_LOCATOR = ".v-image";

    @Override
    public ChipAssert is() {
        return new ChipAssert().set(this);
    }

    @Override
    @JDIAction("Get if '{name}' is enabled")
    public boolean isEnabled() {
        return !hasClass("v-chip--disabled");
    }

    @JDIAction("Get '{name}' content")
    public UIElement getContent() {
        return find(CONTENT_LOCATOR);
    }

    @JDIAction("Get '{name}' text")
    public String getText() {
        return getContent().getText();
    }

    @JDIAction("Close '{name}'")
    public void close() {
        find(CLOSE_BUTTON_LOCATOR).click();
    }

    @JDIAction("Get if '{name}' is draggable")
    public boolean isDraggable() {
        return hasClass("v-chip--draggable");
    }

    @JDIAction("Get if '{name}' is active")
    public boolean active() {
        return hasClass("v-chip--active");
    }

    @JDIAction("Get if '{name}' filter icon is displayed")
    public boolean isFilterIconDisplayed() {
        return find(FILTER_LOCATOR).isDisplayed();
    }

    // "label" refers to specific element border radius settings
    @JDIAction("Get if '{name}' is marked as label chip")
    public boolean isLabel() {
        return hasClass("v-chip--label");
    }

    @Override
    @JDIAction("Get '{name}'s image")
    public Image image() {
        return new Image().setCore(Image.class, core().find(IMAGE_LOCATOR));
    }

    @JDIAction("Get '{name}' font size")
    public int fontSize() {
        return Integer.parseInt(css("font-size").replace("px", ""));
    }

    @JDIAction("Get if '{name}' hss x-small size")
    public boolean hasXSmallSize() {
        return hasClass("v-size--x-small");
    }

    @JDIAction("Get if '{name}' has small size")
    public boolean hasSmallSize() {
        return hasClass("v-size--small");
    }

    @JDIAction("Get if '{name}' has default size")
    public boolean hasDefaultSize() {
        return hasClass("v-size--default");
    }

    @JDIAction("Get if '{name}' has large size")
    public boolean hasLargeSize() {
        return hasClass("v-size--large");
    }

    @JDIAction("Get if '{name}' has x-large size")
    public boolean hasXLargeSize() {
        return hasClass("v-size--x-large");
    }

    @JDIAction("Get '{name}' borderColor")
    public String borderColor() {
        return css("border-color");
    }

    @Override
    public void click() {
        getContent().core().click();
    }

    @JDIAction("Get if {name} is removable")
    public boolean isRemovable() {
        return hasClass("v-chip--removable") || find("span button").isExist() &&
                find("span button").attr("class").contains("close");
    }

    @JDIAction("Get if '{name}' is pill")
    public boolean isPill() {
        return hasClass("v-chip--pill");
    }
}
