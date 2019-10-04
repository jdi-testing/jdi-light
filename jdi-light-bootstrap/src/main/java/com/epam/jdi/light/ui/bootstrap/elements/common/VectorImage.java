package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.ui.bootstrap.asserts.BaseImageAssert;
import com.epam.jdi.light.ui.bootstrap.asserts.VectorImageAssert;
import org.openqa.selenium.By;

public class VectorImage extends BaseImage<VectorImageAssert> {

    private UIElement getInnerElement(final String tagName) {
        return core().find(By.tagName(tagName));
    }

    public String getText(final String tagName) {
        return getInnerElement(tagName).core().getText();
    }

    public String getAttribute(final String tagName, final String attribute) {
        return getInnerElement(tagName).core().getAttribute(attribute);
    }

    public BaseImageAssert is() {
        return new VectorImageAssert().set(this);
    }
}
