package io.github.com.custom;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.driver.get.OsTypes;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.elements.complex.Combobox;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.driver.get.DriverData.getOs;

/**
 * To see example of AdvancedCombobox web element please visit https://vuetifyjs.com/en/components/combobox/
 */

public class AdvancedCombobox extends Combobox {

    protected String valueLocator = ".pr-2";

    @Override
    public List<String> selectedValues() {
        return core().finds(valueLocator).stream().map(UIElement::getText).collect(Collectors.toList());
    }

    @Override
    public void select(String value) {
        if (!isSelected(value)) {
            expand();
            find(listLocator + "/..//span[text()[normalize-space() = '" + value + "']]").click();
            if (isExpanded()) {
                close();
            }
        }
    }

    @Override
    public void select(List<String> values) {
        if (!isSelected(values)) {
            expand();
            values.forEach(x -> {
                find(listLocator + "/..//span[text()[normalize-space() = '" + x + "']]").click();
            });
            if (isExpanded()) {
                close();
            }
        }
    }

    @Override
    public void unselect(String value) {
        if (isSelected(value)) {
            find("//*[text()[normalize-space() = '" + value + "']]//following-sibling::button").click();
            if (isExpanded()) {
                close();
            }
        }

    }

    @Override
    public void unselect(List<String> values) {
        if (isSelected(values)) {
            values.forEach(x -> find("//*[text()[normalize-space() = '" + x + "']]//following-sibling::button").click());
            if (isExpanded()) {
                close();
            }
        }
    }

    @JDIAction("Change text for {name} list element")
    public void changeTextValue(String value, String newText) {
        if (isSelected(value)) {
            unselect(value);
        }
        String itemId = core().find(listLocator + "//..//span[text()[normalize-space() = '" + value + "']]/../..").attr("id");
        UIElement button = core().find("//ancestor::div[@id = 'app']//div[@id = '" + itemId + "']//button[@type = 'button']");
        UIElement inputField = core().find("//ancestor::div[@id = 'app']//div[@id = '" + itemId + "']//input");

        expand();
        button.click();
        if (getOs().equals(OsTypes.MAC)) {
            inputField.sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.DELETE));
        } else {
            inputField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        }
        inputField.sendKeys(newText);
        inputField.sendKeys(Keys.ENTER);
        if (isExpanded()) {
            close();
        }
    }

    @Override
    public boolean isSelected(String value) {
        return selectedValues().contains(value);
    }

    @Override
    public boolean isSelected(List<String> values) {
        return selectedValues().containsAll(values);

    }
}
