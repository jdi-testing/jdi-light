package com.epam.jdi.light.asserts;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.func.JFunc1;
import org.hamcrest.Matcher;

import java.util.List;

import static com.epam.jdi.light.asserts.BaseSelectorAssert.waitAssert;
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

    public UIListAssert<T, E> each(JFunc1<E, Boolean> condition) {
        waitAssert(() -> assertThat(all(data, condition::execute), is(true)), name);
        return this;
    }
    public UIListAssert<T, E> any(JFunc1<E, Boolean> condition) {
        waitAssert(() -> assertThat(LinqUtils.any(data, condition::execute), is(true)), name);
        return this;
    }

    public UIListAssert<T, E> onlyOne(JFunc1<E, Boolean> condition) {
        waitAssert(() -> assertThat(LinqUtils.single(data, condition::execute), is(notNullValue())), name);
        return this;
    }
    public UIListAssert<T, E> noOne(JFunc1<E, Boolean> condition) {
        waitAssert(() -> assertThat(LinqUtils.first(data, condition::execute), is(nullValue())), name);
        return this;
    }
    public UIListAssert<T, E> value(String expected) {
        waitAssert(() -> assertThat(print(data, Object::toString), is(expected)), name);
        return this;
    }
    public UIListAssert<T, E> allDisplayed() {
        waitAssert(() -> assertThat(map(elements, this::isDisplayed), everyItem(is(true))), name);
        return this;
    }
    public UIListAssert<T, E> displayed() {
        waitAssert(() -> assertThat(map(elements, this::isDisplayed), hasItem(true)), name);
        return this;
    }
    public UIListAssert<T, E> hidden() {
        waitAssert(() -> assertThat(map(elements, this::isDisplayed), everyItem(is(false))), name);
        return this;
    }
    private boolean isDisplayed(T element) {
        try {
            return element.get().isDisplayed();
        } catch (Exception ex) { throw exception("Is element Displayed failed. UIList element not a Section. Only Sections can be assert on isDisplayed"); }
    }
    public UIListAssert<T, E> empty() {
        waitAssert(() -> assertThat(elements.isEmpty() ? "list is empty" : "list is not empty", is("list is empty")), name);
        return this;
    }
    public UIListAssert<T, E> notEmpty() {
        waitAssert(() -> assertThat(elements.isEmpty() ? "list is empty" : "list is not empty", is("list is not empty")), name);
        return this;
    }
    public UIListAssert<T, E> size(Matcher<Integer> condition) {
        waitAssert(() -> assertThat(elements.size(), condition), name);
        return this;
    }
}
