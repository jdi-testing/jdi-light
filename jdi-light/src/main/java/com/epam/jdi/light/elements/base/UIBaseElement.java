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
    protected Boolean thisParent = null;
    protected boolean thisParent() {
        if (thisParent == null)
            return base().locator.isEmpty();
        return thisParent;
    }
    protected UIElement linked(String locator, String name) {
        UIElement el = new UIElement(base(), locator, getName() + " " + name, this);
        if (thisParent())
            el.setParent(base().parent);
        return el;
    }
    protected WebList linkedList(String locator, String name) {
        WebList list = new WebList(base(), locator, getName() + " " + name, this);
        if (thisParent())
            list.setParent(base().parent);
        return list;
    }

    protected void setElement(UIElement uiElement) { this.uiElement = uiElement; }

    public A is() {
        return (A) new UIAssert().set(this);
    }

    @Override
    public String toString() {
        return base().toString();
    }
}
