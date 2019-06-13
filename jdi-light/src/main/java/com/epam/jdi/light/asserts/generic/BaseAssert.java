package com.epam.jdi.light.asserts.generic;

import com.epam.jdi.light.asserts.core.SoftAssert;
import com.epam.jdi.light.elements.base.JDIElement;
import com.epam.jdi.tools.func.JFunc1;

public class BaseAssert<E extends JDIElement> {
    public String name;
    public String failElement;
    public E uiElement;
    public static JFunc1<JDIElement, String> PRINT_ASSERT = JDIElement::toString;

    public BaseAssert() { }
    public BaseAssert(E element) {
        this(element.getName(), element.failElement());
        this.uiElement = element;
    }
    public BaseAssert(String name, String failElement) {
        this.name = name;
        this.failElement = failElement;
    }
    public BaseAssert(String name) {
        this.name = name;
        this.failElement = name;
    }

    @Override
    public String toString() {
        return uiElement != null
            ? PRINT_ASSERT.execute(uiElement) : name;
    }

    public void assertResults() {
        SoftAssert.assertResults();
    }
}
