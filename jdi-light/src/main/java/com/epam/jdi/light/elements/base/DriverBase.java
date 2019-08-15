package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.common.UIUtils;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.interfaces.INamed;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Field;

import static com.epam.jdi.light.driver.get.DriverData.DRIVER_NAME;
import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static com.epam.jdi.tools.StringUtils.splitCamelCase;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class DriverBase implements INamed {
    public static final String DEFAULT_DRIVER = "chrome";
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
    protected String context;
    public <T extends JDIBase> T setParent(Object parent) {
        this.parent = parent;
        return (T) this;
    }

    public <T> T setName(String name) {
        this.name = name;
        this.varName = name;
        this.failElement = name;
        return (T) this;
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
        if (!isClass(parent.getClass(), JDIBase.class)) return null;
        return ((JDIBase)parent).getPage();
    }
    public boolean hasParent(String name) {
        if (parent == null) return false;
        if (isClass(parent.getClass(), WebPage.class))
            return ((WebPage) parent).getName().equals(name);
        if (!isClass(parent.getClass(), JDIBase.class)) return false;
        return ((JDIBase)parent).hasParent(name);
    }
}
