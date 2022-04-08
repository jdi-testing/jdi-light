package com.epam.jdi.light.material.asserts.displaydata;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.MUIList;
import com.epam.jdi.light.material.elements.displaydata.MUIListItem;
import org.hamcrest.Matchers;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link MUIList}.
 */
public class MUIListAssert extends UIAssert<MUIListAssert, MUIList> {

    /**
     * Checks that list has given size.
     *
     * @param size expected size
     * @return this {@link MUIListAssert} instance
     */
    @JDIAction("Assert that '{name}' has size {0}")
    public MUIListAssert size(int size) {
        jdiAssert(element().size(), Matchers.is(size));
        return this;
    }

    /**
     * Checks that list is empty.
     *
     * @return this {@link MUIListAssert} instance
     */
    @JDIAction("Assert that '{name}' is empty")
    public MUIListAssert empty() {
        jdiAssert(element().isEmpty() ? "is empty" : "is not empty", Matchers.is("is empty"));
        return this;
    }

    /**
     * Checks that list is not empty.
     *
     * @return this {@link MUIListAssert} instance
     */
    @JDIAction("Assert that '{name}' is not empty")
    public MUIListAssert notEmpty() {
        jdiAssert(!element().isEmpty() ? "is not empty" : "is empty", Matchers.is("is not empty"));
        return this;
    }

    /**
     * Checks that list contains all items with given texts.
     *
     * @param itemTexts expected item texts to be contained in list
     * @return this {@link MUIListAssert} instance
     */
    @JDIAction("Assert that '{name}' contains all items with texts '{0}'")
    public MUIListAssert itemsWithTexts(Set<String> itemTexts) {
        if (itemTexts.isEmpty()) {
            throw new IllegalArgumentException("Set containing expected item names should not be empty");
        } else {
            Set<String> actualItemTexts = element().items().stream().map(MUIListItem::getText)
                    .collect(Collectors.toCollection(HashSet::new));
            jdiAssert(actualItemTexts.containsAll(itemTexts)
                            ? "List contains all items with given texts"
                            : "List does not contain all items with given texts",
                    Matchers.is("List contains all items with given texts"));
            return this;
        }
    }
}
