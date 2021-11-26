package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.OverlayAssert;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.UIFactory.$$;

/**
 * To see an example of Subheader web element please visit https://vuetifyjs.com/en/components/overlays
 */
public class Overlay extends UIBaseElement<OverlayAssert> {

    private static final double DEFAULT_OPACITY = 0.46;
    private static final int DEFAULT_Z_INDEX = 5;
    private String scrimLocator = ".v-overlay__scrim";
    private String contentLocator = ".v-overlay__content";

    Overlay() {
    }

    public Overlay(UIElement element) {
        core().setCore(element);
    }

    @JDIAction("Get content '{name}'")
    public UIElement content() {
        return $$(contentLocator, core()).stream().findFirst().orElse(null);
    }

    public boolean isActive() {
        return core().hasClass("v-overlay--active");
    }

    public boolean isAbsolute() {
        return core().hasClass("v-overlay--absolute");
    }

    @JDIAction("Get '{name}' z-index")
    public int zIndex() {
        if (!core().getAttribute("style").replaceAll("^\\D*?(\\d+).*$", "$1").isEmpty())
            return Integer.parseInt(core().getAttribute("style").replaceAll("^\\D*?(\\d+).*$", "$1"));
        else
            return DEFAULT_Z_INDEX;
    }

    @JDIAction("Get '{name}' opacity")
    public double opacity() {
        if (!$(scrimLocator, core()).css("opacity").isEmpty())
            return Double.parseDouble($(scrimLocator, core()).css("opacity"));
        else
            return DEFAULT_OPACITY;
    }

    @Override
    public OverlayAssert is() {
        return new OverlayAssert().set(this);
    }
}
