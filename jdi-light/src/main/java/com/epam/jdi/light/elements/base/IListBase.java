package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.common.TextType;

public interface IListBase extends IBaseElement {
    void click();
    String getText();
    String text(TextType type);
    boolean isSelected();
    boolean isDisplayed();
}
