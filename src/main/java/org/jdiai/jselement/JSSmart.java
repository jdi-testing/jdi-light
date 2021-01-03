package org.jdiai.jselement;

import com.epam.jdi.tools.map.MapArray;
import com.google.gson.JsonObject;
import org.jdiai.jsbuilder.IJSBuilder;
import org.jdiai.jsbuilder.JSBuilder;
import org.jdiai.jsbuilder.SmartBuilderActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static com.epam.jdi.tools.LinqUtils.map;
import static java.util.Arrays.asList;

public class JSSmart extends JSElement {
    public JSSmart(WebDriver driver, List<By> locators) {
        super(driver, locators);
        this.driver.setBuilder(new JSBuilder(driver, new SmartBuilderActions()));
    }
    public JSSmart(WebDriver driver, By... locators) {
        this(driver, asList(locators));
    }

    public String getAttribute(String attribute) {
        return getValue("element." + attribute);
    }
    public MapArray<String, String> getAttributes(List<String> attributes) {
        JsonObject json = driver.getOne(attributesToJson(attributes)).asJson();
        return new MapArray<>(attributes, s -> s, s -> json.get(s).getAsString());
    }
    public MapArray<String, String> getAttributes(String... attributes) {
        return getAttributes(asList(attributes));
    }
    public List<String> getAttributeList(String attribute) {
        return driver.getList("element." + attribute).asString();
    }
    public List<MapArray<String, String>> getMultiAttributes(List<String> attributes) {
        List<JsonObject> objects = driver.getList(attributesToJson(attributes)).asJson();
        return map(objects, json -> new MapArray<>(attributes, k -> k, v -> json.get(v).getAsString()));
    }
    public List<MapArray<String, String>> getMultiAttributes(String... attributes) {
        return getMultiAttributes(asList(attributes));
    }
    public JsonObject getJson(String json) {
        return driver.getOne(json).asJson();
    }
    public String getValue(String valueFunc) {
        return driver.getOne(valueFunc).asString();
    }
    public List<JsonObject> getJsonList(String json) {
        return driver.getList(json).asJson();
    }

    protected Class<?> entity;
    public JSSmart setEntity(Class<?> entity) {
        this.entity = entity;
        return this;
    }
    public <T> T getEntity(String objectMap) {
        return (T) driver.getOne(objectMap).asObject(entity);
    }
    public <T> T getEntityFromObject(String jsObject) {
        return getEntity("JSON.stringify(" + jsObject + ")");
    }
    public <T> T getEntity(List<String> attributes) {
        return (T) driver.getOne(attributesToJson(attributes)).asObject(entity);
    }
    public <T> T getEntity(String... attributes) {
        return getEntity(asList(attributes));
    }
    public String jsExecute(String script) {
        IJSBuilder builder = jsDriver().builder();
        builder.addJSCode(script);
        return builder.executeQuery();
    }
}
