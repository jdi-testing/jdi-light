package com.epam.jdi.light.elements.interfaces.base;

public interface HasPlaceholder extends ICoreElement {
    default String placeholder() { return core().placeholder(); }
}
