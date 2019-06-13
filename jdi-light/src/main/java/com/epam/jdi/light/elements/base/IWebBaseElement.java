package com.epam.jdi.light.elements.base;

public interface IWebBaseElement extends IBaseElement {
    String getAttribute(String value);
    String getCssValue(String value);
    String getTagName();
}
