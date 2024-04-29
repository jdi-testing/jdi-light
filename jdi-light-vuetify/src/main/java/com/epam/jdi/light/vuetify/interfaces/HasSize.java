package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

public interface HasSize extends ICoreElement {

    @JDIAction("Get if '{name}' hss x-small size")
    default boolean xSmallSize() {
        return core().hasClass("v-size--x-small");
    }

    @JDIAction("Get if '{name}' has small size")
    default boolean smallSize() {
        return core().hasClass("v-size--small");
    }

    @JDIAction("Get if '{name}' has default size")
    default boolean defaultSize() {
        return core().hasClass("v-size--default");
    }

    @JDIAction("Get if '{name}' has large size")
    default boolean largeSize() {
        return core().hasClass("v-size--large");
    }

    @JDIAction("Get if '{name}' has x-large size")
    default boolean xLargeSize() {
        return core().hasClass("v-size--x-large");
    }
}
