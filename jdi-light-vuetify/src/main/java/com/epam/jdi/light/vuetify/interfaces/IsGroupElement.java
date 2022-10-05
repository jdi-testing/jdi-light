package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.vuetify.elements.common.Chip;

import java.util.Arrays;
import java.util.List;

public interface IsGroupElement<A extends UIBaseElement<?>> extends ICoreElement {

    List<A> groupElements();

    A getElement(String value);

    default int size() {
        return groupElements().size();
    }
}
