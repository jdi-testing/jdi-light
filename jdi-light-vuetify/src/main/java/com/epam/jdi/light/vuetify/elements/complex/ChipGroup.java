package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.vuetify.asserts.ChipGroupAssert;
import com.epam.jdi.light.vuetify.elements.common.Chip;

import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.common.Exceptions.runtimeException;

/**
 * Chip Group is a group of Chip elements.
 *
 * To see an example of Chip Group web element please visit https://vuetifyjs.com/en/components/chip-groups/
 */
public class ChipGroup extends UIBaseElement<ChipGroupAssert> {

    private static final String CHIP_LOCATOR = ".v-chip";

    public ChipGroupAssert is() {
        return new ChipGroupAssert().set(this);
    }

    @JDIAction("Get '{name}' slide group")
    public SlideGroup slideGroup() {
        return new SlideGroup().setCore(SlideGroup.class, core());
    }

    @JDIAction("Get list of chips contained in '{name}'")
    public List<Chip> chips() {
        return finds(CHIP_LOCATOR).stream()
                .map(listItem -> new Chip().setCore(Chip.class, listItem))
                .collect(Collectors.toList());
    }

    @JDIAction("Get '{name}' size")
    public int size() {
        return chips().size();
    }

    @JDIAction("Check if '{name}' is empty")
    public boolean isEmpty() {
        return size() == 0;
    }

    @JDIAction("Get first chip with text '{0}' in '{name}'")
    public Chip getChipByText(String chipText) {
        for (Chip chip : chips()) {
            if (chip.getText().equals(chipText)) {
                return chip;
            }
        }
        throw runtimeException("Group does not contain a chip with specified text");
    }

    @JDIAction("Select first chip with text '{0}' in '{name}' by clicking it")
    public void select(String chipText) {
        if (!getChipByText(chipText).isActive()) { getChipByText(chipText).click(); }
    }

    @JDIAction("Select chips with provided texts contained in '{name}' by clicking")
    public void select(String... chipTexts) {
        for (String text : chipTexts) {
            select(text);
        }
    }

    @JDIAction("Deselect first chip with text '{0}' in '{name}' by clicking it")
    public void deselect(String chipText) {
        if (getChipByText(chipText).isActive()) { getChipByText(chipText).click(); }
    }

    @JDIAction("Deselect chips with provided texts contained in '{name}' by clicking")
    public void deselect(String... chipTexts) {
        for (String text : chipTexts) {
            deselect(text);
        }
    }

    @JDIAction("Check if chip with text '{0}' in '{name}' is active")
    public boolean hasSelectedChip(String chipText) {
        return getChipByText(chipText).isActive();
    }

    @JDIAction("Close first chip with text '{0}' in '{name}' by clicking its close button")
    public void close(String chipText) {
        getChipByText(chipText).close();
    }

    @JDIAction("Close chips with provided texts contained in '{name}' by clicking their close buttons")
    public void close(String... chipTexts) {
        for (String text : chipTexts) {
            close(text);
        }
    }
}
