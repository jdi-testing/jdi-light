package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.asserts.OverlayAssert;
import com.epam.jdi.light.vuetify.asserts.SubheaderAssert;
import com.epam.jdi.tools.map.MapArray;

import java.util.Arrays;
import java.util.List;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.UIFactory.$$;
/**
 * To see an example of Subheader web element please visit https://vuetifyjs.com/en/components/overlays
 */
public class Overlay extends UIBaseElement<OverlayAssert>  {

    protected String SCRIM_LOCATOR = ".v-overlay__scrim";
    protected String CONTENT_LOCATOR = ".v-overlay__content";
    protected double DEFAULT_OPACITY = 0.46;
    protected int DEFAULT_Z_INDEX = 5;

    @JDIAction("Get content '{name}'")
    public UIElement content() {
        return $$(CONTENT_LOCATOR, core()).stream().findFirst().orElse(null);
    }

    public boolean isActive() {
        return core().hasClass("v-overlay--active");
    }

    public boolean isAbsolute() {
        return core().hasClass("v-overlay--absolute");
    }

    @JDIAction("Get '{name}' z-index")
    public int zIndex() {
        if(!core().getAttribute("style").replaceAll("^\\D*?(\\d+).*$", "$1").isEmpty())
            return Integer.parseInt(core().getAttribute("style").replaceAll("^\\D*?(\\d+).*$", "$1"));
        else
            return DEFAULT_Z_INDEX;
    }

    @JDIAction("Get '{name}' opacity")
    public double opacity() {
        if (!$(SCRIM_LOCATOR, core()).css("opacity").isEmpty())
            return Double.parseDouble($(SCRIM_LOCATOR, core()).css("opacity"));
        else
            return DEFAULT_OPACITY;
    }

    @JDIAction("Get '{name}' background-color")
    public String backgroundColor() {
        return $(SCRIM_LOCATOR, core()).css("background-color");
    }

    @JDIAction("Get '{name}' border-color")
    public String borderColor() {
        return $(SCRIM_LOCATOR, core()).css("border-color");
    }

    @Override
    public OverlayAssert is() {
        return new OverlayAssert().set(this);
    }
}
