package com.epam.jdi.light.material.asserts.displaydata;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.material.interfaces.displaydata.IMUIList;
import org.hamcrest.Matchers;

import java.util.Arrays;
import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.light.common.Exceptions.runtimeException;

public abstract class ListCommonAssert<A extends UIAssert<?, ?>, E extends IMUIList> extends UIAssert<A, E> {

    /**
     * Checks that list has given size.
     *
     * @param size expected size
     * @return the same assert for chaining
     */
    @JDIAction("Assert that '{name}' has size {0}")
    public A size(int size) {
        jdiAssert(element().size(), Matchers.is(size));
        return (A) this;
    }

    /**
     * Checks that list is empty.
     * @return the same assert for chaining
     */
    @JDIAction("Assert that '{name}' is empty")
    public A empty() {
        jdiAssert(element().isEmpty(), Matchers.is(true), "List is not empty");
        return (A) this;
    }

    /**
     * Checks that list is not empty.
     * @return the same assert for chaining
     */
    @JDIAction("Assert that '{name}' is not empty")
    public A notEmpty() {
        jdiAssert(element().isEmpty(), Matchers.is(false), "List is empty");
        return (A) this;
    }

    /**
     * Checks that list has headers.
     * @return the same assert for chaining
     */
    @JDIAction("Assert that '{name}' has headers")
    public A headers() {
        jdiAssert(element().hasHeaders(), Matchers.is(true), "List has no headers");
        return (A) this;
    }

    /**
     * Checks that list has headers.
     * @return the same assert for chaining
     */
    @JDIAction("Assert that '{name}' has no headers")
    public A noHeaders() {
        jdiAssert(!element().hasHeaders(), Matchers.is(true), "List has headers");
        return (A) this;
    }

    /**
     * Checks that list contains all items with given texts.
     *
     * @param itemTexts expected items
     * @return the same assert for chaining
     */
    @JDIAction("Assert that '{name}' contains all items with texts '{0}'")
    public A itemsWithTexts(String... itemTexts) {
        if (itemTexts.length == 0) {
            throw runtimeException("Set containing expected item names should not be empty");
        } else {
            List<String> expList = Arrays.asList(itemTexts);
            List<ICoreElement> items = element().items();
            String[] notExistsTexts = items.stream()
                    .map(el -> el.core().text())
                    .filter(s -> !expList.contains(s))
                    .toArray(String[]::new);
            jdiAssert(notExistsTexts, Matchers.emptyArray());
            return (A) this;
        }
    }
}
