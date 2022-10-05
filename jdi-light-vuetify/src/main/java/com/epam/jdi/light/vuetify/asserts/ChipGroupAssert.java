package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Chip;
import com.epam.jdi.light.vuetify.elements.complex.ChipGroup;
import org.hamcrest.Matchers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link ChipGroup}
 */
public class ChipGroupAssert extends UIAssert<ChipGroupAssert, ChipGroup> {

    @JDIAction("Assert that {name} is disabled")
    public ChipGroupAssert text(List<String> values) {
        jdiAssert(element().groupElements().stream()
                .map(Chip::getText)
                .collect(Collectors.toSet()).containsAll(values) ? "has all elements" : "has not all elements",
                Matchers.is("has all elements"));
        return this;
    }

    @JDIAction("Assert that '{0}' option selected for '{name}'")
    public ChipGroupAssert selected(List<String> options) {
        options.forEach(option -> element().getElement(option).is().selected());
        return this;
    }

    @JDIAction("Assert that '{0}' option selected for '{name}'")
    public ChipGroupAssert selected(String option) {
        selected(Collections.singletonList(option));
        return this;
    }

    @JDIAction("Assert that '{0}' option deselected for '{name}'")
    public ChipGroupAssert deselected(String option) {
        deselected(Collections.singletonList(option));
        return this;
    }

    @JDIAction("Assert that '{0}' option deselected for '{name}'")
    public ChipGroupAssert deselected(List<String> options) {
        options.forEach(option -> element().getElement(option).is().deselected());
        return this;
    }

    @JDIAction("Assert that '{name}' size {0}")
    public ChipGroupAssert size(int size) {
        jdiAssert(element().size(), Matchers.is(size));
        return this;
    }

    @JDIAction("Assert that '{name}' is column")
    public ChipGroupAssert column() {
        jdiAssert(element().isColumn() ? "column" : "not column", Matchers.is("column"));
        return this;
    }

    @JDIAction("Assert that theme of '{name}' is light")
    public ChipGroupAssert lightTheme() {
        jdiAssert(element().isLightTheme(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that theme of '{name}' is dark")
    public ChipGroupAssert darkTheme() {
        jdiAssert(element().isDarkTheme(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has filter icon")
    public ChipGroupAssert filterIcon(String value) {
        filterIcon(Collections.singletonList(value));
        return this;
    }

    @JDIAction("Assert that '{name}' has filter icon")
    public ChipGroupAssert filterIcon(List<String> values) {
        values.forEach(value -> jdiAssert(element().hasFilter(value), Matchers.is(true)));
        return this;
    }

}
