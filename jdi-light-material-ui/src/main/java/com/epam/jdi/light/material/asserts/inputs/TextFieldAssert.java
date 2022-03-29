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
    @JDIAction("Assert that '{name}' label text {0}")
    public TextFieldAssert text(Matcher<String> condition) {
        jdiAssert(element().getText(), condition);
        return this;
    }

    /**
     * Checks that text field is readonly.
     *
     * @return this {@link TextFieldAssert} instance
     */
    @JDIAction("Assert that '{name}' is readonly")
    public TextFieldAssert readonly() {
        jdiAssert(element().isReadonly() ? "is readonly" : "is not readonly", Matchers.is("is readonly"));
        return this;
    }

    /**
     * Checks that text field has given helper text.
     *
     * @param text expected helper text
     * @return this {@link TextFieldAssert} instance
     */
    @JDIAction("Assert that '{name}' helper text is '{0}'")
    public TextFieldAssert helperText(String text) {
        return helperText(Matchers.is(text));
    }

    /**
     * Checks that text field helper text meets the given condition.
     *
     * @param condition expected condition
     * @return this {@link TextFieldAssert} instance
     */
    @JDIAction("Assert that '{name}' helper text {0}")
    public TextFieldAssert helperText(Matcher<String> condition) {
        jdiAssert(element().getHelperText(), condition);
        return this;
    }

    /**
     * Checks that text field has placeholder.
     *
     * @return this {@link TextFieldAssert} instance
     */
    @JDIAction("Assert that '{name}' has placeholder")
    public TextFieldAssert placeholder() {
        jdiAssert(element().hasPlaceholder() ? "has placeholder" : "does not have placeholder",
            Matchers.is("has placeholder"));
        return this;
    }

    /**
     * Checks that text field has given placeholder text.
     *
     * @param text expected helper text
     * @return this {@link TextFieldAssert} instance
     */
    @JDIAction("Assert that '{name}' placeholder text is '{0}'")
    public TextFieldAssert placeholderText(String text) {
        return placeholderText(Matchers.is(text));
    }

    /**
     * Checks that text field placeholder text meets the given condition.
     *
     * @param condition expected condition
     * @return this {@link TextFieldAssert} instance
     */
    @JDIAction("Assert that '{name}' placeholder text {0}")
    public TextFieldAssert placeholderText(Matcher<String> condition) {
        jdiAssert(element().getPlaceHolderText(), condition);
        return this;
    }

    /**
     * Checks that text field his focused.
     *
     * @return this {@link TextFieldAssert} instance
     */
    @JDIAction("Assert that '{name}' is focused")
    public TextFieldAssert focused() {
        jdiAssert(element().isFocused() ? "is focused" : "is not focused", Matchers.is("is focused"));
        return this;
    }

    /**
     * Checks that text field has given type.
     *
     * @param type expected text field type
     * @return this {@link TextFieldAssert} instance
     */
    @JDIAction("Assert that '{name}' type is '{0}'")
    public TextFieldAssert type(String type) {
        return type(Matchers.is(type));
    }

    /**
     * Checks that text field type meets the given condition.
     *
     * @param condition expected condition
     * @return this {@link TextFieldAssert} instance
     */
    @JDIAction("Assert that '{name}' type {0}")
    public TextFieldAssert type(Matcher<String> condition) {
        jdiAssert(element().type(), condition);
        return this;
    }

    /**
     * Checks that text field has validation error.
     *
     * @return this {@link TextFieldAssert} instance
     */
    @JDIAction("Assert that '{name}' has error notification")
    public TextFieldAssert validationError() {
        jdiAssert(element().hasValidationError() ? "has validation error" : "does not have validation error",
            Matchers.is("has validation error"));
        return this;
    }
}
