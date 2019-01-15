package com.epam.jdi.light.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIElement;
import org.hamcrest.Matcher;
import org.openqa.selenium.WebElement;

import java.util.Collection;
import java.util.List;

import static com.epam.jdi.light.asserts.BaseSelectorAssert.waitAssert;
import static com.epam.jdi.tools.LinqUtils.map;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ListAssert<T extends UIElement> extends BaseAssert {
    List<T> elements;

    public ListAssert(List<T> elements, String name) {
        super(name);
        this.elements = elements;
    }

    @JDIAction("Assert '{name}' texts")
    public ListAssert<T> texts(Matcher<Collection<? extends String>> condition) {
        assertThat(map(elements, WebElement::getText), condition);
        return this;
    }
    @JDIAction("Assert '{name}' attributes")
    public ListAssert<T> attrs(String attrName, Matcher<Collection<? extends String>> condition) {
        assertThat(map(elements, el -> el.getAttribute(attrName)), condition);
        return this;
    }
    @JDIAction("Assert '{name}' css '{0}'")
    public ListAssert<T> css(String css, Matcher<Collection<? extends String>> condition) {
        assertThat(map(elements, el -> el.getCssValue(css)), condition);
        return this;
    }
    @JDIAction("Assert '{name}' tags")
    public ListAssert<T> tags(Matcher<Collection<? extends String>> condition) {
        assertThat(map(elements, WebElement::getTagName), condition);
        return this;
    }
    @JDIAction("Assert '{name}' classes")
    public ListAssert<T> cssClasses(Matcher<Collection<? extends String>> condition) {
        assertThat(map(elements, el -> el.getAttribute("class")), condition);
        return this;
    }
    @JDIAction("Assert that all elements of '{name}' are displayed")
    public ListAssert<T> allDisplayed() {
        assertThat(map(elements, UIElement::isDisplayed), everyItem(is(true)));
        return this;
    }
    @JDIAction("Assert that all elements of '{name}' are displayed")
    public ListAssert<T> displayed() {
        assertThat(map(elements, UIElement::isDisplayed), hasItem(true));
        return this;
    }
    @JDIAction("Assert that all elements of '{name}' are hidden")
    public ListAssert<T> hidden() {
        assertThat(map(elements, UIElement::isDisplayed), everyItem(is(false)));
        return this;
    }
    @JDIAction("Assert that '{name}' elements selected")
    public ListAssert<T> selected(Matcher<Collection<? extends Boolean>> condition) {
        assertThat(map(elements, UIElement::isSelected), condition);
        return this;
    }
    @JDIAction("Assert that '{name}' elements enabled")
    public ListAssert<T> enabled(Matcher<Collection<? extends Boolean>> condition) {
        assertThat(map(elements, UIElement::isEnabled), condition);
        return this;
    }
    @JDIAction("Assert that '{name}' is empty")
    public ListAssert<T> empty() {
        assertThat(elements.isEmpty() ? "list is empty" : "list is not empty", is("list is empty"));
        return this;
    }
    @JDIAction("Assert that '{name}' is not empty")
    public ListAssert<T> notEmpty() {
        assertThat(elements.isEmpty() ? "list is empty" : "list is not empty", is("list is not empty"));
        return this;
    }
    @JDIAction("Assert '{name}' size")
    public ListAssert<T> size(Matcher<Integer> condition) {
        assertThat(elements.size(), condition);
        return this;
    }
}
