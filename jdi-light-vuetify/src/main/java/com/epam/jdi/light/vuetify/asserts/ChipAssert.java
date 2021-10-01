package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Chip;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ChipAssert extends UIAssert<ChipAssert, Chip> {

    @JDIAction("Assert that '{name}' is displayed'")
    public ChipAssert displayed() {
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is not displayed")
    public ChipAssert notDisplayed() {
        jdiAssert(element().isDisplayed(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that '{name}' contains '{0}'")
    public ChipAssert containsText(String text) {
        jdiAssert(element().getText(), Matchers.containsString(text));
        return this;
    }

    @JDIAction("Assert that '{name}' has background color with code '{0}'")
    public ChipAssert backgroundColor(String colorCode) {
        jdiAssert(element().getBackgroundColor(), Matchers.containsString(colorCode));
        return this;
    }

    @JDIAction("Assert that '{name}' has border color with code '{0}'")
    public ChipAssert borderColor(String colorCode) {
        jdiAssert(element().getBorderColor(), Matchers.containsString(colorCode));
        return this;
    }

    @JDIAction("Assert that '{name}' has filter")
    public ChipAssert visibleBorder() {
        jdiAssert(element().hasVisibleBorder(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has filter")
    public ChipAssert notVisibleBorder() {
        jdiAssert(element().hasVisibleBorder(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that '{name}' is draggable")
    public ChipAssert draggable() {
        jdiAssert(element().isDraggable(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has filter")
    public ChipAssert filter() {
        jdiAssert(element().hasFilter(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has not filter")
    public ChipAssert notFilter() {
        jdiAssert(element().hasFilter(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that '{name}' has icon")
    public ChipAssert icon() {
        jdiAssert(element().hasIcon(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has not icon")
    public ChipAssert notIcon() {
        jdiAssert(element().hasIcon(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that '{name}' has image")
    public ChipAssert image() {
        jdiAssert(element().hasImage(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has not image")
    public ChipAssert notImage() {
        jdiAssert(element().hasImage(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that '{name}' has height {0}")
    public ChipAssert height(Integer height) {
        jdiAssert(element().getHeight(), Matchers.equalToIgnoringCase(height + "px"));
        return this;
    }

    @JDIAction("Assert that '{name}' has font size {0}")
    public ChipAssert fontSize(Integer fontSize) {
        jdiAssert(element().getFontSize(), Matchers.equalToIgnoringCase(fontSize + "px"));
        return this;
    }

    @JDIAction("Assert that '{name}' has font size {0}")
    public ChipAssert fontColor(String colorcode) {
        jdiAssert(element().getFontColor(), Matchers.containsStringIgnoringCase(colorcode));
        return this;
    }
}
