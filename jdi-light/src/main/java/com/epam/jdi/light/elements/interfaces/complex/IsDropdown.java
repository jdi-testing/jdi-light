package com.epam.jdi.light.elements.interfaces.complex;

import com.epam.jdi.light.elements.complex.ISelector;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;

public interface IsDropdown extends ISelector, HasLabel {
    /*default void select(String value) {
        expand();
        list().select(value);
        close();
    }
    default void select(int index) {
        if (index < 1)
            throw exception("Can't get element with index '%s'. Index should be 1 or more", index);
        expand();
        list().select(index-1);
        close();
    }
    @JDIAction(value = "Is '{name}' expanded", level = DEBUG)
    default boolean isExpanded() {
        return list().noWait(WebList::isDisplayed, WebList.class);
    }
    default void expand() {
        if (!isExpanded())
            toggle();
    }
    default void close() {
        if (isExpanded())
            toggle();
    }
    default void toggle() { core().click(); }*/
}
