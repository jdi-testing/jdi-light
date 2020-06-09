package com.epam.jdi.light.asserts.generic;

import com.epam.jdi.light.asserts.core.SoftAssert;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.interfaces.base.HasRefresh;
import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import com.epam.jdi.light.elements.interfaces.base.JDIElement;
import com.epam.jdi.tools.func.JFunc1;

import static com.epam.jdi.tools.ReflectionUtils.isInterface;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class BaseAssert<E extends IBaseElement> implements IBaseElement {
    public String name;
    @Override
    public String getName() {
        return name;
    }
    public String failElement;
    public E element;
    public static JFunc1<JDIElement, String> PRINT_ASSERT = JDIElement::toString;

    public JDIBase base() {
        return element().base();
    }
    public E element() {
        if (isInterface(element.getClass(), HasRefresh.class))
            ((HasRefresh)element).refresh();
        return element;
    }

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
