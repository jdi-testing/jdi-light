package com.epam.jdi.light.material.asserts.inputs;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.TextField;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

/**
 * Assertions for {@link TextField}
 */
public class TextFieldAssert extends UIAssert<TextFieldAssert, TextField> implements ITextAssert<TextFieldAssert> {

    @Override
    @JDIAction(value = "Assert that '{name}' label text {0}", isAssert = true)
    public TextFieldAssert text(Matcher<String> condition) {
        jdiAssert(element().getText(), condition);
        return this;
    }

    /**
     * Checks that text field is readonly.
     *
     * @return this {@link TextFieldAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' is readonly", isAssert = true)
    public TextFieldAssert readonly() {
        jdiAssert(element().isReadonly(), Matchers.is(true), "TextField is not readonly");
        return this;
    }

    /**
     * Checks that text field has given helper text.
     *
     * @param text expected helper text
     * @return this {@link TextFieldAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' helper text is '{0}'", isAssert = true)
    public TextFieldAssert helperText(String text) {
        return helperText(Matchers.is(text));
    }

    /**
     * Checks that text field helper text meets the given condition.
     *
     * @param condition expected condition
     * @return this {@link TextFieldAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' helper text {0}", isAssert = true)
    public TextFieldAssert helperText(Matcher<String> condition) {
        jdiAssert(element().helperText().text(), condition);
        return this;
    }

    /**
     * Checks that text field has helper text.
     *
     * @return this {@link TextFieldAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' has helper text", isAssert = true)
    public TextFieldAssert hasHelperText() {
        jdiAssert(element().hasHelperText(), Matchers.is(true), "TextField doesn't have helper text");
        return this;
    }

    /**
     * Checks that text field has given placeholder text.
     *
     * @param text expected placeholder text
     * @return this {@link TextFieldAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' placeholder text is '{0}'", isAssert = true)
    public TextFieldAssert placeholderText(String text) {
        return placeholderText(Matchers.is(text));
    }

    /**
     * Checks that text field placeholder text meets the given condition.
     *
     * @param condition expected condition
     * @return this {@link TextFieldAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' placeholder text {0}", isAssert = true)
    public TextFieldAssert placeholderText(Matcher<String> condition) {
        jdiAssert(element().placeHolderText(), condition);
        return this;
    }

    /**
     * Checks that text field is focused.
     *
     * @return this {@link TextFieldAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' is focused", isAssert = true)
    public TextFieldAssert focused() {
        jdiAssert(element().isFocused(), Matchers.is(true), "TextField is not focused");
        return this;
    }

    /**
     * Checks that text field has given type.
     *
     * @param type expected text field type
     * @return this {@link TextFieldAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' type is '{0}'", isAssert = true)
    public TextFieldAssert type(String type) {
        return type(Matchers.is(type));
    }

    /**
     * Checks that text field type meets the given condition.
     *
     * @param condition expected condition
     * @return this {@link TextFieldAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' type {0}", isAssert = true)
    public TextFieldAssert type(Matcher<String> condition) {
        jdiAssert(element().type(), condition);
        return this;
    }

    /**
     * Checks that text field has validation error.
     *
     * @return this {@link TextFieldAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' has error notification", isAssert = true)
    public TextFieldAssert validationError() {
        jdiAssert(element().isValidationErrorPresent(), Matchers.is(true),
                "Validation Error is not displayed for TextField");
        return this;
    }
}
