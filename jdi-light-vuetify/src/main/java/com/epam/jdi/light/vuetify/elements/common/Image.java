package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.vuetify.asserts.ImageAssert;
import com.epam.jdi.tools.Timer;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * To see an example of Image web element please visit https://vuetifyjs.com/en/components/images/
 */

public class Image extends UIBaseElement<ImageAssert> {

    @JDIAction("Get '{name}' image source path")
    public String hasSourcePath() {
        return Arrays.stream(find(".v-image__image").getCssValue("background-image")
                .split("\"")).filter(e -> e.contains("https")).collect(Collectors.joining());
    }

    @JDIAction("'{name}' has height")
    public String hasHeight() {
        return core().getCssValue("height");
    }

    @JDIAction("'{name}' has width")
    public String hasWidth() {
        return core().getCssValue("width");
    }

    @JDIAction("'{name}' has gradient")
    public boolean hasGradient() {
        return find(".v-image__image").getAttribute("style").contains("gradient") ||
                find(".fill-height").getAttribute("class").contains("gradient");
    }

    @JDIAction("'{name}' has limited height")
    public boolean hasLimitedHeight() {
        return core().getAttribute("style").contains("height");
    }

    @JDIAction("'{name}' is loading")
    public boolean isLoading() {
        return find(".v-progress-circular").isDisplayed();
    }

    @JDIAction("Scroll to '{name}'")
    public void scrollIntoView() {
        Timer.waitCondition(this::isDisplayed);
        core().jsExecute("scrollIntoView()");
    }

    public ImageAssert is() {
        return new ImageAssert().set(this);
    }

    public ImageAssert has() {
        return is();
    }
}
