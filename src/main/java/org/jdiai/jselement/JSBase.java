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

public abstract class JSBase<T extends JSBase<?>> {
    protected JSDriver driver;
    public JSDriver jsDriver() {
        return driver;
    }
    public T multiSearch() {
        driver.multiSearch();
        return (T) this;
    }

    public JSBase(WebDriver driver, List<By> locators) {
        this.driver = new JSDriver(driver, locators);
    }
    public JSBase(WebDriver driver, By... locators) {
        this.driver = new JSDriver(driver, locators);
    }

    public void doAction(String action) {
        driver.getOne("element." + action);
    }

    public String getStyle(String style) {
        return driver.getOne("{ \"style\": getComputedStyle(element)." + style + " }").asJson().get("style").getAsString();
    }
    public MapArray<String, String> getStyles(List<String> styles) {
        String jsonObject = "{ " + print(map(styles, el -> "\"" + el + "\": getComputedStyle(element)." + el), ", ") + " }";
        JsonObject json = driver.getOne(jsonObject).asJson();
        return new MapArray<>(styles, s -> s, s -> json.get(s).getAsString());
    }
    public MapArray<String, String> getStyles(String... styles) {
        return getStyles(asList(styles));
    }

    public List<String> getStylesList(String style) {
        List<JsonObject> styles = driver.getList("{ \"style\": getComputedStyle(element)." + style + " }").asJson();
        return map(styles, s -> s.get("style").getAsString());
    }
    public List<MapArray<String, String>> getMultiStyles(List<String> styles) {
        String jsonObject = "{ " + print(map(styles, el -> "\"" + el + "\": getComputedStyle(element)." + el), ", ") + " }";
        List<JsonObject> jsonList = driver.getList(jsonObject).asJson();
        return map(jsonList, j -> new MapArray<>(styles, s -> s, s -> j.get(s).getAsString()));
    }
    public List<MapArray<String, String>> getMultiStyles(String... styles) {
        return getMultiStyles(asList(styles));
    }

    protected String attributesToJson(List<String> attributes) {
        return  "{ " + print(map(attributes, el -> "\"" + el + "\": element." + el), ", ") + " }";
    }
}
