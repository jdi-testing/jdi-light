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
    public UIElement linked(String locator, String name) {
        return new UIElement(base()).setup(
            b -> { b.setLocator(locator); b.name = getName() + " " + name; });
    }
    public WebList linkedList(String locator, String name) {
        return new WebList(base()).setup(
                b -> { b.setLocator(locator); b.name = getName() + " " + name; });
    }

    protected void setElement(UIElement uiElement) { this.uiElement = uiElement; }
    public A is() {
        return (A) new UIAssert().set(this);
    }
}
