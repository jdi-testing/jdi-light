package com.epam.jdi.light.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.complex.ISelector;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.tools.func.JFunc;
import org.hamcrest.Matcher;

import java.util.Collection;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.LinqUtils.map;
import static com.epam.jdi.light.asserts.SoftAssert.softAssertThat;
import static org.hamcrest.Matchers.*;

public class SelectAssert extends IsAssert<SelectAssert> {
    JFunc<ISelector> selector;

    public SelectAssert(JFunc<ISelector> selector) {
        super(selector.execute());
        this.selector = selector;
    }

    @JDIAction("Assert that '{0}' option selected for '{name}'")
    public SelectAssert selected(String option) {
        softAssertThat(selector.execute().selected(option), is(true));
        return this;
    }
    public <TEnum extends Enum> SelectAssert selected(TEnum option) {
        return selected(getEnumValue(option));
    }
    
    @JDIAction("Assert that '{name}' selected option {0}")
    public SelectAssert selected(Matcher<? super List<String>> condition) {
        softAssertThat(selector.execute().checked(), condition);
        return this;
    }

    @JDIAction("Assert that '{name}' values {0}")
    public SelectAssert values(Matcher<? super List<String>> condition) {
        softAssertThat(selector.execute().values(), condition);
        return this;
    }
    @JDIAction("Assert that '{name}' values {0}")
    public SelectAssert innerValues(Matcher<? super List<String>> condition) {
        softAssertThat(selector.execute().innerValues(), condition);
        return this;
    }
    @JDIAction("Assert that '{name}' enabled items {0}")
    public SelectAssert enabled(Matcher<? super List<String>> condition) {
        softAssertThat(selector.execute().listEnabled(), condition);
        return this;
    }
    @JDIAction("Assert that '{name}' disabled items {0}")
    public SelectAssert disabled(Matcher<? super List<String>> condition) {
        softAssertThat(selector.execute().listDisabled(), condition);
        return this;
    }
    @JDIAction("Assert that all '{name}' texts {0}")
    public SelectAssert texts(Matcher<Collection<? extends String>> condition) {
        softAssertThat(selector.execute().values(), condition);
        return this;
    }
    @JDIAction("Assert that all '{name}' attributes {0}")
    public SelectAssert attrs(String attrName, Matcher<Collection<? extends String>> condition) {
        softAssertThat(selector.execute().getAllAttributes().keys(), condition);
        return this;
    }
    @JDIAction("Assert that all '{name}' elements css '{0}' {1}")
    public SelectAssert allCss(String css, Matcher<Collection<? extends String>> condition) {
        softAssertThat(map(selector.execute().allUI(), el -> el.getCssValue(css)), condition);
        return this;
    }
    @JDIAction("Assert that all '{name}' tags {0}")
    public SelectAssert allTags(Matcher<Collection<? extends String>> condition) {
        softAssertThat(map(selector.execute().allUI(), UIElement::getTagName), condition);
        return this;
    }

    @JDIAction("Assert that '{name}' has css class {0}")
    public SelectAssert hasCssClasses(String... classNames) {
        return cssClasses(hasItems(classNames));
    }
    @JDIAction("Assert that all '{name}' css classes {0}")
    public SelectAssert cssClasses(Matcher<Iterable<String>> condition) {
        softAssertThat(selector.execute().classes(), condition);
        return this;
    }
    private WebList getWebList() {
        WebList elements = selector.execute().allUI();
        if (elements.size() == 0)
            throw exception("No elements found");
        return elements;
    }
    @JDIAction("Assert that all '{name}' elements are displayed")
    public SelectAssert allDisplayed() {
        softAssertThat(map(getWebList(), UIElement::isDisplayed), everyItem(is(true)));
        return this;
    }
    @JDIAction("Assert that all '{name}' elements are hidden")
    public SelectAssert allHidden() {
        softAssertThat(map(getWebList(), UIElement::isDisplayed), everyItem(is(false)));
        return this;
    }
    @JDIAction("Assert that all '{name}' elements are selected")
    public SelectAssert allSelected() {
        softAssertThat(map(getWebList(), UIElement::isSelected), everyItem(is(true)));
        return this;
    }
    @JDIAction("Assert that all '{name}' elements are enabled")
    public SelectAssert allEnabled() {
        softAssertThat(map(getWebList(), UIElement::isEnabled), everyItem(is(true)));
        return this;
    }
    @JDIAction("Assert that '{name}' is empty")
    public SelectAssert empty() {
        softAssertThat(selector.execute().isEmpty() ? "list is empty" : "list is not empty", is("list is empty"));
        return this;
    }
    @JDIAction("Assert that '{name}' is not empty")
    public SelectAssert notEmpty() {
        softAssertThat(selector.execute().isEmpty() ? "list is empty" : "list is not empty", is("list is not empty"));
        return this;
    }
    @JDIAction("Assert that '{name}' size {0}")
    public SelectAssert size(Matcher<Integer> condition) {
        softAssertThat(selector.execute().size(), condition);
        return this;
    }
    @JDIAction("Assert that '{name}' size {0}")
    public SelectAssert size(int size) {
        return size(is(size));
    }
}
