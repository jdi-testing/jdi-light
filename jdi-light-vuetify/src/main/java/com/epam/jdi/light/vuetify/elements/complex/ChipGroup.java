package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.vuetify.asserts.ChipGroupAssert;
import com.epam.jdi.light.vuetify.elements.common.Chip;

import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.common.Exceptions.runtimeException;

/**
 * Chip Group is a group of Chip elements.
 *
 * To see an example of Chip Group web element please visit <a href="https://vuetifyjs.com/en/components/chip-groups/">Vuetify Test Page</a>
 */
public class ChipGroup extends UIListBase<ChipGroupAssert> {

    /**
     * Locator for Chip.
     */
    private static final String CHIP_LOCATOR = ".v-chip";

    public ChipGroupAssert is() {
        return new ChipGroupAssert().set(this);
    }

    @JDIAction("Get '{name}' slide group")
    public SlideGroup slideGroup() {
        return new SlideGroup().setCore(SlideGroup.class, core());
    }

    /**
     * Gets items of this Chip.
     *
     * @return items of this Chip as {@link List} of {@link Chip}
     */
    @JDIAction("Get list of '{name}' items")
    public List<Chip> chips() {
        return core().finds(CHIP_LOCATOR).stream()
                .map(listItem -> new Chip().setCore(Chip.class, listItem))
                .collect(Collectors.toList());
    }

    /**
     * Checks if this Chip Group contains all chip with given texts.
     *
     * @param chipTexts full texts of item to be found
     * @return {@code true} if this Chip Group contains all chip with given texts, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' contains all chip with texts in '{0}'")
    public boolean containsTexts(List<String> chipTexts) {
        return chips().stream().map(Chip::getText).collect(Collectors.toSet()).containsAll(chipTexts);
    }

    /**
     * Gets size of this Chip.
     *
     * @return size of this Chip as {@code int}
     */
    @JDIAction("Get size of '{name}'")
    @Override
    public int size() {
        return chips().size();
    }

//    @JDIAction("Check if '{name}' is empty")
//    public boolean isEmpty() {
//        return size() == 0;
//    }

    /**
     * Gets specific item of this list Chip using its text (full equality is used by searching).
     *
     * @param chipText full text of item to be found
     * @return item of this list Chip as {@link Chip}
     * @throws RuntimeException if no items found
     */
    @JDIAction("Get first chip with text '{0}' in '{name}'")
    public Chip chipByText(String chipText) {
        for (Chip chip : chips()) {
            if (chip.getText().equals(chipText)) {
                return chip;
            }
        }
        throw runtimeException(String.format("Group does not contain a chip with specified text '%s'", chipText));
    }

    /**
     * Selects a first Chip by its text (full equality is used by searching).
     *
     * @param chipText full text of item to be found
     */
    @JDIAction("Select first chip with text '{0}' in '{name}' by clicking it")
    @Override
    public void select(String chipText) {
        if (!chipByText(chipText).isActive()) {
            chipByText(chipText).click();
        }
    }

    /**
     * Selects multiple Chip by its text (full equality is used by searching).
     *
     * @param chipTexts multiple full texts of list item to be found
     */
    @JDIAction("Select chips with provided texts contained in '{name}' by clicking")
    @Override
    public void select(String... chipTexts) {
        for (String text : chipTexts) {
            select(text);
        }
    }

    /**
     * Deselects a first Chip by its text (full equality is used by searching).
     *
     * @param chipText full text of item to be found
     */
    @JDIAction("Deselect first chip with text '{0}' in '{name}' by clicking it")
    public void deselect(String chipText) {
        if (chipByText(chipText).isActive()) {
            chipByText(chipText).click();
        }
    }

    /**
     * Deselects multiple Chip by its text (full equality is used by searching).
     *
     * @param chipTexts full texts of list item to be found
     */
    @JDIAction("Deselect chips with provided texts contained in '{name}' by clicking")
    public void deselect(String... chipTexts) {
        for (String text : chipTexts) {
            deselect(text);
        }
    }

    /**
     * Checks if this Chip is selected or not by its text.
     *
     * @param chipText full text of item to be found
     * @return {@code true} if this Chip is selected, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' with text '{0}' is active")
    public boolean isSelected(String chipText) {
        return chipByText(chipText).isActive();
    }

    /**
     * Checks if this Chip is deselected or not by its text.
     *
     * @param text full text of item to be found
     * @return {@code true} if chi Chip is deselected, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' with text '{0}' is inactive")
    public boolean isDeselected(String text) {
        return !isSelected(text);
    }

    /**
     * Closes a first Chip by its text.
     *
     * @param chipText full text of item to be found
     */
    @JDIAction("Close first chip with text '{0}' in '{name}' by clicking its close button")
    public void close(String chipText) {
        chipByText(chipText).close();
    }

    /**
     * Closes multiple Chip by its text.
     *
     * @param chipTexts multiple full texts of list item to be found
     */
    @JDIAction("Close chips with provided texts contained in '{name}' by clicking their close buttons")
    public void close(String... chipTexts) {
        for (String text : chipTexts) {
            close(text);
        }
    }
}
