package com.epam.jdi.light.asserts.core;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.SelectedAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.containsString;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class IsAssert extends UIAssert<IsAssert, UIElement>
        implements SelectedAssert<IsAssert>, ITextAssert<IsAssert> {
    @JDIAction("Assert that '{name}' text {0}")
    public IsAssert text(Matcher<String> condition, String... messages) {
        jdiAssert(element.getText(), condition, messages);
        return this;
    }
    
    /**
     * Match passed value with the element attribute
     *
     * @param attrName
     * @param condition to compare
     */
    @JDIAction("Assert that '{name}' attribute '{0}' {1}")
    public IsAssert attr(String attrName, Matcher<String> condition, String... messages) {
        jdiAssert(element.getAttribute(attrName), condition, messages);
        return this;
    }
    
    public IsAssert attr(String attrName, String value, String... messages) {
        return attr(attrName, Matchers.is(value), messages);
    }
    
    /**
     * Match passed value with the element css
     *
     * @param css
     * @param condition to compare
     */
    @JDIAction("Assert that '{name}' css '{0}' {1}")
    public IsAssert css(String css, Matcher<String> condition, String... messages) {
        jdiAssert(element.getCssValue(css), condition, messages);
        return this;
    }
    
    public IsAssert css(String css, String value, String... messages) {
        return css(css, Matchers.is(value), messages);
    }
    
    /**
     * Match passed value with the element tag
     *
     * @param condition to compare
     */
    @JDIAction("Assert that '{name}' tag {0}")
    public IsAssert tag(Matcher<String> condition, String... messages) {
        jdiAssert(element.getTagName(), condition, messages);
        return this;
    }
    
    public IsAssert tag(String tagName, String ... messages) {
        return tag(Matchers.is(tagName), messages);
    }
    
    /**
     * Match passed value with the element class
     *
     * @param className to compare
     */
    @JDIAction("Assert that '{name}' has css class {0}")
    public IsAssert hasClass(String className, String ... messages) {
        return cssClass(containsString(className), messages);
    }
    
    /**
     * Match passed value with the element class
     *
     * @param condition to compare
     */
    @JDIAction("Assert that '{name}' css class {0}")
    public IsAssert cssClass(Matcher<String> condition, String ... messages) {
        jdiAssert(element.getAttribute("class"), condition, messages);
        return this;
    }
    
    public IsAssert cssClass(String className, String ... messages) {
        return cssClass(Matchers.is(className), messages);
    }
    
    
    /**
     * Check that the element is selected
     */
    @JDIAction("Assert that '{name}' is selected")
    public IsAssert selected(String ... messages) {
        jdiAssert(element.isSelected() ? "selected" : "not selected", Matchers.is("selected"), messages);
        return this;
    }
    
    /**
     * Check that the element is deselected
     */
    @JDIAction("Assert that '{name}' is deselected")
    public IsAssert deselected(String ... messages) {
        jdiAssert(element.isSelected() ? "selected" : "not selected", Matchers.is("not selected"), messages);
        return this;
    }
    
}
