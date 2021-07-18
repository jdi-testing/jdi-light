package com.jdiai.jswraper;

import com.jdiai.jsbuilder.IJSBuilder;
import com.jdiai.jsbuilder.JSBuilder;
import com.jdiai.jsproducer.Json;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.function.Supplier;

import static com.epam.jdi.tools.LinqUtils.map;
import static com.epam.jdi.tools.LinqUtils.newList;
import static com.jdiai.jswraper.JSEntity.GET_ENTITY_MAP;

public class JSBaseEngine extends JSElement implements JSEngine {
    protected Class<?> entity;
    protected String objectMap;

    public JSBaseEngine(Supplier<WebDriver> driver, List<By> locators, IJSBuilder builder) {
        super(driver, locators);
        if (builder != null) {
            jsDriver().setBuilder(builder);
        }
    }

    public JSBaseEngine(Supplier<WebDriver> driver, List<By> locators) {
        this(driver, locators, new JSBuilder());
    }

    public JSBaseEngine(WebDriver driver, List<By> locators) {
        this(() -> driver, locators);
    }

    public JSBaseEngine(Supplier<WebDriver> driver, By... locators) {
        this(driver, newList(locators));
    }

    public JSBaseEngine(WebDriver driver, By... locators) {
        this(() -> driver, locators);
    }

    public JSBaseEngine setupEntity(Class<?> entity) {
        this.entity = entity;
        return this;
    }

    // Use json map like "{ 'tag': element.tagName, 'text': element.textContent... } with names equal to field names in class
    public <T> T getEntity(String objectMap) {
        return (T) driver.getOne(validateXpath(objectMap)).asObject(entity);
    }

    public <T> T getEntity() {
        return getEntity(GET_ENTITY_MAP.apply(entity));
    }

    public <T> T getEntity(List<String> attributes) {
        return (T) driver.getOne(attributesToJson(attributes)).asObject(entity);
    }

    public <T> T getEntityFromAttr(String... attributes) {
        return getEntity(newList(attributes));
    }

    public <T> List<T> getEntityList(String objectMap) {
        return map(driver.getList(validateXpath(objectMap)).asObject(entity), el -> (T) el);
    }

    public <T> List<T> getEntityList() {
        return getEntityList(GET_ENTITY_MAP.apply(entity));
    }

    public <T> List<T> getEntityList(List<String> attributes) {
        return map(driver.getList(attributesToJson(attributes)).asObject(entity), el -> (T) el);
    }

    public <T> List<T> getEntityListFromAttr(String... attributes) {
        return getEntityList(newList(attributes));
    }

    public Json getAsMap() {
        return driver.getOne(objectMap).asMap();
    }

    @Override
    public Json getAsMap(String valueFunc) {
        setMap(valueFunc);
        return getAsMap();
    }

    public void setMap(String objectMap) {
        this.objectMap = objectMap;
    }
}
