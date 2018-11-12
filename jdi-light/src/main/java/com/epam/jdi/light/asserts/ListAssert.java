package com.epam.jdi.light.asserts;

import com.epam.jdi.light.elements.base.UIElement;
import org.hamcrest.Matcher;
import org.openqa.selenium.WebElement;

import java.util.Collection;
import java.util.List;

import static com.epam.jdi.tools.LinqUtils.map;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ListAssert<T extends UIElement> {
    List<T> elements;

    public ListAssert(List<T> elements) {
        this.elements = elements;
    }

    public void texts(Matcher<Collection<? extends String>> condition) {
        assertThat(map(elements, WebElement::getText), condition);
    }
    public void attrs(String attrName, Matcher<Collection<? extends String>> condition) {
        assertThat(map(elements, el -> el.getAttribute(attrName)), condition);
    }
    public void css(String css, Matcher<Collection<? extends String>> condition) {
        assertThat(map(elements, el -> el.getCssValue(css)), condition);
    }
    public void tags(Matcher<Collection<? extends String>> condition) {
        assertThat(map(elements, WebElement::getTagName), condition);
    }
    public void cssClasses(Matcher<Collection<? extends String>> condition) {
        assertThat(map(elements, el -> el.getAttribute("class")), condition);
    }
    public void allDisplayed() {
        assertThat(map(elements, UIElement::isDisplayed), everyItem(is(true)));
    }
    public void displayed() {
        assertThat(map(elements, UIElement::isDisplayed), hasItem(true));
    }
    public void hidden() {
        assertThat(map(elements, UIElement::isDisplayed), everyItem(is(false)));
    }
    public void selected(Matcher<Collection<? extends Boolean>> condition) {
        assertThat(map(elements, UIElement::isSelected), condition);
    }
    public void enabled(Matcher<Collection<? extends Boolean>> condition) {
        assertThat(map(elements, UIElement::isEnabled), condition);
    }
}
