package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Input;
import com.epam.jdi.light.asserts.generic.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.DenseAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.HideDetailsAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.LoadingAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MeasurementAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MessagesAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ReadOnlyAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class InputAssert extends UIAssert<InputAssert, Input>
        implements MessagesAssert<InputAssert, Input>, ReadOnlyAssert<InputAssert, Input>,
        LoadingAssert<InputAssert, Input>, ColorAssert<InputAssert, Input>, ThemeAssert<InputAssert, Input>,
        MeasurementAssert<InputAssert, Input>, DenseAssert<InputAssert, Input>, HideDetailsAssert<InputAssert, Input> {
    @Override
    @JDIAction(value = "Assert that '{name}' is disabled", isAssert = true)
    public InputAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true), "Input is enabled");
        return this;
    }

    @Override
    @JDIAction(value = "Assert that '{name}' is enabled", isAssert = true)
    public InputAssert enabled() {
        jdiAssert(element().isDisabled(), Matchers.is(false), "Input is disabled");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has text in slot '{0}'", isAssert = true)
    public InputAssert text(String text) {
        jdiAssert(element().text(), Matchers.equalTo(text));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' matches the condition", isAssert = true)
    public InputAssert text(Matcher<String> matcher) {
        jdiAssert(element().text(), matcher);
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has text field", isAssert = true)
    public InputAssert textInput() {
        jdiAssert(element().hasInputField(), Matchers.is(true), "Input hasn't text field");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has text field", isAssert = true)
    public InputAssert notTextInput() {
        jdiAssert(element().hasInputField(), Matchers.is(false), "Input has text field");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no label", isAssert = true)
    public InputAssert noLabel() {
        jdiAssert(element().hasLabel(), Matchers.is(false), "Input has label");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has label '{0}'", isAssert = true)
    public InputAssert label(String text) {
        jdiAssert(element().label().text(), Matchers.equalTo(text));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is focused", isAssert = true)
    public InputAssert focused() {
        jdiAssert(element().isFocused(), Matchers.is(true), "Input is not focused");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not focused", isAssert = true)
    public InputAssert notFocused() {
        jdiAssert(element().isFocused(), Matchers.is(false), "Input is focused");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has prepend outer icon", isAssert = true)
    public InputAssert prependOuterIcon() {
        jdiAssert(element().hasPrependOuterIcon(), Matchers.is(true), "Input hasn't prepend outer icon");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has prepend inner icon", isAssert = true)
    public InputAssert prependInnerIcon() {
        jdiAssert(element().hasPrependInnerIcon(), Matchers.is(true), "Input hasn't prepend inner icon");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has append outer icon", isAssert = true)
    public InputAssert appendOuterIcon() {
        jdiAssert(element().hasAppendOuterIcon(), Matchers.is(true), "Input hasn't append outer icon");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has append inner icon", isAssert = true)
    public InputAssert appendInnerIcon() {
        jdiAssert(element().hasAppendInnerIcon(), Matchers.is(true), "Input hasn't append inner icon");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has switch", isAssert = true)
    public InputAssert switchInput() {
        jdiAssert(element().hasSwitch(), Matchers.is(true), "Input hasn't switch");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' switch is checked", isAssert = true)
    public InputAssert checkedSwitch() {
        jdiAssert(element().switchIsChecked(), Matchers.is(true), "Input's switch is unchecked");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' switch is unchecked", isAssert = true)
    public InputAssert uncheckedSwitch() {
        jdiAssert(element().switchIsChecked(), Matchers.is(false), "Input's switch is checked");
        return this;
    }
}
