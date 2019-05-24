package com.epam.jdi.light.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.func.JFunc1;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;

import java.util.List;

import static com.epam.jdi.light.asserts.SoftAssert.jdiAssert;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.tools.LinqUtils.*;
import static com.epam.jdi.tools.PrintUtils.print;
import static org.hamcrest.Matchers.*;

public class UIListAssert<T extends Section, E> extends IsAssert<UIListAssert<T, E>> {
    List<T> elements;
    JFunc<List<E>> data;
    public String name;
    public String jdi_element;
    public String failElement;

    public UIListAssert(List<T> elements, JFunc<List<E>> data, String name, String failElement) {
        super($("Not Allowed in UI List"));
        this.elements = elements;
        this.data = data;
        this.name = name;
        jdi_element = elements.toString();
        this.failElement = failElement;
    }

    /**
     * Check that all elements meet condition
     * @param condition to compare
     * @return UIListAssert
     */
    @JDIAction("Assert that each of '{name}' elements meet condition")
    public UIListAssert<T, E> each(JFunc1<E, Boolean> condition) {
        jdiAssert(all(data.execute(), condition::execute), is(true));
        return this;
    }

    /**
     * Check that at least one element meets condition
     * @param condition to compare
     * @return UIListAssert
     */
    @JDIAction("Assert that any of '{name}' elements meet condition")
    public UIListAssert<T, E> any(JFunc1<E, Boolean> condition) {
        jdiAssert(LinqUtils.any(data.execute(), condition::execute), is(true));
        return this;
    }

    /**
     * Check that only one of elements meets condition
     * @param condition to compare
     * @return UIListAssert
     */
    @JDIAction("Assert that only one of '{name}' elements meet condition")
    public UIListAssert<T, E> onlyOne(JFunc1<E, Boolean> condition) {
        jdiAssert(single(data.execute(), condition::execute), is(notNullValue()));
        return this;
    }

    /**
     * Check that none of elements meets condition
     * @param condition to compare
     * @return UIListAssert
     */
    @JDIAction("Assert that none of '{name}' meet condition")
    public UIListAssert<T, E> noOne(JFunc1<E, Boolean> condition) {
        jdiAssert(first(data.execute(), condition::execute), is(nullValue()));
        return this;
    }

    /**
     * Check that element has the item
     * @param item to compare
     * @return UIListAssert
     */
    @JDIAction("Assert that '{name}' text {0}")
    public UIListAssert<T, E> value(E item) {
        return and(hasItem(item));
    }

    /**
     * Match passed value with elements texts
     * @param condition to compare
     * @return UIListAssert
     */
    @JDIAction("Assert that '{name}' text {0}")
    public UIListAssert<T, E> value(Matcher<String> condition) {
        jdiAssert(print(data.execute(), Object::toString), condition);
        return this;
    }

    /**
     * Check that the element has the text
     * @param text to compare
     * @return UIListAssert
     */
    @JDIAction("Assert that '{name}' text {0}")
    public UIListAssert<T, E> value(String text) {
        elements.clear();
        jdiAssert(select(data.execute(), Object::toString), hasItem(text));
        return this;
    }

    /**
     * Check that all elements are displayed
     * @return UIListAssert
     */
    @JDIAction("Assert that '{name}' is displayed")
    public UIListAssert<T, E> allDisplayed() {
        elements.clear();
        jdiAssert(map(elements, this::isDisplayed), everyItem(is(true)));
        return this;
    }

    /**
     * Check that at least one element is displayed
     * @return UIListAssert
     */
    @JDIAction("Assert that '{name}' has at least one displayed element")
    public UIListAssert<T, E> displayed() {
        elements.clear();
        jdiAssert(map(elements, this::isDisplayed), hasItem(true));
        return this;
    }

    /**
     * Check that all elements are hidden
     * @return UIListAssert
     */
    @JDIAction("Assert that '{name}' is hidden")
    public UIListAssert<T, E> hidden() {
        elements.clear();
        jdiAssert(map(elements, this::isDisplayed), everyItem(is(false)));
        return this;
    }
    private boolean isDisplayed(T element) {
        try {
            return element.get().isDisplayed();
        } catch (Exception ex) { throw exception("Is element Displayed failed. UIList element not a Section. Only Sections can be assert on isDisplayed"); }
    }

    /**
     * Check that the list is empty
     * @return UIListAssert
     */
    @JDIAction("Assert that '{name}' is empty")
    public UIListAssert<T, E> empty() {
        elements.clear();
        jdiAssert(elements.isEmpty() ? "list is empty" : "list is not empty", is("list is empty"));
        return this;
    }

    /**
     * Check that the list isn't empty
     * @return UIListAssert
     */
    @JDIAction("Assert that '{name}' is not empty")
    public UIListAssert<T, E> notEmpty() {
        elements.clear();
        jdiAssert(elements.isEmpty() ? "list is empty" : "list is not empty", is("list is not empty"));
        return this;
    }

    /**
     * Match passed value with element size
     * @param condition to compare
     * @return UIListAssert
     */
    @JDIAction("Assert that '{name}' size {0}")
    public UIListAssert<T, E> size(Matcher<Integer> condition) {
        elements.clear();
        jdiAssert(elements.size(), condition);
        return this;
    }

    /**
     * Check that the list size is given size
     * @param size to compare
     * @return UIListAssert
     */
    @JDIAction("Assert that '{name}' size {0}")
    public UIListAssert<T, E> size(int size) {
        return size(equalTo(size));
    }

    /**
     * Match passed value with elements data
     * @param condition to compare
     * @return UIListAssert
     */
    @JDIAction("Assert that '{name}' data {0}")
    public UIListAssert<T, E> and(Matcher<? super List<E>> condition) {
        elements.clear();
        MatcherAssert.assertThat(data.execute(), condition);
        return this;
    }
}
