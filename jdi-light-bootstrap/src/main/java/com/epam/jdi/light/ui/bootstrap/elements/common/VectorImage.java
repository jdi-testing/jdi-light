package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.ui.bootstrap.asserts.BaseImageAssert;
import com.epam.jdi.light.ui.bootstrap.asserts.VectorImageAssert;
import org.openqa.selenium.By;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;

public class VectorImage extends BaseImage<VectorImageAssert> {

    @JDIAction(value = "Get '{name}' vector image internal element", level = DEBUG)
    public UIElement getInnerElement(final String tagName) {
        return core().find(By.tagName(tagName));
    }

    @JDIAction(value = "Get '{name}' vector image tag text", level = DEBUG)
    public String getText(final String tagName) {
        return getInnerElement(tagName).core().getText();
    }

    @JDIAction(value = "Get '{name}' vector image tag attribute by its name", level = DEBUG)
    public String getAttribute(final String tagName, final String attribute) {
        return getInnerElement(tagName).core().getAttribute(attribute);
    }

    public BaseImageAssert is() {
        return new VectorImageAssert().set(this);
    }
}
