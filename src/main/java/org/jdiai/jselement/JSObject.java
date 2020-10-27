package org.jdiai.jselement;

import org.jdiai.JSException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.List;

import static com.epam.jdi.tools.ReflectionUtils.getGenericTypes;

public class JSObject<T> extends JSBase {
    protected Class<T> cl;
    public JSObject(WebDriver driver, List<By> locators) {
        super(driver, locators);
    }
    public JSObject(WebDriver driver, By... locators) {
        super(driver, locators);
    }
    public JSObject<T> initClass(Class<T> cl) {
        this.cl = cl;
        return this;
    }
    public void initFromField(Field field) {
        Type[] types;
        try {
            types = getGenericTypes(field);
        } catch (Exception ex) { return; }
        if (types.length != 1) return;
        try {
            this.cl = (Class<T>) types[0];
        } catch (Exception ex) { throw new JSException(ex, "Can't init JSObject class."); }

    }

    public T getObject(String json) {
        return driver.json(json).getOne().asObject(cl);
    }
    public T getObject(String... attributes) {
        return driver.attributes(attributes).getOne().asObject(cl);
    }
    public List<T> getObjectList(String json) {
        return driver.json(json).getList().asObject(cl);
    }
    public List<T> getObjectList(String... attributes) {
        return driver.attributes(attributes).getList().asObject(cl);
    }
}
