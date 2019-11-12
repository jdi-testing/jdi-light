package com.epam.jdi.light.ui.html.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasValue;
import com.epam.jdi.light.ui.html.asserts.ImageAssert;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.light.ui.html.HtmlUtils.getInt;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class Image extends UIBaseElement<ImageAssert>
        implements HasClick, HasValue {
    // region Actions
    @JDIAction(value = "Get '{name}' image source path", level = DEBUG)
    public String src() { return uiElement.attr("src"); }
    @JDIAction(value = "Get '{name}' image source path", level = DEBUG)
    public String fileName() {
        String[] split = uiElement.attr("src").split("/");
        return split[split.length-1];
    }
    @JDIAction(value = "Get '{name}' image height", level = DEBUG)
    public int height() { return getInt("height", uiElement); }
    @JDIAction(value = "Get '{name}' image width", level = DEBUG)
    public int width() { return getInt("width", uiElement); }
    @JDIAction(value = "Get '{name}' image alt", level = DEBUG)
    public String alt() { return uiElement.attr("alt"); }
    public String makePhoto() { return uiElement.makePhoto(); }
    public String makePhoto(String tag) { return uiElement.makePhoto(tag); }
    public void visualValidation(String tag) {
        uiElement.visualValidation(tag);
    }
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
