package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Input;
import com.epam.jdi.light.vuetify.interfaces.asserts.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.DenseAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.HideDetailsAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.LoadingAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MeasurementAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MessagesAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ReadOnlyAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class InputAssert extends UIAssert<InputAssert, Input>
        implements MessagesAssert<InputAssert, Input>, ReadOnlyAssert<InputAssert, Input>,
        LoadingAssert<InputAssert, Input>, ColorAssert<InputAssert, Input>, ThemeAssert<InputAssert, Input>,
        MeasurementAssert<InputAssert, Input>, DenseAssert<InputAssert, Input>, HideDetailsAssert<InputAssert, Input> {
    @Override
    @JDIAction("Assert that '{name}' is disabled")
    public InputAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true), "Element is enabled");
        return this;
    }

    @Override
    @JDIAction("Assert that '{name}' is enabled")
    public InputAssert enabled() {
        jdiAssert(element().isDisabled(), Matchers.is(false), "Element is disabled");
        return this;
    }

    @JDIAction("Assert that '{name}' has text in slot")
    public InputAssert textInSlot() {
        jdiAssert(element().hasTextInSlot(), Matchers.is(true), "Element hasn't text in slot");
        return this;
    }

    @JDIAction("Assert that '{name}' has text in slot '{0}'")
    public InputAssert textInSlot(String text) {
        String actualTextInSlot = element().getTextInSlot();
        jdiAssert(actualTextInSlot, Matchers.equalTo(text), String.format("Actual text in slot '%s' is not equal to " +
                "expected '%s'", actualTextInSlot, text));
        return this;
    }

    @JDIAction("Assert that '{name}' has text field")
    public InputAssert textField() {
        jdiAssert(element().hasTextField(), Matchers.is(true), "Element hasn't text field");
        return this;
    }

    @JDIAction("Assert that '{name}' has text field")
    public InputAssert notTextField() {
        jdiAssert(element().hasTextField(), Matchers.is(false), "Element text field");
        return this;
    }

    @JDIAction("Assert that '{name}' has typed text in input field")
    public InputAssert typedText() {
        jdiAssert(element().hasTypedText(), Matchers.is(true), "Element hasn't typed text");
        return this;
    }

    @JDIAction("Assert that '{name}' has typed text '{0}' in input field")
    public InputAssert typedText(String text) {
        String actualTypedText = element().getTypedText();
        jdiAssert(actualTypedText, Matchers.equalTo(text), String.format("Actual typed text '%s' is not equal to " +
                "expected '%s'", actualTypedText, text));
        return this;
    }

    @JDIAction("Assert that '{name}' has not typed text in input field")
    public InputAssert notTypedText() {
        jdiAssert(element().hasTypedText(), Matchers.is(true), "Element has typed text");
        return this;
    }

    @JDIAction("Assert that '{name}' has label")
    public InputAssert label() {
        jdiAssert(element().hasLabel(), Matchers.is(true), "Element has no label");
        return this;
    }

    @JDIAction("Assert that '{name}' has no label")
    public InputAssert noLabel() {
        jdiAssert(element().hasLabel(), Matchers.is(false), "Element has label");
        return this;
    }

    @JDIAction("Assert that '{name}' has label '{0}'")
    public InputAssert label(String text) {
        String actualLabelText = element().getLabel();
        jdiAssert(actualLabelText, Matchers.equalTo(text), String.format("Actual label text '%s' is not equal to " +
                "expected '%s'", actualLabelText, text));
        return this;
    }

    @JDIAction("Assert that '{name}' is focused")
    public InputAssert focused() {
        jdiAssert(element().isFocused(), Matchers.is(true), "Element is not focused");
        return this;
    }

    @JDIAction("Assert that '{name}' is not focused")
    public InputAssert notFocused() {
        jdiAssert(element().isFocused(), Matchers.is(false), "Element is focused");
        return this;
    }

    @JDIAction("Assert that '{name}' has prepend outer icon")
    public InputAssert prependOuterIcon() {
        jdiAssert(element().hasPrependOuterIcon(), Matchers.is(true), "Element hasn't prepend outer icon");
        return this;
    }

    @JDIAction("Assert that '{name}' has prepend inner icon")
    public InputAssert prependInnerIcon() {
        jdiAssert(element().hasPrependInnerIcon(), Matchers.is(true), "Element hasn't prepend inner icon");
        return this;
    }

    @JDIAction("Assert that '{name}' has append outer icon")
    public InputAssert appendOuterIcon() {
        jdiAssert(element().hasAppendOuterIcon(), Matchers.is(true), "Element hasn't append outer icon");
        return this;
    }

    @JDIAction("Assert that '{name}' has append inner icon")
    public InputAssert appendInnerIcon() {
        jdiAssert(element().hasAppendInnerIcon(), Matchers.is(true), "Element hasn't append inner icon");
        return this;
    }

    @JDIAction("Assert that '{name}' has switch")
    public InputAssert switchInput() {
        jdiAssert(element().hasSwitch(), Matchers.is(true), "Element hasn't switch");
        return this;
    }

    @JDIAction("Assert that '{name}' switch is checked")
    public InputAssert checkedSwitch() {
        jdiAssert(element().switchIsChecked(), Matchers.is(true), "Element's switch is unchecked");
        return this;
    }

    @JDIAction("Assert that '{name}' switch is unchecked")
    public InputAssert uncheckedSwitch() {
        jdiAssert(element().switchIsChecked(), Matchers.is(false), "Element's switch is checked");
        return this;
    }

    @JDIAction("Assert that '{name}' has class attribute '{0}'")
    public InputAssert className(String className) {
        jdiAssert(element().hasClass(className), Matchers.is(true), String.format("Element hasn't class " +
                "attribute '%s'", className));
        return this;
    }

    @JDIAction("Assert that '{name}' has not class attribute '{0}'")
    public InputAssert notClassName(String className) {
        jdiAssert(element().hasAttribute(className), Matchers.is(false), String.format("Element has class " +
                "attribute '%s'", className));
        return this;
    }
}
