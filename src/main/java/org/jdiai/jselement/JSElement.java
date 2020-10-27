package org.jdiai.jselement;

import com.epam.jdi.tools.map.MapArray;
import com.google.gson.JsonObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static com.epam.jdi.tools.LinqUtils.map;
import static java.util.Arrays.asList;

public class JSElement extends JSBase {
    public JSElement(WebDriver driver, List<By> locators) {
        super(driver, locators);
    }
    public JSElement(WebDriver driver, By... locators) {
        super(driver, locators);
    }

    public String getAttribute(String attribute) {
        return driver.attribute(attribute).getOne().asString();
    }
    public MapArray<String, String> getAttributes(List<String> attributes) {
        JsonObject json = driver.attributes(attributes).getOne().asJson();
        return new MapArray<>(attributes, s -> s, s -> json.get(s).getAsString());
    }
    public MapArray<String, String> getAttributes(String... attributes) {
        return getAttributes(asList(attributes));
    }
    public List<String> getAttributeList(String text) {
        return driver.attribute(text).getList().asString();
    }
    public List<MapArray<String, String>> getMultiAttributes(List<String> attributes) {
        List<JsonObject> objects = driver.attributes(attributes).getList().asJson();
        return map(objects, json -> new MapArray<>(attributes, k -> k, v -> json.get(v).getAsString()));
    }
    public List<MapArray<String, String>> getMultiAttributes(String... attributes) {
        return getMultiAttributes(asList(attributes));
    }

}
