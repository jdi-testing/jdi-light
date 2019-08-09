package com.epam.jdi.light.ui.html.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasValue;
import com.epam.jdi.light.ui.html.asserts.ImageAssert;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.light.ui.html.HtmlUtils.getInt;

public class Image extends UIBaseElement<ImageAssert>
        implements HasClick, HasValue {
    // region Actions
    @JDIAction(value = "Get '{name}' image source path", level = DEBUG)
    public String src() { return uiElement.attr("src"); }
    @JDIAction(value = "Get '{name}' image height", level = DEBUG)
    public int height() { return getInt("height", uiElement); }
    @JDIAction(value = "Get '{name}' image width", level = DEBUG)
    public int width() { return getInt("width", uiElement); }
    @JDIAction(value = "Get '{name}' image alt", level = DEBUG)
    public String alt() { return uiElement.attr("alt"); }

    public String getValue() {
        return src();
    }
    // endregion

    // region Extend assertions
    @Override
    public ImageAssert is() {
        return new ImageAssert().set(this);
    }
    // endregion
}
