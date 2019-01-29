package com.epam.jdi.light.asserts;

import com.epam.jdi.light.elements.base.BaseElement;
import com.epam.jdi.light.elements.base.BaseUIElement;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.tools.func.JFunc1;

import static com.epam.jdi.tools.ReflectionUtils.isClass;

public class BaseAssert {
    public String name;
    public String failElement;
    public JDIBase element;
    public static JFunc1<JDIBase, String> PRINT_ASSERT = JDIBase::toString;

    public BaseAssert(BaseElement element) {
        this(get(element).name, get(element).toError());
        this.element = (JDIBase) element;
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
        return element != null
            ? PRINT_ASSERT.execute(element) : name;
    }
    private static JDIBase get(BaseElement element) { return (JDIBase) element; }
}
