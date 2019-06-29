package com.epam.jdi.light.ui.html.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.TextType;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.ui.html.asserts.ChecklistAssert;
import com.epam.jdi.tools.EnumUtils;
import org.openqa.selenium.By;

import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverByUtils.defineLocator;
import static com.epam.jdi.light.driver.WebDriverByUtils.fillByTemplate;
import static com.epam.jdi.light.elements.complex.Selector.LABEL_LOCATOR;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.tools.EnumUtils.getEnumValues;
import static com.epam.jdi.tools.LinqUtils.*;
import static com.epam.jdi.tools.PrintUtils.print;
import static java.util.Arrays.asList;
import static org.openqa.selenium.By.cssSelector;

public class Checklist extends UIListBase<ChecklistAssert> {
    By checkbox = cssSelector("input[type=checkbox][id='%s']");
    By label = LABEL_LOCATOR;
    public void setLabelLocator(String locator) {
        label = defineLocator(locator);
    }
    private String getId(String name) { return label(name).getAttribute("for"); }

    /**
     * Gets a value
     * @param value String
     * @return UIElement
     */
    public UIElement get(String value) {
        return $(fillByTemplate(checkbox, getId(value)), core().parent).setName(value);
    }
    private UIElement label(String value) {
        return $(fillByTemplate(label, value), core().parent).setName("label");
    }

    WebList labels() {
        return new WebList(list().map(el -> new UIElement(el).label().setName(getName()+ " label"))).setName(getName() + " labels");
    }

    /**
     * Select particular elements by name
     * @param names String var arg, elements with text to select
     */
    @JDIAction("Select '{0}' checkboxes in '{name}' checklist")
    public void select(String... names) {
        for (String name : names) {
            UIElement value = get(name);
            if (value.isEnabled())
                value.click();
        }
    }

    public <TEnum extends Enum> void select(TEnum... value) {
        select(toStringArray(map(value, EnumUtils::getEnumValue)));
    }

    /**
     * Selects particular elements by index
     * @param indexes String var arg, elements with text to select
     */
    @JDIAction("Select '{0}' checkboxes in '{name}' checklist")
    public void select(int... indexes) {
        shouldBeVisible("select");
        for (int index : indexes) {
            UIElement value = list().get(index - 1);
            if (value.isEnabled())
                value.click();
        }
    }
    private void shouldBeVisible(String action) {
        if (isHidden())
            throw exception("Checklist should have at least one element visible. Failed to do '%s'", action);
    }

    /**
     * Selects only particular elements and unselects others
     * @param names String var arg, elements with text to select
     */
    @JDIAction("Check '{0}' checkboxes in '{name}' checklist")
    public void check(String... names) {
        shouldBeVisible("check");
        List<String> listNames = asList(names);
        for (String name : values()) {
            UIElement value = get(name);
            if (value.isDisabled()) continue;
            if (selected(value) && !listNames.contains(value.labelText().trim())
                    || !selected(value) && listNames.contains(value.labelText().trim()))
                value.click();
        }
    }

    protected boolean selected(UIElement value) {
        return value.isSelected();
    }
    /**
     * Unselects only particular elements and select others
     * @param names String var arg, elements with text to unselect
     */
    @JDIAction("Uncheck '{0}' checkboxes in '{name}' checklist")
    public void uncheck(String... names) {
        shouldBeVisible("uncheck");
        List<String> listNames = asList(names);
        for (String name : values()) {
            UIElement value = get(name);
            if (value.isDisabled()) continue;
            if (selected(value) && listNames.contains(value.labelText().trim())
                    || !selected(value) && !listNames.contains(value.labelText().trim()))
                value.click();
        }
    }
    public <TEnum extends Enum> void check(TEnum... values) {
        check(getEnumValues(values));
    }

    public <TEnum extends Enum> void uncheck(TEnum... values) {
        uncheck(getEnumValues(values));
    }

    /**
     * Checks particular elements by index and uncheck others
     * @param indexes int var arg, ids to check
     */
    @JDIAction("Check '{0}' checkboxes in '{name}' checklist")
    public void check(int... indexes) {
        shouldBeVisible("check");
        List<Integer> listIndexes = toList(indexes);
        for (int i = 1; i <= values().size(); i++) {
            UIElement value = list().get(i - 1);
            if (value.isDisabled()) continue;
            if (selected(value) && !listIndexes.contains(i)
                    || !selected(value) && listIndexes.contains(i))
                value.click();
        }
    }
    @Override
    public boolean isDisplayed() {
        return list().isDisplayed();
    }

    /**
     * Checks all elements
     */
    @JDIAction("Check all '{name}' unchecked options")
    public void checkAll() {
        shouldBeVisible("check");
        for (UIElement checkbox : list()) {
            if (checkbox.isEnabled() && !selected(checkbox)) {
                checkbox.click();
            }
        }
    }
    /**
     * Unchecks particular elements by index and check others
     * @param indexes int var arg, ids to uncheck
     */
    @JDIAction("Uncheck '{0}' checkboxes in  '{name}' checklist")
    public void uncheck(int... indexes) {
        shouldBeVisible("uncheck");
        if (indexes.length > 0 && list().get(indexes[0]-1).isDisplayed()) {
            List<Integer> listIndexes = toList(indexes);
            for (int i = 1; i <= values().size(); i++) {
                UIElement value = list().get(i - 1);
                if (value.isDisabled()) continue;
                if (selected(value) && listIndexes.contains(i)
                        || !selected(value) && !listIndexes.contains(i))
                    value.click();
            }
        }
    }

    /**
     * Unchecks all elements
     */
    @JDIAction("Uncheck all '{name}' checked options")
    public void uncheckAll() {
        shouldBeVisible("uncheck");
        for (UIElement checkbox : list()) {
            if (checkbox.isEnabled() && selected(checkbox)) {
                checkbox.click();
            }
        }
    }

    /**
     * Gets checked values in checklist
     * @return List<String>
     */
    @JDIAction("Get '{name}' checked options")
    public List<String> checked() {
        return ifSelect(list(), UIElement::isSelected, UIElement::labelText);
    }

    /**
     * Selects a value in checklist
     * @param value String var arg
     */
    @JDIAction("Select '{0}' for '{name}'")
    public void select(String value) {
        select(new String[]{value});
    }

    /**
     * Selects a value with index in checklist
     * @param index int var arg
     */
    @JDIAction("Select '{0}' for '{name}'")
    public void select(int index) {
        select(new int[]{index});
    }

    /**
     * Gets a list of text from each values from checklist
     * @return List<String>
     */
    @JDIAction("Get '{name}' values")
    public List<String> values() {
        return map(labels(), element -> element.getText().trim());
    }

    /**
     * Gets a list of innerText from each values from checklist
     * @return List<String>
     */
    @JDIAction("Get '{name}' values")
    public List<String> values(TextType type) {
        return map(labels(), element -> element.text(type).trim());
    }

    /**
     * Gets enabled values from checklist
     * @return List<String>
     */
    @JDIAction("Get '{name}' enabled options")
    public List<String> listEnabled() {
        return list().ifSelect(UIElement::isEnabled, UIElement::labelText);
    }

    /**
     * Gets disabled values from checklist
     * @return List<String>
     */
    @JDIAction("Get '{name}' disabled options")
    public List<String> listDisabled() {
        return list().ifSelect(UIElement::isDisabled, UIElement::labelText);
    }

    /**
     * Sets values in checklist
     * @param value String with values separated ";"
     */
    @Override
    public void setValue(String value) {
        check(value.split(";"));
    }

    /**
     * Gets selected values separated ";"
     * @return String
     */
    @Override
    @JDIAction("Get '{name}' selected option")
    public String selected() {
        return print(list().ifSelect(UIElement::isSelected, UIElement::labelText));
    }

    /**
     * Checks if a value is selected in a checklist
     * @param value String to select
     * @return boolean
     */
    @JDIAction("Is '{0}' selected in '{name}'")
    public boolean selected(String value) {
        return get(value).isSelected();
    }
}
