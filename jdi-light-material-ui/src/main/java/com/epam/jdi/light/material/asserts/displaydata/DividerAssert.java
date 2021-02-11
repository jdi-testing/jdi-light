package com.epam.jdi.light.material.asserts.displaydata;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.annotations.JDIDivider;
import com.epam.jdi.light.material.elements.displaydata.Divider;
import com.epam.jdi.light.material.elements.inputs.Button;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.lang.reflect.Field;

public class DividerAssert extends UIAssert<DividerAssert, Divider> {

    @JDIAction("Assert that '{name}' is inset")
    public DividerAssert inset() {
        jdiAssert(element().isInset(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is vertical")
    public DividerAssert vertical() {
        jdiAssert(element().isVertical(), Matchers.is(true));
        return this;
    }

}
