package com.epam.jdi.light.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.BaseElement;
import com.epam.jdi.light.elements.base.BaseUIElement;
import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.complex.Selector;
import org.hamcrest.Matcher;
import org.openqa.selenium.WebElement;

import java.util.Collection;
import java.util.List;

import static com.epam.jdi.tools.LinqUtils.map;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ListAssert<T extends BaseUIElement> extends SelectAssert {
    List<T> elements;

    public ListAssert(List<T> elements, String name) {
        super(new Selector().setName(name));
        this.elements = elements;
    }

    @JDIAction("Assert that all '{name}' texts {0}")
    public ListAssert<T> texts(Matcher<Collection<? extends String>> condition) {
        assertThat(map(elements, WebElement::getText), condition);
        return this;
    }
    @JDIAction("Assert that all '{name}' attributes {0}")
    public ListAssert<T> attrs(String attrName, Matcher<Collection<? extends String>> condition) {
        assertThat(map(elements, el -> el.getAttribute(attrName)), condition);
        return this;
    }
    @JDIAction("Assert that all '{name}' elements css '{0}' {1}")
    public ListAssert<T> allCss(String css, Matcher<Collection<? extends String>> condition) {
        assertThat(map(elements, el -> el.getCssValue(css)), condition);
        return this;
    }
    @JDIAction("Assert that all '{name}' tags {0}")
    public ListAssert<T> allTags(Matcher<Collection<? extends String>> condition) {
        assertThat(map(elements, WebElement::getTagName), condition);
        return this;
    }
    @JDIAction("Assert that all '{name}' css classes {0}")
    public ListAssert<T> cssClasses(Matcher<Collection<? extends String>> condition) {
        assertThat(map(elements, el -> el.getAttribute("class")), condition);
        return this;
    }
    @JDIAction("Assert that all '{name}' elements are displayed")
    public ListAssert<T> allDisplayed() {
        assertThat(map(elements, BaseUIElement::isDisplayed), everyItem(is(true)));
        return this;
    }
    @Override
    @JDIAction("Assert that at least one '{name}' element is displayed")
    public ListAssert<T> displayed() {
        assertThat(map(elements, BaseUIElement::isDisplayed), hasItem(true));
        return this;
    }
    @JDIAction("Assert that all '{name}' elements are hidden")
    public ListAssert<T> allHidden() {
        assertThat(map(elements, BaseUIElement::isDisplayed), everyItem(is(false)));
        return this;
    }
    @JDIAction("Assert that all '{name}' elements are selected")
    public ListAssert<T> allSelected(Matcher<Collection<? extends Boolean>> condition) {
        assertThat(map(elements, BaseUIElement::isSelected), condition);
        return this;
    }
    @JDIAction("Assert that all '{name}' elements are enabled")
    public ListAssert<T> allEnabled(Matcher<Collection<? extends Boolean>> condition) {
        assertThat(map(elements, BaseUIElement::isEnabled), condition);
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
    @JDIAction("Assert that '{name}' size {0}")
    public ListAssert<T> size(Matcher<Integer> condition) {
        assertThat(elements.size(), condition);
        return this;
    }
}
