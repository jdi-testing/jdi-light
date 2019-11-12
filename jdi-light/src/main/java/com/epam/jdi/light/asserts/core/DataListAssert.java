package com.epam.jdi.light.asserts.core;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.DataList;
import com.epam.jdi.light.elements.interfaces.base.IListBase;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.func.JFunc1;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.tools.LinqUtils.*;
import static com.epam.jdi.tools.PrintUtils.print;
import static org.hamcrest.Matchers.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class DataListAssert<T extends IListBase, D>
        extends UISelectAssert<DataListAssert<T, D>, DataList<T, D>> {
    public List<D> data() {
        element.refresh();
        return element.asData();
    }

    /**
     * Check that all elements meet condition
     * @param condition to compare
     * @return DataListAssert
     */
    @JDIAction("Assert that each of '{name}' elements meet condition")
    public DataListAssert<T, D> each(JFunc1<D, Boolean> condition) {
        jdiAssert(LinqUtils.all(data(), condition::execute), is(true));
        return this;
    }

    /**
     * Check that at least one element meets condition
     * @param condition to compare
     * @return DataListAssert
     */
    @JDIAction("Assert that any of '{name}' elements meet condition")
    public DataListAssert<T, D> any(JFunc1<D, Boolean> condition) {
        jdiAssert(LinqUtils.any(data(), condition::execute), is(true));
        return this;
    }

    /**
     * Check that only one of elements meets condition
     * @param condition to compare
     * @return DataListAssert
     */
    @JDIAction("Assert that only one of '{name}' elements meet condition")
    public DataListAssert<T, D> onlyOne(JFunc1<D, Boolean> condition) {
        jdiAssert(single(data(), condition::execute), is(notNullValue()));
        return this;
    }

    /**
     * Check that none of elements meets condition
     * @param condition to compare
     * @return DataListAssert
     */
    @JDIAction("Assert that none of '{name}' meet condition")
    public DataListAssert<T, D> noOne(JFunc1<D, Boolean> condition) {
        jdiAssert(first(data(), condition::execute), is(nullValue()));
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
        jdiAssert(print(data(), Object::toString), condition);
        return this;
    }

    /**
     * Check that the element has the text
     * @param text to compare
     * @return DataListAssert
     */
    @JDIAction("Assert that '{name}' text {0}")
    public DataListAssert<T, D> value(String text) {
        jdiAssert(select(data(), Object::toString), hasItem(text));
        return this;
    }

    /**
     * Check that all elements are displayed
     * @return DataListAssert
     */
    @JDIAction("Assert that '{name}' elements [{0}] are displayed")
    public DataListAssert<T, D> displayed(String... names) {
        for (String name : names)
            jdiAssert(element.get(name).isDisplayed() ? name + "displayed" : "hidden", is(name + "displayed"));
        return this;
    }

    /**
     * Check that at least one element is displayed
     * @return DataListAssert
     */
    @JDIAction("Assert that '{name}' has at least one displayed element")
    public DataListAssert<T, D> displayed() {
        jdiAssert(element.isDisplayed() ? "displayed" : "hidden", is("displayed"));
        return this;
    }

    /**
     * Check that all elements are hidden
     * @return DataListAssert
     */
    @JDIAction("Assert that '{name}' is hidden")
    public DataListAssert<T, D> hidden() {
        jdiAssert(map(element, this::isDisplayed), everyItem(is(false)));
        return this;
    }
    private boolean isDisplayed(T element) {
        try {
            return element.core().isDisplayed();
        } catch (Exception ex) { throw exception("Is element Displayed failed. DataList element not a Section. Only Sections can be assert on isDisplayed"); }
    }

    /**
     * Check that the list is empty
     * @return DataListAssert
     */
    @JDIAction("Assert that '{name}' is empty")
    public DataListAssert<T, D> empty() {
        jdiAssert(element.isEmpty() ? "list is empty" : "list is not empty", is("list is empty"));
        return this;
    }

    /**
     * Check that the list isn't empty
     * @return DataListAssert
     */
    @JDIAction("Assert that '{name}' is not empty")
    public DataListAssert<T, D> notEmpty() {
        jdiAssert(element.isEmpty() ? "list is empty" : "list is not empty", is("list is not empty"));
        return this;
    }

    /**
     * Match passed value with element size
     * @param condition to compare
     * @return DataListAssert
     */
    @JDIAction("Assert that '{name}' size {0}")
    public DataListAssert<T, D> size(Matcher<Integer> condition) {
        jdiAssert(element.size(), condition);
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
        MatcherAssert.assertThat(data(), condition);
        return this;
    }
}
