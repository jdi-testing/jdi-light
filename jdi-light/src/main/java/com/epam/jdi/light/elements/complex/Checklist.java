package com.epam.jdi.light.elements.complex;

import com.epam.jdi.light.asserts.complex.ChecklistAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.IListBase;
import com.epam.jdi.light.elements.interfaces.complex.IsChecklist;

import java.util.List;

import static com.epam.jdi.light.common.TextTypes.LABEL;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.EnumUtils.getEnumValues;
import static com.epam.jdi.tools.LinqUtils.ifSelect;
import static com.epam.jdi.tools.PrintUtils.print;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class Checklist extends UIListBase<ChecklistAssert> implements IsChecklist {
    @Override
    public WebList list() {
        return super.list().setUIElementName(LABEL);
    }
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
        list().check(names);
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
        list().uncheck(names);
    }

    public <TEnum extends Enum> void check(TEnum value) {
        check(getEnumValue(value));
    }
    public <TEnum extends Enum> void check(TEnum... values) {
        list().check(values);
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
        list().check(indexes);
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
        list().checkAll();
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
        list().uncheck(indexes);
    }

    /**
     * Unchecks all elements
     */
    @JDIAction("Uncheck all '{name}' checked options")
    public void uncheckAll() {
        list().uncheckAll();
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
