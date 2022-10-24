package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.annotations.JDICombobox;
import com.epam.jdi.light.vuetify.asserts.ComboboxAssert;
import com.epam.jdi.light.vuetify.interfaces.IsClearable;
import com.epam.jdi.light.vuetify.interfaces.IsMultiple;
import com.epam.jdi.light.vuetify.interfaces.IsReverse;
import com.epam.jdi.light.vuetify.interfaces.IsSingleLine;
import com.epam.jdi.light.vuetify.interfaces.IsFilled;
import com.epam.jdi.light.vuetify.interfaces.HasLoading;
import org.openqa.selenium.Keys;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * To see example of Combobox web element please visit https://vuetifyjs.com/en/components/combobox/
 */

public class Combobox extends UIBaseElement<ComboboxAssert> implements ISetup, IsClearable, IsMultiple,
        IsReverse, IsSingleLine, IsFilled, HasLoading {

    protected String rootLocator = "div[role = 'combobox']";
    protected String listLocator = ".v-list-item__title";
    protected String valueLocator = "div input[type='hidden']";
    protected String inputLocator = "div input[type='text']";
    protected String expandLocator = "div .v-input__append-inner";
    protected String labelLocator = ".v-label";
    protected String messageLocator = "//following::div[@class = 'v-messages__message']";

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDICombobox.class, Combobox.class)) {
            return;
        }
        JDICombobox j = field.getAnnotation(JDICombobox.class);
        setup(j.root(), j.listItems());
    }

    public Combobox setup(String comboboxLocator, String listItemsLocator) {
        if (isNotBlank(comboboxLocator)) {
            rootLocator = comboboxLocator;
        }
        if (isNotBlank(listItemsLocator)) {
            listLocator = listItemsLocator;
        }
        base().setLocator(rootLocator);
        return this;
    }

    @Override
    public ComboboxAssert is() {
        return new ComboboxAssert().set(this);
    }

    public List<String> selectedValues() {
        return Arrays.asList(core().find(valueLocator).attr("value").split(","));
    }

    private UIElement input() {
        return core().find(inputLocator);
    }

    private UIElement expander() {
        return core().find(expandLocator);
    }

    public WebList listItems() {
        return finds(listLocator);
    }

    public UIElement label() {
        return core().find(labelLocator);
    }

    public UIElement message() {
        return find(messageLocator);
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
            expand();
            listItems().select(value);
            if (isExpanded()) {
                close();
            }
        }
    }


    @JDIAction("Select '{0}' from '{name}'")
    public void select(List<String> values) {
        values.forEach(x -> {
            if (!isSelected(x)) {
                expand();
                listItems().select(x);
                if (isExpanded()) {
                    close();
                }
            }
        });
    }

    @JDIAction("Unselect '{0}' from '{name}'")
    public void unselect(String value) {
        if (isSelected(value)) {
            expand();
            listItems().select(value);
            if (isExpanded()) {
                close();
            }
        }
    }

    @JDIAction("Unselect '{0}' from '{name}'")
    public void unselect(List<String> values) {
        expand();
        values.forEach(x -> {
            if (isSelected(x)) {
                listItems().select(x);
            }
        });
        if (isExpanded()) {
            close();
        }
    }

    @JDIAction("Send '{0} keys' to '{name}' input")
    public void sendKeys(String keys) {
        input().sendKeys(keys);
        input().sendKeys(Keys.ENTER);
    }

    @JDIAction("Check that '{name}' is expanded")
    public boolean isExpanded() {
        return core().attr("aria-expanded").equals("true");
    }

    @JDIAction("Check that '{0}' from '{name}' is selected")
    public boolean isSelected(String value) {
        return selectedValues().contains(value);
    }

    @JDIAction("Check that '{0}' from '{name}' is selected")
    public boolean isSelected(List<String> values) {
        return selectedValues().containsAll(values);
    }

    @JDIAction("Check that '{name}' is disabled")
    public boolean isDisabled() {
        return input().hasAttribute("readonly");
    }
}
