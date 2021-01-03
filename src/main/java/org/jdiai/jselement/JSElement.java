package org.jdiai.jselement;

import com.epam.jdi.tools.map.MapArray;
import com.google.gson.JsonObject;
import org.jdiai.jsdriver.JSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static com.epam.jdi.tools.LinqUtils.map;
import static com.epam.jdi.tools.PrintUtils.print;
import static java.util.Arrays.asList;

// Base JSWrapper actions
public class JSElement {
    protected JSDriver driver;
    public JSDriver jsDriver() {
        return driver;
    }
    public void multiSearch() {
        driver.multiSearch();
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

    public String getStyle(String style) {
        return driver.getOne("{ 'style': getComputedStyle(element)." + style + " }").asJson().get("style").getAsString();
    }
    public MapArray<String, String> getStyles(List<String> styles) {
        String jsonObject = "{ " + print(map(styles, style -> "'" + style + "': getComputedStyle(element)." + style), ", ") + " }";
        JsonObject json = driver.getOne(jsonObject).asJson();
        return new MapArray<>(styles, s -> s, s -> json.get(s).getAsString());
    }
    public MapArray<String, String> getStyles(String... styles) {
        return getStyles(asList(styles));
    }

    public List<String> getStylesList(String style) {
        List<JsonObject> styles = driver.getList("{ 'style': getComputedStyle(element)." + style + " }").asJson();
        return map(styles, s -> s.get("style").getAsString());
    }
    public List<MapArray<String, String>> getMultiStyles(List<String> styles) {
        String jsonObject = "{ " + print(map(styles, el -> "'" + el + "': getComputedStyle(element)." + el), ", ") + " }";
        List<JsonObject> jsonList = driver.getList(jsonObject).asJson();
        return map(jsonList, j -> new MapArray<>(styles, s -> s, s -> j.get(s).getAsString()));
    }
    public List<MapArray<String, String>> getMultiStyles(String... styles) {
        return getMultiStyles(asList(styles));
    }
    public String getAttribute(String attribute) {
        return getValue("element." + attribute);
    }
    public String getValue(String valueFunc) {
        return driver.getOne(valueFunc).asString();
    }

    public List<String> getAttributeList(String attribute) {
        return driver.getList("element." + attribute).asString();
    }

    // protected
    protected String attributesToJson(List<String> attributes) {
        return  "{ " + print(map(attributes, el -> "'" + el + "': element." + el), ", ") + " }";
    }

    public MapArray<String, String> getAttributes(String... attributes) {
        return getAttributes(asList(attributes));
    }
    public MapArray<String, String> getAttributes(List<String> attributes) {
        JsonObject json = driver.getOne(attributesToJson(attributes)).asJson();
        return new MapArray<>(attributes, s -> s, s -> json.get(s).getAsString());
    }
    public List<MapArray<String, String>> getMultiAttributes(List<String> attributes) {
        List<JsonObject> objects = driver.getList(attributesToJson(attributes)).asJson();
        return map(objects, json -> new MapArray<>(attributes, k -> k, v -> json.get(v).getAsString()));
    }
    public List<MapArray<String, String>> getMultiAttributes(String... attributes) {
        return getMultiAttributes(asList(attributes));
    }
}
