package com.epam.jdi.light.elements.base;

public interface IListBase extends IBaseElement {
    void click();
    String getText();
    String innerText();
    boolean isSelected();
}
