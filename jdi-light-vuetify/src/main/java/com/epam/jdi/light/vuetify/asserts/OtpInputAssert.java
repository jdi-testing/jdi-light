package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.OtpInput;
import com.epam.jdi.light.vuetify.interfaces.asserts.ReadOnlyAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class OtpInputAssert extends UIAssert<OtpInputAssert, OtpInput>
        implements ThemeAssert<OtpInputAssert, OtpInput>, ReadOnlyAssert<OtpInputAssert, OtpInput> {

    @JDIAction("Check that '{name}' has {0} length")
    public OtpInputAssert length(int expectedLength) {
        int actualLength = element().length();
        jdiAssert(actualLength, Matchers.is(expectedLength),
                String.format("OTP input has '%d' length, but expected '%d'", actualLength, expectedLength));
        return this;
    }

    @JDIAction("Check that '{name}' is plain")
    public OtpInputAssert plain() {
        jdiAssert(element().isPlain(), Matchers.is(true),"OTP input is not plain");
        return this;
    }

    @JDIAction("Check that '{name}' is not plain")
    public OtpInputAssert notPlain() {
        jdiAssert(element().isPlain(), Matchers.is(false),"OTP input is plain");
        return this;
    }

    @JDIAction("Check that '{name}' has {0} type")
    public OtpInputAssert type(String expectedType) {
        String actualType = element().type();
        jdiAssert(actualType, Matchers.is(expectedType),
                String.format("OTP input has '%s' type, but expected '%s'", actualType, expectedType));
        return this;
    }
}
