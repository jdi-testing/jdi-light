package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Alert;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class AlertAssert extends UIAssert<AlertAssert, Alert> implements ITextAssert<AlertAssert> {


    @JDIAction("Assert that '{name}' text {0}")
    public AlertAssert text(Matcher<String> condition) {
        jdiAssert(element().getText(), condition);
        return this;
    }

    public AlertAssert text(String text) {
        return text(Matchers.is(text));
    }

    @JDIAction("Assert that '{name}' has color '{0}'")
    public AlertAssert color(String color) {
        jdiAssert(element().color(), Matchers.is(color));
        return this;
    }

    @JDIAction("Assert that '{name}' has background color '{0}'")
    public AlertAssert backgroundColor(String color) {
        jdiAssert(element().backgroundColor(), Matchers.is(color));
        return this;
    }

    @JDIAction("Assert that theme of '{name}' is light")
    public AlertAssert lightTheme() {
        jdiAssert(element().isLightTheme() ? "light theme" : "dark theme", Matchers.is("light theme"));
        return this;
    }

    @JDIAction("Assert that theme of '{name}' is dark")
    public AlertAssert darkTheme() {
        jdiAssert(element().isDarkTheme() ? "dark theme" : "light theme", Matchers.is("dark theme"));
        return this;
    }

    @JDIAction("Assert that {name} is dense")
    public AlertAssert dense() {
        jdiAssert(element().isDense() ? "is dense" : "is not dense", Matchers.is("is dense"));
        return this;
    }

    @JDIAction("Assert that '{name}' height is '{0}'")
    public AlertAssert height(int height) {
        jdiAssert(element().height(), Matchers.is(height));
        return this;
    }

    @JDIAction("Assert that '{name}' width is '{0}'")
    public AlertAssert width(int width) {
        jdiAssert(element().width(), Matchers.is(width));
        return this;
    }

    @JDIAction("Assert that '{name}' has elevation value {0}")
    public AlertAssert elevation(int value) {
        if (element().isElevated()) {
            jdiAssert(element().elevation(), Matchers.is(value));
        } else {
            elevated();
        }
        return this;
    }

    @JDIAction("Assert that '{name}' is elevated")
    public AlertAssert elevated() {
        jdiAssert(element().isElevated() ? "elevated" : "not elevated", Matchers.is("elevated"));
        return this;
    }

    @JDIAction("Assert that '{name}' is outlined")
    public AlertAssert outlined() {
        jdiAssert(element().isOutlined() ? "outlined" : "not outlined", Matchers.is("outlined"));
        return this;
    }

    @JDIAction("Assert that '{name}' is rounded")
    public AlertAssert rounded() {
        jdiAssert(element().isRounded() ? "is rounded" : "is not rounded",
                Matchers.is("is rounded"));
        return this;
    }

    @JDIAction("Assert that '{name}' is shaped")
    public AlertAssert shaped() {
        jdiAssert(element().isShaped() ? "shaped" : "not shaped", Matchers.is("shaped"));
        return this;
    }

    @JDIAction("Assert that '{name}' is tile")
    public AlertAssert tile() {
        jdiAssert(element().isTile() ? "is tile" : "is not tile", Matchers.is("is tile"));
        return this;
    }

    @JDIAction("Assert that {name} is text styled")
    public AlertAssert textStyled() {
        jdiAssert(element().isTextStyled() ? "is text styled" : "is no text styled", Matchers.is("is text styled"));
        return this;
    }
}
