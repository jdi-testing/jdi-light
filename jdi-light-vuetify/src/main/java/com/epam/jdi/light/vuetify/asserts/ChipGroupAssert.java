package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.ChipGroup;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link ChipGroup}
 */
public class ChipGroupAssert extends SlideGroupAssert {

    @Override
    public ChipGroup element() {
        return (ChipGroup) super.element();
    }

    /**
     * Checks that Chip Group has given current size.
     *
     * @param expectedSize expected current size
     * @return this {@link ChipGroupAssert} instance
     */
    @JDIAction("Assert that '{name}' has size '{0}'")
    public ChipGroupAssert size(int expectedSize) {
        jdiAssert(element().size(), Matchers.is(expectedSize));
        return this;
    }

    /**
     * Checks that Chip Group contains all given texts
     *
     * @param chipTexts expected chip texts
     * @return this {@link ChipGroupAssert} instance
     */
    @JDIAction("Assert that '{name}' contains all chips with texts in '{0}'")
    public ChipGroupAssert containsTexts(List<String> chipTexts) {
        if (chipTexts.size() == 0) {
            throw new IllegalArgumentException("Set containing expected chip names should have non-zero size");
        } else {
            jdiAssert(element().containsTexts(chipTexts) ? "Chip group contains all chips with given texts" : "Chip group does not contain all items with given texts",
                    Matchers.is("Chip group contains all chips with given texts"));
            return this;
        }
    }

    /**
     * Checks that Chip Group is selected with given text
     *
     * @param text full text content of item to be found
     * @return this {@link ChipGroupAssert} instance
     */
    @JDIAction("Assert that '{name}' with text '{0}' is selected")
    public ChipGroupAssert selected(String text) {
        jdiAssert(element().isSelected(text) ? "is selected" : "is deselected", Matchers.is("is selected"));
        return this;
    }

    /**
     * Checks that Chip Group is deselected with given text
     *
     * @param text full text content of item to be found
     * @return this {@link ChipGroupAssert} instance
     */
    @JDIAction("Assert that '{name}' with text '{0}' is deselected")
    public ChipGroupAssert deselected(String text) {
        jdiAssert(element().isDeselected(text) ? "is deselected" : "is selected", Matchers.is("is deselected"));
        return this;
    }

}
