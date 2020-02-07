package com.epam.jdi.light.asserts.generic;

import com.epam.jdi.light.asserts.core.IsAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.tools.Timer;
import com.epam.jdi.tools.func.JFunc1;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.StringUtils.format;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class UIAssert<A extends UIAssert, E extends ICoreElement> extends BaseAssert<E>
    implements CommonAssert<A> {
    /**
     * Check that the element is displayed
     */
    @JDIAction("Assert that '{name}' is displayed")
    public A displayed() {
        jdiAssert(element.isDisplayed() ? "displayed" : "hidden", Matchers.is("displayed"));
        return (A) this;
    }
    /**
     * Check that the element is disappeared
     */
    @JDIAction("Assert that '{name}' disappeared")
    public A disappear() {
        logger.info("!>>");
        jdiAssert(element.isDisplayed() ? "displayed" : "disappeared", Matchers.is("disappeared"));
        logger.info("<<!");
        return (A) this;
    }

    /**
     * Check that the element is hidden
     */
    @JDIAction("Assert that '{name}' is hidden")
    public A hidden() {
        jdiAssert(element.isDisplayed() ? "displayed" : "hidden", Matchers.is("hidden"));
        return (A) this;
    }

    public A notAppear() {
        return notAppear(element.base().getTimeout());
    }

    /**
     * Check that the element doesn't appear for the specified time
     * @param timeoutSec
     */
    @JDIAction(value = "Assert that '{name}' does not appear during {0} seconds", timeout = 0)
    public A notAppear(int timeoutSec) {
        logger.toLog(">!!! " + timeoutSec * 1000);
        boolean result = new Timer(timeoutSec * 1000)
                .wait(() -> element.isDisplayed());
        logger.toLog("<!!! ");
        jdiAssert(result ? "displayed" : "hidden", Matchers.is("hidden"));
        return (A) this;
    }

    /**
     * Check that the element is enabled
     */
    @JDIAction("Assert that '{name}' is enabled")
    public A enabled() {
        jdiAssert(element.isEnabled() ? "enabled" : "disabled", Matchers.is("enabled"));
        return (A) this;
    }

    /**
     * Check that the element is disabled
     */
    @JDIAction("Assert that '{name}' is disabled")
    public A disabled() {
         jdiAssert(element.isEnabled() ? "enabled" : "disabled", Matchers.is("disabled"));
        return (A) this;
    }

    public A and() { return (A) this; }
    public IsAssert core() { return element.core().is(); }
    public A condition(JFunc1<A, A> t) {
        return t.execute((A) this);
    }

    public A set(E element) {
        this.element = element;
        name = element.getName();
        failElement = format("%s(%s)", name, element.core().printFullLocator());
        return (A) this;
    }

    public A is() {
        return (A) this;
    }
}
