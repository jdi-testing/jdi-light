package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.OverlayAssert;
import com.epam.jdi.light.elements.interfaces.base.HasColor;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;

import static com.epam.jdi.light.elements.init.UIFactory.$;

/**
 * To see an example of Overlay web element please visit https://vuetifyjs.com/en/components/overlays
 */
public class Overlay extends UIBaseElement<OverlayAssert> implements HasColor, HasTheme {

    private static final double DEFAULT_OPACITY = 0.46;
    private static final int DEFAULT_Z_INDEX = 5;
    private static final String OVERLAY_SCRIM_LOCATOR = ".v-overlay__scrim";

    @JDIAction("Get {name} content")
    public UIElement content() {
        return core().find(".v-overlay__content");
    }

    @JDIAction("Get {name} content")
    public <T extends UIElement> T content(Class<T> clazz) {
        return this.content().with(clazz);
    }

    @Override
    @JDIAction("Get if '{name}' is displayed")
    public boolean isDisplayed() {
        return core().hasClass("v-overlay--active");
    }

    @JDIAction("Get if '{name}' is absolute")
    public boolean isAbsolute() {
        return core().hasClass("v-overlay--absolute");
    }

    @JDIAction("Get '{name}' z-index value")
    public int zIndex() {
        // z-index value from style attribute
        String zIndex = core().getAttribute("style").replaceFirst(".*z-index: (\\d+);.*", "$1");
        try {
            return Integer.parseInt(zIndex);
        } catch (NumberFormatException ex) {
            return DEFAULT_Z_INDEX;
        }
    }

    @JDIAction("Get '{name}' opacity")
    public double opacity() {
        String opacity = $(OVERLAY_SCRIM_LOCATOR, core()).css("opacity");
        if (!opacity.isEmpty()) {
            return Double.parseDouble(opacity);
        } else {
            return DEFAULT_OPACITY;
        }
    }

    @Override
    @JDIAction("Get '{name}' background color")
    public String backgroundColor() {
        return core().find(OVERLAY_SCRIM_LOCATOR).css("background-color");
    }

    @Override
    public OverlayAssert is() {
        return new OverlayAssert().set(this);
    }
}
