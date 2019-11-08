package com.epam.jdi.light.ui.bootstrap.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.bootstrap.elements.common.BaseImage;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.asserts.core.SoftAssertUtils.jdiAssert;
import static org.hamcrest.Matchers.is;

public abstract class BaseImageAssert<E extends BaseImage> extends UIAssert<BaseImageAssert, BaseImage> {

    @JDIAction("Assert that '{name}' height {0}")
    public BaseImageAssert height(Matcher<Integer> condition) {
        jdiAssert(element.height(), condition);
        return this;
    }

    @JDIAction("Assert that '{name}' height {0}")
    public BaseImageAssert height(int height) { return height(is(height)); }

    @JDIAction("Assert that '{name}' width {0}")
    public BaseImageAssert width(Matcher<Object> condition) {
        jdiAssert(element.width(), condition);
        return this;
    }
    
    @JDIAction("Assert that '{name}' width {0}")
    public BaseImageAssert width(String width) { return width(is(width)); }
}
