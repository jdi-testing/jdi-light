package com.epam.jdi.light.elements.interfaces.base;

public interface HasCheck extends ICoreElement, IClickable {
    default void check() { core().check(); }
    default void uncheck() { core().uncheck(); }
}
