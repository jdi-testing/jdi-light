package com.epam.jdi.light.asserts.core;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.DataList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.func.JFunc1;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.tools.LinqUtils.*;
import static com.epam.jdi.tools.PrintUtils.print;
import static org.hamcrest.Matchers.*;

public class DataListAssert<T extends Section, D> extends UISelectAssert<DataListAssert, DataList<T, D>> {
    List<T> elements;
    JFunc<List<D>> data;
    public String name;
    public String jdi_element;
    public String failElement;

    public DataListAssert(List<T> elements, JFunc<List<D>> data, String name, String failElement) {
        super();
        uiElement.setName("Not Allowed in UI List");
        this.elements = elements;
        this.data = data;
        this.name = name;
        jdi_element = elements.toString();
        this.failElement = failElement;
    }

    /**
     * Check that all elements meet condition
     * @param condition to compare
     * @return DataListAssert
     */
    @JDIAction("Assert that each of '{name}' elements meet condition")
    public DataListAssert<T, D> each(JFunc1<D, Boolean> condition) {
        jdiAssert(all(data.execute(), condition::execute), is(true));
        return this;
    }

    /**
     * Check that at least one element meets condition
     * @param condition to compare
     * @return DataListAssert
     */
    @JDIAction("Assert that any of '{name}' elements meet condition")
    public DataListAssert<T, D> any(JFunc1<D, Boolean> condition) {
        jdiAssert(LinqUtils.any(data.execute(), condition::execute), is(true));
        return this;
    }

    /**
     * Check that only one of elements meets condition
     * @param condition to compare
     * @return DataListAssert
     */
    @JDIAction("Assert that only one of '{name}' elements meet condition")
    public DataListAssert<T, D> onlyOne(JFunc1<D, Boolean> condition) {
        jdiAssert(single(data.execute(), condition::execute), is(notNullValue()));
        return this;
    }

    /**
     * Check that none of elements meets condition
     * @param condition to compare
     * @return DataListAssert
     */
    @JDIAction("Assert that none of '{name}' meet condition")
    public DataListAssert<T, D> noOne(JFunc1<D, Boolean> condition) {
        jdiAssert(first(data.execute(), condition::execute), is(nullValue()));
        return this;
    }

    /**
     * Check that element has the item
     * @param item to compare
     * @return DataListAssert
     */
    @JDIAction("Assert that '{name}' text {0}")
    public DataListAssert<T, D> value(D item) {
        return and(hasItem(item));
    }

    /**
     * Match passed value with elements texts
     * @param condition to compare
     * @return DataListAssert
     */
    @JDIAction("Assert that '{name}' text {0}")
    public DataListAssert<T, D> value(Matcher<String> condition) {
        jdiAssert(print(data.execute(), Object::toString), condition);
        return this;
    }

    /**
     * Check that the element has the text
     * @param text to compare
     * @return DataListAssert
     */
    @JDIAction("Assert that '{name}' text {0}")
    public DataListAssert<T, D> value(String text) {
        elements.clear();
        jdiAssert(select(data.execute(), Object::toString), hasItem(text));
        return this;
    }

    /**
     * Check that all elements are displayed
     * @return DataListAssert
     */
    @JDIAction("Assert that '{name}' is displayed")
    public DataListAssert<T, D> allDisplayed() {
        elements.clear();
        jdiAssert(map(elements, this::isDisplayed), everyItem(is(true)));
        return this;
    }

    /**
     * Check that at least one element is displayed
     * @return DataListAssert
     */
    @JDIAction("Assert that '{name}' has at least one displayed element")
    public DataListAssert<T, D> displayed() {
        elements.clear();
        jdiAssert(map(elements, this::isDisplayed), hasItem(true));
        return this;
    }

    /**
     * Check that all elements are hidden
     * @return DataListAssert
     */
    @JDIAction("Assert that '{name}' is hidden")
    public DataListAssert<T, D> hidden() {
        elements.clear();
        jdiAssert(map(elements, this::isDisplayed), everyItem(is(false)));
        return this;
    }
    private boolean isDisplayed(T element) {
        try {
            return element.get().isDisplayed();
        } catch (Exception ex) { throw exception("Is element Displayed failed. DataList element not a Section. Only Sections can be assert on isDisplayed"); }
    }

    /**
     * Check that the list is empty
     * @return DataListAssert
     */
    @JDIAction("Assert that '{name}' is empty")
    public DataListAssert<T, D> empty() {
        elements.clear();
        jdiAssert(elements.isEmpty() ? "list is empty" : "list is not empty", is("list is empty"));
        return this;
    }

    /**
     * Check that the list isn't empty
     * @return DataListAssert
     */
    @JDIAction("Assert that '{name}' is not empty")
    public DataListAssert<T, D> notEmpty() {
        elements.clear();
        jdiAssert(elements.isEmpty() ? "list is empty" : "list is not empty", is("list is not empty"));
        return this;
    }

    /**
     * Match passed value with element size
     * @param condition to compare
     * @return DataListAssert
     */
    @JDIAction("Assert that '{name}' size {0}")
    public DataListAssert<T, D> size(Matcher<Integer> condition) {
        elements.clear();
        jdiAssert(elements.size(), condition);
        return this;
    }

    /**
     * Check that the list size is given size
     * @param size to compare
     * @return DataListAssert
     */
    @JDIAction("Assert that '{name}' size {0}")
    public DataListAssert<T, D> size(int size) {
        return size(equalTo(size));
    }

    /**
     * Match passed value with elements data
     * @param condition to compare
     * @return DataListAssert
     */
    @JDIAction("Assert that '{name}' data {0}")
    public DataListAssert<T, D> and(Matcher<? super List<D>> condition) {
        elements.clear();
        MatcherAssert.assertThat(data.execute(), condition);
        return this;
    }
}
