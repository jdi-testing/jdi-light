package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.FileInput;
import com.epam.jdi.light.vuetify.interfaces.asserts.ClearableAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.DenseAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.FilledAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.FlatAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.LoadingAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MeasurementAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MessagesAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MultipleAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.OutlinedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ReverseAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.RoundedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ShapedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.SingleLineAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class FileInputAssert extends UIAssert<FileInputAssert, FileInput>
        implements ClearableAssert<FileInputAssert, FileInput>, ColorAssert<FileInputAssert, FileInput>,
        DenseAssert<FileInputAssert, FileInput>, FilledAssert<FileInputAssert, FileInput>,
        FlatAssert<FileInputAssert, FileInput>, LoadingAssert<FileInputAssert, FileInput>,
        MeasurementAssert<FileInputAssert, FileInput>, MessagesAssert<FileInputAssert, FileInput>,
        MultipleAssert<FileInputAssert, FileInput>, OutlinedAssert<FileInputAssert, FileInput>,
        ReverseAssert<FileInputAssert, FileInput>, RoundedAssert<FileInputAssert, FileInput>,
        ShapedAssert<FileInputAssert, FileInput>, SingleLineAssert<FileInputAssert, FileInput>,
        ThemeAssert<FileInputAssert, FileInput> {

    @JDIAction("Assert that '{name}' is enabled")
    public FileInputAssert enabled() {
        jdiAssert(element().isDisabled(), Matchers.is(false), "Element is disabled");
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    public FileInputAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true), "Element is enabled");
        return this;
    }

    @JDIAction("Assert that '{name}' accept {0}")
    public FileInputAssert accept(Matcher<String> condition) {
        String elementAccepts = element().accept();
        jdiAssert(elementAccepts, condition, String.format("Element accepts '%s'. It doesn't accept '%s'",
                elementAccepts, condition));
        return this;
    }

    @JDIAction("Assert that '{name}' has file {0}")
    public FileInputAssert file(Matcher<String> condition) {
        String elementsActualConditions = element().getText();
        jdiAssert(elementsActualConditions, condition, String.format("Element's actual files '%s' don't contain " +
                "expected '%s'", elementsActualConditions, condition));
        return this;
    }

    @JDIAction("Assert that '{name}' has file {0}")
    public FileInputAssert file(String file) {
        return file(Matchers.is(file));
    }

    @JDIAction("Assert that '{name}' has files {0}")
    public FileInputAssert files(Matcher<? super List<String>> condition) {
        List<String> actualFiles = element().getFiles();
        jdiAssert(element().getFiles(), condition, String.format("Element's actual files '%s' don't contain " +
                "expected '%s'", actualFiles, condition));
        return this;
    }

    @JDIAction("Assert that '{name}' has files {0}")
    public FileInputAssert files(List<String> files) {
        return files(Matchers.is(files));
    }

    @JDIAction("Assert that '{name}' has label")
    public FileInputAssert hasLabel() {
        jdiAssert(element().hasLabel(), Matchers.is(true), "There is no label for element");
        return this;
    }

    @JDIAction("Assert that '{name}' has label color '{0}'")
    public FileInputAssert labelColor(String color) {
        String actualLabelColor = element().labelColor();
        jdiAssert(actualLabelColor, Matchers.equalTo(color), String.format("Actual label color '%s' " +
                "is not equal to '%s'", actualLabelColor, color));
        return this;
    }

    @JDIAction("Assert that '{name}' has suffix text '{0}'")
    public FileInputAssert suffixText(String suffixText) {
        String actualSuffixText = element().suffix().getText();
        jdiAssert(actualSuffixText, Matchers.equalTo(suffixText), String.format("Actual suffix text '%s' is not equal" +
                " to expected suffix text '%s'", actualSuffixText, suffixText));
        return this;
    }

    @JDIAction("Assert that '{name}' has prefix text '{0}'")
    public FileInputAssert prefixText(String prefixText) {
        String actualPrefixText = element().prefix().getText();
        jdiAssert(actualPrefixText, Matchers.equalTo(prefixText), String.format("Actual prefix text '%s' is not equal" +
                " to expected suffix text '%s'", actualPrefixText, prefixText));
        return this;
    }

    @JDIAction("Assert that '{name}' has autofocus")
    public FileInputAssert autofocus() {
        jdiAssert(element().isAutofocused(), Matchers.is(true), "Element has not autofocus");
        return this;
    }

    @JDIAction("Assert that '{name}' is full-width")
    public FileInputAssert fullWidth() {
        jdiAssert(element().isFullWidth(), Matchers.is(true), "Element is not full-width");
        return this;
    }

    @JDIAction("Assert that '{name}' is not full-width")
    public FileInputAssert notFullWidth() {
        jdiAssert(element().isFullWidth(), Matchers.is(false), "Element is full-width");
        return this;
    }

    @JDIAction("Assert that '{name}' has details hidden")
    public FileInputAssert detailsHidden() {
        jdiAssert(element().hasDetailsHidden(), Matchers.is(true), "Element has not details hidden");
        return this;
    }

    @JDIAction("Assert that '{name}' has not details hidden")
    public FileInputAssert notDetailsHidden() {
        jdiAssert(element().hasDetailsHidden(), Matchers.is(false), "Element has details hidden");
        return this;
    }

    @JDIAction("Assert that '{name}' has loader height {0}")
    public FileInputAssert loaderHeightPx(int height) {
        int actualLoaderHeight = element().getLoaderHeight();
        jdiAssert(actualLoaderHeight, Matchers.equalTo(height), String.format("Actual element's loader height '%s'" +
                " is not equal to expected %s", actualLoaderHeight + "px", height + "px"));
        return this;
    }

    @JDIAction("Assert that '{name}' has placeholder '{0}'")
    public FileInputAssert placeholder(String placeholder) {
        String actualPlaceholder = element().placeholder();
        jdiAssert(actualPlaceholder, Matchers.equalTo(placeholder), String.format("Element's actual" +
                " placeholder '%s' is not equal to expected '%s'", actualPlaceholder, placeholder));
        return this;
    }

    @JDIAction("Assert that '{name}' is solo")
    public FileInputAssert solo() {
        jdiAssert(element().isSolo(), Matchers.is(true), "Element is not solo");
        return this;
    }

    @JDIAction("Assert that '{name}' is not solo")
    public FileInputAssert notSolo() {
        jdiAssert(element().isSolo(), Matchers.is(false), "Element is solo");
        return this;
    }

    @JDIAction("Assert that '{name}' is solo-inverted")
    public FileInputAssert soloInverted() {
        jdiAssert(element().isSoloInverted(), Matchers.is(true), "Element is not solo-inverted");
        return this;
    }

    @JDIAction("Assert that '{name}' is not solo-inverted")
    public FileInputAssert notSoloInverted() {
        jdiAssert(element().isSoloInverted(), Matchers.is(false), "Element is solo-inverted");
        return this;
    }

    @JDIAction("Assert that '{name}' has truncated file name")
    public FileInputAssert truncatedFileName() {
        String fileInputText = element().getText();
        jdiAssert(fileInputText.contains("…"), Matchers.is(true), String.format(
                "File input text '%s' is not truncated", fileInputText));
        return this;
    }
}
