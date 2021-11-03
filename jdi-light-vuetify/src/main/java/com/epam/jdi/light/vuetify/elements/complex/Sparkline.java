package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.vuetify.asserts.SparklineAssert;

/**
 * To see an example of Sparkline web element please visit https://vuetifyjs.com/en/components/sparklines
 */

public class Sparkline extends UIBaseElement<SparklineAssert> {

    @Override
    public SparklineAssert is() { return new SparklineAssert().set(this); }
}
