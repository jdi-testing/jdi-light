package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

public interface IsContainer extends ICoreElement {
    @JDIAction("Get if '{name}' is fixed")
    default UIElement content() {
        return core().firstChild();
    }

    @JDIAction("Get {name} content")
    default <T extends UIElement> T content(Class<T> clazz) {
        return this.content().with(clazz);
    }
    @JDIAction("Get if {name} has content")
    default boolean hasContent() {
        return this.content().isExist();
    }
}
