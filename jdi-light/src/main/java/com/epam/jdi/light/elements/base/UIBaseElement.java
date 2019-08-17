package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

public abstract class UIBaseElement<A extends UIAssert> implements ICoreElement, HasAssert<A> {
    protected UIElement uiElement;
    public JDIBase base() { return core().base(); }
    public UIElement core() {
        if (uiElement == null)
            uiElement = new UIElement();
        return uiElement;
    }
    protected UIElement linked(String locator, String name) {
        return new UIElement(base(), locator, getName() + " " + name, this);
    }
    protected WebList linkedList(String locator, String name) {
        return new WebList(base(), locator, getName() + " " + name, this);
    }

    protected void setElement(UIElement uiElement) { this.uiElement = uiElement; }
    public A is() {
        return (A) new UIAssert().set(this);
    }
}
