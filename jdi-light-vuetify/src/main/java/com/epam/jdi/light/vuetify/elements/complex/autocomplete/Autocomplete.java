package com.epam.jdi.light.vuetify.elements.complex.autocomplete;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.annotations.JAutocomplete;
import com.epam.jdi.light.vuetify.asserts.AutocompleteAssert;

import java.lang.reflect.Field;
import java.util.List;

import static com.epam.jdi.light.elements.base.Conditions.displayed;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.UIFactory.$$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * To see an example of Autocompletes please visit https://vuetifyjs.com/en/components/autocompletes/
 */

public class Autocomplete extends UIBaseElement<AutocompleteAssert> implements ISetup {

    private String combobox;
    private static final String VALUE = "div input[type='hidden']";
    private static final String INPUT = "div input[type='text']";
    private static final String EXPAND = "div .v-input__append-inner";
    private String listItems;

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JAutocomplete.class, Autocomplete.class)) return;
        JAutocomplete j = field.getAnnotation(JAutocomplete.class);
        setup(j.combobox(), j.listItems());
    }

    public Autocomplete setup(String comboboxLocator, String listItemsLocator) {
        if (isNotBlank(comboboxLocator))
            combobox = comboboxLocator;
        if (isNotBlank(listItemsLocator)) {
            listItems = listItemsLocator;
        }
        return this;
    }

    @Override
    public AutocompleteAssert is() {
        return new AutocompleteAssert().set(this);
    }

    public UIElement combobox() {
        return $(combobox);
    }

    public UIElement value() {
        return $(VALUE, combobox);
    }

    private UIElement input() {
        return $(INPUT, combobox);
    }

    private UIElement expander() {
        return $(EXPAND, combobox);
    }

    public WebList listItems() {
        return $$(listItems);
    }

    @JDIAction("Check that '{name}' is expanded")
    public boolean isExpanded() {
        return combobox().attr("aria-expanded").equals("true");
    }

    @JDIAction("Expand '{name}'")
    public void expand() {
        if (!isExpanded()) {
            expander().click();
        }
    }

    @JDIAction("Close '{name}'")
    public void close() {
        if (isExpanded()) {
            expander().click();
        }
    }

    @JDIAction("Select '{0}' from '{name}'")
    public void select(String value) {
        if (!isSelected(value)) {
            $("//div[text()='" + value + "']").click();
        }
    }

    @JDIAction("Select '{0}' from '{name}'")
    public void select(Integer index) {
        if (!isSelected(listItems().get(index).getText())) {
            listItems().get(index).click();
        }
    }

    @JDIAction("Select '{0}' from '{name}'")
    public void select(List<String> values) {
        values.stream().forEach(e -> {
            $("//div[text()='" + e + "']").waitFor(displayed);
            if (!isSelected(e)) {
                $("//div[text()='" + e + "']").click();
            }
        });
    }

    @JDIAction("Unselect '{0}' from '{name}'")
    public void unselect(String value) {
        if (isSelected(value)) {
            $("//div[text()='" + value + "']").click();
        }
    }

    @JDIAction("Unselect '{0}' from '{name}'")
    public void unselect(Integer index) {
        if (isSelected(listItems().get(index).getText())) {
            listItems().get(index).click();
        }
    }

    @JDIAction("Unselect '{0}' from '{name}'")
    public void unselect(List<String> values) {
        values.stream().forEach(e -> {
            $("//div[text()='" + e + "']").waitFor(displayed);
            if (isSelected(e)) {
                $("//div[text()='" + e + "']").click();
            }
        });
    }

    @JDIAction("Check that '{0}' from '{name}' is selected")
    public boolean isSelected(String value) {
        return value().attr("value").contains(value);
    }

    @JDIAction("Check that '{0}' from '{name}' is selected")
    public boolean isSelected(List<String> values) {
        for (int i = 0; i < values.size(); i++) {
            return value().attr("value").contains(values.get(i));
        }
        return false;
    }

    @JDIAction("Check that '{name}' is disabled")
    public boolean isDisabled() {
        return input().hasAttribute("disabled");
    }
}
