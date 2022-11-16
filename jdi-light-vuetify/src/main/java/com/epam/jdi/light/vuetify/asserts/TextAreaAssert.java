package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.TextArea;
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
import com.epam.jdi.light.vuetify.interfaces.asserts.RoundedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ShapedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.SingleLineAssert;
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
        SingleLineAssert<TextAreaAssert, TextArea>, ThemeAssert<TextAreaAssert, TextArea> {
    @Override
    @JDIAction("Assert that '{name}' text {0}")
    public TextAreaAssert text(Matcher<String> condition) {
        String actualText = element().getText();
        jdiAssert(actualText, condition, String.format("Actual element's text '%s' is not equal to expected " +
                "'%s'", actualText, condition));
        return this;
    }

    @JDIAction("Assert that '{name}' is autoGrow")
    public TextAreaAssert autoGrow() {
        jdiAssert(element().isAutogrow(), Matchers.is(true), "Element is not autogrow");
        return this;
    }

    @JDIAction("Assert that '{name}' is not autoGrow")
    public TextAreaAssert notAutoGrow() {
        jdiAssert(element().isAutogrow(), Matchers.is(false), "Element is autogrow");
        return this;
    }

    @JDIAction("Assert that '{name}' is not resizable")
    public TextAreaAssert notResizable() {
        jdiAssert(element().isNotResizable(), Matchers.is(true), "Element is resizable");
        return this;
    }

    @JDIAction("Assert that '{name}' is not resizable")
    public TextAreaAssert resizable() {
        jdiAssert(element().isNotResizable(), Matchers.is(false), "Element is not resizable");
        return this;
    }

    @JDIAction("Assert that '{name}' height '{0}'")
    public TextAreaAssert height(Matcher<Integer> condition) {
        int actualHeight = element().height();
        jdiAssert(actualHeight, condition, String.format("Actual height '%s' is not equal to expected '%s'",
                actualHeight, condition));
        return this;
    }

    @JDIAction("Assert that '{name}' rows count {0}")
    public TextAreaAssert rowsCount(int rowsCount) {
        int actualRowCount = element().rows();
        jdiAssert(actualRowCount, Matchers.is(rowsCount), String.format("Actual row count '%s' is not equal to expected '%s'",
                actualRowCount, rowsCount));
        return this;
    }

    @JDIAction("Assert that '{name}' has lines {0}")
    private TextAreaAssert lines(Matcher<? super List<String>> condition) {
        List<String> actualLines = element().getLines();
        jdiAssert(actualLines, condition, String.format("Actual lines '%s' doesn't contain expected lines '%s'",
                actualLines, condition));
        return this;
    }

    @JDIAction("Assert that '{name}' has lines {0}")
    public TextAreaAssert lines(String... lines) {
        return lines(containsInAnyOrder(lines));
    }

    @JDIAction("Assert that '{name}' has lines {0}")
    public TextAreaAssert lines(List<String> lines) {
        return lines(containsInAnyOrder(lines.toArray()));
    }

    @JDIAction("Assert that '{name}' has label")
    public TextAreaAssert hasLabel() {
        jdiAssert(element().hasLabel(), Matchers.is(true), "Element doesn't have label");
        return this;
    }

    @JDIAction("Assert that '{name}' has suffix")
    public TextAreaAssert suffix() {
        jdiAssert(element().hasSuffix(), Matchers.is(true), "Element doesn't have suffix");
        return this;
    }

    @JDIAction("Assert that '{name}' has not suffix")
    public TextAreaAssert notSuffix() {
        jdiAssert(element().hasSuffix(), Matchers.is(false), "Element has suffix");
        return this;
    }

    @JDIAction("Assert that '{name}' has suffix text '{0}'")
    public TextAreaAssert suffixText(String text) {
        String actualSuffixText = element().getSuffixText();
        jdiAssert(actualSuffixText, Matchers.equalTo(text), String.format("Element's actual suffix text '%s' is not " +
                "equal to expected '%s'", actualSuffixText, text));
        return this;
    }

    @JDIAction("Assert that '{name}' has prefix")
    public TextAreaAssert prefix() {
        jdiAssert(element().hasPrefix(), Matchers.is(true), "Element doesn't have prefix");
        return this;
    }

    @JDIAction("Assert that '{name}' has not prefix")
    public TextAreaAssert notPrefix() {
        jdiAssert(element().hasPrefix(), Matchers.is(false), "Element has prefix");
        return this;
    }

    @JDIAction("Assert that '{name}' has prefix text '{0}'")
    public TextAreaAssert prefixText(String text) {
        String actualPrefixText = element().getPrefixText();
        jdiAssert(actualPrefixText, Matchers.equalTo(text), String.format("Element's actual prefix text '%s' is not " +
                "equal to expected '%s'", actualPrefixText, text));
        return this;
    }

    @JDIAction("Assert that '{name}' has icon")
    public TextAreaAssert icon() {
        jdiAssert(element().hasIcon(), Matchers.is(true), "Element doesn't have icon");
        return this;
    }

    @JDIAction("Assert that '{name}' has not icon")
    public TextAreaAssert notIcon() {
        jdiAssert(element().hasIcon(), Matchers.is(false), "Element has icon");
        return this;
    }

    @JDIAction("Assert that '{name}' has prepend outer icon")
    public TextAreaAssert prependOuterIcon() {
        jdiAssert(element().hasPrependOuterIcon(), Matchers.is(true), "Element doesn't have prepend " +
                "outer icon");
        return this;
    }

    @JDIAction("Assert that '{name}' has prepend inner icon")
    public TextAreaAssert prependInnerIcon() {
        jdiAssert(element().hasPrependInnerIcon(), Matchers.is(true), "Element doesn't have prepend " +
                "inner icon");
        return this;
    }

    @JDIAction("Assert that '{name}' has append outer icon")
    public TextAreaAssert appendOuterIcon() {
        jdiAssert(element().hasAppendOuterIcon(), Matchers.is(true), "Element doesn't have append " +
                "outer icon");
        return this;
    }

    @JDIAction("Assert that '{name}' has append inner icon")
    public TextAreaAssert appendInnerIcon() {
        jdiAssert(element().hasAppendInnerIcon(), Matchers.is(true), "Element doesn't have append " +
                "inner icon");
        return this;
    }

    @JDIAction("Assert that '{name}' has placeholder")
    public TextAreaAssert placeholder() {
        jdiAssert(element().hasPlaceholder(), Matchers.is(true), "Element doesn't have placeholder");
        return this;
    }

    @JDIAction("Assert that '{name}' has not placeholder")
    public TextAreaAssert notPlaceholder() {
        jdiAssert(element().hasPlaceholder(), Matchers.is(false), "Element has placeholder");
        return this;
    }

    @JDIAction("Assert that '{name}' has placeholder text '{0}'")
    public TextAreaAssert placeholderText(String text) {
        String actualPlaceholderText = element().placeholder();
        jdiAssert(actualPlaceholderText, Matchers.equalTo(text), String.format("Element's actual placeholder text '%s' is not " +
                "equal to expected '%s'", actualPlaceholderText, text));
        return this;
    }

    @JDIAction("Assert that '{name}' has counter value '{0}'")
    public TextAreaAssert counterValue(int n) {
        int actualCounterValue = Integer.parseInt(element().counter().text());
        jdiAssert(actualCounterValue, Matchers.equalTo(n), String.format("Element's actual counter value '%s' is" +
                " not equal to expected '%s'", actualCounterValue, n));
        return this;
    }

    @JDIAction("Assert that '{name}' is autofocused")
    public TextAreaAssert autofocus() {
        jdiAssert(element().isAutofocus(), Matchers.is(true), "Element is not autofocus");
        return this;
    }

    @JDIAction("Assert that '{name}' is not autofocus")
    public TextAreaAssert notAutofocus() {
        jdiAssert(element().isAutofocus(), Matchers.is(false), "Element is not autofocus");
        return this;
    }

    @JDIAction("Assert that '{name}' is reversed")
    public TextAreaAssert reversed() {
        jdiAssert(element().isReversed(), Matchers.is(true), "Element is not reversed");
        return this;
    }

    @JDIAction("Assert that '{name}' is reversed")
    public TextAreaAssert notReversed() {
        jdiAssert(element().isReversed(), Matchers.is(false), "Element is reversed");
        return this;
    }

    @JDIAction("Assert that '{name}' is solo")
    public TextAreaAssert solo() {
        jdiAssert(element().isSolo(), Matchers.is(true), "Element is not solo");
        return this;
    }

    @JDIAction("Assert that '{name}' is not solo")
    public TextAreaAssert notSolo() {
        jdiAssert(element().isSolo(), Matchers.is(false), "Element is solo");
        return this;
    }

    @JDIAction("Assert that '{name}' is solo inverted")
    public TextAreaAssert soloInverted() {
        jdiAssert(element().isSoloInverted(), Matchers.is(true), "Element is not solo inverted");
        return this;
    }

    @JDIAction("Assert that '{name}' is not solo inverted")
    public TextAreaAssert notSoloInverted() {
        jdiAssert(element().isSoloInverted(), Matchers.is(false), "Element is solo inverted");
        return this;
    }

    @JDIAction("Assert that '{name}' is full-width")
    public TextAreaAssert fullWidth() {
        jdiAssert(element().isFullWidth(), Matchers.is(true), "Element is not full-width");
        return this;
    }

    @JDIAction("Assert that '{name}' is not full-width")
    public TextAreaAssert notFullWidth() {
        jdiAssert(element().isFullWidth(), Matchers.is(false), "Element is full-width");
        return this;
    }

    @JDIAction("Assert that '{name}' has details hidden")
    public TextAreaAssert detailsHidden() {
        jdiAssert(element().hasDetailsHidden(), Matchers.is(true), "Element has not details hidden");
        return this;
    }

    @JDIAction("Assert that '{name}' has not details hidden")
    public TextAreaAssert notDetailsHidden() {
        jdiAssert(element().hasDetailsHidden(), Matchers.is(false), "Element has details hidden");
        return this;
    }

    @JDIAction("Assert that '{name}' has loader height {0}")
    public TextAreaAssert loaderHeightPx(int height) {
        int actualLoaderHeight = element().getLoaderHeight();
        jdiAssert(actualLoaderHeight, Matchers.equalTo(height), String.format("Actual element's loader height " +
                "'%s px' is not equal to expected '%s px'", actualLoaderHeight, height));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    public TextAreaAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true), "Element is not disabled");
        return this;
    }

    @JDIAction("Assert that '{name}' is not disabled")
    public TextAreaAssert notDisabled() {
        jdiAssert(element().isDisabled(), Matchers.is(false), "Element is disabled");
        return this;
    }
}
