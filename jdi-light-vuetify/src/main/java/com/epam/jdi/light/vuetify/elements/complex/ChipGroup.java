package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.vuetify.asserts.ChipGroupAssert;
import com.epam.jdi.light.vuetify.elements.common.Chip;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.IsGroupElement;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ChipGroup extends UIBaseElement<ChipGroupAssert> implements IsGroupElement<Chip>, HasTheme {

    @Override
    public ChipGroupAssert is() {
        return new ChipGroupAssert().set(this);
    }

    @Override
    public ChipGroupAssert has() {
        return is();
    }

    @JDIAction("Get size of '{name}'")
    public int size() {
        return groupElements().size();
    }

    @JDIAction("Get list of '{name}' items")
    public List<Chip> groupElements() {
        return core().finds(".v-chip").stream()
                .map(listItem -> new Chip().setCore(Chip.class, listItem))
                .collect(Collectors.toList());
    }

    public Chip getElement(String value) {
        return groupElements().stream()
                .filter(element -> element.getText().equals(value))
                .findFirst()
                .get();
    }

    public void select(List<String> values) {
        values.forEach(value -> {
            if (!getElement(value).selected()) {
                getElement(value).click();
            }});
    }

    public void select(String value) {
        select(Collections.singletonList(value));
    }

    public void deselect(List<String> values) {
        values.forEach(value -> {
            if (getElement(value).selected()) {
            getElement(value).click();
        }});
    }

    public void deselect(String value) {
        deselect(Collections.singletonList(value));
    }

    @JDIAction("Check that {name} is column")
    public boolean isColumn() {
        return core().hasClass("v-chip-group--column");
    }

    @JDIAction("Check that {name} has filter option")
    public boolean hasFilter(String value) {
        return getElement(value).isFilterIconDisplayed();
    }


    @JDIAction("Click on next for {name}")
    public void next() {
        find(".v-slide-group__next").click();
    }

    @JDIAction("Click on prev for {name}")
    public void prev() {
        find(".v-slide-group__prev").click();
    }
}
