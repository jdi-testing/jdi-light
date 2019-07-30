package com.epam.jdi.light.elements.interfaces;

import com.epam.jdi.light.elements.base.DriverBase;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.tools.func.JAction1;

public interface IBaseElement extends JDIElement, HasCache {
    JDIBase base();
    default <T> T setup(Class<T> cl, JAction1<JDIBase> setup) {
        setup.execute(base());
        return (T)this;
    }
    default DriverBase setName(String name) {
        return base().setName(name);
    }
    default String getName() {
        return base().getName();
    }
    default void offCache() {
        base().offCache();
    }
}
