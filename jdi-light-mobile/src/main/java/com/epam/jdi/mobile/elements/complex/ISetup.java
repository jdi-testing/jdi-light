package com.epam.jdi.mobile.elements.complex;

import com.epam.jdi.mobile.elements.interfaces.base.JDIElement;

import java.lang.reflect.Field;

/**
 * Created by Roman Iovlev on 08.04.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public interface ISetup extends JDIElement {
    void setup(Field f);
}
