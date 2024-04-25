package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.TextField;
import com.epam.jdi.light.vuetify.interfaces.asserts.ClearableAssert;
import com.epam.jdi.light.asserts.generic.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.DenseAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.FilledAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.FlatAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.FullWidthAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.HideDetailsAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.LoadingAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MeasurementAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MessagesAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.OutlinedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ReadOnlyAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ReverseAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.RoundedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ShapedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.SingleLineAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.SoloAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Represents assertion for text field
 *
 * @see <a href="https://jdi-testing.github.io/jdi-light/vuetify/text-fields">Text fields test page</a>
 */
public class TextFieldAssert extends UIAssert<TextFieldAssert, TextField>
        implements ClearableAssert<TextFieldAssert, TextField>, ColorAssert<TextFieldAssert, TextField>,
        DenseAssert<TextFieldAssert, TextField>, FilledAssert<TextFieldAssert, TextField>,
        FlatAssert<TextFieldAssert, TextField>, LoadingAssert<TextFieldAssert, TextField>,
        MeasurementAssert<TextFieldAssert, TextField>, MessagesAssert<TextFieldAssert, TextField>,
        OutlinedAssert<TextFieldAssert, TextField>, ReadOnlyAssert<TextFieldAssert, TextField>,
        ReverseAssert<TextFieldAssert, TextField>, RoundedAssert<TextFieldAssert, TextField>,
        ShapedAssert<TextFieldAssert, TextField>, SingleLineAssert<TextFieldAssert, TextField>,
        ThemeAssert<TextFieldAssert, TextField>, SoloAssert<TextFieldAssert, TextField>,
        FullWidthAssert<TextFieldAssert, TextField>, ITextAssert<TextFieldAssert>,
        HideDetailsAssert<TextFieldAssert, TextField> {

    @Override
    @JDIAction(value = "Assert that '{name}' text '{0}'", isAssert = true)
    public TextFieldAssert text(Matcher<String> condition) {
        jdiAssert(element().getText(), condition);
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is focused", isAssert = true)
    public TextFieldAssert focused() {
        jdiAssert(element().isFocused(), Matchers.is(true), "TextField is not focused");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not focused", isAssert = true)
    public TextFieldAssert notFocused() {
        jdiAssert(element().isFocused(), Matchers.is(false), "TextField is focused");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' text type is '{0}'", isAssert = true)
    public TextFieldAssert textType(String textType) {
        jdiAssert(element().getTextType(), Matchers.equalTo(textType));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has placeholder", isAssert = true)
    public TextFieldAssert placeholder() {
        jdiAssert(element().hasPlaceholder(), Matchers.is(true), "TextField has not placeholder");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has not placeholder", isAssert = true)
    public TextFieldAssert notPlaceholder() {
        jdiAssert(element().hasPlaceholder(), Matchers.is(false), "TextField has placeholder");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' placeholder is '{0}'", isAssert = true)
    public TextFieldAssert placeholder(String placeholder) {
        if (element().hasPlaceholder()) {
            jdiAssert(element().placeholder(), Matchers.equalTo(placeholder));
        } else {
            return placeholder();
        }
        return this;
    }

    @JDIAction(value = "Assert that '{name}' current counter is '{0}' and max counter is '{1}'", isAssert = true)
    public TextFieldAssert counter(String counter) {
        jdiAssert(element().counter().text(), Matchers.equalTo(counter));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has label {0}", isAssert = true)
    public TextFieldAssert label(String label) {
        jdiAssert(element().labelText(), Matchers.is(label));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has label", isAssert = true)
    public TextFieldAssert label() {
        jdiAssert(element().hasLabel(), Matchers.is(true), "There is no label for TextField");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has append outer icon", isAssert = true)
    public TextFieldAssert appendOuterIcon() {
        jdiAssert(element().hasAppendOuterIcon(), Matchers.is(true),
                "TextField doesn't have append outer icon");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has append inner icon", isAssert = true)
    public TextFieldAssert appendInnerIcon() {
        jdiAssert(element().hasAppendInnerIcon(), Matchers.is(true),
                "TextField doesn't have append inner icon");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has prepend outer icon", isAssert = true)
    public TextFieldAssert prependOuterIcon() {
        jdiAssert(element().hasPrependOuterIcon(), Matchers.is(true),
                "TextField doesn't have prepend outer icon");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has prepend inner icon", isAssert = true)
    public TextFieldAssert prependInnerIcon() {
        jdiAssert(element().hasPrependInnerIcon(), Matchers.is(true),
                "TextField doesn't have prepend inner icon");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is autofocus", isAssert = true)
    public TextFieldAssert autofocus() {
        jdiAssert(element().isAutofocus(), Matchers.is(true), "TextField is not autofocus");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not autofocus", isAssert = true)
    public TextFieldAssert notAutofocus() {
        jdiAssert(element().isAutofocus(), Matchers.is(false), "TextField is autofocus");
        return this;
    }
}
