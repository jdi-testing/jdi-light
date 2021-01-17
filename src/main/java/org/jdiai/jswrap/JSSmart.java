package org.jdiai.jswrap;

import com.google.gson.JsonObject;
import org.jdiai.Json;
import org.jdiai.jsbuilder.JSBuilder;
import org.jdiai.jsbuilder.SmartBuilderActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static com.epam.jdi.tools.LinqUtils.map;
import static com.epam.jdi.tools.LinqUtils.newList;

public class JSSmart extends JSElement {
    public JSSmart(WebDriver driver, List<By> locators) {
        super(driver, locators);
        this.driver.setBuilder(new JSBuilder(driver, new SmartBuilderActions()));
    }
    public JSSmart(WebDriver driver, By... locators) {
        this(driver, newList(locators));
    }

    public String getAttribute(String attribute) {
        return getValue("element." + attribute);
    }
    public Json getAttributes(List<String> attributes) {
        JsonObject json = driver.getOne(attributesToJson(attributes)).asJson();
        return new Json(attributes, s -> json.get(s).getAsString());
    }
    public Json getAttributes(String... attributes) {
        return getAttributes(newList(attributes));
    }
    public List<String> getAttributeList(String attribute) {
        return driver.getList("element." + attribute).asString();
    }
    public List<Json> getMultiAttributes(List<String> attributes) {
        List<JsonObject> objects = driver.getList(attributesToJson(attributes)).asJson();
        return map(objects, json -> new Json(attributes, v -> json.get(v).getAsString()));
    }
    public List<Json> getMultiAttributes(String... attributes) {
        return getMultiAttributes(newList(attributes));
    }
    public JsonObject getJson(String json) {
        return driver.getOne(json).asJson();
    }
    public String getValue(String valueFunc) {
        return driver.getOne(valueFunc).asString();
    }
    public Json getMap(String valueFunc) {
        return driver.getOne(valueFunc).asMap();
    }
    public List<JsonObject> getJsonList(String json) {
        return driver.getList(json).asJson();
    }

    protected Class<?> entity;
    public JSSmart setEntity(Class<?> entity) {
        this.entity = entity;
        return this;
    }
    // Use json map like "{ 'tag': element.tagName, 'text': element.textContent... } with names equal to field names in class
    public <T> T getEntity(String objectMap) {
        return (T) driver.getOne(objectMap).asObject(entity);
    }
    public <T> T getEntity(List<String> attributes) {
        return (T) driver.getOne(attributesToJson(attributes)).asObject(entity);
    }
    public <T> T getEntityFromAttr(String... attributes) {
        return getEntity(newList(attributes));
    }
    // Use json map like "{ 'tag': element.tagName, 'text': element.textContent... } with names equal to field names in class
    public <T> List<T> getEntityList(String objectMap) {
        return map(driver.getList(objectMap).asObject(entity), el -> (T) el);
    }
    public <T> List<T> getEntityList(List<String> attributes) {
        return map(driver.getList(attributesToJson(attributes)).asObject(entity), el -> (T) el);
    }
    public <T> List<T> getEntityListFromAttr(String... attributes) {
        return getEntityList(newList(attributes));
    }
}
