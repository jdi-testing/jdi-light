package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Switch;
import com.epam.jdi.light.vuetify.interfaces.asserts.HideDetailsAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SwitchAssert extends UIAssert<SwitchAssert, Switch>
        implements ThemeAssert<SwitchAssert, Switch>, HideDetailsAssert<SwitchAssert, Switch> {

    @JDIAction("Assert that '{name}' is checked")
    public SwitchAssert checked() {
        jdiAssert(element().isChecked() ? "is checked"
                : "isn't checked", Matchers.is("is checked"));
        return this;
    }

    @JDIAction("Assert that '{name}' is unchecked")
    public SwitchAssert unchecked() {
        jdiAssert(element().isNotChecked() ? "is unchecked"
                : "isn't unchecked", Matchers.is("is unchecked"));
        return this;
    }

    @JDIAction("Assert that '{name}' has label")
    public SwitchAssert label() {
        jdiAssert(element().hasLabel(), Matchers.is(true), "There is no label for element");
        return this;
    }

    @JDIAction("Assert that '{name}' has not label")
    public SwitchAssert notLabel() {
        jdiAssert(element().hasLabel(), Matchers.is(false), "There a label for element");
        return this;
    }

    @JDIAction("Assert that '{name}' has value {0}")
    public SwitchAssert value(String value) {
        String actualValue = element().value();
        jdiAssert(actualValue, Matchers.equalTo(value), "Actual value " + actualValue + "is not equal to " + value);
        return this;
    }

    @JDIAction("Assert that '{name}' has color '{0}'")
    public SwitchAssert color(String color) {
        String actualColor = element().color();
        jdiAssert(actualColor, Matchers.equalTo(color), actualColor + " is not equal to " + color);
        return this;
    }

    @JDIAction("Assert that '{name}' has background color {0}")
    public SwitchAssert backgroundColor(String backgroundColor) {
        String actualBackgroundColor = element().backgroundColor();
        jdiAssert(actualBackgroundColor, Matchers.equalTo(backgroundColor),
                actualBackgroundColor + " is not equal to " + backgroundColor);
        return this;
    }

    @JDIAction("Assert that '{name}' has slot's background color {0}")
    public SwitchAssert slotsBackgroundColor(String backgroundColor) {
        String actualBackgroundColor = element().slotsBackgroundColor();
        jdiAssert(actualBackgroundColor, Matchers.equalTo(backgroundColor),
                actualBackgroundColor + " is not equal to " + backgroundColor);
        return this;
    }

    @JDIAction("Assert that '{name}' is dense")
    public SwitchAssert dense() {
        jdiAssert(element().isDense(), Matchers.is(true), "Element is not dense");
        return this;
    }

    @JDIAction("Assert that '{name}' is not dense")
    public SwitchAssert notDense() {
        jdiAssert(element().isDense(), Matchers.is(false), "Element is dense");
        return this;
    }

    @JDIAction("Assert that '{name}' has message")
    public SwitchAssert message() {
        jdiAssert(element().hasMessages(), Matchers.is(true), "Element has not message");
        return this;
    }

    @JDIAction("Assert that '{name}' has messages {0}")
    public SwitchAssert messages(List<String> messages) {
        List<String> actualMessages = element().getMessages();
        jdiAssert(actualMessages, Matchers.equalTo(messages), String.format("Actual element's messages %s is "
                + "not equal to expected messages %s", actualMessages, messages));
        return this;
    }

    @JDIAction("Assert that '{name}' has error message {0}")
    public SwitchAssert message(String message) {
        jdiAssert(element().getMessages().contains(message), Matchers.is(true), String.format("Actual element's"
                + " messages %s doesn't contain expected message %s", element().getMessages(), message));
        return this;
    }

    @JDIAction("Assert that '{name}' has not message")
    public SwitchAssert notMessage() {
        jdiAssert(element().hasMessages(), Matchers.is(false), String.format("Element has following messages: %s", element().getMessages()));
        return this;
    }

    @JDIAction("Assert that '{name}' has error message")
    public SwitchAssert errorMessage() {
        jdiAssert(element().hasErrorMessage(), Matchers.is(true), "Element has not error messages");
        return this;
    }

    @JDIAction("Assert that number of {name}'s error messages is {0}")
    public SwitchAssert numberOfErrorMessages(Integer n) {
        Integer actualNumberOfErrorMessages = element().getNumberErrorMessages();
        jdiAssert(actualNumberOfErrorMessages, Matchers.equalTo(n), String.format("Actual number of error messages %s "
                + "is not equal to %s", actualNumberOfErrorMessages, n));
        return this;
    }

    @JDIAction("Assert that '{name}' has error messages {0}")
    public SwitchAssert errorMessages(List<String> errorMessages) {
        List<String> actualErrorMessages = element().getErrorMessages();
        jdiAssert(actualErrorMessages, Matchers.equalTo(errorMessages), String.format("Actual element's messages %s "
                + "is not equal to expected messages %s", actualErrorMessages, errorMessages));
        return this;
    }

    @JDIAction("Assert that '{name}' has error messages {0}")
    public SwitchAssert errorMessage(String errorMessage) {
        jdiAssert(element().getErrorMessages().contains(errorMessage), Matchers.is(true), String.format("Actual element's error"
                + " messages %s doesn't contain expected message %s", element().getErrorMessages(), errorMessage));
        return this;
    }

    @JDIAction("Assert that '{name}' has not error message")
    public SwitchAssert notErrorMessage() {
        jdiAssert(element().hasErrorMessage(), Matchers.is(false),
                String.format("Element has following error messages: %s", element().getErrorMessages()));
        return this;
    }

    @JDIAction("Assert that '{name}' has success message")
    public SwitchAssert successMessage() {
        jdiAssert(element().hasSuccessMessage(), Matchers.is(true), "Element has not success messages");
        return this;
    }

    @JDIAction("Assert that '{name}' has success message {0}")
    public SwitchAssert successMessage(String successMessage) {
        jdiAssert(element().getSuccessMessages().contains(successMessage), Matchers.is(true), String.format("Actual element's success"
                + " messages %s doesn't contain expected message %s", element().getSuccessMessages(), successMessage));
        return this;
    }

    @JDIAction("Assert that '{name}' has success messages {0}")
    public SwitchAssert successMessages(List<String> successMessages) {
        jdiAssert(element().getSuccessMessages(), Matchers.equalTo(successMessages), String.format("Actual element's success"
                + " messages %s is not equal to expected messages %s", element().getSuccessMessages(), successMessages));
        return this;
    }

    @JDIAction("Assert that '{name}' has not success message")
    public SwitchAssert notSuccessMessage() {
        jdiAssert(element().hasSuccessMessage(), Matchers.is(false),
                String.format("Element has following success messages: %s", element().getSuccessMessages()));
        return this;
    }

    @JDIAction("Assert that '{name}' is flat")
    public SwitchAssert flat() {
        jdiAssert(element().isFlat(), Matchers.is(true), "Element is not flat");
        return this;
    }

    @JDIAction("Assert that '{name}' is not flat")
    public SwitchAssert notFlat() {
        jdiAssert(element().isFlat(), Matchers.is(false), "Element is flat");
        return this;
    }

    @JDIAction("Assert that '{name}' is inset")
    public SwitchAssert inset() {
        jdiAssert(element().isInset(), Matchers.is(true), "Element is not inset");
        return this;
    }

    @JDIAction("Assert that '{name}' is not inset")
    public SwitchAssert notInset() {
        jdiAssert(element().isInset(), Matchers.is(false), "Element is inset");
        return this;
    }

    @JDIAction("Assert that '{name}' has icon-append")
    public SwitchAssert iconAppend() {
        jdiAssert(element().hasIconAppend(), Matchers.is(true), "Element has not icon-append");
        return this;
    }

    @JDIAction("Assert that '{name}' has not icon-append")
    public SwitchAssert notIconAppend() {
        jdiAssert(element().hasIconAppend(), Matchers.is(false), "Element has icon-append");
        return this;
    }

    @JDIAction("Assert that '{name}' has icon-prepend")
    public SwitchAssert iconPrepend() {
        jdiAssert(element().hasIconPrepend(), Matchers.is(true), "Element has not icon-prepend");
        return this;
    }

    @JDIAction("Assert that '{name}' has not icon-prepend")
    public SwitchAssert notIconPrepend() {
        jdiAssert(element().hasIconPrepend(), Matchers.is(false), "Element has icon-prepend");
        return this;
    }

    @JDIAction("Assert that '{name}' is read-only")
    public SwitchAssert readonly() {
        jdiAssert(element().isReadonly(), Matchers.is(true), "Element is not read-only");
        return this;
    }

    @JDIAction("Assert that '{name}' is read-only")
    public SwitchAssert notReadonly() {
        jdiAssert(element().isReadonly(), Matchers.is(false), "Element is read-only");
        return this;
    }

    @JDIAction("Assert that '{name}' has ripple")
    public SwitchAssert ripple() {
        jdiAssert(element().hasRipple(), Matchers.is(true), "Element has not ripple");
        return this;
    }

    @JDIAction("Assert that '{name}' has not ripple")
    public SwitchAssert notRipple() {
        jdiAssert(element().hasRipple(), Matchers.is(false), "Element has ripple");
        return this;
    }
}
