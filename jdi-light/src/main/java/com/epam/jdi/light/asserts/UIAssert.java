package com.epam.jdi.light.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.IBaseElement;
import com.epam.jdi.tools.Timer;
import com.epam.jdi.tools.func.JFunc1;

import static com.epam.jdi.light.asserts.SoftAssert.jdiAssert;
import static com.epam.jdi.light.settings.TimeoutSettings.TIMEOUT;
import static org.hamcrest.Matchers.is;

public class UIAssert<A extends UIAssert, E extends IBaseElement> extends BaseAssert<E> {
    /**
     * Check that the element is displayed
     */
    @JDIAction("Assert that '{name}' is displayed")
    public A displayed() {
        jdiAssert(uiElement.isDisplayed() ? "displayed" : "hidden", is("displayed"));
        return (A) this;
    }

    /**
     * Check that the element is disappeared
     */
    @JDIAction("Assert that '{name}' is disappeared")
    public A disappear() {
        jdiAssert(uiElement.isDisplayed() ? "displayed" : "disappeared", is("disappeared"));
        return (A) this;
    }

    /**
     * Check that the element is hidden
     */
    @JDIAction("Assert that '{name}' is hidden")
    public A hidden() {
        jdiAssert(uiElement.isDisplayed() ? "displayed" : "hidden", is("hidden"));
        return (A) this;
    }

    public A notAppear() {
        return notAppear(TIMEOUT.get());
    }

    /**
     * Check that the element doesn't appear for the specified time
     * @param timeoutSec
     */
    @JDIAction(value = "Assert that '{name}' does not appear during {0} seconds", timeout = 0)
    public A notAppear(int timeoutSec) {
        boolean result = new Timer(timeoutSec * 1000)
                .wait(() -> uiElement.isDisplayed());
        jdiAssert(result ? "displayed" : "hidden", is("hidden"));
        return (A) this;
    }

    /**
     * Check that the element is enable
     */
    @JDIAction("Assert that '{name}' is enabled")
    public A enabled() {
        jdiAssert(uiElement.isEnabled() ? "enabled" : "disabled", is("enabled"));
        return (A) this;
    }

    /**
     * Check that the element is disable
     */
    @JDIAction("Assert that '{name}' is disabled")
    public A disabled() {
         jdiAssert(uiElement.isEnabled() ? "enabled" : "disabled", is("disabled"));
        return (A) this;
    }

    public A and() { return (A) this; }
    public A condition(JFunc1<A, A> t) {
        return t.execute((A) this);
    }

    public A set(E element) {
        this.uiElement = element;
        return (A) this;
    }
}
