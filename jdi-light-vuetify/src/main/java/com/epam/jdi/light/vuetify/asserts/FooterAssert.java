package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.composite.Footer;
import com.epam.jdi.light.asserts.generic.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ElevationAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MeasurementAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.OutlinedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.RoundedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ShapedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.TileAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ContainerAssert;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class FooterAssert extends UIAssert<FooterAssert, Footer> implements ITextAssert<FooterAssert>,
        ColorAssert<FooterAssert, Footer>, ThemeAssert<FooterAssert, Footer>, ElevationAssert<FooterAssert, Footer>,
        MeasurementAssert<FooterAssert, Footer>, OutlinedAssert<FooterAssert, Footer>,
        RoundedAssert<FooterAssert, Footer>, ShapedAssert<FooterAssert, Footer>, TileAssert<FooterAssert, Footer>,
        ContainerAssert<FooterAssert, Footer> {
    @Override
    @JDIAction(value = "Assert that '{name}' has text '{0}'", isAssert = true)
    public FooterAssert text(Matcher<String> condition) {
        jdiAssert(element().getText(), condition);
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is padless", isAssert = true)
    public FooterAssert padless() {
        jdiAssert(element().isPadless(), Matchers.is(true), "Footer is not padless");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not padless", isAssert = true)
    public FooterAssert notPadless() {
        jdiAssert(element().isPadless(), Matchers.is(false), "Footer is padless");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is absolute", isAssert = true)
    public FooterAssert absolute() {
        jdiAssert(element().isAbsolute(), Matchers.is(true), "Footer is not absolute");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not absolute", isAssert = true)
    public FooterAssert notAbsolute() {
        jdiAssert(element().isAbsolute(), Matchers.is(false), "Footer is absolute");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is fixed", isAssert = true)
    public FooterAssert fixed() {
        jdiAssert(element().isFixed(), Matchers.is(true), "Footer is not fixed");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not fixed", isAssert = true)
    public FooterAssert notFixed() {
        jdiAssert(element().isFixed(), Matchers.is(false), "Footer is fixed");
        return this;
    }
}
