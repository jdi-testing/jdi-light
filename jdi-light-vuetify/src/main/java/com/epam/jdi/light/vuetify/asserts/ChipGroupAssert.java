package com.epam.jdi.light.vuetify.asserts;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Chip;
import com.epam.jdi.light.vuetify.elements.complex.ChipGroup;
import org.hamcrest.Matchers;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


public class ChipGroupAssert extends UIAssert<ChipGroupAssert, ChipGroup> {

    @JDIAction("Assert that '{name}' has size '{0}'")
    public ChipGroupAssert size(int expectedSize) {
        jdiAssert(element().size(), Matchers.is(expectedSize));
        return this;
    }

    @JDIAction("Assert that '{name}' is empty")
    public ChipGroupAssert empty() {
        jdiAssert(element().isEmpty() ? "empty" : "not empty", Matchers.is("empty"));
        return this;
    }

    @JDIAction("Assert that '{name}' is empty")
    public ChipGroupAssert notEmpty() {
        jdiAssert(element().isEmpty() ? "empty" : "not empty", Matchers.is("not empty"));
        return this;
    }

    @JDIAction("Assert that '{name}' contains all chips with texts specified in '{0}'")
    public ChipGroupAssert chipsWithTexts(Set<String> expectedChipTexts) {
        if (expectedChipTexts.size() == 0) {
            throw new IllegalArgumentException("Set containing expected chip names should have non-zero size");
        } else {
            Set<String> actualChipTexts = element().chips().stream().map(Chip::getText)
                    .collect(Collectors.toCollection(HashSet::new));
            jdiAssert(actualChipTexts.containsAll(expectedChipTexts) ?
                            "Chip group contains all chips with given texts" :
                            "Chip group does not contain all items with given texts",
                    Matchers.is("Chip group contains all chips with given texts"));
            return this;
        }
    }

    @JDIAction("Assert that chip with text '{0}' is selected")
    public ChipGroupAssert selectedChip(String chipText) {
        jdiAssert(element().hasSelectedChip(chipText) ? "selected" : "not selected", Matchers.is("selected"));
        return this;
    }
}
