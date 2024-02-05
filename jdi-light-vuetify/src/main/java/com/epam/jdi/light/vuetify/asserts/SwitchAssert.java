package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Switch;
import com.epam.jdi.light.asserts.generic.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.HideDetailsAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SwitchAssert extends UIAssert<SwitchAssert, Switch>
        implements ThemeAssert<SwitchAssert, Switch>, HideDetailsAssert<SwitchAssert, Switch>,
        ColorAssert<SwitchAssert, Switch> {

    @JDIAction(value = "Assert that '{name}' is checked", isAssert = true)
    public SwitchAssert checked() {
        jdiAssert(element().isChecked(), Matchers.is(true), "Switch is unchecked");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is unchecked", isAssert = true)
    public SwitchAssert unchecked() {
        jdiAssert(element().isNotChecked(), Matchers.is(true), "Switch is checked");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has label", isAssert = true)
    public SwitchAssert label() {
        jdiAssert(element().hasLabel(), Matchers.is(true), "There is no label for switch");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has not label", isAssert = true)
    public SwitchAssert notLabel() {
        jdiAssert(element().hasLabel(), Matchers.is(false), "There a label for switch");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has value {0}", isAssert = true)
    public SwitchAssert value(String value) {
        jdiAssert(element().value(), Matchers.equalTo(value));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has color '{0}'", isAssert = true)
    public SwitchAssert color(String color) {
        jdiAssert(element().color(), Matchers.equalTo(color));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has background color {0}", isAssert = true)
    public SwitchAssert backgroundColor(String backgroundColor) {
        jdiAssert(element().backgroundColor(), Matchers.equalTo(backgroundColor));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has slot's background color {0}", isAssert = true)
    public SwitchAssert slotsBackgroundColor(String backgroundColor) {
        jdiAssert(element().slotsBackgroundColor(), Matchers.equalTo(backgroundColor));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is dense", isAssert = true)
    public SwitchAssert dense() {
        jdiAssert(element().isDense(), Matchers.is(true), "Switch is not dense");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not dense", isAssert = true)
    public SwitchAssert notDense() {
        jdiAssert(element().isDense(), Matchers.is(false), "Switch is dense");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has message", isAssert = true)
    public SwitchAssert message() {
        jdiAssert(element().hasMessages(), Matchers.is(true), "Switch has not message");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has messages {0}", isAssert = true)
    public SwitchAssert messages(List<String> messages) {
        jdiAssert(element().getMessages(), Matchers.is(messages));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has error message {0}", isAssert = true)
    public SwitchAssert message(String message) {
        jdiAssert(element().getMessages(), Matchers.contains(message));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has not message", isAssert = true)
    public SwitchAssert notMessage() {
        jdiAssert(element().hasMessages(), Matchers.is(false),
                "Switch has no messages");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has error message", isAssert = true)
    public SwitchAssert errorMessage() {
        jdiAssert(element().hasErrorMessage(), Matchers.is(true), "Switch has not error messages");
        return this;
    }

    @JDIAction(value = "Assert that number of {name}'s error messages is {0}", isAssert = true)
    public SwitchAssert numberOfErrorMessages(Integer n) {
        jdiAssert(element().getNumberErrorMessages(), Matchers.equalTo(n));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has error messages {0}", isAssert = true)
    public SwitchAssert errorMessages(List<String> errorMessages) {
        jdiAssert(element().getErrorMessages(), Matchers.equalTo(errorMessages));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has error messages {0}", isAssert = true)
    public SwitchAssert errorMessage(String errorMessage) {
        jdiAssert(element().getErrorMessages(), Matchers.hasItem(errorMessage));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has not error message", isAssert = true)
    public SwitchAssert notErrorMessage() {
        jdiAssert(element().hasErrorMessage(), Matchers.is(false),
                "Switch has following no error messages");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has success message", isAssert = true)
    public SwitchAssert successMessage() {
        jdiAssert(element().hasSuccessMessage(), Matchers.is(true), "Switch has not success messages");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has success message {0}", isAssert = true)
    public SwitchAssert successMessage(String successMessage) {
        jdiAssert(element().getSuccessMessages(), Matchers.contains(successMessage));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has success messages {0}", isAssert = true)
    public SwitchAssert successMessages(List<String> successMessages) {
        jdiAssert(element().getSuccessMessages(), Matchers.is(successMessages));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has not success message", isAssert = true)
    public SwitchAssert notSuccessMessage() {
        jdiAssert(element().hasSuccessMessage(), Matchers.is(false),
                String.format("Switch has following success messages: %s", element().getSuccessMessages().stream().collect(Collectors.joining("; "))));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is flat", isAssert = true)
    public SwitchAssert flat() {
        jdiAssert(element().isFlat(), Matchers.is(true), "Switch is not flat");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not flat", isAssert = true)
    public SwitchAssert notFlat() {
        jdiAssert(element().isFlat(), Matchers.is(false), "Switch is flat");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is inset", isAssert = true)
    public SwitchAssert inset() {
        jdiAssert(element().isInset(), Matchers.is(true), "Switch is not inset");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not inset", isAssert = true)
    public SwitchAssert notInset() {
        jdiAssert(element().isInset(), Matchers.is(false), "Switch is inset");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has icon-append", isAssert = true)
    public SwitchAssert iconAppend() {
        jdiAssert(element().hasIconAppend(), Matchers.is(true), "Switch has not icon-append");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has not icon-append", isAssert = true)
    public SwitchAssert notIconAppend() {
        jdiAssert(element().hasIconAppend(), Matchers.is(false), "Switch has icon-append");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has icon-prepend", isAssert = true)
    public SwitchAssert iconPrepend() {
        jdiAssert(element().hasIconPrepend(), Matchers.is(true), "Switch has not icon-prepend");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has not icon-prepend", isAssert = true)
    public SwitchAssert notIconPrepend() {
        jdiAssert(element().hasIconPrepend(), Matchers.is(false), "Switch has icon-prepend");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is read-only", isAssert = true)
    public SwitchAssert readonly() {
        jdiAssert(element().isReadonly(), Matchers.is(true), "Switch is not read-only");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is read-only", isAssert = true)
    public SwitchAssert notReadonly() {
        jdiAssert(element().isReadonly(), Matchers.is(false), "Switch is read-only");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has ripple", isAssert = true)
    public SwitchAssert ripple() {
        jdiAssert(element().hasRipple(), Matchers.is(true), "Switch has not ripple");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has not ripple", isAssert = true)
    public SwitchAssert notRipple() {
        jdiAssert(element().hasRipple(), Matchers.is(false), "Switch has ripple");
        return this;
    }
}
