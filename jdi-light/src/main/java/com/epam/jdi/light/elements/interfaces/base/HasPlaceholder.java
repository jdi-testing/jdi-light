package com.epam.jdi.light.elements.interfaces.base;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

public interface HasPlaceholder extends ICoreElement {
    default String placeholder() { return core().placeholder(); }
}
