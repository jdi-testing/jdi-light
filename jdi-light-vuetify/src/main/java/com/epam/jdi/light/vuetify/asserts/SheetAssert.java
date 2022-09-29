package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.composite.Sheet;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SheetAssert extends UIAssert<SheetAssert, Sheet> implements ITextAssert<SheetAssert> {

    @JDIAction("Assert that '{name}' has elevation value {0}")
    public SheetAssert elevation(int value) {
        if (element().isElevated()) {
            jdiAssert(element().elevation(), Matchers.is(value));
        }
        else {
            elevated();
        }
        return this;
    }

    @JDIAction("Assert that '{name}' is elevated")
    public SheetAssert elevated() {
        jdiAssert(element().isElevated() ? "elevated" : "not elevated", Matchers.is("elevated"));
        return this;
    }

    @JDIAction("Assert that '{name}' is rounded")
    public SheetAssert rounded() {
        jdiAssert(element().isRounded() ? "rounded" : "not rounded", Matchers.is("rounded"));
        return this;
    }


    @JDIAction("Assert that '{name}' is outlined")
    public SheetAssert outlined() {
        jdiAssert(element().isOutlined() ? "outlined" : "not outlined", Matchers.is("outlined"));
        return this;
    }

    @JDIAction("Assert that '{name}' is shaped")
    public SheetAssert shaped() {
        jdiAssert(element().isShaped() ? "shaped" : "not shaped", Matchers.is("shaped"));
        return this;
    }

    @JDIAction("Assert that '{name}' is tile")
    public SheetAssert tile() {
        jdiAssert(element().isTile() ? "tile" : "not tile", Matchers.is("tile"));
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


    @JDIAction("Assert that theme of '{name}' is light")
    public SheetAssert lightTheme() {
        jdiAssert(element().isLightTheme(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that theme of '{name}' is dark")
    public SheetAssert darkTheme() {
        jdiAssert(element().isDarkTheme(), Matchers.is(true));
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
