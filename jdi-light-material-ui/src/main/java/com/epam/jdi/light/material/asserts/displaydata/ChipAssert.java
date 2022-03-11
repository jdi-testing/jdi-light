package com.epam.jdi.light.material.asserts.displaydata;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.Chip;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ChipAssert extends UIAssert<ChipAssert, Chip> {

    @JDIAction("Assert that '{name}' is displayed")
    public ChipAssert displayed() {
        jdiAssert(element().isDisplayed() ? "is displayed" : "is not displayed",
                Matchers.is("is displayed"));
        return this;
    }

    @JDIAction("Assert that '{name}' is not visible by user")
    public ChipAssert notVisible() {
        jdiAssert(element().isNotVisible() ? "is not visible" : "is visible",
                Matchers.is("is not visible"));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    public ChipAssert disabled(){
        jdiAssert(element().isDisabled() ? "is disabled" : "is enabled", Matchers.is("is disabled"));
        return this;
    }

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

    @JDIAction("Assert that '{name}' is not clickable")
    public ChipAssert notClickable() {
        jdiAssert(!element().isClickable() ? "is not clickable" : "is clickable",
                Matchers.is("is not clickable"));
        return this;
    }

    @JDIAction("Assert that '{name}' is outlined")
    public ChipAssert outlined() {
        jdiAssert(element().isOutlined() ? "is outlined" : "is not outlined",
                Matchers.is("is outlined"));
        return this;
    }

    @JDIAction("Assert that '{name}' has primary color")
    public ChipAssert primaryColor() {
        jdiAssert(element().hasPrimaryColor() ? "has primary color" : "does not have primary color",
                Matchers.is("has primary color"));
        return this;
    }

    @JDIAction("Assert that '{name}' has secondary color")
    public ChipAssert secondaryColor() {
        jdiAssert(element().hasSecondaryColor() ? "has secondary color" : "does not have secondary color",
                Matchers.is("has secondary color"));
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
