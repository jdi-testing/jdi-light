package com.epam.jdi.light.elements.interfaces;

import java.lang.reflect.Field;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public interface INamed {
    String getName();
    void setName(Field field, String className);
    <T> T setName(String name);
}
