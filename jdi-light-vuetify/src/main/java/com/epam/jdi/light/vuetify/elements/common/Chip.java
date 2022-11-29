package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.vuetify.asserts.ChipAssert;
import com.epam.jdi.light.vuetify.elements.complex.Text;
import com.epam.jdi.light.vuetify.interfaces.HasColor;
import com.epam.jdi.light.vuetify.interfaces.HasIcon;
import com.epam.jdi.light.vuetify.interfaces.HasImage;
import com.epam.jdi.light.vuetify.interfaces.HasMeasurement;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.IsOutlined;
import com.jdiai.tools.Timer;

import java.util.List;

/**
 * To see an example of Chip web element please visit https://vuetifyjs.com/en/components/chips/
 */

public class Chip extends UIBaseElement<ChipAssert> implements HasClick, HasLabel, HasColor, HasIcon, HasImage,
        HasTheme, IsOutlined, HasMeasurement {

    protected static final String TEXT = ".v-chip__content";

    private static final String CONTENT = ".v-chip__content *";
    private static final String CLOSE_BUTTON = "button.v-chip__close";
    private static final String FILTER = ".v-chip__filter";
    private static final String IMAGE = ".v-image__image";

    @Override
    public ChipAssert is() {
        return new ChipAssert().set(this);
    }

    @Override
    @JDIAction("Check that '{name}' is enabled")
    public boolean isEnabled() {
        return !hasClass("v-chip--disabled");
    }

    @JDIAction("Get '{name}' content")
    public List<UIElement> getContent() {
        return finds(CONTENT);
    }

    @JDIAction("Get '{name}' text")
    public Text text() {
        return new Text().setCore(Text.class, find(TEXT));
    }

    @JDIAction("Get '{name}' text")
    public String getText() {
        return text().getText();
    }

    @JDIAction("Close '{name}'")
    public void close() {
        find(CLOSE_BUTTON).click();
    }

    @JDIAction("Check that '{name}' is draggable")
    public boolean isDraggable() {
        return hasClass("v-chip--draggable");
    }

    @JDIAction("Check that '{name}' is active")
    public boolean active() {
        return hasClass("v-chip--active");
    }

    @JDIAction("Check that '{name}' filter icon is displayed")
    public boolean isFilterIconDisplayed() {
        return find(FILTER).isDisplayed();
    }

    // "label" refers to specific element border radius settings
    @JDIAction("Check that '{name}' is marked as label chip")
    public boolean isLabel() {
        return hasClass("v-chip--label");
    }

    @JDIAction("Check that '{name}' has an image")
    public boolean hasImage() {
        return new Timer(base().getTimeout() * 1000L)
            .wait(() -> this.find(IMAGE).isExist());
    }

    @JDIAction("Get '{name}' font size")
    public int fontSize() {
        return Integer.parseInt(css("font-size").replace("px", ""));
    }

    @JDIAction("Check that '{name}' hss x-small size")
    public boolean hasXSmallSize() {
        return hasClass("v-size--x-small");
    }

    @JDIAction("Check that '{name}' has small size")
    public boolean hasSmallSize() {
        return hasClass("v-size--small");
    }

    @JDIAction("Check that '{name}' has default size")
    public boolean hasDefaultSize() {
        return hasClass("v-size--default");
    }

    @JDIAction("Check that '{name}' has large size")
    public boolean hasLargeSize() {
        return hasClass("v-size--large");
    }

    @JDIAction("Check that '{name}' has x-large size")
    public boolean hasXLargeSize() {
        return hasClass("v-size--x-large");
    }

    @JDIAction("Get '{name}' borderColor")
    public String borderColor() {
        return css("border-color");
    }

    @Override
    public void click() {
        text().core().click();
    }

    @JDIAction("Check that '{name}' is removable")
    public boolean isRemovable() {
        return hasClass("v-chip--removable");
    }

    @JDIAction("Check that '{name}' is pill")
    public boolean isPill() {
        return hasClass("v-chip--pill");
    }
}
