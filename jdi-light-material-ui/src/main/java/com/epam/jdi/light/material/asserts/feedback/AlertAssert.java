package com.epam.jdi.light.material.asserts.feedback;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.feedback.Alert;
import com.epam.jdi.light.material.elements.utils.enums.Severity;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class AlertAssert extends UIAssert<AlertAssert, Alert> {
    @JDIAction("Assert that '{name}' text like {0}")
    public AlertAssert text(Matcher<String> condition) {
        jdiAssert(element().text(), condition);
        return this;
    }

    @JDIAction("Assert that '{name}' text like {0}")
    public AlertAssert text(String text) {
        jdiAssert(element().text(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}' title like {0}")
    public AlertAssert title(Matcher<String> condition) {
        jdiAssert(element().title(), condition);
        return this;
    }

    @JDIAction("Assert that '{name}' title is {0}")
    public AlertAssert title(String text) {
        jdiAssert(element().title(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}' has title")
    public AlertAssert hasTitle() {
        jdiAssert(element().hasTitle(), Matchers.is(true), "Alert has not title");
        return this;
    }

    @JDIAction("Assert that '{name}' has no title")
    public AlertAssert hasNoTitle() {
        jdiAssert(element().hasTitle(), Matchers.is(false), "Alert has title");
        return this;
    }

    @JDIAction("Assert that '{name}' severity is {0}")
    public AlertAssert severity(Severity value) {
        jdiAssert(element().severity(), Matchers.is(value));
        return this;
    }

    @JDIAction("Assert that '{name}' title is {0}")
    public AlertAssert notSeverity(Severity value) {
        jdiAssert(element().severity(), Matchers.not(Matchers.is(value)));
        return this;
    }


}
