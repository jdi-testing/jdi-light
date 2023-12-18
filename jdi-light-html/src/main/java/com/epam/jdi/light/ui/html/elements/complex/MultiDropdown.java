package com.epam.jdi.light.ui.html.elements.complex;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.TextTypes;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import org.openqa.selenium.By;

import java.lang.reflect.Field;
import java.util.List;

import static com.epam.jdi.light.driver.WebDriverByUtils.fillByTemplate;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.UIFactory.$$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.jdiai.tools.EnumUtils.getEnumValues;
import static com.jdiai.tools.LinqUtils.*;
import static com.jdiai.tools.LinqUtils.ifSelect;
import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class MultiDropdown extends UIListBase<UISelectAssert<?,?>>
        implements ICoreElement, HasLabel, ISetup {

    protected String expandArrow = ".caret";
    protected String items = "li";
    protected String valueTemplate = ".//a[label[text()='%s']]";
    protected String selectedValues = "button";
    protected String valuesContainer = "ul";

    @Override
    public void setup(Field field) {
        if (fieldHasAnnotation(field, com.epam.jdi.light.ui.html.elements.annotations.MultiDropdown.class, MultiDropdown.class))
        {
            com.epam.jdi.light.ui.html.elements.annotations.MultiDropdown annotation = field.getAnnotation(com.epam.jdi.light.ui.html.elements.annotations.MultiDropdown.class);
            expandArrow = annotation.expander();
            items = annotation.items();
            valueTemplate = annotation.byValueTemplate();
            selectedValues = annotation.selectedValues();
            valuesContainer = annotation.itemsContainer();
        }
    }
    UIElement root() {
        return $(By.xpath(".."), this).setName("root");
    }

    UIElement expander() {
        return root().find(expandArrow).setName("expandArrow");
    }

    UIElement valuesList() {
        return root().find(valuesContainer).setName("valuesContainer");
    }

    UIElement value(String name) {
        return root().find(fillByTemplate(By.xpath(valueTemplate), name)).setName("valueTemplate");
    }

    UIElement valueText() {
        return root().find(selectedValues).setName("value");
    }

    List<UIElement> allValues() {
        return root().finds(items);
    }

    @JDIAction(level = DEBUG)
    private void expand() {
        if (valuesList().setup(JDIBase::noValidation).isHidden())
            expander().click();
    }

    /**
     * Selects values from parameters
     *
     * @param names String var arg, elements with text to select
     */
    @JDIAction("Select '{0}' for '{name}'")
    public void select(String... names) {
        this.expand();
        for (String name : names) {
            UIElement value = value(name);
            if (value.isEnabled()) {
                value.click();
            }
        }
    }

    /**
     * Selects only particular elements
     *
     * @param indexes String var arg, elements with text to select
     */
    @JDIAction("Select '{0}' for '{name}'")
    public void select(int... indexes) {
        expand();
        for (int i = 1; i <= indexes.length; i++) {
            UIElement value = $$(items, this).setName(getName()).get(indexes[i]);
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
     *
     * @param names String var arg, elements with text to select
     */
    @JDIAction("Check '{0}' for '{name}'")
    public void check(String... names) {
        this.expand();
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
     *
     * @param names String var arg, elements with text to unselect
     */
    @JDIAction("Uncheck '{0}' for '{name}'")
    public void uncheck(String... names) {
        this.expand();
        List<String> listNames = asList(names);
        for (String name : values()) {
            UIElement value = value(name);
            if (value.isDisabled()) continue;
            if (value.isSelected() && listNames.contains(value.getText().trim())
                    || !value.isSelected() && !listNames.contains(value.getText().trim()))
                value.click();
        }
    }

    public <EnumType extends Enum<?>> void check(EnumType... values) {
        check(getEnumValues(values));
    }

    public <EnumType extends Enum<?>> void uncheck(EnumType... values) {
        uncheck(getEnumValues(values));
    }

    /**
     * Checks particular elements by index
     *
     * @param indexes int var arg, ids to check
     */
    @JDIAction("Check '{0}' for '{name}'")
    public void check(int... indexes) {
        this.expand();
        List<Integer> listIndexes = toList(indexes);
        for (int i = 1; i <= values().size(); i++) {
            UIElement value = allValues().get(i - 1);
            if (value.isDisabled()) continue;
            if (value.isSelected() && !listIndexes.contains(i)
                    || !value.isSelected() && listIndexes.contains(i))
                value.click();
        }
    }

    /**
     * Unchecks particular elements by index (based on 1)
     *
     * @param indexes int var arg, ids to uncheck
     */
    @JDIAction("Uncheck '{0}' for '{name}'")
    public void uncheck(int... indexes) {
        this.expand();
        List<Integer> listIndexes = toList(indexes);
        for (int i = 1; i <= values().size(); i++) {
            UIElement value = allValues().get(i - 1);
            if (value.isDisabled()) continue;
            if (value.isSelected() && listIndexes.contains(i)
                    || !value.isSelected() && !listIndexes.contains(i))
                value.click();
        }
    }

    /**
     * Gets checked values in dropdown
     *
     * @return List of the values
     */
    @JDIAction("Get '{name}' checked values")
    public List<String> checked() {
        return ifSelect(allValues(), UIElement::isSelected, UIElement::getText);
    }

    /**
     * Selects value in dropdown
     *
     * @param value String var arg
     */
    @JDIAction("Select '{0}' for '{name}'")
    public void select(String value) {
        if (value == null) return;
        select(new String[]{value});
    }

    /**
     * Selects value with index in dropdown
     *
     * @param index int var arg
     */
    @JDIAction("Select '{0}' for '{name}'")
    public void select(int index) {
        select(new int[]{index});
    }

    /**
     * Gets a list of text from each values from dropdown
     *
     * @return List&lt;String&gt;
     */
    @JDIAction("Get '{name}' list values")
    public List<String> values() {
        return map(allValues(), UIElement::getText);
    }

    /**
     * Gets a list of innerText from each values from dropdown
     *
     * @return List&lt;String&gt;
     */
    @JDIAction("Get '{name}' values")
    public List<String> values(TextTypes type) {
        return map(allValues(), o -> o.text(type));
    }

    /**
     * Gets enabled values from dropdown
     *
     * @return List&lt;String&gt;
     */
    @JDIAction("Get '{name}' enabled values")
    public List<String> listEnabled() {
        return ifSelect(allValues(), UIElement::isEnabled, UIElement::getText);
    }

    /**
     * Gets disabled values from dropdown
     *
     * @return List&lt;String&gt;
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
     *
     * @return String
     */
    @Override
    @JDIAction("Get '{name}' selected value")
    public String selected() {
        return valueText().getText();
    }

    /**
     * Checks if a value is selected in a dropdown
     *
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
