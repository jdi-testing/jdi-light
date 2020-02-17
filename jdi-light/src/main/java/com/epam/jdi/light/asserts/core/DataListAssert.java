package com.epam.jdi.light.asserts.core;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.DataList;
import com.epam.jdi.light.elements.interfaces.base.IListBase;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.func.JFunc1;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import java.util.Arrays;
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
     *
     * @param condition to compare
     * @return DataListAssert
     */
    @JDIAction("Assert that each of '{name}' elements meet condition")
    public DataListAssert<T, D> each(JFunc1<D, Boolean> condition, String... messages) {
        jdiAssert(LinqUtils.all(data(), condition::execute), Matchers.is(true), messages);
        return this;
    }
    
    /**
     * Check that at least one element meets condition
     *
     * @param condition to compare
     * @return DataListAssert
     */
    @JDIAction("Assert that any of '{name}' elements meet condition")
    public DataListAssert<T, D> any(JFunc1<D, Boolean> condition, String... messages) {
        jdiAssert(LinqUtils.any(data(), condition::execute), Matchers.is(true), messages);
        return this;
    }
    
    /**
     * Check that only one of elements meets condition
     *
     * @param condition to compare
     * @return DataListAssert
     */
    @JDIAction("Assert that only one of '{name}' elements meet condition")
    public DataListAssert<T, D> onlyOne(JFunc1<D, Boolean> condition, String... messages) {
        jdiAssert(single(data(), condition::execute), Matchers.is(notNullValue()), messages);
        return this;
    }
    
    /**
     * Check that none of elements meets condition
     *
     * @param condition to compare
     * @return DataListAssert
     */
    @JDIAction("Assert that none of '{name}' meet condition")
    public DataListAssert<T, D> noOne(JFunc1<D, Boolean> condition, String... messages) {
        jdiAssert(first(data(), condition::execute), Matchers.is(nullValue()), messages);
        return this;
    }
    
    /**
     * Check that element has the item
     *
     * @param item to compare
     * @return DataListAssert
     */
    @JDIAction("Assert that '{name}' text {0}")
    public DataListAssert<T, D> value(D item, String... messages) {
        return and(hasItem(item), messages);
    }
    
    /**
     * Match passed value with elements texts
     *
     * @param condition to compare
     * @return DataListAssert
     */
    @JDIAction("Assert that '{name}' text {0}")
    public DataListAssert<T, D> value(Matcher<String> condition, String ... messages) {
        jdiAssert(print(data(), Object::toString), condition, messages);
        return this;
    }
    
    /**
     * Check that the element has the text
     *
     * @param text to compare
     * @return DataListAssert
     */
    @JDIAction("Assert that '{name}' text {0}")
    public DataListAssert<T, D> value(String text, String ... messages) {
        jdiAssert(select(data(), Object::toString), hasItem(text), messages);
        return this;
    }
    
    /**
     * Check that all elements are displayed
     *
     * @return DataListAssert
     */
    @JDIAction("Assert that '{name}' elements [{0}] are displayed")
    public DataListAssert<T, D> displayed(String... names) {
        for (String name : names)
            jdiAssert(element.get(name).isDisplayed() ? name + "displayed" : "hidden", Matchers.is(name + "displayed"));
        return this;
    }
    
    /**
     * Check that at least one element is displayed
     *
     * @return DataListAssert
     */
    @JDIAction("Assert that '{name}' has at least one displayed element")
    public DataListAssert<T, D> displayed() {
        jdiAssert(element.isDisplayed() ? "displayed" : "hidden", Matchers.is("displayed"));
        return this;
    }
    
    /**
     * Check that all elements are hidden
     *
     * @return DataListAssert
     */
    @JDIAction("Assert that '{name}' is hidden")
    public DataListAssert<T, D> hidden(String ... messages) {
        jdiAssert(map(element, this::isDisplayed), everyItem(Matchers.is(false)), messages);
        return this;
    }
    
    private boolean isDisplayed(T element) {
        try {
            return element.core().isDisplayed();
        } catch (Exception ex) {
            throw exception(ex, "Is element Displayed failed. DataList element not a Section. Only Sections can be assert on isDisplayed");
        }
    }
    
    /**
     * Check that the list is empty
     *
     * @return DataListAssert
     */
    @JDIAction("Assert that '{name}' is empty")
    public DataListAssert<T, D> empty(String ... messages) {
        jdiAssert(element.isEmpty() ? "list is empty" : "list is not empty", Matchers.is("list is empty"), messages);
        return this;
    }
    
    /**
     * Check that the list isn't empty
     *
     * @return DataListAssert
     */
    @JDIAction("Assert that '{name}' is not empty")
    public DataListAssert<T, D> notEmpty(String ... messages) {
        jdiAssert(element.isEmpty() ? "list is empty" : "list is not empty", Matchers.is("list is not empty"), messages);
        return this;
    }
    
    /**
     * Match passed value with element size
     *
     * @param condition to compare
     * @return DataListAssert
     */
    @JDIAction("Assert that '{name}' size {0}")
    public DataListAssert<T, D> size(Matcher<Integer> condition, String... messages) {
        jdiAssert(element.size(), condition, messages);
        return this;
    }
    
    /**
     * Check that the list size is given size
     *
     * @param size to compare
     * @return DataListAssert
     */
    @JDIAction("Assert that '{name}' size {0}")
    public DataListAssert<T, D> size(int size, String... messages) {
        return size(equalTo(size), messages);
    }
    
    /**
     * Match passed value with elements data
     *
     * @param condition to compare
     * @return DataListAssert
     */
    @JDIAction("Assert that '{name}' data {0}")
    public DataListAssert<T, D> and(Matcher<? super List<D>> condition, String... messages) {
        String message = Arrays.stream(messages).reduce("", (s, s1) -> s += " " + s1);
        MatcherAssert.assertThat(message, data(), condition);
        return this;
    }
}
