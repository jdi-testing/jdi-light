package com.epam.jdi.light.material.interfaces.inputs;

import com.epam.jdi.light.elements.interfaces.base.HasLabel;

public interface HasPlaceholder extends HasLabel {

    boolean hasPlaceholder();

    String getPlaceHolderText();
}
