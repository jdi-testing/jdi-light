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

    @JDIAction("Assert that '{name}' can accept multiple files")
    public FileInputAssert multiple() {
        jdiAssert(element().isMultiple() ? "multiple" : "not multiple", Matchers.is("multiple"));
        return this;
    }

    @JDIAction("Assert that '{name}' accept {0}")
    public FileInputAssert accept(Matcher<String> condition) {
        jdiAssert(element().accept(), condition);
        return this;
    }

    @JDIAction("Assert that '{name}' has file {0}")
    public FileInputAssert file(Matcher<String> condition) {
        jdiAssert(element().getText(), condition);
        return this;
    }

    @JDIAction("Assert that '{name}' has file {0}")
    public FileInputAssert file(String file) {
        return file(Matchers.is(file));
    }

    @JDIAction("Assert that '{name}' has files {0}")
    public FileInputAssert files(Matcher<? super List<String>> condition) {
        jdiAssert(element().getFiles(), condition);
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

    @JDIAction("Assert that '{name}' has suffix text '{0}'")
    public FileInputAssert suffixText(String suffixText) {
        String actualSuffixText = element().suffix().getText();
        jdiAssert(actualSuffixText, Matchers.equalTo(suffixText), String.format("Actual suffix test '%s' is not equal" +
                " to expected suffix text '%s'", actualSuffixText, suffixText));
        return this;
    }

    @JDIAction("Assert that '{name}' has prefix text '{0}'")
    public FileInputAssert prefixText(String prefixText) {
        String actualPrefixText = element().prefix().getText();
        jdiAssert(actualPrefixText, Matchers.equalTo(prefixText), String.format("Actual suffix test '%s' is not equal" +
                " to expected suffix text '%s'", actualPrefixText, prefixText));
        return this;
    }

    @JDIAction("Assert that '{name}' has autofocus")
    public FileInputAssert autofocus() {
        jdiAssert(element().isAutofocused(), Matchers.is(true), "Element has not autofocus");
        return this;
    }

    @JDIAction("Assert that number of {name}'s error messages is {0}")
    public FileInputAssert numberOfErrorMessages(Integer n) {
        Integer actualNumberOfErrorMessages = element().getNumberErrorMessages();
        jdiAssert(actualNumberOfErrorMessages, Matchers.equalTo(n), String.format("Actual number of error messages %s "
                + "is not equal to %s", actualNumberOfErrorMessages, n));
        return this;
    }

    @JDIAction("Assert that '{name}' has error messages {0}")
    public FileInputAssert errorMessages(List<String> errorMessages) {
        List<String> actualErrorMessages = element().getErrorMessages();
        jdiAssert(actualErrorMessages, Matchers.equalTo(errorMessages), String.format("Actual element's messages %s "
                + "is not equal to expected messages %s", actualErrorMessages, errorMessages));
        return this;
    }

    @JDIAction("Assert that '{name}' has error messages {0}")
    public FileInputAssert errorMessage(String errorMessage) {
        jdiAssert(element().getErrorMessages().contains(errorMessage), Matchers.is(true), String.format("Actual element's error"
                + " messages %s doesn't contain expected message %s", element().getErrorMessages(), errorMessage));
        return this;
    }

    @JDIAction("Assert that '{name}' has success messages {0}")
    public FileInputAssert successMessages(List<String> successMessages) {
        jdiAssert(element().getSuccessMessages(), Matchers.equalTo(successMessages), String.format("Actual element's success"
                + " messages %s is not equal to expected messages %s", element().getSuccessMessages(), successMessages));
        return this;
    }

    @JDIAction("Assert that '{name}' has success message {0}")
    public FileInputAssert successMessage(String successMessage) {
        jdiAssert(element().getSuccessMessages().contains(successMessage), Matchers.is(true), String.format("Actual element's success"
                + " messages %s doesn't contain expected message %s", element().getSuccessMessages(), successMessage));
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

    @JDIAction("Assert that '{name}' has detailes hidden")
    public FileInputAssert detailsHidden() {
        jdiAssert(element().hasDetailsHidden(), Matchers.is(true), "Element has not details hidden");
        return this;
    }

    @JDIAction("Assert that '{name}' has details hidden")
    public FileInputAssert notDetailsHidden() {
        jdiAssert(element().hasDetailsHidden(), Matchers.is(false), "Element has details hidden");
        return this;
    }

    @JDIAction("Assert that '{name}' has loader height {0}")
    public FileInputAssert loaderHeight(String height) {
        String actualLoaderHeight = element().getLoaderHeight();
        jdiAssert(actualLoaderHeight, Matchers.equalTo(height), String.format("Actual element's loader height '%s'" +
                " is not equal to expected %s", actualLoaderHeight, height));
        return this;
    }

    @JDIAction("Assert that '{name}' has details hidden")
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
