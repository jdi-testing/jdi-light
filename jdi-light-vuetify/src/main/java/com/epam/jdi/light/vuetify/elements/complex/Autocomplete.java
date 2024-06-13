package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.driver.get.OsTypes;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.vuetify.annotations.JAutocomplete;
import com.epam.jdi.light.vuetify.asserts.AutocompleteAssert;
import com.epam.jdi.light.vuetify.elements.common.ListItem;
import com.epam.jdi.light.vuetify.interfaces.*;
import com.jdiai.tools.Timer;
import org.openqa.selenium.Keys;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import static com.epam.jdi.light.driver.get.DriverData.getOs;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.UIFactory.$$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * To see an example of Autocompletes please visit https://v2.vuetifyjs.com/en/components/autocompletes/
 */

public class Autocomplete extends UIBaseElement<AutocompleteAssert>
        implements ISetup, IsFilled, IsOutlined, IsDense, IsShaped, HasRounded {
    private static final String VALUE_LOCATOR = "div input[type='hidden']";
    private static final String INPUT_LOCATOR = "div input[type='text']";
    private static final String EXPAND_LOCATOR = "div .v-input__append-inner";
    private static final String MASK_LOCATOR = ".v-list-item__mask";
    private static final String CLEAR_BUTTON = ".v-input__icon--clear";
    private String rootLocator;
    private String optionsMenuLocator = ".menuable__content__active.v-autocomplete__content";

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JAutocomplete.class, Autocomplete.class)) {
            return;
        }
        JAutocomplete j = field.getAnnotation(JAutocomplete.class);
        setup(j.root(), j.listItems());
    }

    @Override
    public void show() {
        root().show();
    }

    public Autocomplete setup(String rootLocator, String listItemsLocator) {
        if (isNotBlank(rootLocator)) {
            this.rootLocator = rootLocator;
        }
        if (isNotBlank(listItemsLocator)) {
            optionsMenuLocator = listItemsLocator;
        }
        return this;
    }

    @Override
    public AutocompleteAssert is() {
        return new AutocompleteAssert().set(this);
    }

    public UIElement root() {
        if (rootLocator != null) {
            return $(rootLocator);
        } else {
            return core();
        }
    }

    public UIElement value() {
        return root().find(VALUE_LOCATOR);
    }

    public UIElement input() {
        return root().find(INPUT_LOCATOR);
    }

    private UIElement expander() {
        return root().find(EXPAND_LOCATOR);
    }

    private Menu optionsMenu() {
        return new Menu().setCore(Menu.class, $$(optionsMenuLocator));
    }

    public List<ListItem> options() {
        this.expand();
        Menu optionsMenu = optionsMenu();
        return optionsMenu.items();
    }

    private UIElement mask() {
        return $(MASK_LOCATOR);
    }

    private UIElement clearButton() {
        return root().find(CLEAR_BUTTON);
    }

    @JDIAction("Get if '{name}' is expanded")
    public boolean isExpanded() {
        return root().find("div[role='combobox']").attr("aria-expanded").equals("true");
    }

    @JDIAction("Expand '{name}'")
    public void expand() {
        if (!isExpanded()) {
            expander().click();
        }
    }

    // @todo #5308 We need to send Esc, as expander can be hidden
    @JDIAction("Close '{name}'")
    public void close() {
        if (isExpanded()) {
            expander().click();
        }
    }

    @JDIAction("Select '{0}' from '{name}'")
    public void select(String value) {
        if (!isSelected(value)) {
            this.expand();
            optionsMenu().selectOptionByTitle(value);
            this.close();
        }
    }

    // @todo #5308 another selected options are keeped, it is not correct
    @JDIAction("Select '{0}' from '{name}'")
    public void select(List<String> values) {
        this.expand();
        Menu optionsMenu = optionsMenu();
        values.forEach(v -> {
            if (!isSelected(v)) {
                optionsMenu.selectOptionByTitle(v);
            }
        });
        this.close();
    }

    // @todo #5308 in case option was not selected, if will be selected after
    @JDIAction("Unselect '{0}' from '{name}'")
    public void unselect(String value) {
        if (isSelected(value)) {
            this.expand();
            optionsMenu().selectOptionByTitle(value);
            this.close();
        }
    }

    @JDIAction("Unselect '{0}' from '{name}'")
    public void unselect(List<String> values) {
        this.expand();
        Menu optMenu = optionsMenu();
        values.forEach(v -> {
            if (isSelected(v)) {
                optMenu.selectOptionByTitle(v);
            }
        });
        this.close();
    }

    // @todo #5308 for example, we have thing and something in the list.
    //  something option is selected, but for option thing it will return true result.
    @JDIAction("Get if '{0}' from '{name}' is selected")
    public boolean isSelected(String value) {
        String allValues = value().attr("value");
        return allValues.contains(value + ",") || allValues.endsWith(value);
    }

    // @todo #5308 strange function, double check the meaning
    @JDIAction("Get if '{0}' from '{name}' is selected")
    public boolean isSelected(List<String> values) {
        String allValues = value().attr("value");
        for (String value : values) {
            if (!(allValues.contains(value + ",") || allValues.endsWith(value))) {
                return false;
            }
        }
        return true;
    }

    @JDIAction("Get {name}'s list of selected options")
    public List<String> selected() {
        return Arrays.asList(value().attr("value").split(","));
    }

    @Override
    @JDIAction("Get if '{name}' is disabled")
    public boolean isDisabled() {
        return input().hasAttribute("disabled");
    }

    @Override
    @JDIAction("Get if '{name}' is enabled")
    public boolean isEnabled() {
        return !this.isDisabled();
    }

    @JDIAction("Type text in the {name}'s text field")
    public void typeText(String value) {
        input().clear();
        input().sendKeys(value);
    }

    @JDIAction("Clear text in the {name}'s text field")
    public void clearTextField() {
        if (getOs().equals(OsTypes.MAC)) {
            input().sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.DELETE));
        } else {
            input().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        }
        new Timer(base().getTimeout() * 1000L)
                .wait(() -> mask().isNotExist());
    }

    @JDIAction("Click {name}'s 'Clear' button")
    public void clickClear() {
        clearButton().click();
    }

    @JDIAction("Get if one element can be selected in {name}")
    public boolean isSolo() {
        return root().attr("class").contains("v-text-field--solo");
    }

    @Override
    public boolean isRounded() {
        return root().attr("class").contains("v-text-field--rounded");
    }
}
