package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.ImageAssert;
import com.epam.jdi.light.vuetify.interfaces.HasMeasurement;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;

/**
 * To see an example of Image web element please visit https://vuetifyjs.com/en/components/images/
 */

public class Image extends UIBaseElement<ImageAssert> implements HasMeasurement, HasTheme {

    @JDIAction("Get '{name}' alternate image text")
    public String alternateText() {
        return core().attr("aria-label");
    }

    @JDIAction("Check that '{name}' is contain")
    public boolean isContain() {
        return image().hasClass("v-image__image--contain");
    }

    @JDIAction("Get '{name}' image source path")
    public String sourcePath() {
        return image().getCssValue("background-image")
                .replaceAll("(^url\\(\")(\\S+)(\"\\)$)", "$2");
    }

    @JDIAction("Check that '{name}' has gradient")
    public boolean hasGradient() {
        if (image().getAttribute("style").contains("gradient")) {
            return true;
        } else if (core().find(".fill-height").isExist()) {
            return core().find(".fill-height").getAttribute("class").contains("gradient");
        }
        return false;
    }

    @JDIAction("Check that '{name}' has placeholder")
    public boolean hasPlaceholder() {
        return core().find(".v-image__placeholder").isExist();
    }

    private UIElement image() {
        return core().find(".v-image__image");
    }

    @Override
    public ImageAssert is() {
        return new ImageAssert().set(this);
    }
}
