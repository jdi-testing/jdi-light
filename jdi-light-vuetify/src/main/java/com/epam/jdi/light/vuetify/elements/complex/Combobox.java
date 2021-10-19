package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.annotations.JDICombobox;
import com.epam.jdi.light.vuetify.asserts.ComboboxAssert;
import org.openqa.selenium.Keys;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class Combobox extends UIBaseElement<ComboboxAssert> implements ISetup {

    public String rootLocator = "";
    private String listLocator = "";
    private static final String VALUE_LOCATOR = "div input[type='hidden']";
    private static final String INPUT_LOCATOR = "div input[type='text']";
    private static final String EXPAND_LOCATOR = "div .v-input__append-inner";
    private static final String LABEL_LOCATOR = ".v-label";
    private static final String MESSAGE_LOCATOR = "//following::div[@class = 'v-messages__message']";
    private static final String LIST_INPUT_ITEM = ".v-select__selection--comma";

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDICombobox.class, Combobox.class)) return;
        JDICombobox j = field.getAnnotation(JDICombobox.class);
        setup(j.root(), j.listItems());
        this.setCore(Combobox.class, $(rootLocator));
    }

    public Combobox setup(String comboboxLocator, String listItemsLocator) {
        if (isNotBlank(comboboxLocator))
            rootLocator = comboboxLocator;
        if (isNotBlank(listItemsLocator)) {
            listLocator = listItemsLocator;
        }
        return this;
    }

    @Override
    public ComboboxAssert is() {
        return new ComboboxAssert().set(this);
    }

    public UIElement value() {
        return core().find(VALUE_LOCATOR);
    }

    private UIElement input() {
        return core().find(INPUT_LOCATOR);
    }

    private UIElement expander() {
        return core().find(EXPAND_LOCATOR);
    }

    public WebList listItems() {
        return finds(listLocator);
    }

    public WebList listInputItem() {
        return core().finds(LIST_INPUT_ITEM);
    }
    //div[@id = 'AdvancedCustomOptionsCombobox']//div[@role = 'combobox']//*[contains(text(),'Foo')]
    //div[@id = 'MultipleCombobox']//div[@role = 'combobox']//*[text()[normalize-space() = 'Programming']]

    public UIElement label() {
        return core().find(LABEL_LOCATOR);
    }

    public UIElement message() {
        return find(MESSAGE_LOCATOR);
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
//        if (!isSelected(value)) {
//            expand();
//            listItems().stream()
//                    .filter(e -> e.getText().equals(value))
//                    .forEach(UIElement::click);
//            if (isExpanded()) {
//                close();
//            }
//        }
        //-------------------------------------------
//        expand();
//        for (UIElement element : listItems()) {
//            if (element.getText().equals(value))
//                element.click();
//        }
        //-------------------------------------------
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
        //-------------------------------------------
//        expand();
//        listItems().get(index).click();

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
//        if (isSelected(value)) {
//            expand();
//            listItems().stream()
//                    .filter(e -> e.getText().equals(value))
//                    .forEach(UIElement::click);
//            if (isExpanded()) {
//                close();
//            }
//        }

        //-------------------------------------
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
        return Arrays.asList(value().attr("value").split(",")).contains(value);
//        return core().find("//*[text()[normalize-space() = '" + value + "']]").isExist();
    }

    @JDIAction("Check that '{0}' from '{name}' is selected")
    public boolean isSelected(List<String> values) {
        return Arrays.asList(value().attr("value").split(",")).containsAll(values);
    }

    @JDIAction("Check that '{name}' is disabled")
    public boolean isDisabled() {
        return input().hasAttribute("readonly");
    }
}
