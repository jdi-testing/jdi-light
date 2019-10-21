package com.epam.jdi.light.asserts.core;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.SelectedAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.Matchers.is;

public class IsAssert extends UIAssert<IsAssert, UIElement>
        implements SelectedAssert<IsAssert>, ITextAssert<IsAssert> {
    @JDIAction("Assert that '{name}' text {0}")
    public IsAssert text(Matcher<String> condition) {
        jdiAssert(element.getText(), condition);
        return this;
    }
    /**
     * Match passed value with the element attribute
     * @param attrName
     * @param condition to compare
     */
    @JDIAction("Assert that '{name}' attribute '{0}' {1}")
    public IsAssert attr(String attrName, Matcher<String> condition) {
        jdiAssert(element.getAttribute(attrName), condition);
        return this;
    }
    public IsAssert attr(String attrName, String value) {
        return attr(attrName, is(value));
    }

    /**
     * Check that the element contains attribute
     * @param attrName
     */

    @JDIAction("Assert that '{name}' attribute {0}")
    public IsAssert hasAttr(String attrName) {
        jdiAssert(element.attrs().keys().toArray(), hasItemInArray(attrName));
        return this;
    }

    /**
     * Match passed value with the element css
     * @param css
     * @param condition to compare
     */
    @JDIAction("Assert that '{name}' css '{0}' {1}")
    public IsAssert css(String css, Matcher<String> condition) {
        jdiAssert(element.getCssValue(css), condition);
        return this;
    }
    public IsAssert css(String css, String value) {
        return css(css, is(value));
    }

    /**
     * Match passed value with the element tag
     * @param condition to compare
     */
    @JDIAction("Assert that '{name}' tag {0}")
    public IsAssert tag(Matcher<String> condition) {
        jdiAssert(element.getTagName(), condition);
        return this;
    }
    public IsAssert tag(String tagName) {
        return tag(is(tagName));
    }

    /**
     * Match passed value with the element class
     * @param className to compare
     */
    @JDIAction("Assert that '{name}' has css class {0}")
    public IsAssert hasClass(String className) {
        return cssClass(containsString(className));
    }

    /**
     * Match passed value with the element class
     * @param condition to compare
     */
    @JDIAction("Assert that '{name}' css class {0}")
    public IsAssert cssClass(Matcher<String> condition) {
        jdiAssert(element.getAttribute("class"), condition);
        return this;
    }
    public IsAssert cssClass(String className) {
        return cssClass(is(className));
    }


    /**
     * Check that the element is selected
     */
    @JDIAction("Assert that '{name}' is selected")
    public IsAssert selected() {
        jdiAssert(element.isSelected() ? "selected" : "not selected", is("selected"));
        return this;
    }

    /**
     * Check that the element is deselected
     */
    @JDIAction("Assert that '{name}' is deselected")
    public IsAssert deselected() {
        jdiAssert(element.isSelected() ? "selected" : "not selected", is("not selected"));
        return this;
    }

}
