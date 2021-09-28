package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.annotations.JAutocomplete;
import com.epam.jdi.light.vuetify.asserts.AutocompleteAssert;
import com.epam.jdi.tools.Timer;
import org.openqa.selenium.Keys;

import java.lang.reflect.Field;
import java.util.List;

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
    private static final String MASK = ".v-list-item__mask";
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
        return combobox().find(VALUE);
    }

    private UIElement input() {
        return combobox().find(INPUT);
    }

//    private WebElement inputForJS() {
//        WebElement comboboxEl;
//        if (combobox.startsWith("//")) {
//            comboboxEl = getDriver().findElement(By.xpath(combobox));
//        } else {
//            comboboxEl = getDriver().findElement(By.cssSelector(combobox));
//        }
//        return comboboxEl.findElement(By.cssSelector(INPUT));
//    }

    private UIElement expander() {
        return combobox().find(EXPAND);
    }

    public WebList listItems() {
        return $$(listItems);
    }

    private UIElement mask() {
        return $(MASK);
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
        UIElement valueLocator = $("//div[text()='" + value + "']");
        new Timer(base().getTimeout() * 1000L)
                .wait(valueLocator::isDisplayed);
        if (!isSelected(value)) {
            valueLocator.click();
        }
    }

    @JDIAction("Select '{0}' from '{name}'")
    public void select(List<String> values) {
        values.stream().forEach(e -> {
            new Timer(base().getTimeout() * 1000L)
                    .wait(() -> $("//div[text()='" + e + "']").isDisplayed());
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
    public void unselect(List<String> values) {
        values.stream().forEach(e -> {
            new Timer(base().getTimeout() * 1000L)
                    .wait(() -> $("//div[text()='" + e + "']").isDisplayed());
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
            if (!value().attr("value").contains(values.get(i))) {
                return false;
            }
        }
        return true;
    }

    @JDIAction("Check that '{name}' is disabled")
    public boolean isDisabled() {
        return input().hasAttribute("disabled");
    }

    @JDIAction("Type text in the {name}'s text field")
    public void typeText(String value) {
        input().sendKeys(value);
        new Timer(base().getTimeout() * 1000L)
                .wait(() -> mask().isNotEmpty());
    }

    @JDIAction("Clear text in the {name}'s text field")
    public void clearTextField() {
        input().doubleClick();
        input().sendKeys(Keys.BACK_SPACE);
//        input().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
//        JavascriptExecutor js = (JavascriptExecutor)getDriver();
//        js.executeScript("arguments[0].value = '';", inputForJS());
        new Timer(base().getTimeout() * 1000L)
                .wait(() -> mask().isNotExist());
    }
}
