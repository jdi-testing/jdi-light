package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.HasMeasurement;
import com.epam.jdi.light.asserts.generic.IBaseAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface MeasurementAssert<A, E extends HasMeasurement> extends IBaseAssert<E> {

    @JDIAction("Assert that '{name}' height is '{0}'")
    default A height(int height) {
        jdiAssert(element().height(), Matchers.is(height));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' height is less than '{0}'")
    default A heightLessThan(int height) {
        jdiAssert(element().height(), Matchers.lessThan(height));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' height is greater than '{0}'")
    default A heightGreaterThan(int height) {
        jdiAssert(element().height(), Matchers.greaterThan(height));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' width is '{0}'")
    default A width(int width) {
        jdiAssert(element().width(), Matchers.is(width));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' width is less than '{0}'")
    default A widthLessThan(int width) {
        jdiAssert(element().width(), Matchers.lessThan(width));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' width is greater than '{0}'")
    default A widthGreaterThan(int width) {
        jdiAssert(element().width(), Matchers.greaterThan(width));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' max height is '{0}'")
    default A maxHeight(int height) {
        jdiAssert(element().maxHeight(), Matchers.equalTo(height));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' max width is '{0}'")
    default A maxWidth(int width) {
        jdiAssert(element().maxWidth(), Matchers.equalTo(width));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' min height is '{0}'")
    default A minHeight(int height) {
        jdiAssert(element().minHeight(), Matchers.equalTo(height));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' min width is '{0}'")
    default A minWidth(int width) {
        jdiAssert(element().minWidth(), Matchers.equalTo(width));
        return (A) this;
    }
}
