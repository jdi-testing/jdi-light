package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.elements.complex.WebList;
import org.hamcrest.Matcher;
import org.openqa.selenium.WebElement;

import java.util.Collection;
import java.util.List;

import static com.epam.jdi.tools.LinqUtils.map;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ListAssert {
    List<UIElement> elements;
    List<String> values;
    public ListAssert(WebList elements) {
        this.elements = elements.allUI();
        this.values = elements.values();
    }

    public void texts(Matcher<Collection<? extends String>> condition) {
        assertThat(values, condition);
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
