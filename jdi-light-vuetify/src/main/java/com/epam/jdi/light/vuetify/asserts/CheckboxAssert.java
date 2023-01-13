package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Checkbox;
import com.epam.jdi.light.vuetify.interfaces.asserts.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.DenseAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MessagesAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ReadOnlyAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class CheckboxAssert extends UIAssert<CheckboxAssert, Checkbox> implements ThemeAssert<CheckboxAssert, Checkbox>,
        ColorAssert<CheckboxAssert, Checkbox>, DenseAssert<CheckboxAssert, Checkbox>,
        MessagesAssert<CheckboxAssert, Checkbox>, ReadOnlyAssert<CheckboxAssert, Checkbox> {
    @JDIAction("Assert that '{name}' is checked")
    public CheckboxAssert checked() {
        boolean isChecked = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isChecked());
        jdiAssert(isChecked, Matchers.is(true), "Element is unchecked");
        return this;
    }

    @JDIAction("Assert that '{name}' is unchecked")
    public CheckboxAssert unchecked() {
        boolean isUnchecked = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isUnchecked());
        jdiAssert(isUnchecked, Matchers.is(true), "Element is checked");
        return this;
    }

    @JDIAction("Assert that '{name}' has '{0}' label")
    public CheckboxAssert label(String text) {
        new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isDisplayed());
        String actualLabelText = element().labelText();
        jdiAssert(actualLabelText, equalToIgnoringCase(text), String.format("Element's actual label text '%s' is " +
                "not equal to expected '%s'", actualLabelText, text));
        return this;
    }

    @JDIAction("Assert that '{name}' label contains '{text}'")
    public CheckboxAssert labelContains(String text) {
        String actualLabelText = element().labelText();
        jdiAssert(actualLabelText, Matchers.containsString(text), String.format("Element's actual label text '%s' " +
                "doesn't contain expected text '%s'", actualLabelText, text));
        return this;
    }

    @JDIAction("Assert that '{name}' is indeterminate")
    public CheckboxAssert indeterminate() {
        jdiAssert(element().isIndeterminate(), Matchers.is(true), "Element is not indeterminate");
        return this;
    }

    @JDIAction("Assert that '{name}' is not indeterminate")
    public CheckboxAssert notIndeterminate() {
        jdiAssert(element().isIndeterminate(), Matchers.is(false), "Element is indeterminate");
        return this;
    }

    @JDIAction("Assert that '{name}' has label")
    public CheckboxAssert label() {
        jdiAssert(element().hasLabel(), Matchers.is(true), "Element has no label");
        return this;
    }

    @JDIAction("Assert that '{name}' has not label")
    public CheckboxAssert noLabel() {
        jdiAssert(element().hasLabel(), Matchers.is(false), "Element has label");
        return this;
    }

    @JDIAction("Assert that '{name}' is success")
    public CheckboxAssert success() {
        jdiAssert(element().isSuccess(), Matchers.is(true), "Element is not success");
        return this;
    }

    @JDIAction("Assert that '{name}' is not success")
    public CheckboxAssert notSuccess() {
        jdiAssert(element().isSuccess(), Matchers.is(false), "Element is success");
        return this;
    }

    @JDIAction("Assert that '{name}' is error")
    public CheckboxAssert error() {
        jdiAssert(element().isError(), Matchers.is(true), "Element is not error");
        return this;
    }

    @JDIAction("Assert that '{name}' is not error")
    public CheckboxAssert notError() {
        jdiAssert(element().isError(), Matchers.is(false), "Element is error");
        return this;
    }

    @JDIAction("Assert that '{name}' has label color '{0}'")
    public CheckboxAssert labelColor(String color) {
        String actualLabelColor = element().labelColor();
        jdiAssert(actualLabelColor, Matchers.equalTo(color), String.format("Element's actual label color '%s' " +
                "is not equal to expected '%s'", actualLabelColor, color));
        return this;
    }
}
