package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.TextArea;
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
import com.epam.jdi.light.vuetify.interfaces.asserts.RoundedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ShapedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.SingleLineAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.SoloAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class TextAreaAssert extends UIAssert<TextAreaAssert, TextArea> implements ITextAssert<TextAreaAssert>,
        ClearableAssert<TextAreaAssert, TextArea>, ColorAssert<TextAreaAssert, TextArea>,
        DenseAssert<TextAreaAssert, TextArea>, FilledAssert<TextAreaAssert, TextArea>,
        FlatAssert<TextAreaAssert, TextArea>, LoadingAssert<TextAreaAssert, TextArea>,
        MeasurementAssert<TextAreaAssert, TextArea>, MessagesAssert<TextAreaAssert, TextArea>,
        OutlinedAssert<TextAreaAssert, TextArea>, ReadOnlyAssert<TextAreaAssert, TextArea>,
        RoundedAssert<TextAreaAssert, TextArea>, ShapedAssert<TextAreaAssert, TextArea>,
        SingleLineAssert<TextAreaAssert, TextArea>, ThemeAssert<TextAreaAssert, TextArea>,
        SoloAssert<TextAreaAssert, TextArea>, FullWidthAssert<TextAreaAssert, TextArea>,
        HideDetailsAssert<TextAreaAssert, TextArea> {
    @Override
    @JDIAction(value = "Assert that '{name}' has text with condition", isAssert = true)
    public TextAreaAssert text(Matcher<String> condition) {
        jdiAssert(element().getText(), condition);
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has text '{0}'", isAssert = true)
    public TextAreaAssert text(String text) {
        text(Matchers.equalTo(text));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is auto grow", isAssert = true)
    public TextAreaAssert autoGrow() {
        jdiAssert(element().isAutogrow(), Matchers.is(true), "TextArea is not auto grow");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not auto grow", isAssert = true)
    public TextAreaAssert notAutoGrow() {
        jdiAssert(element().isAutogrow(), Matchers.is(false), "TextArea is auto grow");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not resizable", isAssert = true)
    public TextAreaAssert notResizable() {
        jdiAssert(element().isNotResizable(), Matchers.is(true), "TextArea is resizable");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is resizable", isAssert = true)
    public TextAreaAssert resizable() {
        jdiAssert(element().isNotResizable(), Matchers.is(false), "TextArea is not resizable");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' rows count is {0}", isAssert = true)
    public TextAreaAssert rowsCount(int rowsCount) {
        jdiAssert(element().rows(), Matchers.is(rowsCount));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has lines with condition", isAssert = true)
    private TextAreaAssert lines(Matcher<? super List<String>> condition) {
        jdiAssert(element().getLines(), condition);
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has lines {0}", isAssert = true)
    public TextAreaAssert lines(String... lines) {
        return lines(containsInAnyOrder(lines));
    }

    @JDIAction(value = "Assert that '{name}' has label", isAssert = true)
    public TextAreaAssert label() {
        jdiAssert(element().hasLabel(), Matchers.is(true), "TextArea doesn't have label");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has suffix", isAssert = true)
    public TextAreaAssert suffix() {
        jdiAssert(element().hasSuffix(), Matchers.is(true), "TextArea doesn't have suffix");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has not suffix", isAssert = true)
    public TextAreaAssert notSuffix() {
        jdiAssert(element().hasSuffix(), Matchers.is(false), "TextArea has suffix");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has prefix", isAssert = true)
    public TextAreaAssert prefix() {
        jdiAssert(element().hasPrefix(), Matchers.is(true), "TextArea doesn't have prefix");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has not prefix", isAssert = true)
    public TextAreaAssert notPrefix() {
        jdiAssert(element().hasPrefix(), Matchers.is(false), "TextArea has prefix");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has icon", isAssert = true)
    public TextAreaAssert icon() {
        jdiAssert(element().hasIcon(), Matchers.is(true), "TextArea doesn't have icon");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has not icon", isAssert = true)
    public TextAreaAssert notIcon() {
        jdiAssert(element().hasIcon(), Matchers.is(false), "TextArea has icon");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has prepend outer icon", isAssert = true)
    public TextAreaAssert prependOuterIcon() {
        jdiAssert(element().hasPrependOuterIcon(), Matchers.is(true),
                "TextArea doesn't have prepend outer icon");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has prepend inner icon", isAssert = true)
    public TextAreaAssert prependInnerIcon() {
        jdiAssert(element().hasPrependInnerIcon(), Matchers.is(true),
                "TextArea doesn't have prepend inner icon");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has append outer icon", isAssert = true)
    public TextAreaAssert appendOuterIcon() {
        jdiAssert(element().hasAppendOuterIcon(), Matchers.is(true),
                "TextArea doesn't have append outer icon");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has append inner icon", isAssert = true)
    public TextAreaAssert appendInnerIcon() {
        jdiAssert(element().hasAppendInnerIcon(), Matchers.is(true),
                "TextArea doesn't have append inner icon");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has placeholder", isAssert = true)
    public TextAreaAssert placeholder() {
        jdiAssert(element().hasPlaceholder(), Matchers.is(true), "TextArea doesn't have placeholder");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has not placeholder", isAssert = true)
    public TextAreaAssert notPlaceholder() {
        jdiAssert(element().hasPlaceholder(), Matchers.is(false), "TextArea has placeholder");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has placeholder text '{0}'", isAssert = true)
    public TextAreaAssert placeholderText(String text) {
        jdiAssert(element().placeholder(), Matchers.equalTo(text));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has counter value '{0}'", isAssert = true)
    public TextAreaAssert counterValue(int n) {
        jdiAssert(element().counterValue(), Matchers.equalTo(n));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is autofocused", isAssert = true)
    public TextAreaAssert autofocus() {
        jdiAssert(element().isAutofocus(), Matchers.is(true), "TextArea is not autofocus");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not autofocus", isAssert = true)
    public TextAreaAssert notAutofocus() {
        jdiAssert(element().isAutofocus(), Matchers.is(false), "TextArea is autofocus");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is reversed", isAssert = true)
    public TextAreaAssert reversed() {
        jdiAssert(element().isReversed(), Matchers.is(true), "TextArea is not reversed");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not reversed", isAssert = true)
    public TextAreaAssert notReversed() {
        jdiAssert(element().isReversed(), Matchers.is(false), "TextArea is reversed");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has loader height {0}", isAssert = true)
    public TextAreaAssert loaderHeightPx(int height) {
        jdiAssert(element().getLoaderHeight(), Matchers.equalTo(height));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' hint message is '{0}'", isAssert = true)
    public TextAreaAssert hint(String msg) {
        return this.hint(Matchers.equalTo(msg));
    }

    @JDIAction(value = "Assert that '{name}' hint message matches condition", isAssert = true)
    public TextAreaAssert hint(Matcher<String> condition) {
        jdiAssert(element().hint().text(), condition);
        return this;
    }
}
