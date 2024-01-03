package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.Combobox;
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
import com.epam.jdi.light.vuetify.interfaces.asserts.MultipleAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.OutlinedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ReadOnlyAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ReverseAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.RoundedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ShapedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.SingleLineAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.SoloAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ComboboxAssert extends UIAssert<ComboboxAssert, Combobox> implements LoadingAssert<ComboboxAssert, Combobox>,
        ClearableAssert<ComboboxAssert, Combobox>, SingleLineAssert<ComboboxAssert, Combobox>,
        ReverseAssert<ComboboxAssert, Combobox>, MultipleAssert<ComboboxAssert, Combobox>,
        FilledAssert<ComboboxAssert, Combobox>, ReadOnlyAssert<ComboboxAssert, Combobox>,
        MessagesAssert<ComboboxAssert, Combobox>, DenseAssert<ComboboxAssert, Combobox>,
        OutlinedAssert<ComboboxAssert, Combobox>, SoloAssert<ComboboxAssert, Combobox>,
        FullWidthAssert<ComboboxAssert, Combobox>, ColorAssert<ComboboxAssert, Combobox>,
        ThemeAssert<ComboboxAssert, Combobox>, FlatAssert<ComboboxAssert, Combobox>,
        MeasurementAssert<ComboboxAssert, Combobox>, RoundedAssert<ComboboxAssert, Combobox>,
        ShapedAssert<ComboboxAssert, Combobox>, HideDetailsAssert<ComboboxAssert, Combobox> {

    @JDIAction(value = "Assert that '{name}' is expanded", isAssert = true)
    public ComboboxAssert expanded() {
        jdiAssert(element().isExpanded(), Matchers.is(true), "Element is closed");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is closed", isAssert = true)
    public ComboboxAssert closed() {
        jdiAssert(element().isExpanded(), Matchers.is(false), "Element is expanded");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is selected", isAssert = true)
    public ComboboxAssert selected(String value) {
        jdiAssert(element().isSelected(value), Matchers.is(true), String.format("Value '%s' is not selected",
                value));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is selected", isAssert = true)
    public ComboboxAssert selected(List<String> values) {
        jdiAssert(element().isSelected(values), Matchers.is(true), String.format("Values '%s' are not selected",
                values));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not selected", isAssert = true)
    public ComboboxAssert notSelected(String value) {
        jdiAssert(element().isSelected(value), Matchers.is(false), String.format("Value '%s' is selected",
                value));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not selected", isAssert = true)
    public ComboboxAssert notSelected(List<String> values) {
        jdiAssert(element().isSelected(values), Matchers.is(false), String.format("Values '%s' are selected",
                values));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' label is '{0}'", isAssert = true)
    public ComboboxAssert label(String text) {
        String actualLabelText = element().label().getText();
        jdiAssert(actualLabelText, Matchers.is(text), String.format("Actual label text '%s' is not equal to expected " +
                "'%s'", actualLabelText, text));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is error", isAssert = true)
    public ComboboxAssert error() {
        jdiAssert(element().isError(), Matchers.is(true), "Element is not error");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not error", isAssert = true)
    public ComboboxAssert notError() {
        jdiAssert(element().isError(), Matchers.is(false), "Element is error");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is success", isAssert = true)
    public ComboboxAssert success() {
        jdiAssert(element().isSuccess(), Matchers.is(true), "Element is not success");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not success", isAssert = true)
    public ComboboxAssert notSuccess() {
        jdiAssert(element().isSuccess(), Matchers.is(false), "Element is success");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has chips", isAssert = true)
    public ComboboxAssert chips() {
        jdiAssert(element().hasChips(), Matchers.is(true), "Element has no chips");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no chips", isAssert = true)
    public ComboboxAssert noChips() {
        jdiAssert(element().hasChips(), Matchers.is(false), "Element has chips");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has small chips", isAssert = true)
    public ComboboxAssert smallChips() {
        jdiAssert(element().hasSmallChips(), Matchers.is(true), "Element has no small chips");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no small chips", isAssert = true)
    public ComboboxAssert noSmallChips() {
        jdiAssert(element().hasSmallChips(), Matchers.is(false), "Element has small chips");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has placeholder", isAssert = true)
    public ComboboxAssert placeholder() {
        jdiAssert(element().hasPlaceholder(), Matchers.is(true), "Element has no placeholder");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no placeholder", isAssert = true)
    public ComboboxAssert noPlaceholder() {
        jdiAssert(element().hasPlaceholder(), Matchers.is(false), "Element has placeholder");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has placeholder '{0}'", isAssert = true)
    public ComboboxAssert placeholder(String placeholder) {
        String actualPlaceholder = element().placeholder();
        jdiAssert(actualPlaceholder, Matchers.equalTo(placeholder), String.format("Element's actual placeholder " +
                "'%s' is not equal to expected '%s'", actualPlaceholder, placeholder));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is autofocus", isAssert = true)
    public ComboboxAssert autofocus() {
        jdiAssert(element().isAutofocus(), Matchers.is(true), "Element is not autofocus");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not autofocus", isAssert = true)
    public ComboboxAssert notAutofocus() {
        jdiAssert(element().isAutofocus(), Matchers.is(false), "Element is autofocus");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has counter", isAssert = true)
    public ComboboxAssert counter() {
        jdiAssert(element().hasCounter(), Matchers.is(true), "Element has no counter");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no counter", isAssert = true)
    public ComboboxAssert noCounter() {
        jdiAssert(element().hasCounter(), Matchers.is(false), "Element has counter");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has counter value '{0}'", isAssert = true)
    public ComboboxAssert counterValue(String value) {
        String actualCounterValue = element().hasCounterValue();
        jdiAssert(actualCounterValue, Matchers.equalTo(value), String.format("Element's actual counter " +
                "value '%s' is not equal to expected '%s'", actualCounterValue, value));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has prefix", isAssert = true)
    public ComboboxAssert prefix() {
        jdiAssert(element().hasPrefix(), Matchers.is(true), "Element has no prefix");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no prefix", isAssert = true)
    public ComboboxAssert noPrefix() {
        jdiAssert(element().hasPrefix(), Matchers.is(false), "Element has prefix");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has prefix '{0}'", isAssert = true)
    public ComboboxAssert prefix(String text) {
        String actualPrefixText = element().getPrefixText();
        jdiAssert(actualPrefixText, Matchers.equalTo(text), String.format("Element's actual prefix text '%s' is not " +
                "equal to expected '%s'", actualPrefixText, text));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has suffix", isAssert = true)
    public ComboboxAssert suffix() {
        jdiAssert(element().hasSuffix(), Matchers.is(true), "Element has no suffix");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no suffix", isAssert = true)
    public ComboboxAssert noSuffix() {
        jdiAssert(element().hasSuffix(), Matchers.is(false), "Element has suffix");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has suffix '{0}'", isAssert = true)
    public ComboboxAssert suffix(String text) {
        String actualSuffixText = element().getSuffixText();
        jdiAssert(actualSuffixText, Matchers.equalTo(text), String.format("Element's actual suffix text '%s' is not " +
                "equal to expected '%s'", actualSuffixText, text));
        return this;
    }
}
