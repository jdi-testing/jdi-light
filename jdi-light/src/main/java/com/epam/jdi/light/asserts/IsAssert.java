package com.epam.jdi.light.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.BaseWebElement;
import com.epam.jdi.light.elements.base.IBaseElement;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.asserts.SoftAssert.jdiAssert;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.settings.TimeoutSettings.TIMEOUT;
import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class IsAssert<A extends IsAssert> extends BaseAssert implements CommonAssert<A> {

    public IsAssert(IBaseElement element) {
        super(element);
    }

    private BaseWebElement toBaseUIElement(String action) {
        if (!isClass(uiElement.getClass(), BaseWebElement.class))
            throw exception("%s not a BaseWebElement. %s assert allowed only for elements that extends BaseWebElement",
                    uiElement.getName(), action);
        return (BaseWebElement) uiElement;
    }

    /**
     * Match passed value with the element text
     * @param condition to compare
     */
    @JDIAction("Assert that '{name}' text {0}")
    public A text(Matcher<String> condition) {
        jdiAssert(toBaseUIElement("text").getText(), condition);
        return (A) this;
    }
    public A text(String text) {
        return text(is(text));
    }
    /**
     * Match passed value with the element attribute
     * @param attrName
     * @param condition to compare
     */
    @JDIAction("Assert that '{name}' attribute '{0}' {1}")
    public A attr(String attrName, Matcher<String> condition) {
        jdiAssert(uiElement.getAttribute(attrName), condition);
        return (A) this;
    }
    public A attr(String attrName, String value) {
        return attr(attrName, is(value));
    }

    /**
     * Match passed value with the element css
     * @param css
     * @param condition to compare
     */
    @JDIAction("Assert that '{name}' css '{0}' {1}")
    public A css(String css, Matcher<String> condition) {
        jdiAssert(uiElement.getCssValue(css), condition);
        return (A) this;
    }
    public A css(String css, String value) {
        return css(css, is(value));
    }

    /**
     * Match passed value with the element tag
     * @param condition to compare
     */
    @JDIAction("Assert that '{name}' tag {0}")
    public A tag(Matcher<String> condition) {
        jdiAssert(uiElement.getTagName(), condition);
        return (A) this;
    }
    public A css(String tagName) {
        return tag(is(tagName));
    }

    /**
     * Match passed value with the element class
     * @param className to compare
     */
    @JDIAction("Assert that '{name}' has css class {0}")
    public A hasClass(String className) {
        return cssClass(containsString(className));
    }

    /**
     * Match passed value with the element class
     * @param condition to compare
     */
    @JDIAction("Assert that '{name}' css class {0}")
    public A cssClass(Matcher<String> condition) {
        jdiAssert(uiElement.getAttribute("class"), condition);
        return (A) this;
    }
    public A cssClass(String className) {
        return cssClass(is(className));
    }

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
        jdiAssert(uiElement.idHidden() ? "disappeared" : "displayed", is("disappeared"));
        return (A) this;
    }

    /**
     * Check that the element is hidden
     */
    @JDIAction("Assert that '{name}' is hidden")
    public A hidden() {
        jdiAssert(uiElement.idHidden() ? "hidden" : "displayed", is("hidden"));
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
                .wait(() -> uiElement.displayed());
        jdiAssert(result ? "displayed" : "hidden", is("hidden"));
        return (A) this;
    }

    /**
     * Check that the element is selected
     */
    @JDIAction("Assert that '{name}' is selected")
    public A selected() {
        jdiAssert(toBaseUIElement("selected").isSelected() ? "selected" : "not selected", is("selected"));
        return (A) this;
    }

    /**
     * Check that the element is deselected
     */
    @JDIAction("Assert that '{name}' is deselected")
    public A deselected() {
        jdiAssert(toBaseUIElement("deselected").isSelected() ? "selected" : "not selected", is("not selected"));
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
}
