package com.epam.jdi.light.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.complex.ISelector;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.tools.func.JFunc;
import org.hamcrest.Matcher;

import java.util.Collection;
import java.util.List;

import static com.epam.jdi.light.asserts.SoftAssert.jdiAssert;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.LinqUtils.map;
import static org.hamcrest.Matchers.*;

public class SelectAssert extends IsAssert<SelectAssert> {
    JFunc<ISelector> selector;

    public SelectAssert(JFunc<ISelector> selector) {
        super(selector.execute());
        this.selector = selector;
    }

    /**
     * Check that the option is selected
     * @param option to compare
     * @return SelectAssert
     */
    @JDIAction("Assert that '{0}' option selected for '{name}'")
    public SelectAssert selected(String option) {
        jdiAssert(selector.execute().selected(option), is(true));
        return this;
    }
    public <TEnum extends Enum> SelectAssert selected(TEnum option) {
        return selected(getEnumValue(option));
    }

    /**
     * Match passed value with selected option
     * @param condition to compare
     * @return SelectAssert
     */
    @JDIAction("Assert that '{name}' selected option {0}")
    public SelectAssert selected(Matcher<? super List<String>> condition) {
        jdiAssert(selector.execute().checked(), condition);
        return this;
    }

    /**
     * Match passed value with selected values
     * @param condition to compare
     * @return SelectAssert
     */
    @JDIAction("Assert that '{name}' values {0}")
    public SelectAssert values(Matcher<? super List<String>> condition) {
        jdiAssert(selector.execute().values(), condition);
        return this;
    }

    /**
     * Match passed value with selected values
     * @param condition to compare
     * @return SelectAssert
     */
    @JDIAction("Assert that '{name}' values {0}")
    public SelectAssert innerValues(Matcher<? super List<String>> condition) {
        jdiAssert(selector.execute().innerValues(), condition);
        return this;
    }

    /**
     * Check that element has the passed items among enabled items
     * @param condition to compare
     * @return SelectAssert
     */
    @JDIAction("Assert that '{name}' enabled items {0}")
    public SelectAssert enabled(Matcher<? super List<String>> condition) {
        jdiAssert(selector.execute().listEnabled(), condition);
        return this;
    }

    /**
     * Check that element has the passed items among disabled items
     * @param condition to compare
     * @return SelectAssert
     */
    @JDIAction("Assert that '{name}' disabled items {0}")
    public SelectAssert disabled(Matcher<? super List<String>> condition) {
        jdiAssert(selector.execute().listDisabled(), condition);
        return this;
    }

    /**
     * Check that all elements have specific texts
     * @param condition to compare
     * @return SelectAssert
     */
    @JDIAction("Assert that all '{name}' texts {0}")
    public SelectAssert texts(Matcher<Collection<? extends String>> condition) {
        jdiAssert(selector.execute().values(), condition);
        return this;
    }

    /**
     * Check that all elements have specific attributes
     * @param condition to compare
     * @return SelectAssert
     */
    @JDIAction("Assert that all '{name}' attributes {0}")
    public SelectAssert attrs(String attrName, Matcher<Collection<? extends String>> condition) {
        jdiAssert(selector.execute().getAllAttributes().keys(), condition);
        return this;
    }

    /**
     * Check that all elements have specific css
     * @param condition to compare
     * @return SelectAssert
     */
    @JDIAction("Assert that all '{name}' elements css '{0}' {1}")
    public SelectAssert allCss(String css, Matcher<Collection<? extends String>> condition) {
        jdiAssert(map(selector.execute().allUI(), el -> el.getCssValue(css)), condition);
        return this;
    }

    /**
     * Check that all elements have specific tags
     * @param condition to compare
     * @return SelectAssert
     */
    @JDIAction("Assert that all '{name}' tags {0}")
    public SelectAssert allTags(Matcher<Collection<? extends String>> condition) {
        jdiAssert(map(selector.execute().allUI(), UIElement::getTagName), condition);
        return this;
    }

    /**
     * Match passed value with element class
     * @param classNames to compare
     * @return SelectAssert
     */
    @JDIAction("Assert that '{name}' has css class {0}")
    public SelectAssert hasCssClasses(String... classNames) {
        return cssClasses(hasItems(classNames));
    }

    /**
     * Check that all elements have specific classes
     * @param condition to compare
     * @return SelectAssert
     */
    @JDIAction("Assert that all '{name}' css classes {0}")
    public SelectAssert cssClasses(Matcher<Iterable<String>> condition) {
        jdiAssert(selector.execute().classes(), condition);
        return this;
    }
    private WebList getWebList() {
        WebList elements = selector.execute().allUI();
        if (elements.size() == 0)
            throw exception("No elements found");
        return elements;
    }

    /**
     * Check that all elements are displayed
     * @return SelectAssert
     */
    @JDIAction("Assert that all '{name}' elements are displayed")
    public SelectAssert allDisplayed() {
        jdiAssert(map(getWebList(), UIElement::isDisplayed), everyItem(is(true)));
        return this;
    }

    /**
     * Check that all elements are hidden
     * @return SelectAssert
     */
    @JDIAction("Assert that all '{name}' elements are hidden")
    public SelectAssert allHidden() {
        jdiAssert(map(getWebList(), UIElement::isDisplayed), everyItem(is(false)));
        return this;
    }

    /**
     * Check that all elements are selected
     * @return SelectAssert
     */
    @JDIAction("Assert that all '{name}' elements are selected")
    public SelectAssert allSelected() {
        jdiAssert(map(getWebList(), UIElement::isSelected), everyItem(is(true)));
        return this;
    }

    /**
     * Check that all elements are enabled
     * @return SelectAssert
     */
    @JDIAction("Assert that all '{name}' elements are enabled")
    public SelectAssert allEnabled() {
        jdiAssert(map(getWebList(), UIElement::isEnabled), everyItem(is(true)));
        return this;
    }

    /**
     * Check that the element is empty
     * @return SelectAssert
     */
    @JDIAction("Assert that '{name}' is empty")
    public SelectAssert empty() {
        jdiAssert(selector.execute().isEmpty() ? "list is empty" : "list is not empty", is("list is empty"));
        return this;
    }

    /**
     * Check that the element isn't empty
     * @return SelectAssert
     */
    @JDIAction("Assert that '{name}' is not empty")
    public SelectAssert notEmpty() {
        jdiAssert(selector.execute().isEmpty() ? "list is empty" : "list is not empty", is("list is not empty"));
        return this;
    }

    /**
     * Match passed value with element size
     * @param condition to compare
     * @return SelectAssert
     */
    @JDIAction("Assert that '{name}' size {0}")
    public SelectAssert size(Matcher<Integer> condition) {
        jdiAssert(selector.execute().size(), condition);
        return this;
    }

    /**
     * Match passed value with element size
     * @param size to compare
     * @return SelectAssert
     */
    @JDIAction("Assert that '{name}' size {0}")
    public SelectAssert size(int size) {
        return size(is(size));
    }
}
