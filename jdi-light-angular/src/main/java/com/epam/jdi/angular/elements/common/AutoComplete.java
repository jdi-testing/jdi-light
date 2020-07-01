package com.epam.jdi.angular.elements.common;

import com.epam.jdi.light.asserts.complex.*;
import com.epam.jdi.light.common.*;
import com.epam.jdi.light.elements.base.*;
import com.epam.jdi.light.elements.common.*;
import com.epam.jdi.light.elements.complex.*;
import com.epam.jdi.light.elements.interfaces.base.*;
import com.epam.jdi.light.elements.interfaces.common.*;
import com.epam.jdi.tools.map.*;
import org.openqa.selenium.*;

import java.util.*;

import static com.epam.jdi.light.common.TextTypes.*;

public class AutoComplete extends UIBaseElement<DropdownAssert> implements HasLabel, SetValue, HasPlaceholder, IsInput {

    private String optionsCss = "mat-option";
    private String optionsGroupsCss = "mat-optgroup>label";
    private String optionsGroupsAndValuesCss = "mat-optgroup";
    private String displayValueCss = "mat-label";
    private String autocompleteAttrPrefix = "_ngcontent-";

    public AutoComplete() {
    }

    public void setUniqueAutoCompleteAttribute(String value) {
        autocompleteAttrPrefix = value;
    }

    public void click() {
        this.core().click();
    }

    public void focusOut() {
        this.sendKeys(Keys.TAB);
    }

    public void input(String value) {
        this.core().input(value);
    }

    @Override
    public void clear() {
        this.sendKeys(Keys.CONTROL + "a");
        this.sendKeys(Keys.DELETE);
    }

    public void select(String value) {
        WebList options = new WebList(By.cssSelector(optionsCss));
        options.get(value).click();
    }

    @Override
    public String placeholder() {
        return this.core().getAttribute("placeholder");
    }

    public String displayValue() {
        String curAttr = getAutocompleteUniqueAttribute();
        String displayValueXpath = displayValueCss + "[" + curAttr + "]";
        WebList labels = new WebList(By.cssSelector(displayValueXpath));
        return labels.get(1).getText();
    }

    public boolean isOptionHighlighted(String value) {
        WebList values = new WebList(By.cssSelector(optionsCss));
        UIElement element = values.get(value);
        String selected = element.core().getAttribute("aria-selected");
        if ("true".equals(selected)) {
            return true;
        } else {
            return false;
        }
    }

    @JDIAction("Input '{0}' and select '{1}' in '{name}'")
    public void setValue(String inputValue, String selectValue) {
        if (!("").equals(getValue())) {
            clear();
        }
        input(inputValue);
        select(selectValue);
    }

    @JDIAction("Select '{0}' in '{name}'")
    @Override
    public void setValue(String selectValue) {
        if (!("").equals(getValue())) {
            clear();
        }
        click();
        select(selectValue);
    }

    @Override
    public String getValue() {
        return core().text(VALUE);
    }

    public WebList items() {
        click();
        WebList options = new WebList(By.cssSelector(optionsCss));
        this.click();
        return options;
    }

    public WebList items(String inputValue) {
        input(inputValue);
        WebList options = new WebList(By.cssSelector(optionsCss));
        click();
        return options;
    }

    public List<String> values() {
        items();
        return getValues();
    }

    public List<String> values(String inputValue) {
        items(inputValue);
        return getValues();
    }

    private List<String> getValues() {
        List<String> values = new ArrayList<>();
        WebList options = new WebList(By.cssSelector(optionsCss));
        options.forEach(option -> values.add(option.getValue()));
        return values;
    }

    public WebList groups() {
        return new WebList(By.cssSelector(optionsGroupsCss));
    }

    public HashMap<UIElement, List<WebElement>> groupsAndOptions() {
        WebList groups = new WebList(By.cssSelector(optionsGroupsCss));
        HashMap<UIElement, List<WebElement>> groupsAndOptions = new HashMap<>();
        groups.forEach(group -> {
            WebList curOptions = new WebList(By.cssSelector(optionsGroupsAndValuesCss + ">" + optionsCss));
            groupsAndOptions.put(group, curOptions.getWebElements());
        });
        return groupsAndOptions;
    }

    public List<String> groupsValues() {
        WebList groupsList = groups();
        List<String> groupsValues = new ArrayList<>();
        groupsList.forEach(group -> {
            groupsValues.add(group.getValue());
        });
        return groupsValues;
    }

    public HashMap<String, ArrayList<String>> groupsAndOptionsValues() {
        HashMap<UIElement, List<WebElement>> groupsAndOptionsMap = groupsAndOptions();
        HashMap<String, ArrayList<String>> groupsAndOptionsValues = new HashMap<>();
        groupsAndOptionsMap.forEach((group, options) -> {
            ArrayList<String> values = new ArrayList<>();
            options.forEach(option -> {
                values.add(option.getText());
            });
            groupsAndOptionsValues.put(group.getText(), values);
        });
        return groupsAndOptionsValues;
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

    public boolean isMandatory() {
        if ("true".equals(core().getAttribute("aria-required"))) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isInvalidated() {
        if ("true".equals(core().getAttribute("aria-invalid"))) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isDisabled() {
        return core().hasAttribute("disabled");
    }

    @Override
    public boolean isEnabled() {
        return !isDisabled();
    }

}
