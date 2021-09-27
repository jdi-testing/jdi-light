package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Chip;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ChipAssert extends UIAssert<ChipAssert, Chip> {

    @JDIAction("Assert that '{name}' contains '{0}'")
    public ChipAssert containsText(String text) {
        jdiAssert(element().getText(), Matchers.containsString(text));
        return this;
    }

    @JDIAction("Assert that '{name}' has filter")
    public ChipAssert filter() {
        jdiAssert(element().hasFilter(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has filter")
    public ChipAssert notFilter() {
        jdiAssert(element().hasFilter(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that '{name}' has icon")
    public ChipAssert icon() {
        jdiAssert(element().hasIcon(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has icon")
    public ChipAssert notIcon() {
        jdiAssert(element().hasIcon(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that '{name}' has image")
    public ChipAssert image() {
        jdiAssert(element().hasImage(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has image")
    public ChipAssert notImage() {
        jdiAssert(element().hasImage(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that '{name}' has image")
    public ChipAssert fontSize(Integer fontSize) {
        jdiAssert(element().fontSize(), Matchers.equalToIgnoringCase(fontSize + "px"));
        return this;
    }
}
