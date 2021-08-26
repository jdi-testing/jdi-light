package com.jdiai.page.objects;

import java.lang.reflect.Field;

import static com.jdiai.tools.ReflectionUtils.getValueField;

public class InitInfo {
    public Object parent;
    public Object instance;
    public Field field;
    public Class<?> fieldClass() { return field.getType(); }
    public Class<?> instanceClass() { return instance.getClass(); }
    public Object fieldValue() { return getValueField(field, parent); }

    public InitInfo(Object parent, Field field, Object instance) {
        this.parent = parent;
        this.field = field;
        this.instance = instance;
    }
}
