package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.SkeletonLoader;
import com.epam.jdi.light.vuetify.interfaces.asserts.CursorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ElevationAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MeasurementAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.TileAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SkeletonLoaderAssert extends UIAssert<SkeletonLoaderAssert, SkeletonLoader> implements
        ThemeAssert<SkeletonLoaderAssert, SkeletonLoader>, ElevationAssert<SkeletonLoaderAssert, SkeletonLoader>,
        MeasurementAssert<SkeletonLoaderAssert, SkeletonLoader>, TileAssert<SkeletonLoaderAssert, SkeletonLoader>,
        CursorAssert<SkeletonLoaderAssert, SkeletonLoader> {

    @JDIAction(value = "Assert that '{name}' is boilerplate")
    public SkeletonLoaderAssert boilerplate() {
        jdiAssert(element().isBoilerplate(), Matchers.is(true), "Element is not boilerplate");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not boilerplate")
    public SkeletonLoaderAssert notBoilerplate() {
        jdiAssert(element().isBoilerplate(), Matchers.is(false), "Element is boilerplate");
        return this;
    }
}
