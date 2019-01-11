package com.epam.jdi.light.asserts;

import com.epam.jdi.light.elements.base.UIElement;
import org.hamcrest.Matcher;
import org.openqa.selenium.WebElement;

import java.util.Collection;
import java.util.List;

import static com.epam.jdi.light.asserts.BaseSelectorAssert.waitAssert;
import static com.epam.jdi.tools.LinqUtils.map;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ListAssert<T extends UIElement> {
    List<T> elements;
    String name;

    public ListAssert(List<T> elements, String name) {
        this.elements = elements;
        this.name = name;
    }

    public ListAssert<T> texts(Matcher<Collection<? extends String>> condition) {
        waitAssert(() -> assertThat(map(elements, WebElement::getText), condition), name);
        return this;
    }
    public ListAssert<T> attrs(String attrName, Matcher<Collection<? extends String>> condition) {
        waitAssert(() -> assertThat(map(elements, el -> el.getAttribute(attrName)), condition), name);
        return this;
    }
    public ListAssert<T> css(String css, Matcher<Collection<? extends String>> condition) {
        waitAssert(() -> assertThat(map(elements, el -> el.getCssValue(css)), condition), name);
        return this;
    }
    public ListAssert<T> tags(Matcher<Collection<? extends String>> condition) {
        waitAssert(() -> assertThat(map(elements, WebElement::getTagName), condition), name);
        return this;
    }
    public ListAssert<T> cssClasses(Matcher<Collection<? extends String>> condition) {
        waitAssert(() -> assertThat(map(elements, el -> el.getAttribute("class")), condition), name);
        return this;
    }
    public ListAssert<T> allDisplayed() {
        waitAssert(() -> assertThat(map(elements, UIElement::isDisplayed), everyItem(is(true))), name);
        return this;
    }
    public ListAssert<T> displayed() {
        waitAssert(() -> assertThat(map(elements, UIElement::isDisplayed), hasItem(true)), name);
        return this;
    }
    public ListAssert<T> hidden() {
        waitAssert(() -> assertThat(map(elements, UIElement::isDisplayed), everyItem(is(false))), name);
        return this;
    }
    public ListAssert<T> selected(Matcher<Collection<? extends Boolean>> condition) {
        waitAssert(() -> assertThat(map(elements, UIElement::isSelected), condition), name);
        return this;
    }
    public ListAssert<T> enabled(Matcher<Collection<? extends Boolean>> condition) {
        waitAssert(() -> assertThat(map(elements, UIElement::isEnabled), condition), name);
        return this;
    }
    public ListAssert<T> empty() {
        waitAssert(() -> assertThat(elements.isEmpty() ? "list is empty" : "list is not empty", is("list is empty")), name);
        return this;
    }
    public ListAssert<T> notEmpty() {
        waitAssert(() -> assertThat(elements.isEmpty() ? "list is empty" : "list is not empty", is("list is not empty")), name);
        return this;
    }
    public ListAssert<T> size(Matcher<Integer> condition) {
        waitAssert(() -> assertThat(elements.size(), condition), name);
        return this;
    }
}
