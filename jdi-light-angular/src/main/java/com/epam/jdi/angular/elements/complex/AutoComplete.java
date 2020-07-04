package com.epam.jdi.angular.elements.complex;

import com.epam.jdi.angular.asserts.*;
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
        this.click();
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
        groups.forEach(group -> {
            WebList curOptions = getOptions(optionsGroupsAndValuesCss + ">" + optionsCss);
            groupsAndOptions.put(group, curOptions.getWebElements());
        });
        return groupsAndOptions;
    }

    @JDIAction("Get groups for '{name}'")
    public List<String> groups() {
        WebList groupsList = getOptions(optionsGroupsCss);
        List<String> groupsValues = new ArrayList<>();
        groupsList.forEach(group -> {
            groupsValues.add(group.getValue());
        });
        return groupsValues;
    }

    @JDIAction("Get groups and options for '{name}'")
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

    public WebList getOptions() {
        return new WebList(By.cssSelector(optionsCss));
    }

    public WebList getOptions(String css) {
        return new WebList(By.cssSelector(css));
    }

    public String getAutocompleteUniqueAttribute() {
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

    public Boolean isMandatory() {
        return "true".equals(core().getAttribute("aria-required"));
    }

    public Boolean isInvalidated() {
        return "true".equals(core().getAttribute("aria-invalid"));
    }

    @Override
    public boolean isDisabled() {
        return core().hasAttribute("disabled");
    }

    @Override
    public boolean isEnabled() {
        return !isDisabled();
    }

    @Override
    public AutoCompleteAssert is() { return new AutoCompleteAssert().set(this); }

}
