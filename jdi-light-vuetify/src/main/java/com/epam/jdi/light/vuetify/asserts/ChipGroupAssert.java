package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.ChipGroup;
import com.epam.jdi.light.asserts.generic.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

import java.util.Collections;
import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link ChipGroup}
 */
public class ChipGroupAssert extends UIAssert<ChipGroupAssert, ChipGroup>
        implements ThemeAssert<ChipGroupAssert, ChipGroup>, ColorAssert<ChipGroupAssert, ChipGroup> {

    @JDIAction(value = "Assert that '{name}' has values '{0}'", isAssert = true)
    public ChipGroupAssert text(List<String> values) {
        jdiAssert(element().getTexts(), Matchers.containsInAnyOrder(values));
        return this;
    }

    @JDIAction(value = "Assert that '{0}' option selected for '{name}'", isAssert = true)
    public ChipGroupAssert selected(List<String> options) {
        options.forEach(option -> element().getElement(option).is().selected());
        return this;
    }

    @JDIAction(value = "Assert that '{0}' option selected for '{name}'", isAssert = true)
    public ChipGroupAssert selected(String option) {
        selected(Collections.singletonList(option));
        return this;
    }

    @JDIAction(value = "Assert that '{0}' option deselected for '{name}'", isAssert = true)
    public ChipGroupAssert deselected(String option) {
        deselected(Collections.singletonList(option));
        return this;
    }

    @JDIAction(value = "Assert that '{0}' option deselected for '{name}'", isAssert = true)
    public ChipGroupAssert deselected(List<String> options) {
        options.forEach(option -> element().getElement(option).is().deselected());
        return this;
    }

    @JDIAction(value = "Assert that '{name}' size is {0}", isAssert = true)
    public ChipGroupAssert size(int size) {
        jdiAssert(element().size(), Matchers.is(size));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is column", isAssert = true)
    public ChipGroupAssert column() {
        jdiAssert(element().isColumn(), Matchers.is(true), "ChipGroup is not column");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not column", isAssert = true)
    public ChipGroupAssert notColumn() {
        jdiAssert(element().isColumn(), Matchers.is(false), "ChipGroup is column");
        return this;
    }
}
