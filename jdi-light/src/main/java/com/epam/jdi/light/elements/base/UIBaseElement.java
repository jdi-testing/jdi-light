package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public abstract class UIBaseElement<A extends UIAssert<?,?>> implements ICoreElement, HasAssert<A> {
    protected UIElement uiElement;
    public JDIBase base() { return core().base(); }
    public UIElement core() {
        if (uiElement == null)
            uiElement = new UIElement();
        return uiElement;
    }
    protected boolean thisParent = false;
    protected UIElement linked(@MarkupLocator String locator, String name) {
        UIElement el = new UIElement(base(), locator, getName() + " " + name, this);
        if (thisParent)
            el.setParent(base().parent);
        return el;
    }
    protected WebList linkedList(@MarkupLocator String locator, String name) {
        WebList list = new WebList(base(), locator, getName() + " " + name, this);
        list.searchVisible();
        if (thisParent)
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
