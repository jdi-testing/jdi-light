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
}
