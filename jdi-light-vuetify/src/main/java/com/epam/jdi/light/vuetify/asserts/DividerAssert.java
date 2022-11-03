package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.vuetify.elements.common.Divider;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.OrientationAssert;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class DividerAssert extends UIAssert<DividerAssert, Divider>
        implements OrientationAssert<DividerAssert, Divider>, ThemeAssert<DividerAssert, Divider> {

}
