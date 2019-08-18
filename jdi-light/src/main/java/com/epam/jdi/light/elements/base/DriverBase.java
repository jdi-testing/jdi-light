package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.common.UIUtils;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.init.SiteInfo;
import com.epam.jdi.light.elements.interfaces.base.JDIElement;
import com.epam.jdi.tools.Timer;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.driver.get.DriverData.DRIVER_NAME;
import static com.epam.jdi.light.settings.TimeoutSettings.TIMEOUT;
import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static com.epam.jdi.tools.StringUtils.splitCamelCase;
import static org.apache.commons.lang3.StringUtils.isBlank;

public abstract class DriverBase implements JDIElement {
    public String driverName = DRIVER_NAME;
    public WebDriver driver() { return WebDriverFactory.getDriver(driverName); }
    public JavascriptExecutor js() { return (JavascriptExecutor) driver(); }

    public <T> T asEntity(Class<T> entityClass) {
        return UIUtils.asEntity(this, entityClass);
    }
    public String name = "";
    public String varName = "";
    public String typeName = "";
    public String failElement = "";
    public Object parent;
    public List<Object> parents() {
        List<Object> parents = new ArrayList<>();
        Object p = parent;
        while (p != null) {
            parents.add(p);
            p = isClass(p.getClass(), DriverBase.class) ? ((DriverBase)p).parent : null;
        }
        return parents;
    }
    protected String context;
    public DriverBase setParent(Object parent) {
        this.parent = parent;
        return this;
    }

    public void setName(SiteInfo info) {
        if (info.field != null)
            setName(info.field, info.parentName());
        else {
            setName(info.name());
            setTypeName(info.type().getSimpleName());
        }
    }
    public DriverBase setName(String name) {
        this.name = name;
        this.varName = name;
        this.failElement = name;
        return this;
    }
    public void setName(Field field, String className) {
        this.name = splitCamelCase(field.getName());
        this.failElement = this.name;
        this.varName = className + "." + field.getName();
        this.typeName = field.getType().getSimpleName();
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    public String getName() {
        return isBlank(name) ? getClass().getSimpleName() : name;
    }

    public WebPage getPage() {
        if (parent == null) return null;
        if (isClass(parent.getClass(), WebPage.class))
            return (WebPage) parent;
        if (!isClass(parent.getClass(), DriverBase.class)) return null;
        return ((DriverBase)parent).getPage();
    }
}
