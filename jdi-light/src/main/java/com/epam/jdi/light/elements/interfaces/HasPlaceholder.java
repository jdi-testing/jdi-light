package com.epam.jdi.light.elements.interfaces;

public interface HasPlaceholder extends IBaseElement {
    default String placeholder() { return core().placeholder(); }
}
