package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.common.Chip;
import com.epam.jdi.light.angular.elements.enums.AngularColors;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ChipAssert extends UIAssert<ChipAssert, Chip> {

    @JDIAction("Assert that '{name}' is enabled")
    public ChipAssert selected() {
        jdiAssert(element().selected(), Matchers.is(true), "Element is not selected");
        return this;
    }

    @JDIAction("Assert that '{name}' is enabled")
    public ChipAssert deselected() {
        jdiAssert(element().selected(), Matchers.is(false), "Element is selected");
        return this;
    }

    @JDIAction("Assert that '{name}' is removable ")
    public ChipAssert removable() {
        jdiAssert(element().removable(), Matchers.is(true), "Element is not removable");
        return this;
    }

    @JDIAction("Assert that '{name}' is removable ")
    public ChipAssert notRemovable() {
        jdiAssert(element().removable(), Matchers.is(false), "Element is removable");
        return this;
    }

    @JDIAction("Assert that '{name}' has '{0}' color")
    public ChipAssert color(AngularColors color) {
        return cssClass(color.getStyle());
    }

    @JDIAction("Assert that '{name}' is focused ")
    public ChipAssert focused() {
        jdiAssert(element().focused(), Matchers.is(true), "Element is not focused");
        return this;
    }

    @JDIAction("Assert that '{name}' is highlighted ")
    public ChipAssert highlighted() {
        jdiAssert(element().highlighted(), Matchers.is(true), "Element is not highlighted");
        return this;
    }

    @JDIAction("Assert that '{name}' isn't highlighted ")
    public ChipAssert notHighlighted() {
        jdiAssert(element().highlighted(), Matchers.is(false), "Element is highlighted");
        return this;
    }

    @JDIAction("Assert that '{name}' isn't focused ")
    public ChipAssert notFocused() {
        jdiAssert(element().focused(), Matchers.is(false), "Element is focused");
        return this;
    }

    @JDIAction("Assert that '{name}' has avatar image")
    public ChipAssert image() {
        jdiAssert(element().hasImage(), Matchers.is(true), "Element is not avatar image");
        return this;
    }
}
