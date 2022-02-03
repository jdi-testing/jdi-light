package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.Checkbox;
import com.epam.jdi.light.material.elements.utils.enums.Position;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class CheckboxAssert extends UIAssert<CheckboxAssert, Checkbox> {

    @JDIAction("Assert that '{name}' is checked")
    public CheckboxAssert checked() {
        jdiAssert(element().isChecked() ? "is checked" : "is unchecked", Matchers.is("is checked"));
        return this;
    }

    @JDIAction("Assert that '{name}' is unchecked")
    public CheckboxAssert unchecked() {
        jdiAssert(element().isUnchecked() ? "is unchecked" : "is checked", Matchers.is("is unchecked"));
        return this;
    }

    @JDIAction("Assert that '{name}' has primary color")
    public CheckboxAssert primaryColor() {
        jdiAssert(element().hasPrimaryColor() ? "has primary color" : "does not have primary color",
                Matchers.is("has primary color"));
        return this;
    }

    @JDIAction("Assert that '{name}' has secondary color")
    public CheckboxAssert secondaryColor() {
        jdiAssert(element().hasSecondaryColor() ? "has secondary color" : "does not have secondary color",
                Matchers.is("has secondary color"));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected color")
    public CheckboxAssert color(String color) {
        jdiAssert(element().getColor(), Matchers.is(color));
        return this;
    }

    @JDIAction("Assert that '{name}' is enabled")
    public CheckboxAssert enabled() {
        jdiAssert(element().isEnabled() ? "is enabled" : "is disabled", Matchers.is("is enabled"));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    public CheckboxAssert disabled() {
        jdiAssert(element().isDisabled() ? "is disabled" : "is enabled", Matchers.is("is disabled"));
        return this;
    }

    @JDIAction("Assert that '{name}' is indeterminate")
    public CheckboxAssert indeterminate() {
        jdiAssert(element().isIndeterminate() ? "is indeterminate" : "is determinate",
                Matchers.is("is indeterminate"));
        return this;
    }

    @JDIAction("Assert that '{name}''s label has position {0}")
    public CheckboxAssert labelPosition(String position) {
        jdiAssert(element().getLabelPosition().getPosition(), Matchers.is(position));
        return this;
    }

    @JDIAction("Assert that '{name}''s label has position {0}")
    public CheckboxAssert labelPosition(Position position) {
        jdiAssert(element().getLabelPosition(), Matchers.is(position));
        return this;
    }

}
