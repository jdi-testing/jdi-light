package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

import java.util.List;

public interface IsGroupElement<A extends UIBaseElement<?>> extends ICoreElement {

    List<A> groupElements();

    A getElement(String value);

    @JDIAction("Get size of '{name}'")
    default int size() {
        return groupElements().size();
    }
}
