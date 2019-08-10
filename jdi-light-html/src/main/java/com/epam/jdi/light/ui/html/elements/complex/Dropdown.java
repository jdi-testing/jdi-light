package com.epam.jdi.light.ui.html.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.complex.IsDropdown;

import java.util.List;

/**
 * Created by Roman Iovlev on 02.03.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class Dropdown extends DropdownExpand {
    protected DropdownSelect ds() {
        return new DropdownSelect().setCore(DropdownSelect.class, base());
    }
    protected IsDropdown dropdown() {
        return setupDone ? this : ds();
    }

    /**
     * Select the specified element by the value
     * @param value
     */
    @JDIAction("Select '{0}' in '{name}'") @Override
    public void select(String value) {
        dropdown().select(value);
    }

    /**
     * Select the specified element by the index
     * @param index
     */
    @JDIAction("Select '{0}' in '{name}'") @Override
    public void select(int index) {
        dropdown().select(index);
    }

    @JDIAction("Check that '{name}' is displayed") @Override
    public String selected() { return dropdown().selected(); }

    @Override
    public boolean selected(String option) {
        return dropdown().selected(option);
    }

    @JDIAction("Get '{name}' values")
    public List<String> values() {
        return dropdown().values();
    }

    public String getValue() { return dropdown().getValue(); }
    public void setValue(String value) { dropdown().setValue(value); }
    public int size() { return dropdown().size(); }

}
