package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Chip;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ChipAssert extends UIAssert<ChipAssert, Chip> {

    //For simple (not composite) label
    @JDIAction("Assert that {name}'s label contains '{0}'")
    public ChipAssert containsText(String text) {
        jdiAssert(element().getText(), Matchers.containsString(text));
        return this;
    }

    @JDIAction("Assert that {name}'s composite label contains '{0}'")
    public ChipAssert compositeLabelContainsText(String text) {
        jdiAssert(element().getFullTextFromCompositeLabel(), Matchers.containsString(text));
        return this;
    }

    @JDIAction("Assert that bold text from {name}'s composite label contains '{0}'")
    public ChipAssert compositeLabelBoldTextContains(String text) {
        jdiAssert(element().getBoldTextFromCompositeLabel(), Matchers.containsString(text));
        return this;
    }

    @JDIAction("Assert that regular text from {name}'s composite label contains '{0}'")
    public ChipAssert compositeLabelRegularTextContains(String text) {
        jdiAssert(element().getRegularTextFromCompositeLabel(), Matchers.containsString(text));
        return this;
    }

    @JDIAction("Assert that '{name}' has background color with code '{0}'")
    public ChipAssert backgroundColor(String colorCode) {
        jdiAssert(element().backgroundColor(), Matchers.containsString(colorCode));
        return this;
    }

    @JDIAction("Assert that '{name}' has border color with code '{0}'")
    public ChipAssert borderColor(String colorCode) {
        jdiAssert(element().borderColor(), Matchers.containsString(colorCode));
        return this;
    }

    @JDIAction("Assert that '{name}' has border color name '{0}'")
    public ChipAssert colorName(String colorName) {
        jdiAssert(element().colorName(), Matchers.containsString(colorName));
        return this;
    }

    @JDIAction("Assert that '{name}' has visible border")
    public ChipAssert visibleBorder() {
        jdiAssert(element().hasVisibleBorder() ? "has visible border" : "has no visible border",
                Matchers.is("has visible border"));
        return this;
    }

    @JDIAction("Assert that '{name}' is draggable")
    public ChipAssert draggable() {
        jdiAssert(element().isDraggable() ? "draggable" : "not draggable", Matchers.is("draggable"));
        return this;
    }

    @JDIAction("Assert that '{name}' is not draggable")
    public ChipAssert notDraggable() {
        jdiAssert(element().isDraggable() ? "draggable" : "not draggable", Matchers.is("not draggable"));
        return this;
    }

    @JDIAction("Assert that '{name}' is active")
    public ChipAssert selected() {
        jdiAssert(element().selected() ? "active" : "not active", Matchers.is("active"));
        return this;
    }

    @JDIAction("Assert that '{name}' is active")
    public ChipAssert deselected() {
        jdiAssert(element().selected() ? "active" : "not active", Matchers.is("not active"));
        return this;
    }

    @JDIAction("Assert that '{name}' is a label chip")
    public ChipAssert label() {
        jdiAssert(element().isLabel() ? "label" : "not label", Matchers.is("label"));
        return this;
    }

    @JDIAction("Assert that '{name} filter icon is displayed'")
    public ChipAssert filterIconDisplayed() {
        jdiAssert(element().isFilterIconDisplayed() ? "icon displayed" : "icon not displayed", Matchers.is("icon displayed"));
        return this;
    }

    @JDIAction("Assert that '{name}' has icon")
    public ChipAssert icon() {
        jdiAssert(element().hasIcon() ? "has icon" : "has no icon", Matchers.is("has icon"));
        return this;
    }

    @JDIAction("Assert that '{name}' has image")
    public ChipAssert image() {
        jdiAssert(element().hasImage() ? "has image" : "has no image", Matchers.is("has image"));
        return this;
    }

    @JDIAction("Assert that '{name}' has height {0} px")
    public ChipAssert height(int height) {
        jdiAssert(element().height(), Matchers.equalToIgnoringCase(height + "px"));
        return this;
    }

    @JDIAction("Assert that '{name}' font size is equal to {0} px")
    public ChipAssert fontSize(int fontSize) {
        jdiAssert(element().fontSize(), Matchers.equalToIgnoringCase(fontSize + "px"));
        return this;
    }

    @JDIAction("Assert that '{name}' has font color {0}")
    public ChipAssert fontColor(String colorcode) {
        jdiAssert(element().fontColor(), Matchers.containsStringIgnoringCase(colorcode));
        return this;
    }

    @JDIAction("Assert that '{name}' is removable")
    public ChipAssert removable() {
        jdiAssert(element().isRemovable(), Matchers.is(true));
        return this;
    }

    @Override
    @JDIAction("Assert that '{name}' is displayed")
    public ChipAssert displayed() {
        jdiAssert(element().isDisplayed() ? "is displayed" : "is hidden", Matchers.is("is displayed"));
        return this;
    }
}
