package com.epam.jdi.light.material.asserts.displaydata;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.Chip;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.containsString;

public class ChipAssert extends UIAssert<ChipAssert, Chip> {

    @JDIAction("Assert that chip {name} label is displayed")
    public ChipAssert displayed() {
        jdiAssert(element().getChipLabel().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that chip {name} label is not displayed")
    public ChipAssert notDisplayed() {
        jdiAssert(element().getChipLabel().isDisplayed(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that of chip label {name} text is '{0}'")
    public ChipAssert text(String text) {
        jdiAssert(element().getChipLabel().getText(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that chip {name} root is disabled")
    public ChipAssert disabled(){
        element().has().classValue(containsString("Mui-disabled"));
        return this;
    }

    @JDIAction("Assert that chip {name} is deletable")
    public ChipAssert deletable() {
        jdiAssert(element().isDeletable(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that chip {name} is not deletable")
    public ChipAssert notDeletable() {
        jdiAssert(element().isDeletable(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that chip {name} root is clickable")
    public ChipAssert clickable() {
        jdiAssert(element().getChipLabel().isClickable(), Matchers.is(true));
        return this;
    }
}
