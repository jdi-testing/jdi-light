package com.epam.jdi.light.ui.html.elements.complex;

import com.epam.jdi.light.asserts.complex.ChecklistAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.IListBase;
import com.epam.jdi.light.elements.interfaces.complex.IsChecklist;

import java.util.List;

import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.EnumUtils.getEnumValues;
import static com.epam.jdi.tools.LinqUtils.ifSelect;
import static com.epam.jdi.tools.LinqUtils.toList;
import static com.epam.jdi.tools.PrintUtils.print;
import static java.util.Arrays.asList;

public class Checklist extends UIListBase<ChecklistAssert> implements IsChecklist {
    public Checklist() {
        base().setLocator("input[type=checkbox]");
    }
    /**
     * Selects a value in checklist
     * @param value String var arg
     */
    @JDIAction("Select '{0}' for '{name}'")
    public void select(String value) {
        list().select(value);
    }
    /**
     * Select particular elements by name
     * @param values String var arg, elements with text to select
     */
    @JDIAction("Select '{0}' checkboxes in '{name}' checklist")
    public void select(String... values) {
        list().select(values);
    }

    public <TEnum extends Enum> void select(TEnum value) {
        list().select(value);
    }

    public <TEnum extends Enum> void select(TEnum... values) {
        list().select(values);
    }


    /**
     * Selects a value with index in checklist
     * @param index int var arg
     */
    @JDIAction("Select '{0}' for '{name}'")
    public void select(int index) {
        list().select(index-1);
    }
    /**
     * Selects particular elements by index
     * @param indexes String var arg, elements with text to select
     */
    @JDIAction("Select '{0}' checkboxes in '{name}' checklist")
    public void select(int... indexes) {
        for (int index : indexes)
            select(index);
    }

    /**
     * Selects only particular elements and unselects others
     * @param names String var arg, elements with text to select
     */
    @JDIAction("Check '{0}' checkboxes in '{name}' checklist")
    public void check(String... names) {
        List<String> listNames = asList(names);
        for (UIElement value : list()) {
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
        List<String> listNames = asList(names);
        for (UIElement value : list()) {
            if (value.isDisabled()) continue;
            if (selected(value) && listNames.contains(value.labelText().trim())
                    || !selected(value) && !listNames.contains(value.labelText().trim()))
                value.click();
        }
    }

    public <TEnum extends Enum> void check(TEnum value) {
        check(getEnumValue(value));
    }
    public <TEnum extends Enum> void check(TEnum... values) {
        check(getEnumValues(values));
    }


    public <TEnum extends Enum> void uncheck(TEnum value) {
        uncheck(getEnumValue(value));
    }
    public <TEnum extends Enum> void uncheck(TEnum... values) {
        uncheck(getEnumValues(values));
    }

    public void check(int index) {
        check(new int[]{index});
    }
    /**
     * Checks particular elements by index and uncheck others
     * @param indexes int var arg, ids to check
     */
    @JDIAction("Check '{0}' checkboxes in '{name}' checklist")
    public void check(int... indexes) {
        List<Integer> listIndexes = toList(indexes);
        for (int i = 0; i < values().size(); i++) {
            UIElement value = list().get(i);
            if (value.isDisabled()) continue;
            if (selected(value) && !listIndexes.contains(i+1)
                    || !selected(value) && listIndexes.contains(i+1))
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
        for (UIElement checkbox : list()) {
            if (checkbox.isEnabled() && !selected(checkbox)) {
                checkbox.click();
            }
        }
    }
    public void uncheck(int index) {
        uncheck(new int[]{index});
    }
    /**
     * Unchecks particular elements by index and check others
     * @param indexes int var arg, ids to uncheck
     */
    @JDIAction("Uncheck '{0}' checkboxes in  '{name}' checklist")
    public void uncheck(int... indexes) {
        if (indexes.length > 0 && list().get(indexes[0]-1).isDisplayed()) {
            List<Integer> listIndexes = toList(indexes);
            for (int i = 0; i < values().size(); i++) {
                UIElement value = list().get(i);
                if (value.isDisabled()) continue;
                if (selected(value) && listIndexes.contains(i+1)
                        || !selected(value) && !listIndexes.contains(i+1))
                    value.click();
            }
        }
    }

    /**
     * Unchecks all elements
     */
    @JDIAction("Uncheck all '{name}' checked options")
    public void uncheckAll() {
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
        return list().get(value).isSelected();
    }
    @Override
    public List<String> listEnabled() {
        return list().ifSelect(IListBase::isEnabled, UIElement::labelText);
    }
    @Override
    public List<String> listDisabled() {
        return list().ifSelect(IListBase::isDisabled, UIElement::labelText);
    }

    @Override
    public ChecklistAssert is() {
        return new ChecklistAssert().set(this);
    }

}
