package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.ProgressLinear;
import com.epam.jdi.light.asserts.generic.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.LoadingAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MeasurementAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ReverseAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.RoundedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ProgressLinearAssert extends UIAssert<ProgressLinearAssert, ProgressLinear> implements
        RoundedAssert<ProgressLinearAssert, ProgressLinear>, ColorAssert<ProgressLinearAssert, ProgressLinear>,
        ReverseAssert<ProgressLinearAssert, ProgressLinear>, MeasurementAssert<ProgressLinearAssert, ProgressLinear>,
        ThemeAssert<ProgressLinearAssert, ProgressLinear>, LoadingAssert<ProgressLinearAssert, ProgressLinear> {

    @JDIAction(value = "Assert that '{name}' is displayed", isAssert = true)
    public ProgressLinearAssert displayed() {
        jdiAssert(element().isDisplayed(), Matchers.is(true), "ProgressLinear is not displayed");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is indeterminate", isAssert = true)
    public ProgressLinearAssert indeterminate() {
        jdiAssert(element().isIndeterminate(), Matchers.is(true), "ProgressLinear is determinate");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is determinate", isAssert = true)
    public ProgressLinearAssert determinate() {
        jdiAssert(element().isDeterminate(), Matchers.is(true), "ProgressLinear is indeterminate");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is reactive", isAssert = true)
    public ProgressLinearAssert reactive() {
        jdiAssert(element().isReactive(), Matchers.is(true), "ProgressLinear is not reactive");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not reactive", isAssert = true)
    public ProgressLinearAssert notReactive() {
        jdiAssert(element().isReactive(), Matchers.is(false), "ProgressLinear is reactive");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is striped", isAssert = true)
    public ProgressLinearAssert striped() {
        jdiAssert(element().isStriped(), Matchers.is(true), "ProgressLinear is not striped");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not striped", isAssert = true)
    public ProgressLinearAssert notStriped() {
        jdiAssert(element().isStriped(), Matchers.is(false), "ProgressLinear is striped");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has bar color is {0}", isAssert = true)
    public ProgressLinearAssert barColor(String barColor) {
        jdiAssert(element().hasBarColor(), Matchers.is(barColor));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has expected value '{0}'", isAssert = true)
    public ProgressLinearAssert value(double value) {
        return value(value, 0.5);
    }

    @JDIAction(value = "Assert that '{name}' has expected value '{0}'", isAssert = true)
    public ProgressLinearAssert valueMax(double value) {
        return valueMax(value, 0.5);
    }

    @JDIAction(value = "Assert that '{name}' has expected value '{0}'", isAssert = true)
    public ProgressLinearAssert value(double value, double error) {
        jdiAssert(element().getValue(), Matchers.closeTo(value, error));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has expected value '{0}'", isAssert = true)
    public ProgressLinearAssert valueMax(double value, double error) {
        jdiAssert(element().getMaxValue(), Matchers.closeTo(value, error));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has stream", isAssert = true)
    public ProgressLinearAssert stream() {
        jdiAssert(element().hasStream(), Matchers.is(true), "ProgressLinear has no stream");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no stream", isAssert = true)
    public ProgressLinearAssert noStream() {
        jdiAssert(element().hasStream(), Matchers.is(false), "ProgressLinear has stream");
        return this;
    }
}
