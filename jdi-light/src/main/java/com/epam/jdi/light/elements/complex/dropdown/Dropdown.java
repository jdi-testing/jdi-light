package com.epam.jdi.light.elements.complex.dropdown;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.WebList;

import java.util.List;

/**
 * Created by Roman Iovlev on 02.03.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class Dropdown extends DropdownExpand {
    protected DropdownSelect ds() {
        return new DropdownSelect().setCore(DropdownSelect.class, base());
    }

    @Override
    public WebList list() {
        return setupDone ? super.list() : ds().list();
    }
    /**
     * Select the specified element by the value
     * @param value
     */
    @JDIAction("Select '{0}' in '{name}'") @Override
    public void select(String value) {
        if (setupDone)
            super.select(value);
        else ds().select(value);
    }

    /**
     * Select the specified element by the index
     * @param index
     */
    @JDIAction("Select '{0}' in '{name}'") @Override
    public void select(int index) {
        if (setupDone)
            super.select(index);
        else ds().select(index);
    }

    @JDIAction("Check that '{name}' is displayed") @Override
    public String selected() {
        return setupDone ? super.selected() : ds().selected();
    }

    @JDIAction("Is '{0}' selected") @Override
    public boolean selected(String option) {
        return setupDone ? super.selected(option) : ds().selected(option);
    }

    @JDIAction("Get '{name}' values") @Override
    public List<String> values() {
        return setupDone ? super.values() : ds().values();
    }

    @Override
    public String getText() {
        return setupDone ? super.getText() : ds().getText();
    }

    @Override
    public String getValue() {
        return getText();
    }
    @Override
    public void setValue(String value) {
        if (setupDone)
            super.setValue(value);
        else ds().setValue(value);
    }
    @Override
    public int size() {
        return setupDone ? super.size() : ds().size();
    }

}
