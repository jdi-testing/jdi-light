package com.epam.jdi.light.asserts.core;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.tools.func.JFunc;
import org.hamcrest.Matcher;

import java.util.Collection;
import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.LinqUtils.map;
import static org.hamcrest.Matchers.*;

public class ListAssert extends IsAssert<ListAssert, JList> {
    JFunc<JList> elements;

    public ListAssert(JFunc<JList> elements, String name) {
        super(elements.execute().setName(name));
        this.elements = elements;
    }
    /**
     * Check that the option is selected
     * @param option to compare
     * @return SelectAssert
     */
    @JDIAction("Assert that '{0}' option selected for '{name}'")
    public ListAssert selected(String option) {
        jdiAssert(elements.execute().selected(option), is(true));
        return this;
    }
    public <TEnum extends Enum> ListAssert selected(TEnum option) {
        return selected(getEnumValue(option));
    }

    /**
     * Match passed value with selected option
     * @param condition to compare
     * @return ListAssert<T>
     */
    @JDIAction("Assert that '{name}' selected option {0}")
    public ListAssert selected(Matcher<? super List<String>> condition) {
        jdiAssert(elements.execute().checked(), condition);
        return this;
    }

    /**
     * Match passed value with selected values
     * @param condition to compare
     * @return ListAssert<T>
     */
    @JDIAction("Assert that '{name}' values {0}")
    public ListAssert values(Matcher<? super List<String>> condition) {
        jdiAssert(elements.execute().values(), condition);
        return this;
    }

    /**
     * Match passed value with selected values
     * @param condition to compare
     * @return ListAssert<T>
     */
    @JDIAction("Assert that '{name}' values {0}")
    public ListAssert innerValues(Matcher<? super List<String>> condition) {
        jdiAssert(elements.execute().innerValues(), condition);
        return this;
    }

    /**
     * Check that element has the passed items among enabled items
     * @param condition to compare
     * @return ListAssert<T>
     */
    @JDIAction("Assert that '{name}' enabled items {0}")
    public ListAssert enabled(Matcher<? super List<String>> condition) {
        jdiAssert(elements.execute().listEnabled(), condition);
        return this;
    }

    /**
     * Check that element has the passed items among disabled items
     * @param condition to compare
     * @return ListAssert<T>
     */
    @JDIAction("Assert that '{name}' disabled items {0}")
    public ListAssert disabled(Matcher<? super List<String>> condition) {
        jdiAssert(elements.execute().listDisabled(), condition);
        return this;
    }

    /**
     * Check that all elements have specific texts
     * @param condition to compare
     * @return ListAssert<T>
     */
    @JDIAction("Assert that all '{name}' texts {0}")
    public ListAssert texts(Matcher<Collection<? extends String>> condition) {
        jdiAssert(elements.execute().values(), condition);
        return this;
    }

    /**
     * Check that all elements have specific attributes
     * @param condition to compare
     * @return ListAssert<T>
     */
    @JDIAction("Assert that all '{name}' attributes {0}")
    public ListAssert attrs(Matcher<Collection<? extends String>> condition) {
        jdiAssert(elements.execute().getAllAttributes().keys(), condition);
        return this;
    }

    /**
     * Check that all elements have specific css
     * @param condition to compare
     * @return ListAssert<T>
     */
    @JDIAction("Assert that all '{name}' elements css '{0}' {1}")
    public ListAssert allCss(String css, Matcher<Collection<? extends String>> condition) {
        jdiAssert(map(elements.execute().allUI(), el -> el.getCssValue(css)), condition);
        return this;
    }

    /**
     * Check that all elements have specific tags
     * @param condition to compare
     * @return ListAssert<T>
     */
    @JDIAction("Assert that all '{name}' tags {0}")
    public ListAssert allTags(Matcher<Collection<? extends String>> condition) {
        jdiAssert(map(elements.execute().allUI(), UIElement::getTagName), condition);
        return this;
    }

    /**
     * Match passed value with element class
     * @param classNames to compare
     * @return ListAssert<T>
     */
    @JDIAction("Assert that '{name}' has css class {0}")
    public ListAssert hasCssClasses(String... classNames) {
        return cssClasses(hasItems(classNames));
    }

    /**
     * Check that all elements have specific classes
     * @param condition to compare
     * @return ListAssert<T>
     */
    @JDIAction("Assert that all '{name}' css classes {0}")
    public ListAssert cssClasses(Matcher<Iterable<String>> condition) {
        jdiAssert(elements.execute().classes(), condition);
        return this;
    }

    /**
     * Check that all elements are displayed
     * @return ListAssert<T>
     */
    @JDIAction("Assert that all '{name}' elements are displayed")
    public ListAssert allDisplayed() {
        jdiAssert(map(elements.execute().allUI(), UIElement::isDisplayed), everyItem(is(true)));
        return this;
    }

    /**
     * Check that all elements are hidden
     * @return ListAssert<T>
     */
    @JDIAction("Assert that all '{name}' elements are hidden")
    public ListAssert allHidden() {
        jdiAssert(map(elements.execute().allUI(), UIElement::isDisplayed), everyItem(is(false)));
        return this;
    }

    /**
     * Check that all elements are selected
     * @return ListAssert<T>
     */
    @JDIAction("Assert that all '{name}' elements are selected")
    public ListAssert allSelected() {
        jdiAssert(map(elements.execute().allUI(), UIElement::isSelected), everyItem(is(true)));
        return this;
    }

    /**
     * Check that all elements are enabled
     * @return ListAssert<T>
     */
    @JDIAction("Assert that all '{name}' elements are enabled")
    public ListAssert allEnabled() {
        jdiAssert(map(elements.execute().allUI(), UIElement::isEnabled), everyItem(is(true)));
        return this;
    }

    /**
     * Check that the element is empty
     * @return ListAssert<T>
     */
    @JDIAction("Assert that '{name}' is empty")
    public ListAssert empty() {
        jdiAssert(elements.execute().isEmpty() ? "list is empty" : "list is not empty", is("list is empty"));
        return this;
    }

    /**
     * Check that the element isn't empty
     * @return ListAssert<T>
     */
    @JDIAction("Assert that '{name}' is not empty")
    public ListAssert notEmpty() {
        jdiAssert(elements.execute().isEmpty() ? "list is empty" : "list is not empty", is("list is not empty"));
        return this;
    }

    /**
     * Match passed value with element size
     * @param condition to compare
     * @return ListAssert<T>
     */
    @JDIAction("Assert that '{name}' size {0}")
    public ListAssert size(Matcher<Integer> condition) {
        jdiAssert(elements.execute().size(), condition);
        return this;
    }

    /**
     * Match passed value with element size
     * @param size to compare
     * @return ListAssert<T>
     */
    @JDIAction("Assert that '{name}' size {0}")
    public ListAssert size(int size) {
        return size(is(size));
    }
}
