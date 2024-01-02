package com.epam.jdi.light.vuetify.asserts.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.bars.SystemBar;
import com.epam.jdi.light.vuetify.interfaces.asserts.MeasurementAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SystemBarAssert extends BasicBarAssert<SystemBarAssert, SystemBar>
        implements MeasurementAssert<SystemBarAssert, SystemBar> {

    @JDIAction(value = "Assert that '{name}' is lights out", isAssert = true)
    public SystemBarAssert lightsOut() {
        jdiAssert(element().isLightsOut(), Matchers.is(true), "SystemBar is not lights out");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not lights out", isAssert = true)
    public SystemBarAssert notLightsOut() {
        jdiAssert(element().isLightsOut(), Matchers.is(false), "SystemBar is lights out");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is window", isAssert = true)
    public SystemBarAssert window() {
        jdiAssert(element().isWindow(), Matchers.is(true), "SystemBar is not window");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not window", isAssert = true)
    public SystemBarAssert notWindow() {
        jdiAssert(element().isWindow(), Matchers.is(false), "SystemBar is window");
        return this;
    }
}
