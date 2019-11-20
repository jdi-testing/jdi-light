package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.ui.bootstrap.asserts.BaseImageAssert;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.light.ui.bootstrap.BootstrapUtils.getInt;

/**
 * To see an example of Image in bootstrap please visit https://getbootstrap.com/docs/4.3/content/images/
 */

public abstract class BaseImage<A extends BaseImageAssert> extends UIBaseElement<BaseImageAssert> {
    @JDIAction(value = "Get '{name}' image height", level = DEBUG)
    public int height() { return getInt("height", uiElement); }
    @JDIAction(value = "Get '{name}' image width", level = DEBUG)
    public String width() { return uiElement.attr("width"); }
}
