package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.FileInput;
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
import com.epam.jdi.light.vuetify.interfaces.asserts.ReverseAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.RoundedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ShapedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.SingleLineAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.SoloAssert;
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
        ThemeAssert<FileInputAssert, FileInput>, SoloAssert<FileInputAssert, FileInput>,
        FullWidthAssert<FileInputAssert, FileInput>, HideDetailsAssert<FileInputAssert, FileInput> {

    @JDIAction(value = "Assert that '{name}' is enabled", isAssert = true)
    public FileInputAssert enabled() {
        jdiAssert(element().isDisabled(), Matchers.is(false), "FileInput is disabled");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is disabled", isAssert = true)
    public FileInputAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true), "FileInput is enabled");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' accept {0}", isAssert = true)
    public FileInputAssert accept(Matcher<String> condition) {
        jdiAssert(element().accept(), condition);
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has file {0}", isAssert = true)
    public FileInputAssert file(Matcher<String> condition) {
        jdiAssert(element().getText(), condition);
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has file {0}", isAssert = true)
    public FileInputAssert file(String file) {
        return file(Matchers.is(file));
    }

    @JDIAction(value = "Assert that '{name}' has files {0}", isAssert = true)
    public FileInputAssert files(Matcher<? super List<String>> condition) {
        jdiAssert(element().getFiles(), condition);
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has files {0}", isAssert = true)
    public FileInputAssert files(List<String> files) {
        return files(Matchers.is(files));
    }

    @JDIAction(value = "Assert that '{name}' has label", isAssert = true)
    public FileInputAssert hasLabel() {
        jdiAssert(element().hasLabel(), Matchers.is(true), "There is no label for FileInput");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has label color '{0}'", isAssert = true)
    public FileInputAssert labelColor(String color) {
        jdiAssert(element().labelColor(), Matchers.equalTo(color));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has suffix text '{0}'", isAssert = true)
    public FileInputAssert suffixText(String suffixText) {
        jdiAssert(element().suffix().getText(), Matchers.equalTo(suffixText));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has prefix text '{0}'", isAssert = true)
    public FileInputAssert prefixText(String prefixText) {
        jdiAssert(element().prefix().getText(), Matchers.equalTo(prefixText));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has autofocus", isAssert = true)
    public FileInputAssert autofocus() {
        jdiAssert(element().isAutofocus(), Matchers.is(true), "FileInput has not autofocus");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has loader height {0}", isAssert = true)
    public FileInputAssert loaderHeightPx(int height) {
        jdiAssert(element().getLoaderHeight(), Matchers.equalTo(height));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has placeholder '{0}'", isAssert = true)
    public FileInputAssert placeholder(String placeholder) {
        jdiAssert(element().placeholder(), Matchers.equalTo(placeholder));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has truncated file name", isAssert = true)
    public FileInputAssert truncatedFileName() {
        jdiAssert(element().getText(), Matchers.containsString("..."));
        return this;
    }
}
