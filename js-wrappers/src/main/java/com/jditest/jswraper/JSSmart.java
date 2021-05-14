package com.jditest.jswraper;

import com.google.gson.JsonObject;
import com.jditest.jsbuilder.SmartBuilderActions;
import com.jditest.jsproducer.Json;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.function.Supplier;

import static com.epam.jdi.tools.LinqUtils.map;
import static com.epam.jdi.tools.LinqUtils.newList;
import static com.jditest.jsbuilder.JSTemplates.XPATH_FUNC;
import static com.jditest.jswraper.JSEntity.GET_ENTITY_MAP;

public class JSSmart extends JSElement {
    public JSSmart(Supplier<WebDriver> driver, List<By> locators) {
        super(driver, locators);
        this.driver.updateBuilderActions(new SmartBuilderActions());
    }
    public JSSmart(WebDriver driver, List<By> locators) {
        this(() -> driver, locators);
    }
    public JSSmart(Supplier<WebDriver> driver, By... locators) {
        this(driver, newList(locators));
    }
    public JSSmart(WebDriver driver, By... locators) {
        this(() -> driver, locators);
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
    public List<String> getValues(String valueFunc) {
        return driver.getList(valueFunc).asString();
    }
    public String firstValue(String valueFunc) {
        return driver.getFirst(valueFunc).asString();
    }
    public Json getMap(String valueFunc) {
        return driver.getOne(valueFunc).asMap();
    }
    public List<JsonObject> getJsonList(String json) {
        return driver.getList(json).asJson();
    }

    protected Class<?> entity;
    public JSSmart setupEntity(Class<?> entity) {
        this.entity = entity;
        return this;
    }
    // Use json map like "{ 'tag': element.tagName, 'text': element.textContent... } with names equal to field names in class

    public <T> T getEntity(String objectMap) {
        return (T) driver.getOne(validateXpath(objectMap)).asObject(entity);
    }
    public void setEntity(String objectMap) {
        driver.getOne(validateXpath(objectMap)).asString();
    }
    public <T> T getEntity() {
        return getEntity(GET_ENTITY_MAP.execute(entity));
    }
    public <T> T getEntity(List<String> attributes) {
        return (T) driver.getOne(attributesToJson(attributes)).asObject(entity);
    }
    public void setEntity(List<String> attributes) {
        setEntity(attributesToJson(attributes));
    }
    public <T> T getEntityFromAttr(String... attributes) {
        return getEntity(newList(attributes));
    }
    // Use json map like "{ 'tag': element.tagName, 'text': element.textContent... } with names equal to field names in class
    public <T> List<T> getEntityList(String objectMap) {
        return map(driver.getList(validateXpath(objectMap)).asObject(entity), el -> (T) el);
    }
    public <T> List<T> getEntityList() {
        return getEntityList(GET_ENTITY_MAP.execute(entity));
    }
    public <T> List<T> getEntityList(List<String> attributes) {
        return map(driver.getList(attributesToJson(attributes)).asObject(entity), el -> (T) el);
    }
    public <T> List<T> getEntityListFromAttr(String... attributes) {
        return getEntityList(newList(attributes));
    }

    private String validateXpath(String objectMap) {
        if (objectMap.contains("': xpath(")) {
            driver.builder().registerFunction("xpath", XPATH_FUNC);
        }
        return objectMap;
    }
}
