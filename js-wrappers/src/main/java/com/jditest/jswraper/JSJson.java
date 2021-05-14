package com.jditest.jswraper;

import com.google.gson.JsonObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class JSJson extends JSElement {
    public JSJson(WebDriver driver, List<By> locators) {
        super(driver, locators);
    }
    public JSJson(WebDriver driver, By... locators) {
        super(driver, locators);
    }

    // Use json map like "{ 'tag': element.tagName, 'text': element.textContent... } with names equal to field names in class
    public JsonObject getJson(String json) {
        return driver.getOne(json).asJson();
    }
    // Use json map like "{ 'tag': element.tagName, 'text': element.textContent... } with names equal to field names in class
    public List<JsonObject> getJsonList(String json) {
        return driver.getList(json).asJson();
    }
}
