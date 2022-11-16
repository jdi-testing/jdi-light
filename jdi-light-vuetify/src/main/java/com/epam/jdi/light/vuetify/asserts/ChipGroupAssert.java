package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.ChipGroup;
import com.epam.jdi.light.vuetify.interfaces.asserts.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link ChipGroup}
 */
public class ChipGroupAssert extends UIAssert<ChipGroupAssert, ChipGroup>
        implements ThemeAssert<ChipGroupAssert, ChipGroup>, ColorAssert<ChipGroupAssert, ChipGroup> {

    @JDIAction("Assert that '{name}' has values '{0}'")
    public ChipGroupAssert text(List<String> values) {
        Set<String> actualValues = element().getTexts();
        jdiAssert(actualValues.containsAll(values),
                Matchers.is(true), String.format("Element actual values '%s' contains not all the expected" +
                        " values '%s'", actualValues, values));
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
        int actualSize = element().size();
        jdiAssert(actualSize, Matchers.is(size), String.format("Actual size '%s' is not equal to expected '%s'",
                actualSize, size));
        return this;
    }

    @JDIAction("Assert that '{name}' is column")
    public ChipGroupAssert column() {
        jdiAssert(element().isColumn(), Matchers.is(true), "Element is not column");
        return this;
    }

    @JDIAction("Assert that '{name}' is not column")
    public ChipGroupAssert notColumn() {
        jdiAssert(element().isColumn(), Matchers.is(false), "Element is column");
        return this;
    }
}
