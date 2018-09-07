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
        return parent == null ? "" : parent.getClass().getSimpleName();
    }
    public Object instance;
    public String driverName;

    public SiteInfo() {}
    public SiteInfo(SiteInfo info) {
        this.field = field;
        this.parentClass = parentClass;
        this.parent = parent;
        this.instance = instance;
        this.driverName = driverName;
    }

}
