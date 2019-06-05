package com.epam.jdi.light.elements.base;

import com.epam.jdi.tools.func.JFunc1;

public interface IBaseElement extends JDIElement {
    void hover();
    boolean isEnabled();
    boolean isDisabled();
    boolean isDisplayed();
    boolean isHidden();
    void highlight(String color);
    void highlight();
    void show();
    boolean wait(JFunc1<IBaseElement, Boolean> condition);
}
