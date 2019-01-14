package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.common.UIUtils;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.composite.WebPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static com.epam.jdi.tools.StringUtils.splitCamelCase;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class DriverBase {
    public static final String DEFAULT_DRIVER = "chrome";
    public String driverName = DEFAULT_DRIVER;
    public WebDriver driver() { return WebDriverFactory.getDriver(driverName); }
    public JavascriptExecutor js() { return (JavascriptExecutor) driver(); }

    public <T> T asEntity(Class<T> entityClass) {
        return UIUtils.asEntity(this, entityClass);
    }

    public String name = "";
    public String varName = "";
    public String typeName = "";
    public Object parent;
    public <T extends JDIBase> T setParent(Object parent) {
        this.parent = parent;
        return (T) this;
    }

    public <T> T setName(String name) {
        this.name = name;
        return (T) this;
    }
    public void setName(String varName, String className) {
        this.name = splitCamelCase(varName);
        this.varName = className + "." + varName;
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


}
