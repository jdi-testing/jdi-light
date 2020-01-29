package com.epam.jdi.light.elements.init;

import com.epam.jdi.tools.DataClass;

import java.lang.reflect.Field;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class SiteInfo extends DataClass<SiteInfo> {
    public Field field;
    public Class<?> cl;
    public String name;
    public Class<?> type() {
        if (cl != null)
            return cl;
        if (field != null)
            return field.getType();
        return instance != null
            ? cl = instance.getClass()
            : null;
    }
    public String name() {
        return name != null
            ? name : ( field != null
                ? field.getName()
                : "Undefined element");
    }
    public Class<?> parentClass;
    public Object parent;
    public String parentName() {
        if (parent != null)
            return parent.getClass().getSimpleName();
        return parentClass != null
            ? parentClass.getSimpleName()
            : "";
    }
    public Object instance;
    public String driverName;

    public SiteInfo(String driver) {
        this.driverName = driver;
    }
    public SiteInfo(String driver, Object instance) {
        this.driverName = driver;
        this.instance = instance;
    }
    public SiteInfo(SiteInfo info) {
        this.field = info.field;
        this.parentClass = info.parentClass;
        this.parent = info.parent;
        this.instance = info.instance;
        this.driverName = info.driverName;
    }

}
