package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.AutoCompleteAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.HasPlaceholder;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.light.elements.interfaces.common.IsInput;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.tools.map.MapArray;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static com.epam.jdi.light.common.TextTypes.VALUE;

/**
 * To see an example of AutoComplete web element please visit https://material.angular.io/components/autocomplete/overview.
 */

public class AutoComplete extends UIBaseElement<AutoCompleteAssert> implements HasLabel, SetValue, HasPlaceholder, IsInput, IsText {

    private String optionsCss = "mat-option";
    private String optionsGroupsCss = "mat-optgroup>label";
    private String optionsGroupsAndValuesCss = "mat-optgroup";
    private String displayValueCss = "mat-label";
    private String autocompleteAttrPrefix = "_ngcontent-";

    public void setUniqueAutoCompleteAttribute(String value) {
        autocompleteAttrPrefix = value;
    }

    public void click() {
        core().click();
    }

    @JDIAction("Get focus out from '{name}'")
    public void focusOut() {
        sendKeys(Keys.TAB);
    }

    public void input(String value) {
        core().input(value);
    }

    @JDIAction("Clear value from '{name}'")
    @Override
    public void clear() {
        sendKeys(Keys.CONTROL + "a");
        sendKeys(Keys.DELETE);
        focusOut();
    }

    @JDIAction("Select value {0} for '{name}'")
    public void select(String value) {
        WebList options = getOptions(optionsCss);
        options.get(value).click();
    }

    @JDIAction("Get placeholder for '{name}'")
    @Override
    public String placeholder() {
        String placeholder = "placeholder";
        return (core().hasAttribute(placeholder)) ? core().getAttribute(placeholder) : "";
    }

    @JDIAction("Get display value for '{name}'")
    public String displayValue() {
        String displayValueXpath = displayValueCss + "[" + getAutocompleteUniqueAttribute() + "]";
        WebList labels = getOptions(displayValueXpath);
        return (!labels.isEmpty()) ? labels.get(1).getText() : "";
    }

    public Boolean isOptionHighlighted(String value) {
        WebList values = getOptions(optionsCss);
        UIElement element = values.get(value);
        String selected = element.core().getAttribute("class");
        return selected.contains("mat-active");
    }

    public void setValue(String inputValue, String selectValue) {
        if (!isEmpty()) {
            clear();
        }
        input(inputValue);
        select(selectValue);
    }

    @Override
    public void setValue(String selectValue) {
        if (!isEmpty()) {
            clear();
        }
        click();
        select(selectValue);
    }

    @Override
    public String text() {
        return core().text(VALUE);
    }

    @Override
    public String getValue() {
        return text();
    }

    private WebList items() {
        click();
        WebList options = getOptions(optionsCss);
        click();
        return options;
    }

    private WebList items(String inputValue) {
        input(inputValue);
        WebList options = getOptions(optionsCss);
        click();
        return options;
    }

    @JDIAction("Get options for '{name}'")
    public List<String> options() {
        items();
        return getValues();
    }

    @JDIAction("Get options for '{name}' when {0} input is provided")
    public List<String> options(String inputValue) {
        items(inputValue);
        return getValues();
    }

    private List<String> getValues() {
        List<String> values = new ArrayList<>();
        WebList options = getOptions(optionsCss);
        options.forEach(option -> values.add(option.getValue()));
        return values;
    }

    private HashMap<UIElement, List<WebElement>> groupsAndOptions() {
        WebList groups = getOptions(optionsGroupsCss);
        HashMap<UIElement, List<WebElement>> groupsAndOptions = new HashMap<>();
        if (groups.isEmpty()) {
            return null;
        }
        groups.forEach(group -> {
            WebList curOptions = getOptions(optionsGroupsAndValuesCss + ">" + optionsCss);
            groupsAndOptions.put(group, curOptions.getWebElements());
        });
        return groupsAndOptions;
    }

    @JDIAction("Get groups for '{name}'")
    public List<String> groups() {
        WebList groupsList = getOptions(optionsGroupsCss);
        if (groupsList.isEmpty()) {
            String emptyArray[] = {""};
            return Arrays.asList(emptyArray);
        }
        List<String> groupsValues = new ArrayList<>();
        groupsList.forEach(group -> {
            groupsValues.add(group.getValue());
        });
        return groupsValues;
    }

    @JDIAction("Get groups and options for '{name}'")
    public HashMap<String, List<String>> groupsAndOptionsValues() {
        HashMap<UIElement, List<WebElement>> groupsAndOptionsMap = groupsAndOptions();
        HashMap<String, List<String>> groupsAndOptionsValues = new HashMap<>();
        if (groupsAndOptionsMap == null) {
            String emptyArray[] = {""};
            groupsAndOptionsValues.put("", Arrays.asList(emptyArray));
            return groupsAndOptionsValues;
        }
        groupsAndOptionsMap.forEach((group, options) -> {
            ArrayList<String> values = new ArrayList<>();
            options.forEach(option -> {
                values.add(option.getText());
            });
            groupsAndOptionsValues.put(group.getText(), values);
        });
        return groupsAndOptionsValues;
    }

    private WebList getOptions() {
        return new WebList(By.cssSelector(optionsCss));
    }

    private WebList getOptions(String css) {
        return new WebList(By.cssSelector(css));
    }

    private String getAutocompleteUniqueAttribute() {
        final String[] curAttr = {""};
        MapArray<String, String> attributesAndValues = core().getAllAttributes();
        List<String> attributes = attributesAndValues.keys();
        attributes.forEach(attr -> {
            boolean doesContain = attr.contains(autocompleteAttrPrefix);
            if (doesContain) {
                curAttr[0] = attr;
            }
        });
        return curAttr[0];
    }

    @JDIAction("Is '{name} mandatory")
    public Boolean isMandatory() {
        return "true".equals(core().getAttribute("aria-required"));
    }

    @JDIAction("Is '{name} invalidated")
    public Boolean isInvalidated() {
        return "true".equals(core().getAttribute("aria-invalid"));
    }

    @JDIAction("Is '{name} disabled")
    @Override
    public boolean isDisabled() {
        return core().hasAttribute("disabled");
    }

    @JDIAction("Is '{name} enabled")
    @Override
    public boolean isEnabled() {
        return !isDisabled();
    }

    @JDIAction("Is '{name}' is expanded")
    public Boolean expanded() {
        if (getOptions().isEmpty()) {
            return false;
        } else {
            return getOptions().get(1).
                getAllAttributes().keys().
                contains(getAutocompleteUniqueAttribute());
        }
    }

    @JDIAction("Is '{name}' is collapsed")
    public Boolean collapsed() {
        return !expanded();
    }

    @Override
    public AutoCompleteAssert is() { return new AutoCompleteAssert().set(this); }

}
