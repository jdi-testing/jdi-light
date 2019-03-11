package com.epam.jdi.light.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.complex.ISelector;
import com.epam.jdi.light.elements.complex.WebList;
import org.hamcrest.Matcher;

import java.util.Collection;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.LinqUtils.map;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;

public class SelectAssert extends IsAssert {
    ISelector selector;

    public SelectAssert(ISelector selector) {
        super(selector);
        this.selector = selector;
    }

    @JDIAction("Assert that '{0}' option selected for '{name}'")
    public SelectAssert selected(String option) {
        assertThat(selector.selected(option), is(true));
        return this;
    }
    public <TEnum extends Enum> SelectAssert selected(TEnum option) {
        return selected(getEnumValue(option));
    }
    
    @JDIAction("Assert that '{name}' selected option {0}")
    public SelectAssert selected(Matcher<? super List<String>> condition) {
        assertThat(selector.checked(), condition);
        return this;
    }

    @JDIAction("Assert that '{name}' values {0}")
    public SelectAssert values(Matcher<? super List<String>> condition) {
        assertThat(selector.values(), condition);
        return this;
    }
    @JDIAction("Assert that '{name}' enabled items {0}")
    public SelectAssert enabled(Matcher<? super List<String>> condition) {
        assertThat(selector.listEnabled(), condition);
        return this;
    }
    @JDIAction("Assert that '{name}' disabled items {0}")
    public SelectAssert disabled(Matcher<? super List<String>> condition) {
        assertThat(selector.listDisabled(), condition);
        return this;
    }
    @JDIAction("Assert that all '{name}' texts {0}")
    public SelectAssert texts(Matcher<Collection<? extends String>> condition) {
        assertThat(selector.values(), condition);
        return this;
    }
    @JDIAction("Assert that all '{name}' attributes {0}")
    public SelectAssert attrs(String attrName, Matcher<Collection<? extends String>> condition) {
        assertThat(selector.getAllAttributes().keys(), condition);
        return this;
    }
    @JDIAction("Assert that all '{name}' elements css '{0}' {1}")
    public SelectAssert allCss(String css, Matcher<Collection<? extends String>> condition) {
        assertThat(map(selector.allUI(), el -> el.getCssValue(css)), condition);
        return this;
    }
    @JDIAction("Assert that all '{name}' tags {0}")
    public SelectAssert allTags(Matcher<Collection<? extends String>> condition) {
        assertThat(map(selector.allUI(), UIElement::getTagName), condition);
        return this;
    }

    @JDIAction("Assert that '{name}' has css class {0}")
    public SelectAssert hasCssClasses(String... classNames) {
        return cssClasses(hasItems(classNames));
    }
    @JDIAction("Assert that all '{name}' css classes {0}")
    public SelectAssert cssClasses(Matcher<Iterable<String>> condition) {
        assertThat(selector.classes(), condition);
        return this;
    }
    private WebList getWebList() {
        WebList elements = selector.allUI();
        if (elements.size() == 0)
            throw exception("No elements found");
        return elements;
    }
    @JDIAction("Assert that all '{name}' elements are displayed")
    public SelectAssert allDisplayed() {
        assertThat(map(getWebList(), UIElement::isDisplayed), everyItem(is(true)));
        return this;
    }
    @JDIAction("Assert that all '{name}' elements are hidden")
    public SelectAssert allHidden() {
        assertThat(map(getWebList(), UIElement::isDisplayed), everyItem(is(false)));
        return this;
    }
    @JDIAction("Assert that all '{name}' elements are selected")
    public SelectAssert allSelected() {
        assertThat(map(getWebList(), UIElement::isSelected), everyItem(is(true)));
        return this;
    }
    @JDIAction("Assert that all '{name}' elements are enabled")
    public SelectAssert allEnabled() {
        assertThat(map(getWebList(), UIElement::isEnabled), everyItem(is(true)));
        return this;
    }
    @JDIAction("Assert that '{name}' is empty")
    public SelectAssert empty() {
        assertThat(selector.isEmpty() ? "list is empty" : "list is not empty", is("list is empty"));
        return this;
    }
    @JDIAction("Assert that '{name}' is not empty")
    public SelectAssert notEmpty() {
        assertThat(selector.isEmpty() ? "list is empty" : "list is not empty", is("list is not empty"));
        return this;
    }
    @JDIAction("Assert that '{name}' size {0}")
    public SelectAssert size(Matcher<Integer> condition) {
        assertThat(selector.size(), condition);
        return this;
    }
    @JDIAction("Assert that '{name}' size {0}")
    public SelectAssert size(int size) {
        return size(is(size));
    }
}
