package org.jdiai.jswraper;

import com.google.gson.JsonObject;
import org.jdiai.jsbuilder.IJSBuilder;
import org.jdiai.jsdriver.JSDriver;
import org.jdiai.jsproducer.JSProducer;
import org.jdiai.jsproducer.Json;
import org.jdiai.jswraper.scripts.NTC;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.function.Supplier;

import static com.epam.jdi.tools.LinqUtils.map;
import static com.epam.jdi.tools.LinqUtils.newList;
import static com.epam.jdi.tools.PrintUtils.print;

public class JSElement {
    protected JSDriver driver;
    public JSDriver jsDriver() {
        return driver;
    }
    public void updateDriver(JSDriver driver) {
        this.driver.context = driver.context;
        this.driver.strategy = driver.strategy;
        this.driver.setBuilder(driver.builder());
    }

    public void multiSearch() {
        driver.multiSearch();
    }
    public JSProducer jsGet(String script) {
        IJSBuilder builder = jsDriver().builder();
        builder.addJSCode(script);
        return new JSProducer(builder.executeQuery());
    }
    public String jsExecute(String script) {
        return jsGet(script).asString();
    }

    public JSElement(Supplier<WebDriver> driver, List<By> locators) {
        this.driver = new JSDriver(driver, locators);
    }
    public JSElement(WebDriver driver, List<By> locators) {
        this.driver = new JSDriver(driver, locators);
    }
    public JSElement(WebDriver driver, By... locators) {
        this.driver = new JSDriver(driver, locators);
    }

    public void doAction(String action) {
        driver.getOne("element." + action);
    }

    // region Attributes
    public String getAttribute(String attribute) {
        return getValue("element." + attribute);
    }
    public String getValue(String valueFunc) {
        return driver.getOne(valueFunc).asString();
    }

    public List<String> getAttributeList(String attribute) {
        return driver.getList("element." + attribute).asString();
    }
    public Json getAttributes(String... attributes) {
        return getAttributes(newList(attributes));
    }
    public Json getAttributes(List<String> attributes) {
        JsonObject json = driver.getOne(attributesToJson(attributes)).asJson();
        return new Json(attributes, s -> json.get(s).getAsString());
    }
    public List<Json> getMultiAttributes(List<String> attributes) {
        List<JsonObject> objects = driver.getList(attributesToJson(attributes)).asJson();
        return map(objects, json -> new Json(attributes, v -> json.get(v).getAsString()));
    }
    public List<Json> getMultiAttributes(String... attributes) {
        return getMultiAttributes(newList(attributes));
    }
    // endregion

    // region Styles
    public String getStyle(String style) {
        return driver.getOne("getComputedStyle(element)." + style).asString();
    }
    public Json getStyles(List<String> styles) {
        String jsonObject = "{ " + print(map(styles, style -> "'" + style + "': getComputedStyle(element)." + style), ", ") + " }";
        JsonObject json = driver.getOne(jsonObject).asJson();
        return new Json(styles, json);
    }
    public String color() {
        return getColor("color");
    }
    public String bgColor() {
        return getColor("backgroundColor");
    }
    public String getColor(String name) {
        driver.builder().addJSCode(NTC.script).executeQuery();
        return driver.getOne("rgb = getComputedStyle(element)."+name+";\n" +
            "return jdi.ntc.name(rgb)[1]").asString();
    }
    public Json getStyles(String... styles) {
        return getStyles(newList(styles));
    }
    public Json getAllStyles() {
        JsonObject json =  driver.getOne("{ keys: [...getComputedStyle(element)], " +
            "values: [...getComputedStyle(element)].map(style=> getComputedStyle(element).getPropertyValue(style)) }").asJson();
        return new Json(json.get("keys"), json.get("values"));
    }
    public String pseudo(String name, String value) {
        return getValue("getComputedStyle(element, " + name + ").getPropertyValue(" + value + ")) }");
    }

    public List<String> getStylesList(String style) {
        List<JsonObject> styles = driver.getList("{ 'style': getComputedStyle(element)." + style + " }").asJson();
        return map(styles, s -> s.get("style").getAsString());
    }
    public List<Json> getMultiStyles(List<String> styles) {
        String jsonObject = "{ " + print(map(styles, el -> "'" + el + "': getComputedStyle(element)." + el), ", ") + " }";
        List<JsonObject> jsonList = driver.getList(jsonObject).asJson();
        return map(jsonList, j -> new Json(styles, s -> j.get(s).getAsString()));
    }
    public List<Json> getMultiStyles(String... styles) {
        return getMultiStyles(newList(styles));
    }
    // endregion

    // region protected
    protected String attributesToJson(List<String> attributes) {
        return  "{ " + print(map(attributes, el -> "'" + el + "': element." + el), ", ") + " }";
    }
    // endregion
}
