package com.epam.jdi.light.material.asserts.displaydata;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.material.interfaces.displaydata.IMUIList;
import org.hamcrest.Matchers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public abstract class ListCommonAssert<A extends UIAssert<?,?>, E extends IMUIList> extends UIAssert<A, E> {

    /**
     * Checks that list has given size.
     */
    @JDIAction("Assert that '{name}' has size {0}")
    public A size(int size) {
        jdiAssert(element().size(), Matchers.is(size));
        return (A) this;
    }

    /**
     * Checks that list is empty.
     */
    @JDIAction("Assert that '{name}' is empty")
    public A empty() {
        jdiAssert(element().isEmpty() ? "is empty" : "is not empty", Matchers.is("is empty"));
        return (A) this;
    }

    /**
     * Checks that list is not empty.
     */
    @JDIAction("Assert that '{name}' is not empty")
    public A notEmpty() {
        jdiAssert(!element().isEmpty() ? "is not empty" : "is empty", Matchers.is("is not empty"));
        return (A) this;
    }

    /**
     * Checks that list has headers.
     */
    @JDIAction("Assert that '{name}' has headers")
    public A headers() {
        jdiAssert(element().hasHeaders(), Matchers.is(true));
        return (A) this;
    }

    /**
     * Checks that list has headers.
     */
    @JDIAction("Assert that '{name}' has no headers")
    public A noHeaders() {
        jdiAssert(!element().hasHeaders(), Matchers.is(true));
        return (A) this;
    }

    /**
     * Checks that list contains all items with given texts.
     */
    @JDIAction("Assert that '{name}' contains all items with texts '{0}'")
    public A itemsWithTexts(Set<String> itemTexts) {
        if (itemTexts.isEmpty()) {
            throw new IllegalArgumentException("Set containing expected item names should not be empty");
        } else {
            List<ICoreElement> items = element().items();
            Set<String> actualItemTexts = items.stream().map(el -> el.core().text())
                    .collect(Collectors.toCollection(HashSet::new));
            jdiAssert(actualItemTexts.containsAll(itemTexts)
                            ? "List contains all items with given texts"
                            : "List does not contain all items with given texts",
                    Matchers.is("List contains all items with given texts"));
            return (A) this;
        }
    }
}
