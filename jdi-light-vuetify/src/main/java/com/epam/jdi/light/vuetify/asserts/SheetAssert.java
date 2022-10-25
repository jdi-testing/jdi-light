package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.composite.Sheet;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.TileAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ShapedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.OutlinedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ElevatedAssert;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SheetAssert extends UIAssert<SheetAssert, Sheet> implements ITextAssert<SheetAssert>,
        ThemeAssert<SheetAssert, Sheet>, TileAssert<SheetAssert, Sheet>,
        ShapedAssert<SheetAssert, Sheet>, OutlinedAssert<SheetAssert, Sheet>,
        ElevatedAssert<SheetAssert, Sheet> {

    @JDIAction("Assert that '{name}' is rounded")
    public SheetAssert rounded() {
        jdiAssert(element().isRounded() ? "rounded" : "not rounded", Matchers.is("rounded"));
        return this;
    }

    @JDIAction("Assert that '{name}' border radius is {0}")
    public SheetAssert borderRadius(int value) {
        jdiAssert(element().borderRadius(), Matchers.is(value));
        return this;
    }

    @JDIAction("Assert that '{name}' has color {0}")
    public SheetAssert color(String color) {
        jdiAssert(element().color(), Matchers.is(color));
        return this;
    }

    @Override
    public SheetAssert text(Matcher<String> condition) {
        jdiAssert(element().getText(), condition);
        return this;
    }

    @Override
    public SheetAssert text(String text) {
        text(Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}' height is '{0}'")
    public SheetAssert height(int height) {
        jdiAssert(element().height(), Matchers.is(height));
        return this;
    }

    @JDIAction("Assert that '{name}' width is '{0}'")
    public SheetAssert width(int width) {
        jdiAssert(element().width(), Matchers.is(width));
        return this;
    }
}
