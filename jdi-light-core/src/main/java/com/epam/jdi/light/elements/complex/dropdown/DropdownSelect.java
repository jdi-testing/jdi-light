package com.epam.jdi.light.elements.complex.dropdown;

import com.epam.jdi.light.asserts.complex.DropdownAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.TextTypes;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.Selector;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.complex.IsDropdown;
import com.jdiai.tools.func.JFunc1;

import java.util.List;

import static com.epam.jdi.light.common.Exceptions.runtimeException;
import static com.epam.jdi.light.settings.JDISettings.ELEMENT;

/**
 * Created by Roman Iovlev on 02.03.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class DropdownSelect extends UIBaseElement<DropdownAssert> implements IsDropdown {
    protected int startIndex = ELEMENT.startIndex;

    protected Selector selector() {
        return new Selector().setCore(Selector.class, base());
    }

    public WebList list() {
        WebList list = selector().list();
        list.setStartIndex(getStartIndex());
        return list;
    }

    /**
     * Select the specified element by the value
     *
     * @param value of item to be found
     */
    @JDIAction("Select '{0}' in '{name}'")
    @Override
    public void select(String value) {
        if (value == null) {
            return;
        }
        selector().select(value);
    }

    /**
     * Select the specified element by the index
     *
     * @param index index of item to be found
     */
    @JDIAction("Select '{0}' in '{name}'")
    @Override
    public void select(int index) {
        selector().select(index);
    }

    /**
     * Gets text of selected item.
     *
     * @return text of selected item as {@link String}
     */
    @JDIAction("Get text of selected '{name}'")
    @Override
    public String selected() {
        return selector().selected();
    }

    public boolean wait(JFunc1<IsDropdown, Boolean> condition) {
        return base().timer().wait(() -> condition.execute(this));
    }

    @Override
    public boolean selected(String option) {
        return selector().selected(option);
    }

    @Override
    public List<String> values() {
        return selector().values();
    }

    @Override
    public List<String> values(TextTypes type) {
        return selector().values();
    }

    @Override
    public DropdownAssert is() {
        return new DropdownAssert().set(this);
    }

    @Override
    public boolean isExpanded() {
        throw runtimeException("function isExpanded() can not be used with this element");
    }

    @Override
    public boolean isCollapsed() {
        throw runtimeException("function isCollapsed() can not be used with this element");
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int index) {
        startIndex = index;
    }
}
