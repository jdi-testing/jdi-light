package com.epam.jdi.light.elements.interfaces.base;

/**
 * Created by Roman Iovlev on 26.03.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public interface HasCache {
    /**
     * Get value of Element
     */
    void offCache();
    boolean isUseCache();
}