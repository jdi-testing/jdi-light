package com.epam.jdi.light.asserts;

import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.func.JFunc1;

import java.util.List;

import static com.epam.jdi.light.asserts.BaseSelectorAssert.waitAssert;
import static com.epam.jdi.tools.LinqUtils.all;
import static com.epam.jdi.tools.PrintUtils.print;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UIListAssert<E> {
    List<E> elements;
    String name;

    public UIListAssert(List<E> elements, String name) {
        this.elements = elements;
        this.name = name;
    }

    public UIListAssert<E> each(JFunc1<E, Boolean> condition) {
        waitAssert(() -> assertThat(all(elements, condition::execute), is(true)), name);
        return this;
    }
    public UIListAssert<E> any(JFunc1<E, Boolean> condition) {
        waitAssert(() -> assertThat(LinqUtils.any(elements, condition::execute), is(true)), name);
        return this;
    }

    public UIListAssert<E> onlyOne(JFunc1<E, Boolean> condition) {
        waitAssert(() -> assertThat(LinqUtils.single(elements, condition::execute), is(notNullValue())), name);
        return this;
    }
    public UIListAssert<E> noOne(JFunc1<E, Boolean> condition) {
        waitAssert(() -> assertThat(LinqUtils.first(elements, condition::execute), is(nullValue())), name);
        return this;
    }
    public UIListAssert<E> value(String expected) {
        waitAssert(() -> assertThat(print(elements, Object::toString), is(expected)), name);
        return this;
    }
}
