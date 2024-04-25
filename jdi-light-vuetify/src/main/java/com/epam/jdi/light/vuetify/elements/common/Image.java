package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.ui.html.interfaces.HasImage;
import com.epam.jdi.light.vuetify.asserts.ImageAssert;
import com.epam.jdi.light.vuetify.interfaces.HasMeasurement;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * To see an example of Image web element please visit https://v2.vuetifyjs.com/en/components/images/
 */

public class Image extends UIBaseElement<ImageAssert> implements HasMeasurement, HasTheme, HasImage {

    @JDIAction("Get '{name}' alternate image text")
    public String alternateText() {
        return core().attr("aria-label");
    }

    @JDIAction("Get if '{name}' is contain (save image original ratio)")
    public boolean isContain() {
        return image().hasClass("v-image__image--contain");
    }

    @JDIAction("Get '{name}' image source path")
    public String getSourcePath() {
        return Arrays.stream(image().css("background-image").split(", "))
                .filter(e -> e.startsWith("url")).collect(Collectors.toList()).get(0);
    }

    @JDIAction("Get if '{name}' has gradient")
    public boolean hasGradient() {
        if (image().attr("style").contains("gradient")) {
            return true;
        }
        UIElement fillHeight = core().find(".fill-height");
        if (fillHeight.isExist()) {
            return fillHeight.getAttribute("class").contains("gradient");
        }
        return false;
    }

    @Override
    public String imageLocator() {
        return ".v-image__image";
    }

    @JDIAction("Get if '{name}' has placeholder")
    public boolean hasPlaceholder() {
        return core().find(".v-image__placeholder").isExist();
    }

    @Override
    public ImageAssert is() {
        return new ImageAssert().set(this);
    }
}
