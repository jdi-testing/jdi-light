package com.epam.jdi.light.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.BaseElement;
import com.epam.jdi.light.elements.base.BaseUIElement;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.asserts.SoftAssert.jdiAssert;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.settings.TimeoutSettings.TIMEOUT;
import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class IsAssert<T extends IsAssert> extends BaseAssert implements CommonAssert<T> {

    public IsAssert(BaseElement element) {
        super(element);
    }

    private BaseUIElement toBaseUIElement(String action) {
        if (!isClass(element.getClass(), BaseUIElement.class))
            throw exception("%s not a BaseUIElement. %s assert allowed only for elements that extends BaseUIElement",
                    element.getName(), action);
        return (BaseUIElement) element;
    }

    /**
     * Match passed value with the element text
     * @param condition to compare
     */
    @JDIAction("Assert that '{name}' text {0}")
    public T text(Matcher<String> condition) {
        jdiAssert(toBaseUIElement("text").getText(), condition);
        return (T) this;
    }

    /**
     * Match passed value with the element attribute
     * @param attrName
     * @param condition to compare
     */
    @JDIAction("Assert that '{name}' attribute '{0}' {1}")
    public T attr(String attrName, Matcher<String> condition) {
        jdiAssert(element.getAttribute(attrName), condition);
        return (T) this;
    }

    /**
     * Match passed value with the element css
     * @param css
     * @param condition to compare
     */
    @JDIAction("Assert that '{name}' css '{0}' {1}")
    public T css(String css, Matcher<String> condition) {
        jdiAssert(element.getCssValue(css), condition);
        return (T) this;
    }

    /**
     * Match passed value with the element tag
     * @param condition to compare
     */
    @JDIAction("Assert that '{name}' tag {0}")
    public T tag(Matcher<String> condition) {
        jdiAssert(element.getTagName(), condition);
        return (T) this;
    }

    /**
     * Match passed value with the element class
     * @param className to compare
     */
    @JDIAction("Assert that '{name}' has css class {0}")
    public T hasClass(String className) {
        return cssClass(containsString(className));
    }

    /**
     * Match passed value with the element class
     * @param condition to compare
     */
    @JDIAction("Assert that '{name}' css class {0}")
    public T cssClass(Matcher<String> condition) {
        jdiAssert(element.getAttribute("class"), condition);
        return (T) this;
    }

    /**
     * Check that the element is displayed
     */
    @JDIAction("Assert that '{name}' is displayed")
    public T displayed() {
        jdiAssert(element.displayed() ? "displayed" : "hidden", is("displayed"));
        return (T) this;
    }

    /**
     * Check that the element is disappeared
     */
    @JDIAction("Assert that '{name}' is disappear")
    public T disappear() {
        jdiAssert(element.displayed() ? "displayed" : "disappear", is("disappear"));
        return (T) this;
    }

    /**
     * Check that the element is hidden
     */
    @JDIAction("Assert that '{name}' is hidden")
    public T hidden() {
        jdiAssert(element.displayed() ? "displayed" : "hidden", is("hidden"));
        return (T) this;
    }

    public T notAppear() {
        return notAppear(TIMEOUT.get());
    }

    /**
     * Check that the element doesn't appear for the specified time
     * @param timeoutSec
     */
    @JDIAction(value = "Assert that '{name}' does not appear during {0} seconds", timeout = 0)
    public T notAppear(int timeoutSec) {
        boolean result = new Timer(timeoutSec * 1000)
                .wait(() -> element.displayed());
        jdiAssert(result ? "displayed" : "hidden", is("hidden"));
        return (T) this;
    }

    /**
     * Check that the element is selected
     */
    @JDIAction("Assert that '{name}' is selected")
    public T selected() {
        jdiAssert(toBaseUIElement("selected").isSelected() ? "selected" : "not selected", is("selected"));
        return (T) this;
    }

    /**
     * Check that the element is deselected
     */
    @JDIAction("Assert that '{name}' is deselected")
    public T deselected() {
        jdiAssert(toBaseUIElement("deselected").isSelected() ? "selected" : "not selected", is("not selected"));
        return (T) this;
    }

    /**
     * Check that the element is enable
     */
    @JDIAction("Assert that '{name}' is enabled")
    public T enabled() {
        jdiAssert(element.isEnabled() ? "enabled" : "disabled", is("enabled"));
        return (T) this;
    }

    /**
     * Check that the element is disable
     */
    @JDIAction("Assert that '{name}' is disabled")
    public T disabled() {
         jdiAssert(element.isEnabled() ? "enabled" : "disabled", is("disabled"));
        return (T) this;
    }
}
