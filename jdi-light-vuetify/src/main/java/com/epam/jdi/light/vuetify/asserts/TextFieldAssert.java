package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.TextField;
import com.epam.jdi.light.vuetify.interfaces.asserts.ClearableAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.DenseAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.FilledAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.FlatAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.LoadingAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MeasurementAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MessagesAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.OutlinedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ReadOnlyAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ReverseAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.RoundedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ShapedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.SingleLineAssert;
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
        ThemeAssert<TextFieldAssert, TextField>, ITextAssert<TextFieldAssert> {

    @Override
    @JDIAction("Assert that '{name}' text '{0}'")
    public TextFieldAssert text(Matcher<String> condition) {
        String actualText = element().getText();
        jdiAssert(actualText, condition, String.format("Actual text '%s' is not equal to expected '%s'", actualText,
                condition));
        return this;
    }

    @JDIAction("Assert that '{name}' is focused")
    public TextFieldAssert focused() {
        jdiAssert(element().isFocused(), Matchers.is(true), "Element is not focused");
        return this;
    }

    @JDIAction("Assert that '{name}' is not focused")
    public TextFieldAssert notFocused() {
        jdiAssert(element().isFocused(), Matchers.is(false), "Element is focused");
        return this;
    }

    @JDIAction("Assert that '{name}' is solo")
    public TextFieldAssert solo() {
        jdiAssert(element().isSolo(), Matchers.is(true), "Element is not solo");
        return this;
    }

    @JDIAction("Assert that '{name}' is not solo")
    public TextFieldAssert notSolo() {
        jdiAssert(element().isSolo(), Matchers.is(false), "Element is solo");
        return this;
    }

    @JDIAction("Assert that '{name}' is solo inverted")
    public TextFieldAssert soloInverted() {
        jdiAssert(element().isSoloInverted(), Matchers.is(true), "Element is not solo inverted");
        return this;
    }

    @JDIAction("Assert that '{name}' is not solo inverted")
    public TextFieldAssert notSoloInverted() {
        jdiAssert(element().isSoloInverted(), Matchers.is(false), "Element is solo inverted");
        return this;
    }

    @JDIAction("Assert that '{name}' is full width")
    public TextFieldAssert fullWidth() {
        jdiAssert(element().isFullWidth(), Matchers.is(true), "Element is not full-width");
        return this;
    }

    @JDIAction("Assert that '{name}' is not full width")
    public TextFieldAssert notFullWidth() {
        jdiAssert(element().isFullWidth(), Matchers.is(false), "Element is full-width");
        return this;
    }

    @JDIAction("Assert that '{name}' text type is '{0}'")
    public TextFieldAssert textType(String textType) {
        String actualTextType = element().getTextType();
        jdiAssert(actualTextType, Matchers.equalTo(textType), String.format("Actual text type '%s' is not equal to " +
                "expected '%s'", actualTextType, textType));
        return this;
    }

    @JDIAction("Assert that '{name}' has placeholder")
    public TextFieldAssert placeholder() {
        jdiAssert(element().hasPlaceholder(), Matchers.is(true), "Element has not placeholder");
        return this;
    }

    @JDIAction("Assert that '{name}' has not placeholder")
    public TextFieldAssert notPlaceholder() {
        jdiAssert(element().hasPlaceholder(), Matchers.is(false), "Element has placeholder");
        return this;
    }

    @JDIAction("Assert that '{name}' placeholder is '{0}'")
    public TextFieldAssert placeholder(String placeholder) {
        String actualPlaceholder;
        if (element().hasPlaceholder()) {
            actualPlaceholder = element().labelText();
        } else {
            actualPlaceholder = "";
        }
        jdiAssert(actualPlaceholder, Matchers.equalTo(placeholder), String.format("Actual placeholder '%s' is not " +
                "equal to expected '%s'", actualPlaceholder, placeholder));
        return this;
    }

    @JDIAction("Assert that '{name}' current counter is '{0}' and max counter is '{1}'")
    public TextFieldAssert counter(int currentCounter, int maxCounter) {
        String[] counter = element().counter().text().replaceAll("\\s", "").split("/");
        jdiAssert(Integer.parseInt(counter[0]), Matchers.equalTo(currentCounter), String.format("Actual current counter " +
                "'%s' is not equal to expected '%s'", counter[0], currentCounter));
        jdiAssert(Integer.parseInt(counter[1]), Matchers.equalTo(maxCounter), String.format("Actual max counter '%s' is " +
                "not equal to expected '%s'", counter[1], maxCounter));
        return this;
    }

    @JDIAction("Assert that '{name}' has label")
    public TextFieldAssert labelText(String label) {
        jdiAssert(element().labelText(), Matchers.is(label));
        return this;
    }

    @JDIAction("Assert that '{name}' has label")
    public TextFieldAssert label() {
        jdiAssert(element().hasLabel(), Matchers.is(true), "There is no label for element");
        return this;
    }

    @JDIAction("Assert that '{name}' has append outer icon")
    public TextFieldAssert appendOuterIcon() {
        jdiAssert(element().hasAppendOuterIcon(), Matchers.is(true), "Element doesn't have append " +
                "outer icon");
        return this;
    }

    @JDIAction("Assert that '{name}' has append inner icon")
    public TextFieldAssert appendInnerIcon() {
        jdiAssert(element().hasAppendInnerIcon(), Matchers.is(true), "Element doesn't have append " +
                "inner icon");
        return this;
    }

    @JDIAction("Assert that '{name}' has prepend outer icon")
    public TextFieldAssert prependOuterIcon() {
        jdiAssert(element().hasPrependOuterIcon(), Matchers.is(true), "Element doesn't have prepend " +
                "outer icon");
        return this;
    }

    @JDIAction("Assert that '{name}' has prepend inner icon")
    public TextFieldAssert prependInnerIcon() {
        jdiAssert(element().hasPrependInnerIcon(), Matchers.is(true), "Element doesn't have prepend " +
                "inner icon");
        return this;
    }

    @JDIAction("Assert that '{name}' is autofocus")
    public TextFieldAssert autofocus() {
        jdiAssert(element().isAutofocus(), Matchers.is(true), "Element is not autofocus");
        return this;
    }

    @JDIAction("Assert that '{name}' is not autofocus")
    public TextFieldAssert notAutofocus() {
        jdiAssert(element().isAutofocus(), Matchers.is(false), "Element is autofocus");
        return this;
    }

    @JDIAction("Assert that '{name}' has details hidden")
    public TextFieldAssert detailsHidden() {
        jdiAssert(element().hasDetailsHidden(), Matchers.is(true), "Element has details not hidden");
        return this;
    }

    @JDIAction("Assert that '{name}' has details not hidden")
    public TextFieldAssert notDetailsHidden() {
        jdiAssert(element().hasDetailsHidden(), Matchers.is(false), "Element has details hidden");
        return this;
    }

    @JDIAction("Assert that '{name}' has loader height {0}")
    public TextFieldAssert loaderHeightPx(int height) {
        int actualLoaderHeight = element().getLoaderHeight();
        jdiAssert(actualLoaderHeight, Matchers.equalTo(height), String.format("Actual element's loader height " +
                "'%s px' is not equal to expected '%s px'", actualLoaderHeight, height));
        return this;
    }
}
