package com.epam.jdi.light.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.func.JFunc1;
import org.hamcrest.Matcher;

import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.tools.LinqUtils.all;
import static com.epam.jdi.tools.LinqUtils.map;
import static com.epam.jdi.tools.PrintUtils.print;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UIListAssert<T extends Section, E> {
    List<E> data;
    List<T> elements;
    String name;

    public UIListAssert(List<T> elements, List<E> data, String name) {
        this.data = data;
        this.elements = elements;
        this.name = name;
    }

    @JDIAction("Assert that each of '{name}' elements {0}")
    public UIListAssert<T, E> each(JFunc1<E, Boolean> condition) {
        assertThat(all(data, condition::execute), is(true));
        return this;
    }
    @JDIAction("Assert that any of '{name}' elements {0}")
    public UIListAssert<T, E> any(JFunc1<E, Boolean> condition) {
        assertThat(LinqUtils.any(data, condition::execute), is(true));
        return this;
    }

    @JDIAction("Assert that only one of '{name}' elements {0}")
    public UIListAssert<T, E> onlyOne(JFunc1<E, Boolean> condition) {
        assertThat(LinqUtils.single(data, condition::execute), is(notNullValue()));
        return this;
    }
    @JDIAction("Assert that none of '{name}' {0} ")
    public UIListAssert<T, E> noOne(JFunc1<E, Boolean> condition) {
        assertThat(LinqUtils.first(data, condition::execute), is(nullValue()));
        return this;
    }
    @JDIAction("Assert that '{name}' text {0}")
    public UIListAssert<T, E> value(Matcher<String> condition) {
        assertThat(print(data, Object::toString), condition);
        return this;
    }
    @JDIAction("Assert that '{name}' is displayed")
    public UIListAssert<T, E> allDisplayed() {
        assertThat(map(elements, this::isDisplayed), everyItem(is(true)));
        return this;
    }
    @JDIAction("Assert that '{name}' has at least one displayed element")
    public UIListAssert<T, E> displayed() {
        assertThat(map(elements, this::isDisplayed), hasItem(true));
        return this;
    }
    @JDIAction("Assert that '{name}' is hidden")
    public UIListAssert<T, E> hidden() {
        assertThat(map(elements, this::isDisplayed), everyItem(is(false)));
        return this;
    }
    private boolean isDisplayed(T element) {
        try {
            return element.get().isDisplayed();
        } catch (Exception ex) { throw exception("Is element Displayed failed. UIList element not a Section. Only Sections can be assert on isDisplayed"); }
    }
    @JDIAction("Assert that '{name}' is empty")
    public UIListAssert<T, E> empty() {
        assertThat(elements.isEmpty() ? "list is empty" : "list is not empty", is("list is empty"));
        return this;
    }
    @JDIAction("Assert that '{name}' is not empty")
    public UIListAssert<T, E> notEmpty() {
        assertThat(elements.isEmpty() ? "list is empty" : "list is not empty", is("list is not empty"));
        return this;
    }
    @JDIAction("Assert that '{name}' size {0}")
    public UIListAssert<T, E> size(Matcher<Integer> condition) {
        assertThat(elements.size(), condition);
        return this;
    }
}
