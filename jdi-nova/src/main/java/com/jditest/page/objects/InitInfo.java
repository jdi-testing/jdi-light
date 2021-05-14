package com.jditest.page.objects;

import java.lang.reflect.Field;

import static com.epam.jdi.tools.ReflectionUtils.getValueField;
import static com.jditest.page.objects.PageFactoryUtils.createInstance;

public class InitInfo {
    public Object parent;
    public Object instance;
    public Field field;
    public Class<?> fieldClass() { return field.getType(); }
    public Class<?> instanceClass() { return instance.getClass(); }
    public Object fieldValue() { return getValueField(field, parent); }

    public InitInfo(Object parent, Field field) {
        this.parent = parent;
        this.field = field;
        this.instance = fieldValue() != null
            ? fieldValue()
            : createInstance(fieldClass());
    }
}
