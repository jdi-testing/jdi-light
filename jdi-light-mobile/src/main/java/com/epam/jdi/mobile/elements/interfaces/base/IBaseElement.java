package com.epam.jdi.mobile.elements.interfaces.base;

import com.epam.jdi.mobile.elements.base.DriverBase;
import com.epam.jdi.mobile.elements.base.JDIBase;
import com.epam.jdi.tools.func.JAction1;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public interface IBaseElement extends JDIElement, HasCache {
    JDIBase base();
    default IBaseElement waitSec(int sec){
        base().waitSec(sec);
        return this;
    }
    default <T> T setup(Class<T> cl, JAction1<JDIBase> setup) {
        setup.execute(base());
        return (T)this;
    }
    default <T> T setCore(Class<T> cl, JDIBase core) {
        base().setCore(core);
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
    default boolean isUseCache() {
        return base().isUseCache();
    }
}
