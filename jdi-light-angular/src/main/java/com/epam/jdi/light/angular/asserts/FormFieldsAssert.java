package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.FormField;
import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class FormFieldsAssert extends UIAssert<FormFieldsAssert, FormField> implements HasAssert<FormFieldsAssert> {
    @JDIAction(value = "Assert that '{name}' input with index {0} has value {1}", isAssert = true)
    public FormFieldsAssert inputText(int index, String expected) {
        jdiAssert(element().getInputValue(index), Matchers.is(expected));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' input with index {0} contains value {1}", isAssert = true)
    public FormFieldsAssert inputText(int index, Matcher<String> condition) {
        jdiAssert(element().getInputValue(index), condition);
        return this;
    }

    @JDIAction(value = "Assert that {name} text area with index {0} has value {1}", isAssert = true)
    public FormFieldsAssert textAreaText(int index, String expected) {
        jdiAssert(element().getTextAreaValue(index), Matchers.is(expected));
        return this;
    }

    @JDIAction(value = "Assert that {name} text area with index {0} contains value {1}", isAssert = true)
    public FormFieldsAssert textAreaText(int index, Matcher<String> condition) {
        jdiAssert(element().getTextAreaValue(index), condition);
        return this;
    }

    @JDIAction(value = "Assert that {name} dropdown with index {0} value is {1}", isAssert = true)
    public FormFieldsAssert dropdownText(int index, String expected) {
        jdiAssert(element().getDropdownValue(index), Matchers.is(expected));
        return this;
    }

    @JDIAction(value = "Assert that {name} dropdown with index {0} value contains {1}", isAssert = true)
    public FormFieldsAssert dropdownText(int index, Matcher<String> condition) {
        jdiAssert(element().getDropdownValue(index), condition);
        return this;
    }

    @JDIAction(value = "Assert that {name} input with index {0} has placeholder {1}", isAssert = true)
    public FormFieldsAssert inputPlaceholder(int index, String expected) {
        jdiAssert(element().inputPlaceholder(index), Matchers.is(expected));
        return this;
    }

    @JDIAction(value = "Assert that {name} input with index {0} contains placeholder {1}", isAssert = true)
    public FormFieldsAssert inputPlaceholder(int index, Matcher<String> condition) {
        jdiAssert(element().inputPlaceholder(index), condition);
        return this;
    }

    @JDIAction(value = "Assert that {name} input with index {0} has label {1}", isAssert = true)
    public FormFieldsAssert inputLabel(int index, String expected) {
        jdiAssert(element().inputLabel(index), Matchers.is(expected));
        return this;
    }

    @JDIAction(value = "Assert that {name} text area with index {0} has label {1}", isAssert = true)
    public FormFieldsAssert textAreaLabel(int index, String expected) {
        jdiAssert(element().textAreaLabel(index), Matchers.is(expected));
        return this;
    }

    @JDIAction(value = "Assert that {name} dropdown with index {0} has label {1}", isAssert = true)
    public FormFieldsAssert dropdownLabel(int index, String expected) {
        jdiAssert(element().dropdownLabel(index), Matchers.is(expected));
        return this;
    }

    @JDIAction(value = "Assert that {name} input with index {0} has hint {1}", isAssert = true)
    public FormFieldsAssert inputHint(int index, String expected) {
        jdiAssert(element().inputHint(index), Matchers.is(expected));
        return this;
    }

    @JDIAction(value = "Assert that {name} input with index {0} has error {1}", isAssert = true)
    public FormFieldsAssert inputError(int index, String expected) {
        jdiAssert(element().inputError(index), Matchers.is(expected));
        return this;
    }

    @JDIAction(value = "Assert that {name} with index {0} has value {1}", isAssert = true)
    public FormFieldsAssert value(int index, String expected) {
        jdiAssert(element().value(index), Matchers.is(expected));
        return this;
    }

    @JDIAction(value = "Assert that {name} with index {0} contains value {1}", isAssert = true)
    public FormFieldsAssert value(int index, Matcher<String> condition) {
        jdiAssert(element().value(index), condition);
        return this;
    }

    @JDIAction(value = "Assert that {name} with index {0} has hint {1}", isAssert = true)
    public FormFieldsAssert hint(int index, String expected) {
        jdiAssert(element().hint(index), Matchers.is(expected));
        return this;
    }

    @JDIAction(value = "Assert that {name} with index {0} has icon {1}", isAssert = true)
    public FormFieldsAssert fieldIcon(int index, String expected) {
        jdiAssert(element().icon(index), Matchers.is(expected));
        return this;
    }

    @JDIAction(value = "Assert that {name} with index {0} has font {1}", isAssert = true)
    public FormFieldsAssert font(int index, String expected) {
        jdiAssert(element().font(index), Matchers.is(expected));
        return this;
    }

    @JDIAction(value = "Assert that {name} with index {0} font contains {1} property", isAssert = true)
    public FormFieldsAssert font(int index, Matcher<String> condition) {
        jdiAssert(element().font(index), condition);
        return this;
    }

    @JDIAction(value = "Assert that {name} with index {0} has color {1}", isAssert = true)
    public FormFieldsAssert color(int index, String expected) {
        jdiAssert(element().color(index), Matchers.is(expected));
        return this;
    }

    @JDIAction(value = "Assert that {name} with index {0} has placeholder {1}", isAssert = true)
    public FormFieldsAssert placeholder(int index, String expected) {
        jdiAssert(element().placeholder(index), Matchers.is(expected));
        return this;
    }

    @JDIAction(value = "Assert that {name} with index {0} has label {1}", isAssert = true)
    public FormFieldsAssert label(int index, String expected) {
        jdiAssert(element().label(index), Matchers.is(expected));
        return this;
    }

    @JDIAction(value = "Assert that {name} with index {0} has error {1}", isAssert = true)
    public FormFieldsAssert error(int index, String expected) {
        jdiAssert(element().error(index), Matchers.is(expected));
        return this;
    }
}
