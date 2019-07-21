package com.epam.jdi.light.elements.interfaces;

import com.epam.jdi.light.elements.base.DriverBase;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.tools.func.JAction1;

public interface IBaseElement extends JDIElement, HasCache {
    void hover();
    boolean isEnabled();
    boolean isDisabled();
    boolean isDisplayed();
    boolean isHidden();
    void highlight(String color);
    void highlight();
    void show();

    JDIBase base();
    UIElement core();
    default <T> T setup(Class<T> cl, JAction1<JDIBase> setup) {
        setup.execute(base());
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
