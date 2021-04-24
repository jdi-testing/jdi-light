package com.epam.jdi.light.asserts.generic;

import com.epam.jdi.light.asserts.core.IsAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.tools.Safe;
import com.epam.jdi.tools.Timer;
import com.epam.jdi.tools.func.JFunc1;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.tools.StringUtils.format;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class UIAssert<A extends UIAssert<?,?>, E extends ICoreElement> extends BaseAssert<E>
    implements CommonAssert<A> {
    /**
     * Check that the element is displayed
     */
    @JDIAction("Assert that '{name}' is displayed")
    public A displayed() {
        jdiAssert(element().isDisplayed() ? "displayed" : "hidden", Matchers.is("displayed"));
        return (A) this;
    }
    /**
     * Check that the element is visible by user
     */
    @JDIAction("Assert that '{name}' is visible by user")
    public A visible() {
        jdiAssert(element().isVisible() ? "is in the user view" : "out of the screen or hidden", Matchers.is("is in the user view"));
        return (A) this;
    }
    /**
     * Check that the element is not visible by user
     */
    @JDIAction("Assert that '{name}' is not visible by user")
    public A notVisible() {
        jdiAssert(element().isNotVisible() ? "out of the user view" : "is in the user view", Matchers.is("out of the user view"));
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
        jdiAssert(element().isHidden() ? "hidden" : "displayed", Matchers.is("hidden"));
        return (A) this;
    }

    public A notAppear() {
        return notAppear(base().getTimeout());
    }

    /**
     * Check that the element doesn't appear for the specified time
     * @param timeoutSec
     */
    @JDIAction(value = "Assert that '{name}' does not appear during {0} seconds", timeout = 0)
    public A notAppear(int timeoutSec) {
        boolean result = new Timer(timeoutSec * 1000L)
                .wait(() -> element().isDisplayed());
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
        jdiAssert(element().attr(attrName), condition);
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
        jdiAssert(element().css(css), condition);
        return (A) this;
    }
    public A css(String css, String value) {
        return css(css, Matchers.is(value));
    }

    @JDIAction("Assert that '{name}' css class is '{0}'")
    public A cssClasses(Matcher<? super List<String>> condition) {
        jdiAssert(element().classes(), condition);
        return (A) this;
    }
    @JDIAction("Assert that '{name}' css class is '{0}'")
    public A classValue(Matcher<String> condition) {
        jdiAssert(element().core().attr("class"), condition);
        return (A) this;
    }
    public A classValue(String value) {
        return classValue(Matchers.is(value));
    }
    public A cssClass(String className) {
        return cssClasses(Matchers.hasItem(className));
    }

    @JDIAction("Assert that '{name}' tag is '{0}'")
    public A tag(Matcher<String> condition) {
        jdiAssert(element().getTagName(), condition);
        return (A) this;
    }
    public A tag(String tagName) {
        return tag(Matchers.is(tagName));
    }

    /**
     * Match passed value with the element class
     * @param attrName to compare attr(String attrName)
     */
    @JDIAction("Assert that '{name}' has css class '{0}'")
    public A attr(String attrName) {
        jdiAssert(format(element().hasAttribute(attrName) ? "has attribute '%s'" : "has no attribute '%s'", attrName) , Matchers.is("has attribute '"+attrName+"'"));
        return (A) this;
    }

    /**
     * Check that the element is enabled
     */
    @JDIAction("Assert that '{name}' is enabled")
    public A enabled() {
        jdiAssert(element().isEnabled() ? "enabled" : "disabled", Matchers.is("enabled"));
        return (A) this;
    }

    /**
     * Check that the element is disabled
     */
    @JDIAction("Assert that '{name}' is disabled")
    public A disabled() {
         jdiAssert(element().isEnabled() ? "enabled" : "disabled", Matchers.is("disabled"));
        return (A) this;
    }

    public A and() { return (A) this; }
    public IsAssert core() { return element().core().is(); }
    public A condition(JFunc1<A, A> t) {
        return t.execute((A) this);
    }

    public A set(E original) {
        this.element = new Safe<>(() -> original);
        name = original.getName();
        failElement = format("%s(%s)", name, original.core().printFullLocator());
        return (A) this;
    }

    public A is() {
        return (A) this;
    }
}
