package com.jdiai.jswraper;

import com.google.gson.JsonObject;
import com.jdiai.jsbuilder.IJSBuilder;
import com.jdiai.jsdriver.JDINovaException;
import com.jdiai.jsdriver.JSDriver;
import com.jdiai.jsproducer.JSProducer;
import com.jdiai.jsproducer.Json;
import com.jdiai.jswraper.scripts.NTC;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.function.Supplier;

import static com.jdiai.jsbuilder.JSTemplates.XPATH_FUNC;
import static com.jdiai.tools.LinqUtils.map;
import static com.jdiai.tools.LinqUtils.newList;
import static com.jdiai.tools.PrintUtils.print;

public class JSElement {
    protected JSDriver jsDriver;

    public JSElement(Supplier<WebDriver> driver, List<By> locators) {
        this.jsDriver = new JSDriver(driver, locators);
    }

    public JSElement(WebDriver driver, List<By> locators) {
        this.jsDriver = new JSDriver(driver, locators);
    }

    public JSElement(WebDriver driver, By... locators) {
        this.jsDriver = new JSDriver(driver, locators);
    }

    public JSDriver jsDriver() {
        if (jsDriver != null) {
            return jsDriver;
        }
        throw new JDINovaException("JSDriver not initialized");
    }

    public void updateDriver(JSDriver driver) {
        this.jsDriver.copy().context = driver.context;
        this.jsDriver.strategy = driver.strategy;
        this.jsDriver.setBuilder(driver.builder());
    }

    public void multiSearch() {
        jsDriver.multiSearch();
    }

    public JSProducer jsGet(String script) {
        IJSBuilder builder = jsDriver().builder();
        builder.addJSCode(script);
        return new JSProducer(builder.executeQuery());
    }

    public String jsExecute(String script) {
        return jsGet(script).asString();
    }

    public void doAction(String action) {
        jsDriver.doAction("element." + action);
    }

    // region Attributes
    public String getAttribute(String attribute) {
        return getValue("element." + attribute);
    }

    public String getValue(String valueFunc) {
        return jsDriver.getOne(valueFunc).asString();
    }

    public List<String> getAttributeList(String attribute) {
        return jsDriver.getList("element." + attribute).asString();
    }

    public Json getAttributes(String... attributes) {
        return getAttributes(newList(attributes));
    }

    public int getSize() {
        return jsDriver.getSize();
    }

    public Json getAttributes(List<String> attributes) {
        JsonObject json = jsDriver.getOne(attributesToJson(attributes)).asJson();
        return new Json(attributes, s -> json.get(s).getAsString());
    }

    public List<JsonObject> getJsonList(String json) {
        return jsDriver.getList(json).asJson();
    }

    public Json getAsMap(String valueFunc) {
        return jsDriver.getOne(valueFunc).asMap();
    }

    public String firstValue(String valueFunc) {
        return jsDriver.getFirst(valueFunc).asString();
    }

    public List<String> getValues(String valueFunc) {
        return jsDriver.getList(valueFunc).asString();
    }

    public List<Json> getMultiAttributes(List<String> attributes) {
        List<JsonObject> objects = jsDriver.getList(attributesToJson(attributes)).asJson();
        return map(objects, json -> new Json(attributes, v -> json.get(v).getAsString()));
    }

    public JsonObject getJson(String json) {
        return jsDriver.getOne(json).asJson();
    }

    public List<Json> getMultiAttributes(String... attributes) {
        return getMultiAttributes(newList(attributes));
    }
    // endregion

    // region Styles
    public String getStyle(String style) {
        return jsDriver.getOne("getComputedStyle(element)." + style).asString();
    }

    public Json getStyles(List<String> styles) {
        String jsonObject = "{ " + print(map(styles, style -> "'" + style + "': getComputedStyle(element)." + style), ", ") + " }";
        JsonObject json = jsDriver.getOne(jsonObject).asJson();
        return new Json(styles, json);
    }

    public String color() {
        return getColor("color");
    }

    public String bgColor() {
        return getColor("backgroundColor");
    }

    public String getColor(String name) {
        jsDriver.builder().addJSCode(NTC.script).executeQuery();
        return jsDriver.getOne("rgb = getComputedStyle(element)."+name+";\n" +
            "return jdi.ntc.name(rgb)[1]").asString();
    }

    public Json getStyles(String... styles) {
        return getStyles(newList(styles));
    }

    public Json getAllStyles() {
        JsonObject json =  jsDriver.getOne("{ keys: [...styles], " +
            "values: [...styles].map(style=>styles.getPropertyValue(style)) }").asJson();
        return new Json(json.get("keys"), json.get("values"));
    }

    public String pseudo(String name, String value) {
        return getValue("getComputedStyle(element, " + name + ").getPropertyValue(" + value + ")) }");
    }

    public List<String> getStylesList(String style) {
        List<JsonObject> styles = jsDriver.getList("{ 'style': getComputedStyle(element)." + style + " }").asJson();
        return map(styles, s -> s.get("style").getAsString());
    }

    public List<Json> getMultiStyles(List<String> styles) {
        String jsonObject = "{ " + print(map(styles, el -> "'" + el + "': getComputedStyle(element)." + el), ", ") + " }";
        List<JsonObject> jsonList = jsDriver.getList(jsonObject).asJson();
        return map(jsonList, j -> new Json(styles, s -> j.get(s).getAsString()));
    }

    public Json getObject(String objectMap) {
        return jsDriver.getOne(validateXpath(objectMap)).asMap();
    }

    public List<Json> getMultiStyles(String... styles) {
        return getMultiStyles(newList(styles));
    }

    public Json getObject(List<String> attributes) {
        return getObject(attributesToJson(attributes));
    }
    // Use json map like "{ 'tag': element.tagName, 'text': element.textContent... } with names equal to field names in class

    // endregion

    // region protected
    protected String attributesToJson(List<String> attributes) {
        return  "{ " + print(map(attributes, attr -> "'" + attr + "': element." + attr), ", ") + " }";
    }

    protected String validateXpath(String objectMap) {
        if (objectMap.contains("': xpath(")) {
            jsDriver.builder().registerFunction("xpath", XPATH_FUNC);
        }
        return objectMap;
    }
    // endregion
}
