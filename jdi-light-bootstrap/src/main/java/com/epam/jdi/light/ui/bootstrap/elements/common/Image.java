package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasValue;
import com.epam.jdi.light.ui.bootstrap.asserts.ImageAssert;
import org.openqa.selenium.By;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;

/**
 * To see an example of Image in bootstrap please visit https://getbootstrap.com/docs/4.3/content/images/
 */

public class Image extends UIBaseElement<ImageAssert>
        implements HasClick, HasValue {
    //TODO REFACTOR REMOVE CLASS
    // region Actions
    @JDIAction(value = "Get '{name}' image source path", level = DEBUG)
    public String src() { return uiElement.attr("src"); }
    @JDIAction(value = "Get '{name}' image height", level = DEBUG)
    public String height() { return uiElement.attr("height"); }
    @JDIAction(value = "Get '{name}' image width", level = DEBUG)
    public String width() { return uiElement.attr("width"); }
    @JDIAction(value = "Get '{name}' image alt", level = DEBUG)
    public String alt() { return uiElement.attr("alt"); }
    @JDIAction(value = "Get '{name}' image tag attribute by its name", level = DEBUG)
    public String getAttribute(final String tagName, final String attribute) {
        return getInnerElement(tagName).core().getAttribute(attribute);
    }
    @JDIAction(value = "Get '{name}' image internal element", level = DEBUG)
    public UIElement getInnerElement(final String tagName) {
        return core().find(By.tagName(tagName));
    }
    @JDIAction(value = "Get '{name}' image tag text", level = DEBUG)
    public String getText(final String tagName) {
        return getInnerElement(tagName).core().getText();
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
