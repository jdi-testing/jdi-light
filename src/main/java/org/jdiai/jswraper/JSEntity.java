package org.jdiai.jswraper;

import com.epam.jdi.tools.func.JFunc1;
import org.jdiai.jsdriver.JSException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.List;

import static com.epam.jdi.tools.LinqUtils.*;
import static com.epam.jdi.tools.LinqUtils.newList;
import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.ReflectionUtils.getGenericTypes;
import static java.lang.String.format;
import static org.jdiai.tools.JS.getValueType;

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
        } catch (Exception ex) { throw new JSException(ex, "Can't init JSObject class."); }
    }

    // Use json map like "{ 'tag': element.tagName, 'text': element.textContent... } with names equal to field names in class
    public T getEntity(String objectMap) {
        return driver.getOne(objectMap).asObject(cl);
    }
    public T getEntity() {
        return getEntity(CLASS_TO_MAP.execute(cl));
    }
    public T getEntity(List<String> attributes) {
        return driver.getOne(attributesToJson(attributes)).asObject(cl);
    }
    public T getEntityFromAttr(String... attributes) {
        return getEntity(newList(attributes));
    }
    // Use json map like "{ 'tag': element.tagName, 'text': element.textContent... } with names equal to field names in class
    public List<T> getEntityList(String objectMap) {
        return driver.getList(objectMap).asObject(cl);
    }
    public List<T> getEntityList() {
        return getEntityList(CLASS_TO_MAP.execute(cl));
    }
    public static JFunc1<Class<?>, String> CLASS_TO_MAP = cl -> {
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
}
