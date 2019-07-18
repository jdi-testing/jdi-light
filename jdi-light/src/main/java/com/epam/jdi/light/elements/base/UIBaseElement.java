package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.elements.common.UIElement;

public abstract class UIBaseElement<A extends UIAssert>
        implements IBaseElement, HasAssert<A> {
    protected UIElement element;
    public JDIBase base() { return core().base(); }
    public UIElement core() {
        if (element == null)
            element = new UIElement();
        return element;
    }

    protected void setElement(UIElement uiElement) { element = uiElement; }

    public void hover() { core().hover(); }
    public boolean isEnabled() {
        return core().isEnabled();
    }
    public boolean isDisabled() {
        return !isEnabled();
    }
    public boolean isDisplayed() {
        return core().isDisplayed();
    }
    public boolean isHidden() {
        return !isDisplayed();
    }
    public void highlight(String color) {
        core().highlight(color);
    }
    public void highlight() {
        core().highlight();
    }
    public void show() {
        core().show();
    }

    public A is() {
        return (A) new UIAssert().set(this);
    }
}
