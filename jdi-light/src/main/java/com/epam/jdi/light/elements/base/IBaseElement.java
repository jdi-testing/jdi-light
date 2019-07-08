package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.HasCache;
import com.epam.jdi.tools.func.JAction1;

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
    default <T> T setup(Class<T> cl, JAction1<JDIBase> setup) {
        setup.execute(core());
        return (T)this;
    }
    default DriverBase setName(String name) {
        return core().setName(name);
    }
    default String getName() {
        return core().getName();
    }
    default void offCache() {
        core().offCache();
    }
}
