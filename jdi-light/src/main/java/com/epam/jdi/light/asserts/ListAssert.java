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

    public ListAssert(List<T> elements) {
        this.elements = elements;
    }

    public ListAssert<T> texts(Matcher<Collection<? extends String>> condition) {
        waitAssert(() -> assertThat(map(elements, WebElement::getText), condition));
        return this;
    }
    public ListAssert<T> attrs(String attrName, Matcher<Collection<? extends String>> condition) {
        waitAssert(() -> assertThat(map(elements, el -> el.getAttribute(attrName)), condition));
        return this;
    }
    public ListAssert<T> css(String css, Matcher<Collection<? extends String>> condition) {
        waitAssert(() -> assertThat(map(elements, el -> el.getCssValue(css)), condition));
        return this;
    }
    public ListAssert<T> tags(Matcher<Collection<? extends String>> condition) {
        waitAssert(() -> assertThat(map(elements, WebElement::getTagName), condition));
        return this;
    }
    public ListAssert<T> cssClasses(Matcher<Collection<? extends String>> condition) {
        waitAssert(() -> assertThat(map(elements, el -> el.getAttribute("class")), condition));
        return this;
    }
    public ListAssert<T> allDisplayed() {
        waitAssert(() -> assertThat(map(elements, UIElement::isDisplayed), everyItem(is(true))));
        return this;
    }
    public ListAssert<T> displayed() {
        waitAssert(() -> assertThat(map(elements, UIElement::isDisplayed), hasItem(true)));
        return this;
    }
    public ListAssert<T> hidden() {
        waitAssert(() -> assertThat(map(elements, UIElement::isDisplayed), everyItem(is(false))));
        return this;
    }
    public ListAssert<T> selected(Matcher<Collection<? extends Boolean>> condition) {
        waitAssert(() -> assertThat(map(elements, UIElement::isSelected), condition));
        return this;
    }
    public ListAssert<T> enabled(Matcher<Collection<? extends Boolean>> condition) {
        waitAssert(() -> assertThat(map(elements, UIElement::isEnabled), condition));
        return this;
    }
}
