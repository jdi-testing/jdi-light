package com.epam.jdi.light.elements.init;

import java.lang.reflect.Field;

public class SiteInfo {
    public Field field;
    public Class fieldType() { return field.getType(); }
    public Class<?> parentClass;
    public Object parent;
    public Class<?> parentType() {
        return parentClass != null ? parentClass : parent.getClass();
    }
    public String parentName() {
        if (parent != null)
            return parent.getClass().getSimpleName();
        return parentClass != null
            ? parentClass.getSimpleName()
            : "";
    }
    public Object instance;
    public String driverName;

    public SiteInfo() {}
    public SiteInfo(SiteInfo info) {
        this.field = info.field;
        this.parentClass = info.parentClass;
        this.parent = info.parent;
        this.instance = info.instance;
        this.driverName = info.driverName;
    }

}
