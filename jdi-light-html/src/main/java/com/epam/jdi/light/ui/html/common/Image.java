package com.epam.jdi.light.ui.html.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.ui.html.aserts.ImageAssert;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;

public class Image extends UIBaseElement<ImageAssert> {
    // region Actions
    @JDIAction("Click on '{name}'")
    public void click() {
        element.click();
    }
    @JDIAction(value = "Get '{name}' image source path", level = DEBUG)
    public String src() { return element.attr("src"); }
    @JDIAction(value = "Get '{name}' image height", level = DEBUG)
    public String height() { return element.attr("height"); }
    @JDIAction(value = "Get '{name}' image width", level = DEBUG)
    public String width() { return element.attr("width"); }
    @JDIAction(value = "Get '{name}' image alt", level = DEBUG)
    public String alt() { return element.attr("alt"); }
    // endregion

    // region Extend assertions
    public ImageAssert is() {
        return new ImageAssert().set(this);
    }
    // endregion
}
