package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.elements.interfaces.base.IBaseElement;

public interface BaseVuetifyAssert <E extends IBaseElement> extends IBaseElement {
    E element();
}
