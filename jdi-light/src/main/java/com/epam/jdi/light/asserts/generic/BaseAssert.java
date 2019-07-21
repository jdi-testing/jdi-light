package com.epam.jdi.light.asserts.generic;

import com.epam.jdi.light.asserts.core.SoftAssert;
import com.epam.jdi.light.elements.interfaces.JDIElement;
import com.epam.jdi.tools.func.JFunc1;

public class BaseAssert<E extends JDIElement> {
    public String name;
    public String failElement;
    public E element;
    public static JFunc1<JDIElement, String> PRINT_ASSERT = JDIElement::toString;

    public BaseAssert() { }
    public BaseAssert(E element) {
        this(element.getName(), element.getName());
        this.element = element;
    }
    public BaseAssert(String name, String failElement) {
        this.name = name;
        this.failElement = failElement;
    }
    public BaseAssert(String name) {
        this(name, name);
    }

    @Override
    public String toString() {
        return element != null
            ? PRINT_ASSERT.execute(element) : name;
    }

    public void assertResults() {
        SoftAssert.assertResults();
    }

}
