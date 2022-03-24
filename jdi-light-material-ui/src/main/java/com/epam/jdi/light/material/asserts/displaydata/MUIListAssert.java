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

public class MUIListAssert extends UIAssert<MUIListAssert, MUIList> {

    @JDIAction("Assert that '{name}' has size '{0}'")
    public MUIListAssert size(int expectedSize) {
        jdiAssert(element().size(), Matchers.is(expectedSize));
        return this;
    }

    @JDIAction("Assert that 'name' is empty")
    public MUIListAssert empty() {
        jdiAssert(element().isEmpty() ? "is empty" : "is not empty", Matchers.is("is empty"));
        return this;
    }

    @JDIAction("Assert that 'name' is not empty")
    public MUIListAssert notEmpty() {
        jdiAssert(!element().isEmpty() ? "is not empty" : "is empty", Matchers.is("is not empty"));
        return this;
    }

    @JDIAction("Assert that '{name}' contains all items with texts specified in '{0}'")
    public MUIListAssert itemsWithTexts(Set<String> expectedItemTexts) {
        if (expectedItemTexts.isEmpty()) {
            throw new IllegalArgumentException("Set containing expected item names should not be empty");
        } else {
            Set<String> actualItemTexts = element().items().stream().map(MUIListItem::getText)
                    .collect(Collectors.toCollection(HashSet::new));
            jdiAssert(actualItemTexts.containsAll(expectedItemTexts)
                            ? "List contains all items with given texts"
                            : "List does not contain all items with given texts",
                    Matchers.is("List contains all items with given texts"));
            return this;
        }
    }
}
