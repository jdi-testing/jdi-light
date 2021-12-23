package com.epam.jdi.light.material.asserts.displaydata;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.List;
import com.epam.jdi.light.material.elements.displaydata.ListItem;
import org.hamcrest.Matchers;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ListAssert extends UIAssert<ListAssert, List> {

    @JDIAction("Assert that '{name}' is dense")
    public ListAssert dense() {
        jdiAssert(element().isDense() ? "is dense" : "is not dense", Matchers.is("is dense"));
        return this;
    }

    @JDIAction("Assert that '{name}' is not dense")
    public ListAssert notDense() {
        jdiAssert(!element().isDense() ? "is not dense" : "is dense", Matchers.is("is not dense"));
        return this;
    }

    @JDIAction("Assert that '{name}' has size '{0}'")
    public ListAssert size(int expectedSize) {
        jdiAssert(element().size(), Matchers.is(expectedSize));
        return this;
    }

    @JDIAction("Assert that 'name' is empty")
    public ListAssert empty() {
        jdiAssert(element().isEmpty() ? "is empty" : "is not empty", Matchers.is("is empty"));
        return this;
    }

    @JDIAction("Assert that 'name' is empty")
    public ListAssert notEmpty() {
        jdiAssert(!element().isEmpty() ? "is not empty" : "is empty", Matchers.is("is not empty"));
        return this;
    }

    @JDIAction("Assert that '{name}' contains all items with texts specified in '{0}'")
    public ListAssert itemsWithTexts(Set<String> expectedItemTexts) {
        if (expectedItemTexts.size() == 0) {
            throw new IllegalArgumentException("Set containing expected item names should have non-zero size");
        } else {
            Set<String> actualItemTexts = element().items().stream().map(ListItem::getText)
                    .collect(Collectors.toCollection(HashSet::new));
            jdiAssert(actualItemTexts.containsAll(expectedItemTexts) ?
                            "List contains all items with given texts" :
                            "List does not contain all items with given texts",
                    Matchers.is("List contains all items with given texts"));
            return this;
        }
    }

    @JDIAction("Assert that '{name}' contains item with text '{0}'")
    public ListAssert itemWithText(String expectedItemText) {
        String itemFoundStatus = element().items().stream().anyMatch(item -> item.getText().equals(expectedItemText)) ?
                "List contains an item with provided text" : "List does not contain any items with provided text" ;
        jdiAssert(itemFoundStatus, Matchers.is("List contains an item with provided text"));
        return this;
    }
}
