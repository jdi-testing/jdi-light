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
        jdiAssert(element().getText(), condition);
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has border color with code '{0}'", isAssert = true)
    public ChipAssert borderColor(String color) {
        jdiAssert(element().borderColor(), Matchers.equalTo(color));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is draggable", isAssert = true)
    public ChipAssert draggable() {
        jdiAssert(element().isDraggable(), Matchers.is(true), "Chip is not draggable");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not draggable", isAssert = true)
    public ChipAssert notDraggable() {
        jdiAssert(element().isDraggable(), Matchers.is(false), "Chip is draggable");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is selected", isAssert = true)
    public ChipAssert selected() {
        jdiAssert(element().active(), Matchers.is(true), "Chip is not selected");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not selected", isAssert = true)
    public ChipAssert deselected() {
        jdiAssert(element().active(), Matchers.is(false), "Chip is selected");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is a label chip", isAssert = true)
    public ChipAssert label() {
        jdiAssert(element().isLabel(), Matchers.is(true), "Chip is not label chip");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not a label chip", isAssert = true)
    public ChipAssert notLabel() {
        jdiAssert(element().isLabel(), Matchers.is(false), "Chip is label chip");
        return this;
    }

    @JDIAction(value = "Assert that ''{name}' filter icon is displayed'", isAssert = true)
    public ChipAssert filterIconDisplayed() {
        jdiAssert(element().filter().isDisplayed(), Matchers.is(true),
                "Chip's filter icon is not displayed");
        return this;
    }

    @JDIAction(value = "Assert that ''{name}' filter icon is not displayed'", isAssert = true)
    public ChipAssert filterIconNotDisplayed() {
        jdiAssert(element().filter().isDisplayed(), Matchers.is(false),
                "Chip's filter icon is displayed");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has icon", isAssert = true)
    public ChipAssert icon() {
        jdiAssert(element().hasIcon(), Matchers.is(true), "Chip does not have icon");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has image", isAssert = true)
    public ChipAssert image() {
        jdiAssert(element().hasImage(), Matchers.is(true), "Chip does not have image");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' size is x-small", isAssert = true)
    public ChipAssert xSmallSize() {
        jdiAssert(element().hasXSmallSize(), Matchers.is(true), "Chip's size is not x-small");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' size is small", isAssert = true)
    public ChipAssert smallSize() {
        jdiAssert(element().hasSmallSize(), Matchers.is(true), "Chip's size is not small");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' size is default", isAssert = true)
    public ChipAssert defaultSize() {
        jdiAssert(element().hasDefaultSize(), Matchers.is(true), "Chip's size is not default");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' size is large", isAssert = true)
    public ChipAssert largeSize() {
        jdiAssert(element().hasLargeSize(), Matchers.is(true), "Chip's size is not large");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' size is x-large", isAssert = true)
    public ChipAssert xLargeSize() {
        jdiAssert(element().hasXLargeSize(), Matchers.is(true), "Chip's size is not x-large");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is removable", isAssert = true)
    public ChipAssert removable() {
        jdiAssert(element().isRemovable(), Matchers.is(true), "Chip is not removable");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not removable", isAssert = true)
    public ChipAssert notRemovable() {
        jdiAssert(element().isRemovable(), Matchers.is(false), "Chip is removable");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is pill", isAssert = true)
    public ChipAssert pill() {
        jdiAssert(element().isPill(), Matchers.is(true), "Chip is not pill");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not pill", isAssert = true)
    public ChipAssert notPill() {
        jdiAssert(element().isPill(), Matchers.is(false), "Chip is pill");
        return this;
    }
}
