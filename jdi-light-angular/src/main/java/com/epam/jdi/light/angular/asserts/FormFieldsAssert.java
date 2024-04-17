package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.FormField;
import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class FormFieldsAssert extends UIAssert<FormFieldsAssert, FormField> implements HasAssert<FormFieldsAssert> {

    @JDIAction(value = "Assert that {name} has label {0}", isAssert = true)
    public FormFieldsAssert label(String expected) {
        jdiAssert(element().label(), Matchers.is(expected));
        return this;
    }

    @JDIAction(value = "Assert that {name} has value {0}", isAssert = true)
    public FormFieldsAssert value(String expected) {
        jdiAssert(element().value(), Matchers.is(expected));
        return this;
    }

    @JDIAction(value = "Assert that {name} contains value {0}", isAssert = true)
    public FormFieldsAssert value(Matcher<String> condition) {
        jdiAssert(element().value(), condition);
        return this;
    }

    @JDIAction(value = "Assert that {name} has hint {0}", isAssert = true)
    public FormFieldsAssert hint(String expected) {
        jdiAssert(element().hints(), Matchers.containsInRelativeOrder(expected));
        return this;
    }

    @JDIAction(value = "Assert that {name} has all hints {0}", isAssert = true)
    public FormFieldsAssert hints(List<String> expected) {
        jdiAssert(element().hints(), Matchers.is(expected));
        return this;
    }

    @JDIAction(value = "Assert that {name} has icon {0}", isAssert = true)
    public FormFieldsAssert fieldIcon(String expected) {
        jdiAssert(element().icon(), Matchers.is(expected));
        return this;
    }

    @JDIAction(value = "Assert that {name} has color {0}", isAssert = true)
    public FormFieldsAssert color(String expected) {
        jdiAssert(element().color(), Matchers.is(expected));
        return this;
    }

    @JDIAction(value = "Assert that {name} has placeholder {0}", isAssert = true)
    public FormFieldsAssert placeholder(String expected) {
        jdiAssert(element().placeholder(), Matchers.is(expected));
        return this;
    }

    @JDIAction(value = "Assert that {name} has error {0}", isAssert = true)
    public FormFieldsAssert error(String expected) {
        jdiAssert(element().error(), Matchers.is(expected));
        return this;
    }

    @JDIAction(value = "Assert that {name} is required", isAssert = true)
    public FormFieldsAssert required() {
        jdiAssert(element().isRequired(), Matchers.is(true), "Field is not required");
        return this;
    }

    @JDIAction(value = "Assert that {name} is not required", isAssert = true)
    public FormFieldsAssert notRequired() {
        jdiAssert(element().isRequired(), Matchers.is(false), "Field is required");
        return this;
    }

    @JDIAction(value = "Assert that {name} appearance attribute is fill", isAssert = true)
    public FormFieldsAssert filled() {
        jdiAssert(element().appearance(), Matchers.is("fill"), "Appearance is not filled");
        return this;
    }

    @JDIAction(value = "Assert that {name} appearance attribute is outline", isAssert = true)
    public FormFieldsAssert outlined() {
        jdiAssert(element().appearance(), Matchers.is("outline"), "Appearance is not outlined");
        return this;
    }

    @JDIAction(value = "Assert that {name} has always float label", isAssert = true)
    public FormFieldsAssert alwaysFloatLabel() {
        jdiAssert(element().hasAlwaysFloatLabel(), Matchers.is(true), "Float label is not always");
        return this;
    }

    @JDIAction(value = "Assert that {name} is required", isAssert = true)
    public FormFieldsAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(false), "Field is not disabled");
        return this;
    }

    @JDIAction(value = "Assert that {name} is not required", isAssert = true)
    public FormFieldsAssert notDisabled() {
        jdiAssert(element().isEnabled(), Matchers.is(true), "Field is disabled");
        return this;
    }

    @JDIAction(value = "Assert that select field {name} is empty", isAssert = true)
    public FormFieldsAssert empty() {
        jdiAssert(element().isEmpty(), Matchers.is(true), "Select field is not empty");
        return this;
    }

    @JDIAction(value = "Assert that select field {name} is not empty", isAssert = true)
    public FormFieldsAssert notEmpty() {
        jdiAssert(element().isEmpty(), Matchers.is(false), "Select field is empty");
        return this;
    }

    @JDIAction(value = "Assert that select field {name} has fixed SubscriptSizing", isAssert = true)
    public FormFieldsAssert dynamicSubscriptSizing() {
        jdiAssert(element().isDynamicSubscriptSizing(), Matchers.is(true), "Select field has fixed SubscriptSizing");
        return this;
    }

    @JDIAction(value = "Assert that select field {name} has dynamic SubscriptSizing", isAssert = true)
    public FormFieldsAssert notDynamicSubscriptSizing() {
        jdiAssert(element().isDynamicSubscriptSizing(), Matchers.is(false), "Select field has dynamic SubscriptSizing");
        return this;
    }
}
