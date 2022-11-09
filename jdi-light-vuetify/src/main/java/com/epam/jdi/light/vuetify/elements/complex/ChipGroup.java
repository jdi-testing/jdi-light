package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.vuetify.asserts.ChipGroupAssert;
import com.epam.jdi.light.vuetify.elements.common.Chip;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.IsGroupElement;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ChipGroup extends UIBaseElement<ChipGroupAssert> implements IsGroupElement<Chip>, HasTheme {

    @JDIAction("Get list of '{name}' items")
    public List<Chip> groupElements() {
        core().timer().wait(() -> core().finds(".v-chip").isDisplayed());
        return core().finds(".v-chip").stream()
                .map(listItem -> new Chip().setCore(Chip.class, listItem))
                .collect(Collectors.toList());
    }

    @JDIAction("Get {0} element from '{name}'")
    public Chip getElement(String value) {
        return groupElements().stream()
                .filter(element -> element.getText().equals(value))
                .findFirst()
                .get();
    }

    @JDIAction("Select '{0}' in '{name}'")
    public void select(List<String> values) {
        values.forEach(value -> {
            if (!getElement(value).selected()) {
                getElement(value).click();
            }
        });
    }

    public void select(String value) {
        select(Collections.singletonList(value));
    }

    @JDIAction("Deselect '{0}' in '{name}'")
    public void deselect(List<String> values) {
        values.forEach(value -> {
            if (getElement(value).selected()) {
                getElement(value).click();
            }
        });
    }

    public void deselect(String value) {
        deselect(Collections.singletonList(value));
    }

    @JDIAction("Check that {name} is column")
    public boolean isColumn() {
        return core().hasClass("v-chip-group--column");
    }

    @JDIAction("Get next for {name}")
    public Icon next() {
        return new Icon().setCore(Icon.class, find(".v-slide-group__next"));
    }

    @JDIAction("Get previous for {name}")
    public Icon previous() {
        return new Icon().setCore(Icon.class, find(".v-slide-group__prev"));
    }

    @JDIAction("Get 'name' color")
    public String color() {
        return core().css("color");
    }

    @Override
    public ChipGroupAssert is() {
        return new ChipGroupAssert().set(this);
    }
}
