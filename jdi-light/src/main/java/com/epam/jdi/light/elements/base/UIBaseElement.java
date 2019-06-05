package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.asserts.IHasAssert;
import com.epam.jdi.light.asserts.UIAssert;
import com.epam.jdi.tools.func.JFunc1;

public class UIBaseElement<A extends UIAssert> extends DriverBase implements IBaseElement, IHasAssert<A> {
    public UIElement element;

    public void hover() {
        element.hover();
    }
    public boolean isEnabled() {
        return element.isEnabled();
    }
    public boolean isDisabled() {
        return element.isDisabled();
    }
    public boolean isDisplayed() {
        return element.isDisplayed();
    }
    public boolean isHidden() {
        return element.isHidden();
    }
    public void highlight(String color) {
        element.highlight(color);
    }
    public void highlight() {
        element.highlight();
    }
    public void show() {
        element.show();
    }
    public boolean wait(JFunc1<IBaseElement, Boolean> condition) {
        return element.wait(condition);
    }

    public A is() {
        return (A) new UIAssert().set(this);
    }
}
