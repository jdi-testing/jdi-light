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

    public com.epam.jdi.light.ui.html.elements.common.Image getJDIImage() {
        return new com.epam.jdi.light.ui.html.elements.common.Image()
                .setCore(com.epam.jdi.light.ui.html.elements.common.Image.class, base());
    }

    @JDIAction("Get '{name}' alternate image text")
    public String alternateText() {
        return getJDIImage().attr("aria-label");
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
        } else if (getJDIImage().find(".fill-height").isExist()) {
            return getJDIImage().find(".fill-height").getAttribute("class").contains("gradient");
        }
        return false;
    }

    @JDIAction("Check that '{name}' has placeholder")
    public boolean hasPlaceholder() {
        return getJDIImage().find(".v-image__placeholder").isExist();
    }

    private UIElement image() {
        return getJDIImage().find(".v-image__image");
    }

    @Override
    public ImageAssert is() {
        return new ImageAssert().set(this);
    }
}
