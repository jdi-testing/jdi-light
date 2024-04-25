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

/**
 * To see an example of Chip web element please visit https://v2.vuetifyjs.com/en/components/chips/
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
        return !core().hasClass("v-chip--disabled");
    }

    @JDIAction("Get '{name}' content")
    public UIElement getContent() {
        return core().find(CONTENT_LOCATOR);
    }

    @JDIAction("Get '{name}' text")
    public String getText() {
        return getContent().getText();
    }

    @JDIAction("Close '{name}'")
    public void close() {
        core().find(CLOSE_BUTTON_LOCATOR).click();
    }

    @JDIAction("Get if '{name}' is draggable")
    public boolean isDraggable() {
        return core().hasClass("v-chip--draggable");
    }

    @JDIAction("Get if '{name}' is active")
    public boolean active() {
        return core().hasClass("v-chip--active");
    }

    @JDIAction("Get '{name}' filter icon")
    public UIElement filter() {
        return core().find(FILTER_LOCATOR);
    }

    @JDIAction("Get if '{name}' is marked as label chip")
    public boolean isLabel() {
        return core().hasClass("v-chip--label");
    }

    @Override
    @JDIAction("Get '{name}'s image")
    public Image image() {
        return new Image().setCore(Image.class, core().find(IMAGE_LOCATOR));
    }

    // @todo #5309 Ass interface for sizes (all small, x-small, default, large, x-large)
    @JDIAction("Get if '{name}' hss x-small size")
    public boolean hasXSmallSize() {
        return core().hasClass("v-size--x-small");
    }

    @JDIAction("Get if '{name}' has small size")
    public boolean hasSmallSize() {
        return core().hasClass("v-size--small");
    }

    @JDIAction("Get if '{name}' has default size")
    public boolean hasDefaultSize() {
        return core().hasClass("v-size--default");
    }

    @JDIAction("Get if '{name}' has large size")
    public boolean hasLargeSize() {
        return core().hasClass("v-size--large");
    }

    @JDIAction("Get if '{name}' has x-large size")
    public boolean hasXLargeSize() {
        return core().hasClass("v-size--x-large");
    }

    @JDIAction("Get '{name}' borderColor")
    public String borderColor() {
        return core().css("border-color");
    }

    @Override
    public void click() {
        getContent().core().click();
    }

    @JDIAction("Get if {name} is removable")
    public boolean isRemovable() {
        return core().hasClass("v-chip--removable") || core().find("span button").isExist() &&
                core().find("span button").attr("class").contains("close");
    }

    @JDIAction("Get if '{name}' is pill")
    public boolean isPill() {
        return core().hasClass("v-chip--pill");
    }
}
