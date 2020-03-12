package com.epam.jdi.light.asserts.generic;

import com.epam.jdi.light.asserts.core.IsAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.settings.WebSettings;
import com.epam.jdi.tools.Timer;
import com.epam.jdi.tools.func.JFunc1;
import org.hamcrest.*;

import static com.epam.jdi.light.asserts.core.SoftAssert.*;
import static com.epam.jdi.tools.StringUtils.*;

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
     * Check that the element is visible by user
     */
    @JDIAction("Assert that '{name}' is visible by user")
    public A visible() {
        jdiAssert(element.isVisible() ? "is in the user view" : "out of the screen or hidden", Matchers.is("is in the user view"));
        return (A) this;
    }
    /**
     * Check that the element is not visible by user
     */
    @JDIAction("Assert that '{name}' is not visible by user")
    public A notVisible() {
        jdiAssert(element.isNotVisible() ? "out of the user view" : "is in the user view", Matchers.is("out of the user view"));
        return (A) this;
    }
    @JDIAction("Assert that '{name}' is shown")
    public A shown() {
        return displayed();
    }
    /**
     * Check that the element is disappeared
     */
    @JDIAction("Assert that '{name}' is disappear")
    public A disappear() {
        return hidden();
    }

    /**
     * Check that the element is hidden
     */
    @JDIAction("Assert that '{name}' is hidden")
    public A hidden() {
        jdiAssert(element.isHidden() ? "hidden" : "displayed", Matchers.is("hidden"));
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
        boolean result = new Timer(timeoutSec * 1000)
                .wait(() -> element.isDisplayed());
        jdiAssert(result ? "displayed" : "hidden", Matchers.is("hidden"));
        return (A) this;
    }

    /**
     * Match passed value with the element attribute
     * @param attrName
     * @param condition to compare
     */
    @JDIAction("Assert that '{name}' attribute '{0}' {1}")
    public A attr(String attrName, Matcher<String> condition) {
        jdiAssert(element.attr(attrName), condition);
        return (A) this;
    }
    public A attr(String attrName, String value) {
        return attr(attrName, Matchers.is(value));
    }

    /**
     * Match passed value with the element css
     * @param css
     * @param condition to compare
     */
    @JDIAction("Assert that '{name}' css '{0}' {1}")
    public A css(String css, Matcher<String> condition) {
        jdiAssert(element.css(css), condition);
        return (A) this;
    }
    public A css(String css, String value) {
        return css(css, Matchers.is(value));
    }

    /**
     * Match passed value with the element class
     * @param className to compare hasClass(String className)
     */
    @JDIAction("Assert that '{name}' has css class {0}")
    public A hasClass(String className) {
        jdiAssert(format(element.classes().contains(className) ? "has class '%s'" : "has no class '%s'", className) , Matchers.is("has class '"+className+"'"));
        return (A) this;
    }
    /**
     * Match passed value with the element class
     * @param attrName to compare hasAttribute(String className)
     */
    @JDIAction("Assert that '{name}' has css class {0}")
    public A hasAttribute(String attrName) {
        jdiAssert(format(element.hasAttribute(attrName) ? "has attribute '%s'" : "has no attribute '%s'", attrName) , Matchers.is("has attribute '"+attrName+"'"));
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
