package com.epam.jdi.light.material.asserts.displaydata;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.Chip;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ChipAssert extends UIAssert<ChipAssert, Chip> {

    @JDIAction("Assert that '{name}' is deletable")
    public ChipAssert deletable() {
        jdiAssert(element().isDeletable() ? "is deletable" : "is not deletable",
                Matchers.is("is deletable"));
        return this;
    }

    @JDIAction("Assert that '{name}' is clickable")
    public ChipAssert clickable() {
        jdiAssert(element().isClickable() ? "is clickable" : "is not clickable",
                Matchers.is("is clickable"));
        return this;
    }

    @JDIAction("Assert that '{name}' is link")
    public ChipAssert link() {
        jdiAssert(element().isLink() ? "element is link" : "element is not link",
                Matchers.is("element is link"));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected href")
    public ChipAssert href(String href) {
        jdiAssert(element().href(), Matchers.is(href));
        return this;
    }
}
