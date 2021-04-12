package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.elements.common.uiElement;
import com.epam.jdi.light.elements.complex.webList;
import com.epam.jdi.light.elements.interfaces.base.HasInit;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;
import com.epam.jdi.tools.Safe;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public abstract class UIBaseElement<A extends UIAssert<?,?>> implements ICoreElement, HasAssert<A>, HasInit {
    private Safe<com.epam.jdi.light.elements.common.uiElement> uiElement = new Safe<>(uiElement::new);
    public JDIBase base() { return core().base(); }
    public com.epam.jdi.light.elements.common.uiElement core() {
        return uiElement.get();
    }
    public void init() {
        com.epam.jdi.light.elements.common.uiElement element = new uiElement(uiElement.get().base());
        uiElement = new Safe<>(() -> element);
    }
    protected boolean thisParent = false;
    protected com.epam.jdi.light.elements.common.uiElement linked(@MarkupLocator String locator, String name) {
        com.epam.jdi.light.elements.common.uiElement el = new uiElement(base(), locator, getName() + " " + name, this);
        if (thisParent)
            el.setParent(base().parent);
        return el;
    }
    protected webList linkedList(@MarkupLocator String locator, String name) {
        webList list = new webList(base(), locator, getName() + " " + name, this);
        list.searchVisible();
        if (thisParent)
            list.setParent(base().parent);
        return list;
    }

    public A is() {
        return (A) new UIAssert().set(this);
    }

    @Override
    public String toString() {
        return base().toString();
    }
}
