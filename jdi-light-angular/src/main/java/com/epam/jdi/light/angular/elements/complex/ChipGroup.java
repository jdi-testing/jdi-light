package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.ChipGroupAssert;
import com.epam.jdi.light.angular.elements.common.Chip;
import com.epam.jdi.light.angular.elements.interfaces.FormField;
import com.epam.jdi.light.angular.elements.interfaces.HasOrientation;
import com.epam.jdi.light.angular.elements.interfaces.IsGroupElement;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

import java.util.List;
import java.util.stream.Collectors;

public class ChipGroup extends UIBaseElement<ChipGroupAssert> implements IsGroupElement<Chip>, HasOrientation, FormField {

    public static final String CHIP_LOCATOR = ".mat-mdc-chip";

    @Override
    @JDIAction("Get list of '{name}' items")
    public List<Chip> groupElements() {
        core().timer().wait(() -> core().finds(CHIP_LOCATOR).isDisplayed());
        return core().finds(CHIP_LOCATOR).stream()
                .map(listItem -> new Chip().setCore(Chip.class, listItem))
                .collect(Collectors.toList());
    }

    @Override
    @JDIAction("Get {0} element from '{name}'")
    public Chip getElement(String value) {
        return groupElements().stream()
                .filter(element -> element.labelText().equals(value))
                .findFirst()
                .get();
    }

    @JDIAction("Get if {0} element exist in '{name}'")
    public boolean hasElement(String value) {
        return groupElements().stream()
                .anyMatch(chip -> chip.labelText().equals(value));
    }

    @Override
    @JDIAction("Get if all chips elements in '{name}' is enabled")
    public boolean isEnabled() {
        return groupElements().stream()
                .allMatch(ICoreElement::isEnabled);
    }

    @JDIAction("Select chip element in '{name}' by '{0}'")
    public void selectByLabel(String text) {
        Chip chip = getElement(text);
        chip.select();
    }

    @JDIAction("Select chip element in '{name}' by '{0}'")
    public void selectByLabel(List<String> values) {
        values.forEach(value -> {
            Chip chip = getElement(value);
            chip.select();
        });

    }

    @JDIAction("Deselect chip element in '{name}' by '{0}'")
    public void unselectByLabel(String text) {
        Chip chip = getElement(text);
        chip.unselect();
    }

    @JDIAction("Deselect chip element in '{name}' by '{0}'")
    public void unselectByLabel(List<String> values) {
        values.forEach(value -> {
            Chip chip = getElement(value);
            chip.unselect();
        });

    }

    @Override
    @JDIAction("Get if '{name}' is vertical")
    public boolean isVertical() {
        return core().attr("class").contains("mat-chip-list-stacked");
    }

    @JDIAction("Get if '{name}' has multiple selection")
    public String multiselectable() {
        return core().attr("aria-multiselectable");
    }

    @Override
    public ChipGroupAssert is() {
        return new ChipGroupAssert().set(this);
    }
}
