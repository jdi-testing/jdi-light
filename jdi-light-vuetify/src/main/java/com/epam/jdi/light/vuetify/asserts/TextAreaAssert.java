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
    @JDIAction(value = "Assert that '{name}' has text '{0}'", isAssert = true)
    public TextAreaAssert text(Matcher<String> condition) {
        String actualText = element().getText();
        jdiAssert(actualText, condition, String.format("Actual element's text '%s' is not equal to expected " +
                "'%s'", actualText, condition));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has text '{0}'", isAssert = true)
    public TextAreaAssert text(String text) {
        text(Matchers.equalTo(text));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is auto grow", isAssert = true)
    public TextAreaAssert autoGrow() {
        jdiAssert(element().isAutogrow(), Matchers.is(true), "Element is not auto grow");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not auto grow", isAssert = true)
    public TextAreaAssert notAutoGrow() {
        jdiAssert(element().isAutogrow(), Matchers.is(false), "Element is auto grow");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not resizable", isAssert = true)
    public TextAreaAssert notResizable() {
        jdiAssert(element().isNotResizable(), Matchers.is(true), "Element is resizable");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is resizable", isAssert = true)
    public TextAreaAssert resizable() {
        jdiAssert(element().isNotResizable(), Matchers.is(false), "Element is not resizable");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' rows count is {0}", isAssert = true)
    public TextAreaAssert rowsCount(int rowsCount) {
        int actualRowCount = element().rows();
        jdiAssert(actualRowCount, Matchers.is(rowsCount));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has lines {0}", isAssert = true)
    private TextAreaAssert lines(Matcher<? super List<String>> condition) {
        List<String> actualLines = element().getLines();
        jdiAssert(actualLines, condition);
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has lines {0}", isAssert = true)
    public TextAreaAssert lines(String... lines) {
        return lines(containsInAnyOrder(lines));
    }

    @JDIAction(value = "Assert that '{name}' has label", isAssert = true)
    public TextAreaAssert label() {
        jdiAssert(element().hasLabel(), Matchers.is(true), "Element doesn't have label");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has suffix", isAssert = true)
    public TextAreaAssert suffix() {
        jdiAssert(element().hasSuffix(), Matchers.is(true), "Element doesn't have suffix");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has not suffix", isAssert = true)
    public TextAreaAssert notSuffix() {
        jdiAssert(element().hasSuffix(), Matchers.is(false), "Element has suffix");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has prefix", isAssert = true)
    public TextAreaAssert prefix() {
        jdiAssert(element().hasPrefix(), Matchers.is(true), "Element doesn't have prefix");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has not prefix", isAssert = true)
    public TextAreaAssert notPrefix() {
        jdiAssert(element().hasPrefix(), Matchers.is(false), "Element has prefix");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has icon", isAssert = true)
    public TextAreaAssert icon() {
        jdiAssert(element().hasIcon(), Matchers.is(true), "Element doesn't have icon");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has not icon", isAssert = true)
    public TextAreaAssert notIcon() {
        jdiAssert(element().hasIcon(), Matchers.is(false), "Element has icon");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has prepend outer icon", isAssert = true)
    public TextAreaAssert prependOuterIcon() {
        jdiAssert(element().hasPrependOuterIcon(), Matchers.is(true), "Element doesn't have prepend " +
                "outer icon");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has prepend inner icon", isAssert = true)
    public TextAreaAssert prependInnerIcon() {
        jdiAssert(element().hasPrependInnerIcon(), Matchers.is(true), "Element doesn't have prepend " +
                "inner icon");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has append outer icon", isAssert = true)
    public TextAreaAssert appendOuterIcon() {
        jdiAssert(element().hasAppendOuterIcon(), Matchers.is(true), "Element doesn't have append " +
                "outer icon");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has append inner icon", isAssert = true)
    public TextAreaAssert appendInnerIcon() {
        jdiAssert(element().hasAppendInnerIcon(), Matchers.is(true), "Element doesn't have append " +
                "inner icon");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has placeholder", isAssert = true)
    public TextAreaAssert placeholder() {
        jdiAssert(element().hasPlaceholder(), Matchers.is(true), "Element doesn't have placeholder");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has not placeholder", isAssert = true)
    public TextAreaAssert notPlaceholder() {
        jdiAssert(element().hasPlaceholder(), Matchers.is(false), "Element has placeholder");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has placeholder text '{0}'", isAssert = true)
    public TextAreaAssert placeholderText(String text) {
        String actualPlaceholderText = element().placeholder();
        jdiAssert(actualPlaceholderText, Matchers.equalTo(text));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has counter value '{0}'", isAssert = true)
    public TextAreaAssert counterValue(int n) {
        jdiAssert(element().counterValue(), Matchers.equalTo(n));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is autofocused", isAssert = true)
    public TextAreaAssert autofocus() {
        jdiAssert(element().isAutofocus(), Matchers.is(true), "Element is not autofocus");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not autofocus", isAssert = true)
    public TextAreaAssert notAutofocus() {
        jdiAssert(element().isAutofocus(), Matchers.is(false), "Element is autofocus");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is reversed", isAssert = true)
    public TextAreaAssert reversed() {
        jdiAssert(element().isReversed(), Matchers.is(true), "Element is not reversed");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not reversed", isAssert = true)
    public TextAreaAssert notReversed() {
        jdiAssert(element().isReversed(), Matchers.is(false), "Element is reversed");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has loader height {0}", isAssert = true)
    public TextAreaAssert loaderHeightPx(int height) {
        int actualLoaderHeight = element().getLoaderHeight();
        jdiAssert(actualLoaderHeight, Matchers.equalTo(height), String.format("Actual element's loader height " +
                "'%s px' is not equal to expected '%s px'", actualLoaderHeight, height));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' hint message is '{0}'", isAssert = true)
    public TextAreaAssert hint(String msg) {
        return this.hint(Matchers.equalTo(msg));
    }

    @JDIAction(value = "Assert that '{name}' hint message is '{0}'", isAssert = true)
    public TextAreaAssert hint(Matcher<String> condition) {
        jdiAssert(element().hint().text(), condition);
        return this;
    }
}
