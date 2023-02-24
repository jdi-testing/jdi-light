package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.ImageAssert;
import com.epam.jdi.light.vuetify.interfaces.HasMeasurement;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;

/**
 * To see an example of Image web element please visit <a href="https://vuetifyjs.com/en/components/images/">images</a>
 */

public class Image extends UIBaseElement<ImageAssert> implements HasMeasurement, HasTheme {

    @JDIAction("Get '{name}' alternate image text")
    public String alternateText() {
        return attr("aria-label");
    }

    @JDIAction("Get if '{name}' is contain")
    public boolean isContain() {
        return image().hasClass("v-image__image--contain");
    }

    @JDIAction("Get '{name}' image source path")
    public String sourcePath() {
        return image().css("background-image").replaceAll("(.*url\\(\")(\\S+)(\"\\).*)", "$2");
    }

    @JDIAction("Get if '{name}' has gradient")
    public boolean hasGradient() {
        if (image().getAttribute("style").contains("gradient")) {
            return true;
        }
        UIElement fillHeight = find(".fill-height");
        if (fillHeight.isExist()) {
            return fillHeight.getAttribute("class").contains("gradient");
        }
        return false;
    }

    @JDIAction("Get if '{name}' has placeholder")
    public boolean hasPlaceholder() {
        return find(".v-image__placeholder").isExist();
    }

    @JDIAction("Get if '{name}' is loaded")
    public boolean isLoaded(){
        return !image().hasClass("v-image__image--preload");
    }

    private UIElement image() {
        return find(".v-image__image");
    }

    @Override
    public ImageAssert is() {
        return new ImageAssert().set(this);
    }
}
