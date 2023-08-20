package com.epam.jdi.light.elements.init;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.jdiai.tools.DataClass;

import java.lang.reflect.Field;

import static com.jdiai.tools.StringUtils.format;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class SiteInfo extends DataClass<SiteInfo> {
    public String siteName;
    public Field field;
    public Class<?> cl;
    public String name;
    public Object parent;

    public Class<?> type() {
        if (cl != null) {
            return cl;
        }
        if (field != null) {
            return field.getType();
        }
        return instance != null
            ? cl = instance.getClass()
            : null;
    }

    public String name() {
        if (name != null) {
            return name;
        }
        return field != null ? field.getName() : "Undefined element";
    }

    public String parentName() {
        if (parent != null) {
            return parent.getClass().getSimpleName();
        }
        return siteName;
    }

    public Object instance;

    public UIElement core() {
        return ((ICoreElement) instance).core();
    }

    public IBaseElement base() {
        return (IBaseElement) instance;
    }

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
        this.siteName = info.siteName;
        this.parent = info.parent;
        this.instance = info.instance;
        this.driverName = info.driverName;
    }

    @Override
    public String toString() {
        try {
            return format("SiteInfo[field:%s]", field.getName());
        } catch (Exception ex) {
            return "SiteInfo[field:null]";
        }
    }
}
