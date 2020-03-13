package org.mytests.uiobjects.example.site.custom;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.*;
import com.epam.jdi.light.elements.base.*;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.*;
import org.openqa.selenium.By;

import java.util.List;

import static com.epam.jdi.light.driver.WebDriverByUtils.*;
import static com.epam.jdi.light.elements.init.UIFactory.*;
import static com.epam.jdi.light.logger.LogLevels.*;
import static com.epam.jdi.tools.EnumUtils.*;
import static com.epam.jdi.tools.LinqUtils.*;
import static java.util.Arrays.*;
import static org.jsoup.helper.StringUtil.*;

public class MultiDropdown extends UIListBase<UISelectAssert<?,?>>
        implements ICoreElement, HasLabel {

    By expandArrow = By.cssSelector(".caret");
    By values = By.tagName("li");
    By valueTemplate = By.xpath(".//a[label[text()='%s']]");
    By value = By.cssSelector("button");
    By valuesConatiner = By.tagName("ul");

    UIElement root() { return $(By.xpath(".."),this).setName("root"); }
    UIElement expander() { return root().find(expandArrow).setName("expandArrow"); }
    UIElement valuesList() { return root().find(valuesConatiner).setName("valuesContainer"); }
    UIElement value(String name) {
        return root().find(fillByTemplate(valueTemplate, name)).setName("valueTemplate");
    }
    UIElement valueText() { return root().find(value).setName("value"); }
    List<UIElement> allValues() {
        return root().finds(values);
    }

    @JDIAction(level = DEBUG)
    private void expand() {
        if (valuesList().setup(JDIBase::noValidation).isHidden())
            expander().click();
    }

    /**
     * Selects values from parameters
     * @param names String var arg, elements with text to select
     */
    @JDIAction("Select '{0}' for '{name}'")
    public void select(String... names) {
        expand();
        for (String name : names) {
            UIElement value = value(name);
            if (value.isEnabled())
                value.click();
        }
    }

    /**
     * Selects only particular elements
     * @param indexes String var arg, elements with text to select
     */
    @JDIAction("Select '{0}' for '{name}'")
    public void select(int... indexes) {
        expand();
        for (int i = 1; i <= indexes.length; i++) {
            UIElement value = $$(values, this).get(indexes[i]);
            if (value.isEnabled())
                value.click();
        }
    }

    public void check(String names) {
        if (isBlank(names)) return;
        check(names.split(","));
    }
    
    /**
     * Selects only particular elements
     * @param names String var arg, elements with text to select
     */
    @JDIAction("Check '{0}' for '{name}'")
    public void check(String... names) {
        expand();
        List<String> listNames = map(names, String::trim);
        for (String name : values()) {
            UIElement value = value(name);
            boolean valueSelected = value.find("input").setup(JDIBase::noValidation)
                .isSelected();
            if (valueSelected && !listNames.contains(name.trim())
                    || !valueSelected && listNames.contains(name.trim()))
                value.click();
        }
        label().click();
    }

    /**
     * Unselects only particular elements
     * @param names String var arg, elements with text to unselect
     */
    @JDIAction("Uncheck '{0}' for '{name}'")
    public void uncheck(String... names) {
        expand();
        List<String> listNames = asList(names);
        for (String name : values()) {
            UIElement value = value(name);
            if (value.isDisabled()) continue;
            if (value.isSelected() && listNames.contains(value.getText().trim())
                    || !value.isSelected() && !listNames.contains(value.getText().trim()))
                value.click();
        }
    }
    public <TEnum extends Enum<?>> void check(TEnum... values) {
        check(getEnumValues(values));
    }

    public <TEnum extends Enum<?>> void uncheck(TEnum... values) {
        uncheck(getEnumValues(values));
    }

    /**
     * Checks particular elements by index
     * @param indexes int var arg, ids to check
     */
    @JDIAction("Check '{0}' for '{name}'")
    public void check(int... indexes) {
        expand();
        List<Integer> listIndexes = toList(indexes);
        for (int i = 1; i <= values().size(); i++) {
            UIElement value = allValues().get(i-1);
            if (value.isDisabled()) continue;
            if (value.isSelected() && !listIndexes.contains(i)
                    || !value.isSelected() && listIndexes.contains(i))
                value.click();
        }
    }

    /**
     * Unchecks particular elements by index
     * @param indexes int var arg, ids to uncheck
     */
    @JDIAction("Uncheck '{0}' for '{name}'")
    public void uncheck(int... indexes) {
        expand();
        List<Integer> listIndexes = toList(indexes);
        for (int i = 1; i <= values().size(); i++) {
            UIElement value = allValues().get(i-1);
            if (value.isDisabled()) continue;
            if (value.isSelected() && listIndexes.contains(i)
                || !value.isSelected() && !listIndexes.contains(i))
                value.click();
        }
    }

    /**
     * Gets checked values in dropdown
     * @return List<String>
     */
    @JDIAction("Get '{name}' checked values")
    public List<String> checked() {
        return ifSelect(allValues(), UIElement::isSelected, UIElement::getText);
    }

    /**
     * Selects value in dropdown
     * @param value String var arg
     */
    @JDIAction("Select '{0}' for '{name}'")
    public void select(String value) {
        select(new String[]{value});
    }

    /**
     * Selects value with index in dropdown
     * @param index int var arg
     */
    @JDIAction("Select '{0}' for '{name}'")
    public void select(int index) {
        select(new int[]{index});
    }

    /**
     * Gets a list of text from each values from dropdown
     * @return List<String>
     */
    @JDIAction("Get '{name}' list values")
    public List<String> values() {
        return map(allValues(), UIElement::getText);
    }

    /**
     * Gets a list of innerText from each values from dropdown
     * @return List<String>
     */
    @JDIAction("Get '{name}' values")
    public List<String> values(TextTypes type) {
        return map(allValues(), o -> o.text(type));
    }

    /**
     * Gets enabled values from dropdown
     * @return List<String>
     */
    @JDIAction("Get '{name}' enabled values")
    public List<String> listEnabled() {
        return ifSelect(allValues(), UIElement::isEnabled, UIElement::getText);
    }

    /**
     * Gets disabled values from dropdown
     * @return List<String>
     */
    @JDIAction("Get '{name}' disabled values")
    public List<String> listDisabled() {
        return ifSelect(allValues(), UIElement::isDisabled, UIElement::getText);
    }

    @Override
    public void setValue(String value) {
        check(value);
    }

    /**
     * Gets selected value
     * @return String
     */
    @Override
    @JDIAction("Get '{name}' selected value")
    public String selected() {
        return valueText().getText();
    }

    /**
     * Checks if a value is selected in a dropdown
     * @param value String to select
     * @return boolean
     */
    @JDIAction("Is '{0}' selected for '{name}'")
    public boolean selected(String value) {
        return selected().trim().equalsIgnoreCase(value.trim());
    }

    @Override
    public String getValue() {
        return selected();
    }
}
