package com.jdiai.jswraper;

import com.jdiai.jsdriver.JDINovaException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.List;
import java.util.function.Function;

import static com.epam.jdi.tools.LinqUtils.map;
import static com.epam.jdi.tools.LinqUtils.newList;
import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.ReflectionUtils.getGenericTypes;
import static com.jdiai.jsbuilder.JSTemplates.XPATH_FUNC;
import static com.jdiai.jswraper.JSWrappersUtils.getValueType;
import static java.lang.String.format;

public class JSEntity<T> extends JSElement {
    protected Class<T> cl;
    public JSEntity(WebDriver driver, List<By> locators) {
        super(driver, locators);
    }
    public JSEntity(WebDriver driver, By... locators) {
        super(driver, locators);
    }
    public JSEntity<T> initClass(Class<T> cl) {
        this.cl = cl;
        return this;
    }
    public void setup(Field field) {
        Type[] types;
        try {
            types = getGenericTypes(field);
        } catch (Exception ex) { return; }
        if (types.length != 1) return;
        try {
            this.cl = (Class<T>) types[0];
        } catch (Exception ex) { throw new JDINovaException(ex, "Can't init JSObject class."); }
    }

    // Use json map like "{ 'tag': element.tagName, 'text': element.textContent... } with names equal to field names in class
    public T getEntity(String objectMap) {
        return driver.getOne(validateXpath(objectMap)).asObject(cl);
    }
    public T getEntity() {
        return getEntity(GET_ENTITY_MAP.apply(cl));
    }
    public T getEntity(List<String> attributes) {
        return driver.getOne(attributesToJson(attributes)).asObject(cl);
    }
    public T getEntityFromAttr(String... attributes) {
        return getEntity(newList(attributes));
    }
    // Use json map like "{ 'tag': element.tagName, 'text': element.textContent... } with names equal to field names in class
    public List<T> getEntityList(String objectMap) {
        return driver.getList(validateXpath(objectMap)).asObject(cl);
    }
    public List<T> getEntityList() {
        return getEntityList(GET_ENTITY_MAP.apply(cl));
    }

    public static Function<Class<?>, String> GET_ENTITY_MAP = cl -> {
        List<String> mapList = map(cl.getDeclaredFields(),
            field -> format("'%s': %s", field.getName(), getValueType(field, "element")));
        return  "{ " + print(mapList, ", ") + " }";
    };

    public List<T> getEntityList(List<String> attributes) {
        return driver.getList(attributesToJson(attributes)).asObject(cl);
    }
    public List<T> getEntityListFromAttr(String... attributes) {
        return getEntityList(newList(attributes));
    }

    private String validateXpath(String objectMap) {
        if (objectMap.contains("': xpath(")) {
            driver.builder().registerFunction("xpath", XPATH_FUNC);
        }
        return objectMap;
    }
}
