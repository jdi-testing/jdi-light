package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Chip;
import com.epam.jdi.light.asserts.generic.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MeasurementAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.OutlinedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ChipAssert extends UIAssert<ChipAssert, Chip> implements ColorAssert<ChipAssert, Chip>,
        OutlinedAssert<ChipAssert, Chip>, ThemeAssert<ChipAssert, Chip>, MeasurementAssert<ChipAssert, Chip>,
        ITextAssert<ChipAssert> {
    @Override
    @JDIAction(value = "Assert that '{name}' has text '{0}'", isAssert = true)
    public ChipAssert text(Matcher condition) {
        String actualText = element().getText();
        jdiAssert(actualText, condition);
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has border color with code '{0}'", isAssert = true)
    public ChipAssert borderColor(String color) {
        String actualBorderColor = element().borderColor();
        jdiAssert(element().borderColor(), Matchers.equalTo(color), String.format("Actual border color " +
                "'%s' is not equal to '%s'", actualBorderColor, color));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is draggable", isAssert = true)
    public ChipAssert draggable() {
        jdiAssert(element().isDraggable(), Matchers.is(true), "Element is not draggable");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not draggable", isAssert = true)
    public ChipAssert notDraggable() {
        jdiAssert(element().isDraggable(), Matchers.is(false), "Element is draggable");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is selected", isAssert = true)
    public ChipAssert selected() {
        jdiAssert(element().active(), Matchers.is(true), "Element is not selected");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not selected", isAssert = true)
    public ChipAssert deselected() {
        jdiAssert(element().active(), Matchers.is(false), "Element is selected");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is a label chip", isAssert = true)
    public ChipAssert label() {
        jdiAssert(element().isLabel(), Matchers.is(true), "Element is not label chip");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not a label chip", isAssert = true)
    public ChipAssert notLabel() {
        jdiAssert(element().isLabel(), Matchers.is(false), "Element is label chip");
        return this;
    }

    @JDIAction(value = "Assert that ''{name}' filter icon is displayed'", isAssert = true)
    public ChipAssert filterIconDisplayed() {
        jdiAssert(element().isFilterIconDisplayed(), Matchers.is(true), "Element's filter icon is not " +
                "displayed");
        return this;
    }

    @JDIAction(value = "Assert that ''{name}' filter icon is not displayed'", isAssert = true)
    public ChipAssert filterIconNotDisplayed() {
        jdiAssert(element().isFilterIconDisplayed(), Matchers.is(false), "Element's filter icon is " +
                "displayed");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has icon", isAssert = true)
    public ChipAssert icon() {
        jdiAssert(element().hasIcon(), Matchers.is(true), "Element has not icon");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has image", isAssert = true)
    public ChipAssert image() {
        jdiAssert(element().hasImage(), Matchers.is(true), "Element has not image");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' font size is equal to '{0} px'", isAssert = true)
    public ChipAssert fontSize(int fontSize) {
        int actualFontSize = element().fontSize();
        jdiAssert(actualFontSize, Matchers.equalTo(fontSize), String.format("Actual font size '%s px' is not equal " +
                "to expected font size '%s px'", actualFontSize, fontSize));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' size is x-small", isAssert = true)
    public ChipAssert xSmallSize() {
        jdiAssert(element().hasXSmallSize(), Matchers.is(true), "Element's size is not x-small");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' size is small", isAssert = true)
    public ChipAssert smallSize() {
        jdiAssert(element().hasSmallSize(), Matchers.is(true), "Element's size is not small");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' size is default", isAssert = true)
    public ChipAssert defaultSize() {
        jdiAssert(element().hasDefaultSize(), Matchers.is(true), "Element's size is not default");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' size is large", isAssert = true)
    public ChipAssert largeSize() {
        jdiAssert(element().hasLargeSize(), Matchers.is(true), "Element's size is not large");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' size is x-large", isAssert = true)
    public ChipAssert xLargeSize() {
        jdiAssert(element().hasXLargeSize(), Matchers.is(true), "Element's size is not x-large");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is removable", isAssert = true)
    public ChipAssert removable() {
        jdiAssert(element().isRemovable(), Matchers.is(true), "Element is not removable");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not removable", isAssert = true)
    public ChipAssert notRemovable() {
        jdiAssert(element().isRemovable(), Matchers.is(false), "Element is removable");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is pill", isAssert = true)
    public ChipAssert pill() {
        jdiAssert(element().isPill(), Matchers.is(true), "Element is not pill");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not pill", isAssert = true)
    public ChipAssert notPill() {
        jdiAssert(element().isPill(), Matchers.is(false), "Element is pill");
        return this;
    }
}
