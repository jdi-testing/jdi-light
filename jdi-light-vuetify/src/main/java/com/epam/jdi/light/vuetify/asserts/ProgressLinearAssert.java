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
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ProgressLinearAssert extends UIAssert<ProgressLinearAssert, ProgressLinear> implements
        RoundedAssert<ProgressLinearAssert, ProgressLinear>, ColorAssert<ProgressLinearAssert, ProgressLinear>,
        ReverseAssert<ProgressLinearAssert, ProgressLinear>, MeasurementAssert<ProgressLinearAssert, ProgressLinear>,
        ThemeAssert<ProgressLinearAssert, ProgressLinear>, LoadingAssert<ProgressLinearAssert, ProgressLinear> {

    @JDIAction(value = "Assert that '{name}' is displayed", isAssert = true)
    public ProgressLinearAssert displayed() {
        Timer.waitCondition(element()::isDisplayed);
        jdiAssert(element().isDisplayed(), Matchers.is(true), "Element is not displayed");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is indeterminate", isAssert = true)
    public ProgressLinearAssert indeterminate() {
        jdiAssert(element().isIndeterminate(), Matchers.is(true), "Element is determinate");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is determinate", isAssert = true)
    public ProgressLinearAssert determinate() {
        jdiAssert(element().isDeterminate(), Matchers.is(true), "Element is indeterminate");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is reactive", isAssert = true)
    public ProgressLinearAssert reactive() {
        jdiAssert(element().isReactive(), Matchers.is(true), "Element is not reactive");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not reactive", isAssert = true)
    public ProgressLinearAssert notReactive() {
        jdiAssert(element().isReactive(), Matchers.is(false), "Element is reactive");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is striped", isAssert = true)
    public ProgressLinearAssert striped() {
        jdiAssert(element().isStriped(), Matchers.is(true), "Element is not striped");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not striped", isAssert = true)
    public ProgressLinearAssert notStriped() {
        jdiAssert(element().isStriped(), Matchers.is(false), "Element is striped");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has expected bar color", isAssert = true)
    public ProgressLinearAssert barColor(String barColor) {
        String actualBarColor = element().hasBarColor();
        jdiAssert(actualBarColor, Matchers.is(barColor), String.format("Actual bar color '%s' is not equal to " +
                "expected '%s'", actualBarColor, barColor));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has expected value '{0}'", isAssert = true)
    public ProgressLinearAssert value(Double value) {
        Timer.waitCondition(() -> Math.abs((element().getValue()) - value) < 0.5);
        double actualValue = element().getValue();
        jdiAssert(actualValue, Matchers.closeTo(value, 0.5), String.format("Actual value '%s' is not close to " +
                "expected '%s'", actualValue, value));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has expected value '{0}'", isAssert = true)
    public ProgressLinearAssert valueMax(Double value) {
        Timer.waitCondition(() -> Math.abs((element().getMaxValue()) - value) < 0.5);
        double actualValue = element().getMaxValue();
        jdiAssert(actualValue, Matchers.closeTo(value, 0.5), String.format("Actual max value '%s' is not close to " +
                "expected '%s'", actualValue, value));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has stream", isAssert = true)
    public ProgressLinearAssert stream() {
        jdiAssert(element().hasStream(), Matchers.is(true), "Element has no stream");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no stream", isAssert = true)
    public ProgressLinearAssert noStream() {
        jdiAssert(element().hasStream(), Matchers.is(false), "Element has stream");
        return this;
    }
}
