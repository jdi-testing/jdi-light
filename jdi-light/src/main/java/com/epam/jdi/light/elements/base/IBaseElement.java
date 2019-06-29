package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.HasCache;

public interface IBaseElement extends JDIElement, HasCache {
    @JDIAction("Get '{name}' text")
    default String getText() { return core().getText(); }
    void hover();
    boolean isEnabled();
    boolean isDisabled();
    boolean isDisplayed();
    boolean isHidden();
    void highlight(String color);
    void highlight();
    void show();

    UIElement core();
    default <T> T setName(String name) {
        return core().setName(name);
    }
    default String getName() {
        return core().getName();
    }
    default void offCache() {
        core().offCache();
    }
}
