package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.annotations.JDICombobox;
import com.epam.jdi.light.vuetify.asserts.ComboboxAssert;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

public class Combobox extends UIBaseElement<ComboboxAssert> implements ISetup {

    public String rootLocator;
    private String listLocator;
    private static final String VALUE_LOCATOR = "div input[type='hidden']";
    private static final String INPUT_LOCATOR = "div input[type='text']";
    private static final String EXPAND_LOCATOR = "div .v-input__append-inner";
    private static final String LABEL_LOCATOR = ".v-label";
    private static final String MESSAGE_LOCATOR = ".v-messages__message";
    private static final String MASK = ".v-list-item__mask";
    //private Boolean setupMarker = false;


    @Override
    public void setup(Field field) {
        if (fieldHasAnnotation(field, JDICombobox.class, Combobox.class)) {
            JDICombobox annotation = field.getAnnotation(JDICombobox.class);
            initializeLocators(annotation);
        }
        this.setCore(Combobox.class, $(rootLocator));
    }

    private void initializeLocators(JDICombobox annotation) {
        if (!annotation.root().isEmpty()) {
            rootLocator = annotation.root();
        }
        if (!annotation.listItems().isEmpty()) {
            listLocator = annotation.listItems();
        }
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

    public UIElement label() {
        return core().find(LABEL_LOCATOR);
    }

    public UIElement message() {
        return core().find(MESSAGE_LOCATOR);
    }


//    private UIElement mask() {
//        return $(MASK);
//    }

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
        }
    }


    @JDIAction("Select '{0}' from '{name}'")
    public void select(List<String> values) {
        expand();
        values.forEach(x -> {
            if (!isSelected(x)) {
                listItems().select(x);
            }
        });
    }

    @JDIAction("Unselect '{0}' from '{name}'")
    public void unselect(String value) {
        if (isSelected(value)) {
            expand();
            listItems().select(value);
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
    }

    @JDIAction("Send '{0} keys' to '{name}' input")
    public void sendKeys(String keys) {
        input().sendKeys(keys);
    }

    @JDIAction("Check that '{name}' is expanded")
    public boolean isExpanded() {
        return core().attr("aria-expanded").equals("true");
    }

    @JDIAction("Check that '{0}' from '{name}' is selected")
    public boolean isSelected(String value) {
        return Arrays.asList(value().attr("value").split(",")).contains(value);
    }

    @JDIAction("Check that '{0}' from '{name}' is selected")
    public boolean isSelected(List<String> values) {
        return Arrays.asList(value().attr("value").split(",")).containsAll(values);
    }

    @JDIAction("Check that '{name}' is disabled")
    public boolean isDisabled() {
        return input().hasAttribute("disabled");
    }

//    @JDIAction("Type text in the {name}'s text field")
//    public void typeText(String value) {
//        input().sendKeys(value);
//        new Timer(base().getTimeout() * 1000L)
//                .wait(() -> mask().isNotEmpty());
//    }
//
//    @JDIAction("Clear text in the {name}'s text field")
//    public void clearTextField() {
//        if (getOs().equals(OsTypes.MAC)) {
//            input().sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.DELETE));
//        } else {
//            input().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
//        }
//        new Timer(base().getTimeout() * 1000L)
//                .wait(() -> mask().isNotExist());
//    }
}
