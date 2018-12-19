package com.epam.jdi.light.asserts;

import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.func.JFunc1;

import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.tools.LinqUtils.all;

public class UIListAssert<E> {
    List<E> elements;

    public UIListAssert(List<E> elements) {
        this.elements = elements;
    }
    public void each(JFunc1<E, Boolean> condition) {
        if (!all(elements, condition::execute))
            throw exception("");
    }
    public void any(JFunc1<E, Boolean> condition) {
        if (!LinqUtils.any(elements, condition::execute))
            throw exception("");
    }

    public void onlyOne(JFunc1<E, Boolean> condition) {
        if (LinqUtils.single(elements, condition::execute) == null)
            throw exception("");
    }
    public void noOne(JFunc1<E, Boolean> condition) {
        if (LinqUtils.first(elements, condition::execute) != null)
            throw exception("");
    }

    /*
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
    }*/
}
