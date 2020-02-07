package com.epam.jdi.mobile.elements.interfaces.base;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public interface IWebBaseElement extends ICoreElement {
    String getAttribute(String value);
    String getCssValue(String value);
    String getTagName();
}
