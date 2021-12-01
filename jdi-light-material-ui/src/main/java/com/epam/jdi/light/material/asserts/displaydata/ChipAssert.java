package com.epam.jdi.light.material.asserts.displaydata;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.Chip;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ChipAssert extends UIAssert<ChipAssert, Chip> {

    @JDIAction("Assert that chip '{name}' label is displayed")
    public ChipAssert displayed() {
        jdiAssert(element().getChipLabel().isDisplayed() ? "is displayed" : "is not displayed",
                Matchers.is("is displayed"));
        return this;
    }

    @JDIAction("Assert that chip '{name}' label is not displayed")
    public ChipAssert notDisplayed() {
        jdiAssert(!element().getChipLabel().isDisplayed() ? "is not displayed" : "is displayed",
                Matchers.is("is not displayed"));
        return this;
    }

    @JDIAction("Assert that of chip label '{name}' text is '{0}'")
    public ChipAssert text(String text) {
        jdiAssert(element().getChipLabel().getText(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that chip '{name}' root is disabled")
    public ChipAssert disabled(){
        jdiAssert(element().isDisabled() ? "is disabled" : "is enabled", Matchers.is("is disabled"));
        return this;
    }

    @JDIAction("Assert that chip '{name}' is deletable")
    public ChipAssert deletable() {
        jdiAssert(element().isDeletable() ? "is deletable" : "is not deletable",
                Matchers.is("is deletable"));
        return this;
    }

    @JDIAction("Assert that chip '{name}' is not deletable")
    public ChipAssert notDeletable() {
        jdiAssert(!element().isDeletable() ? "is not deletable" : "is deletable",
                Matchers.is("is not deletable"));
        return this;
    }

    @JDIAction("Assert that chip '{name}' root is clickable")
    public ChipAssert clickable() {
        jdiAssert(element().getChipLabel().isClickable() ? "is clickable" : "is not clickable",
                Matchers.is("is clickable"));
        return this;
    }
    @JDIAction("Assert that chip '{name}' root is clickable")
    public ChipAssert primaryColor() {
        jdiAssert(element().hasPrimaryColor() ? "has primary color" : "does not have primary color",
                Matchers.is("has primary color"));
        return this;
    }
    @JDIAction("Assert that chip '{name}' root is clickable")
    public ChipAssert secondaryColor() {
        jdiAssert(element().hasSecondaryColor() ? "has secondary color" : "does not have secondary color",
                Matchers.is("has secondary color"));
        return this;
    }
}
