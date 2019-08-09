package com.epam.jdi.light.elements.interfaces.base;

public interface IWebBaseElement extends ICoreElement {
    String getAttribute(String value);
    String getCssValue(String value);
    String getTagName();
}
