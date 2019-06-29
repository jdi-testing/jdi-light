package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.HasCache;

public abstract class UIBaseElement<A extends UIAssert>
        implements IBaseElement, HasAssert<A>, HasUIElement, HasCache {
    protected UIElement element;
    public UIElement core() {
        if (element == null)
            element = new UIElement().setName(getName() + " element");
        return element;
    }
    public String getName() {
        return core().getName();
    }
    protected void setElement(UIElement uiElement) { element = uiElement; }

    public void hover() { core().hover(); }
    public boolean isEnabled() {
        return core().isEnabled();
    }
    public boolean isDisabled() {
        return core().isDisabled();
    }
    public boolean isDisplayed() {
        return core().isDisplayed();
    }
    public boolean isHidden() {
        return core().isHidden();
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

    public void offCache() {
        core().base().offCache();
    }

    public A is() {
        return (A) new UIAssert().set(this);
    }
}
