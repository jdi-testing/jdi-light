package com.epam.jdi.light.material.interfaces.inputs;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

public interface HasPlaceholder extends ICoreElement {

    boolean hasPlaceholder();

    String getPlaceHolderText();
}
