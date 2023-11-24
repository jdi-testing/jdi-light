package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.VueCheckbox;
import com.epam.jdi.light.asserts.generic.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.DenseAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MessagesAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ReadOnlyAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class VueCheckboxAssert extends UIAssert<VueCheckboxAssert, VueCheckbox> implements ThemeAssert<VueCheckboxAssert, VueCheckbox>,
        ColorAssert<VueCheckboxAssert, VueCheckbox>, DenseAssert<VueCheckboxAssert, VueCheckbox>,
        MessagesAssert<VueCheckboxAssert, VueCheckbox>, ReadOnlyAssert<VueCheckboxAssert, VueCheckbox> {

    @JDIAction("Assert that '{name}' is enabled")
    public VueCheckboxAssert enabled() {
        jdiAssert(element().isDisabled(), Matchers.is(false), "Element is disabled");
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    public VueCheckboxAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true), "Element is enabled");
        return this;
    }

    @JDIAction("Assert that '{name}' is checked")
    public VueCheckboxAssert checked() {
        jdiAssert(element().isChecked(), Matchers.is(true), "Element is unchecked");
        return this;
    }

    @JDIAction("Assert that '{name}' is not checked")
    public VueCheckboxAssert unchecked() {
        jdiAssert(element().isChecked(), Matchers.is(false), "Element is checked");
        return this;
    }

    @JDIAction("Assert that '{name}' has '{0}' label")
    public VueCheckboxAssert label(String text) {
        new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isDisplayed());
        String actualLabelText = element().labelText();
        jdiAssert(actualLabelText, equalToIgnoringCase(text), String.format("Element's actual label text '%s' is " +
                "not equal to expected '%s'", actualLabelText, text));
        return this;
    }

    @JDIAction("Assert that '{name}' label contains '{text}'")
    public VueCheckboxAssert labelContains(String text) {
        String actualLabelText = element().labelText();
        jdiAssert(actualLabelText, Matchers.containsString(text), String.format("Element's actual label text '%s' " +
                "doesn't contain expected text '%s'", actualLabelText, text));
        return this;
    }

    @JDIAction("Assert that '{name}' is indeterminate")
    public VueCheckboxAssert indeterminate() {
        jdiAssert(element().isIndeterminate(), Matchers.is(true), "Element is not indeterminate");
        return this;
    }

    @JDIAction("Assert that '{name}' is not indeterminate")
    public VueCheckboxAssert notIndeterminate() {
        jdiAssert(element().isIndeterminate(), Matchers.is(false), "Element is indeterminate");
        return this;
    }

    @JDIAction("Assert that '{name}' has '{0}' class")
    public VueCheckboxAssert className(String className) {
        jdiAssert(element().hasClass(className), Matchers.is(true), String.format("Element hasn't class '%s'", className));
        return this;
    }

    @JDIAction("Assert that '{name}' has not label")
    public VueCheckboxAssert noLabel() {
        jdiAssert(element().hasLabel(), Matchers.is(false), "Element has label");
        return this;
    }

    @JDIAction("Assert that '{name}' has label")
    public VueCheckboxAssert label() {
        jdiAssert(element().hasLabel(), Matchers.is(true), "Element has no label");
        return this;
    }

    @JDIAction("Assert that '{name}' is success")
    public VueCheckboxAssert success() {
        jdiAssert(element().isSuccess(), Matchers.is(true), "Element is not success");
        return this;
    }

    @JDIAction("Assert that '{name}' is not success")
    public VueCheckboxAssert notSuccess() {
        jdiAssert(element().isSuccess(), Matchers.is(false), "Element is success");
        return this;
    }

    @JDIAction("Assert that '{name}' is error")
    public VueCheckboxAssert error() {
        jdiAssert(element().isError(), Matchers.is(true), "Element is not error");
        return this;
    }

    @JDIAction("Assert that '{name}' is not error")
    public VueCheckboxAssert notError() {
        jdiAssert(element().isError(), Matchers.is(false), "Element is error");
        return this;
    }

    @JDIAction("Assert that '{name}' has label color '{0}'")
    public VueCheckboxAssert labelColor(String color) {
        String actualLabelColor = element().labelColor();
        jdiAssert(actualLabelColor, Matchers.equalTo(color), String.format("Element's actual label color '%s' " +
                "is not equal to expected '%s'", actualLabelColor, color));
        return this;
    }
}
