package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Chip;
import com.epam.jdi.light.vuetify.interfaces.asserts.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MeasurementAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.OutlinedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ChipAssert extends UIAssert<ChipAssert, Chip> implements ColorAssert<ChipAssert, Chip>,
        OutlinedAssert<ChipAssert, Chip>, ThemeAssert<ChipAssert, Chip>, MeasurementAssert<ChipAssert, Chip>,
        ITextAssert {
    @Override
    public ChipAssert text(Matcher condition) {
        String actualText = element().getText();
        jdiAssert(actualText, condition, String.format("Actual text '%s' is not equal to expected '%s'", actualText,
                condition));
        return this;
    }

    @JDIAction("Assert that '{name}' has border color with code '{0}'")
    public ChipAssert borderColor(String color) {
        String actualBorderColor = element().borderColor();
        jdiAssert(element().borderColor(), Matchers.equalTo(color), String.format("Actual border color " +
                "'%s' is not equal to '%s'", actualBorderColor, color));
        return this;
    }

    @JDIAction("Assert that '{name}' is draggable")
    public ChipAssert draggable() {
        jdiAssert(element().isDraggable(), Matchers.is(true), "Element is not draggable");
        return this;
    }

    @JDIAction("Assert that '{name}' is not draggable")
    public ChipAssert notDraggable() {
        jdiAssert(element().isDraggable(), Matchers.is(false), "Element is draggable");
        return this;
    }

    @JDIAction("Assert that '{name}' is selected")
    public ChipAssert selected() {
        jdiAssert(element().active(), Matchers.is(true), "Element is not selected");
        return this;
    }

    @JDIAction("Assert that '{name}' is not selected")
    public ChipAssert deselected() {
        jdiAssert(element().active(), Matchers.is(false), "Element is selected");
        return this;
    }

    @JDIAction("Assert that '{name}' is a label chip")
    public ChipAssert label() {
        jdiAssert(element().isLabel(), Matchers.is(true), "Element is not label chip");
        return this;
    }

    @JDIAction("Assert that '{name}' is not a label chip")
    public ChipAssert notLabel() {
        jdiAssert(element().isLabel(), Matchers.is(false), "Element is label chip");
        return this;
    }

    @JDIAction("Assert that ''{name}' filter icon is displayed'")
    public ChipAssert filterIconDisplayed() {
        jdiAssert(element().isFilterIconDisplayed(), Matchers.is(true), "Element's filter icon is not " +
                "displayed");
        return this;
    }

    @JDIAction("Assert that ''{name}' filter icon is not displayed'")
    public ChipAssert filterIconNotDisplayed() {
        jdiAssert(element().isFilterIconDisplayed(), Matchers.is(false), "Element's filter icon is " +
                "displayed");
        return this;
    }

    @JDIAction("Assert that '{name}' has icon")
    public ChipAssert icon() {
        jdiAssert(element().hasIcon(), Matchers.is(true), "Element has not icon");
        return this;
    }

    @JDIAction("Assert that '{name}' has image")
    public ChipAssert image() {
        jdiAssert(element().hasImage(), Matchers.is(true), "Element has not image");
        return this;
    }

    @JDIAction("Assert that '{name}' font size is equal to '{0} px'")
    public ChipAssert fontSize(int fontSize) {
        int actualFontSize = element().fontSize();
        jdiAssert(actualFontSize, Matchers.equalTo(fontSize), String.format("Actual font size '%s px' is not equal " +
                "to expected font size '%s px'", actualFontSize, fontSize));
        return this;
    }

    @JDIAction("Assert that '{name}' size is x-small")
    public ChipAssert xSmallSize() {
        jdiAssert(element().hasXSmallSize(), Matchers.is(true), "Element's size is not x-small");
        return this;
    }

    @JDIAction("Assert that '{name}' size is small")
    public ChipAssert smallSize() {
        jdiAssert(element().hasSmallSize(), Matchers.is(true), "Element's size is not small");
        return this;
    }

    @JDIAction("Assert that '{name}' size is default")
    public ChipAssert defaultSize() {
        jdiAssert(element().hasDefaultSize(), Matchers.is(true), "Element's size is not default");
        return this;
    }

    @JDIAction("Assert that '{name}' size is large")
    public ChipAssert largeSize() {
        jdiAssert(element().hasLargeSize(), Matchers.is(true), "Element's size is not large");
        return this;
    }

    @JDIAction("Assert that '{name}' size is x-large")
    public ChipAssert xLargeSize() {
        jdiAssert(element().hasXLargeSize(), Matchers.is(true), "Element's size is not x-large");
        return this;
    }

    @JDIAction("Assert that '{name}' is removable")
    public ChipAssert removable() {
        jdiAssert(element().isRemovable(), Matchers.is(true), "Element is not removable");
        return this;
    }

    @JDIAction("Assert that '{name}' is not removable")
    public ChipAssert notRemovable() {
        jdiAssert(element().isRemovable(), Matchers.is(false), "Element is removable");
        return this;
    }

    @JDIAction("Assert that '{name}' is pill")
    public ChipAssert pill() {
        jdiAssert(element().isPill(), Matchers.is(true), "Element is not pill");
        return this;
    }

    @JDIAction("Assert that '{name}' is not pill")
    public ChipAssert notPill() {
        jdiAssert(element().isPill(), Matchers.is(false), "Element is pill");
        return this;
    }
}
