package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Switch;
import com.epam.jdi.light.asserts.generic.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.HideDetailsAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SwitchAssert extends UIAssert<SwitchAssert, Switch>
        implements ThemeAssert<SwitchAssert, Switch>, HideDetailsAssert<SwitchAssert, Switch>,
        ColorAssert<SwitchAssert, Switch> {

    @JDIAction(value = "Assert that '{name}' is checked", isAssert = true)
    public SwitchAssert checked() {
        jdiAssert(element().isChecked() ? "is checked"
                : "isn't checked", Matchers.is("is checked"));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is unchecked", isAssert = true)
    public SwitchAssert unchecked() {
        jdiAssert(element().isNotChecked() ? "is unchecked"
                : "isn't unchecked", Matchers.is("is unchecked"));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has label", isAssert = true)
    public SwitchAssert label() {
        jdiAssert(element().hasLabel(), Matchers.is(true), "There is no label for element");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has not label", isAssert = true)
    public SwitchAssert notLabel() {
        jdiAssert(element().hasLabel(), Matchers.is(false), "There a label for element");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has value {0}", isAssert = true)
    public SwitchAssert value(String value) {
        String actualValue = element().value();
        jdiAssert(actualValue, Matchers.equalTo(value), "Actual value " + actualValue + "is not equal to " + value);
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has color '{0}'", isAssert = true)
    public SwitchAssert color(String color) {
        String actualColor = element().color();
        jdiAssert(actualColor, Matchers.equalTo(color), actualColor + " is not equal to " + color);
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has background color {0}", isAssert = true)
    public SwitchAssert backgroundColor(String backgroundColor) {
        String actualBackgroundColor = element().backgroundColor();
        jdiAssert(actualBackgroundColor, Matchers.equalTo(backgroundColor),
                actualBackgroundColor + " is not equal to " + backgroundColor);
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has slot's background color {0}", isAssert = true)
    public SwitchAssert slotsBackgroundColor(String backgroundColor) {
        String actualBackgroundColor = element().slotsBackgroundColor();
        jdiAssert(actualBackgroundColor, Matchers.equalTo(backgroundColor),
                actualBackgroundColor + " is not equal to " + backgroundColor);
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is dense", isAssert = true)
    public SwitchAssert dense() {
        jdiAssert(element().isDense(), Matchers.is(true), "Element is not dense");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not dense", isAssert = true)
    public SwitchAssert notDense() {
        jdiAssert(element().isDense(), Matchers.is(false), "Element is dense");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has message", isAssert = true)
    public SwitchAssert message() {
        jdiAssert(element().hasMessages(), Matchers.is(true), "Element has not message");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has messages {0}", isAssert = true)
    public SwitchAssert messages(List<String> messages) {
        List<String> actualMessages = element().getMessages();
        jdiAssert(actualMessages, Matchers.equalTo(messages), String.format("Actual element's messages %s is "
                + "not equal to expected messages %s", actualMessages, messages));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has error message {0}", isAssert = true)
    public SwitchAssert message(String message) {
        jdiAssert(element().getMessages().contains(message), Matchers.is(true), String.format("Actual element's"
                + " messages %s doesn't contain expected message %s", element().getMessages(), message));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has not message", isAssert = true)
    public SwitchAssert notMessage() {
        jdiAssert(element().hasMessages(), Matchers.is(false), String.format("Element has following messages: %s", element().getMessages()));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has error message", isAssert = true)
    public SwitchAssert errorMessage() {
        jdiAssert(element().hasErrorMessage(), Matchers.is(true), "Element has not error messages");
        return this;
    }

    @JDIAction(value = "Assert that number of {name}'s error messages is {0}", isAssert = true)
    public SwitchAssert numberOfErrorMessages(Integer n) {
        Integer actualNumberOfErrorMessages = element().getNumberErrorMessages();
        jdiAssert(actualNumberOfErrorMessages, Matchers.equalTo(n), String.format("Actual number of error messages %s "
                + "is not equal to %s", actualNumberOfErrorMessages, n));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has error messages {0}", isAssert = true)
    public SwitchAssert errorMessages(List<String> errorMessages) {
        List<String> actualErrorMessages = element().getErrorMessages();
        jdiAssert(actualErrorMessages, Matchers.equalTo(errorMessages), String.format("Actual element's messages %s "
                + "is not equal to expected messages %s", actualErrorMessages, errorMessages));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has error messages {0}", isAssert = true)
    public SwitchAssert errorMessage(String errorMessage) {
        jdiAssert(element().getErrorMessages().contains(errorMessage), Matchers.is(true), String.format("Actual element's error"
                + " messages %s doesn't contain expected message %s", element().getErrorMessages(), errorMessage));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has not error message", isAssert = true)
    public SwitchAssert notErrorMessage() {
        jdiAssert(element().hasErrorMessage(), Matchers.is(false),
                String.format("Element has following error messages: %s", element().getErrorMessages()));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has success message", isAssert = true)
    public SwitchAssert successMessage() {
        jdiAssert(element().hasSuccessMessage(), Matchers.is(true), "Element has not success messages");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has success message {0}", isAssert = true)
    public SwitchAssert successMessage(String successMessage) {
        jdiAssert(element().getSuccessMessages().contains(successMessage), Matchers.is(true), String.format("Actual element's success"
                + " messages %s doesn't contain expected message %s", element().getSuccessMessages(), successMessage));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has success messages {0}", isAssert = true)
    public SwitchAssert successMessages(List<String> successMessages) {
        jdiAssert(element().getSuccessMessages(), Matchers.equalTo(successMessages), String.format("Actual element's success"
                + " messages %s is not equal to expected messages %s", element().getSuccessMessages(), successMessages));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has not success message", isAssert = true)
    public SwitchAssert notSuccessMessage() {
        jdiAssert(element().hasSuccessMessage(), Matchers.is(false),
                String.format("Element has following success messages: %s", element().getSuccessMessages()));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is flat", isAssert = true)
    public SwitchAssert flat() {
        jdiAssert(element().isFlat(), Matchers.is(true), "Element is not flat");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not flat", isAssert = true)
    public SwitchAssert notFlat() {
        jdiAssert(element().isFlat(), Matchers.is(false), "Element is flat");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is inset", isAssert = true)
    public SwitchAssert inset() {
        jdiAssert(element().isInset(), Matchers.is(true), "Element is not inset");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not inset", isAssert = true)
    public SwitchAssert notInset() {
        jdiAssert(element().isInset(), Matchers.is(false), "Element is inset");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has icon-append", isAssert = true)
    public SwitchAssert iconAppend() {
        jdiAssert(element().hasIconAppend(), Matchers.is(true), "Element has not icon-append");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has not icon-append", isAssert = true)
    public SwitchAssert notIconAppend() {
        jdiAssert(element().hasIconAppend(), Matchers.is(false), "Element has icon-append");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has icon-prepend", isAssert = true)
    public SwitchAssert iconPrepend() {
        jdiAssert(element().hasIconPrepend(), Matchers.is(true), "Element has not icon-prepend");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has not icon-prepend", isAssert = true)
    public SwitchAssert notIconPrepend() {
        jdiAssert(element().hasIconPrepend(), Matchers.is(false), "Element has icon-prepend");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is read-only", isAssert = true)
    public SwitchAssert readonly() {
        jdiAssert(element().isReadonly(), Matchers.is(true), "Element is not read-only");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is read-only", isAssert = true)
    public SwitchAssert notReadonly() {
        jdiAssert(element().isReadonly(), Matchers.is(false), "Element is read-only");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has ripple", isAssert = true)
    public SwitchAssert ripple() {
        jdiAssert(element().hasRipple(), Matchers.is(true), "Element has not ripple");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has not ripple", isAssert = true)
    public SwitchAssert notRipple() {
        jdiAssert(element().hasRipple(), Matchers.is(false), "Element has ripple");
        return this;
    }
}
