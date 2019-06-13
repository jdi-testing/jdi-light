package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.HasCache;

public abstract class UIBaseElement<A extends UIAssert> extends DriverBase
        implements IBaseElement, HasAssert<A>, HasUIElement, HasCache {
    protected UIElement element;
    public UIElement element() {
        if (element == null)
            element = new UIElement().setName(getName() + " element");
        return element;
    }
    protected void setElement(UIElement uiElement) { element = uiElement; }

    public void hover() { element().hover(); }
    public boolean isEnabled() {
        return element().isEnabled();
    }
    public boolean isDisabled() {
        return element().isDisabled();
    }
    public boolean isDisplayed() {
        return element().isDisplayed();
    }
    public boolean isHidden() {
        return element().isHidden();
    }
    public void highlight(String color) {
        element().highlight(color);
    }
    public void highlight() {
        element().highlight();
    }
    public void show() {
        element().show();
    }

    public void offCache() {
        element().offCache();
    }

    public A is() {
        return (A) new UIAssert().set(this);
    }
}
