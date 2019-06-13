package com.epam.jdi.light.elements.base;

public interface IBaseElement extends JDIElement {
    void hover();
    boolean isEnabled();
    boolean isDisabled();
    boolean isDisplayed();
    boolean isHidden();
    void highlight(String color);
    void highlight();
    void show();
}
