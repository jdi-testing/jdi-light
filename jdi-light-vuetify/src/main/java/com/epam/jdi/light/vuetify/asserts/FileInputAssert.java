package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.FileInput;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class FileInputAssert extends TextFieldAssert {

    @Override
    public FileInput element() {
        return (FileInput) super.element();
    }

    @JDIAction("Assert that '{name}' can accept multiply files")
    public FileInputAssert multiply() {
        jdiAssert(element().isMultiply() ? "multiply" : "not multiply", Matchers.is("multiply"));
        return this;
    }

    @JDIAction("Assert that '{name}' has chips")
    public FileInputAssert chips() {
        jdiAssert(element().hasChips() ? "has chips" : "has no chips", Matchers.is("has chips"));
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
        jdiAssert(element().getText(), Matchers.is(file));
        return this;
    }

    @JDIAction("Assert that '{name}' has files {0}")
    public FileInputAssert files(Matcher<? super List<String>> condition) {
        jdiAssert(element().getFiles(), condition);
        return this;
    }

    @JDIAction("Assert that '{name}' has files {0}")
    public FileInputAssert files(List<String> files) {
        jdiAssert(element().getFiles(), Matchers.is(files));
        return this;
    }
}
