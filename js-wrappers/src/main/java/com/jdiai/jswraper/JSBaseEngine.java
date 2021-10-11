package com.jdiai.jswraper;

import com.jdiai.jsbuilder.IJSBuilder;
import com.jdiai.jsbuilder.JSBuilder;
import com.jdiai.jsdriver.JSDriver;
import com.jdiai.jsproducer.Json;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.function.Supplier;

import static com.jdiai.jswraper.JSEntity.GET_ENTITY_MAP;
import static com.jdiai.tools.LinqUtils.map;
import static com.jdiai.tools.LinqUtils.newList;
import static com.jdiai.tools.ReflectionUtils.isClass;

public class JSBaseEngine extends JSElement implements JSEngine {
    protected Class<?> entity;
    protected String objectMap;

    public String getEntityName() {
        return entity.getSimpleName();
    }

    public JSBaseEngine(Supplier<WebDriver> driver, List<By> locators, IJSBuilder builder) {
        super(driver, locators);
        if (builder != null) {
            jsDriver().setBuilder(builder);
        }
    }

    public JSBaseEngine(Supplier<WebDriver> driver, List<By> locators) {
        this(driver, locators, new JSBuilder(driver));
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

    public void copyDriver(JSDriver driver) {
        this.jsDriver = driver.copy();
    }

    public JSEngine copy() {
        JSEngine engine = new JSBaseEngine(() -> this.jsDriver.driver());
        engine.updateFrom(this);
        return engine;
    }

    public void updateFrom(JSEngine engine) {
        if (!isClass(engine.getClass(), JSBaseEngine.class)) {
            return ;
        }
        JSBaseEngine jsEngine = (JSBaseEngine) engine;
        this.setupEntity(jsEngine.entity);
        this.setMap(jsEngine.objectMap);
        this.jsDriver.copyFrom(jsEngine.jsDriver);
    }

    public JSBaseEngine setupEntity(Class<?> entity) {
        this.entity = entity;
        return this;
    }

    // Use json map like "{ 'tag': element.tagName, 'text': element.textContent... } with names equal to field names in class
    public <T> T getEntity(String objectMap) {
        return (T) jsDriver.getOne(validateXpath(objectMap)).asObject(entity);
    }

    public <T> T getEntity() {
        return getEntity(GET_ENTITY_MAP.apply(entity));
    }

    public <T> T getEntity(List<String> attributes) {
        return (T) jsDriver.getOne(attributesToJson(attributes)).asObject(entity);
    }

    public <T> T getEntityFromAttr(String... attributes) {
        return getEntity(newList(attributes));
    }

    public <T> List<T> getEntityList(String objectMap) {
        return map(jsDriver.getList(validateXpath(objectMap)).asObject(entity), el -> (T) el);
    }

    public <T> List<T> getEntityList() {
        return getEntityList(GET_ENTITY_MAP.apply(entity));
    }

    public <T> List<T> getEntityList(List<String> attributes) {
        return map(jsDriver.getList(attributesToJson(attributes)).asObject(entity), el -> (T) el);
    }

    public <T> List<T> getEntityListFromAttr(String... attributes) {
        return getEntityList(newList(attributes));
    }

    public Json getAsMap() {
        return jsDriver.getOne(objectMap).asMap();
    }

    @Override
    public Json getAsMap(String valueFunc) {
        setMap(valueFunc);
        return getAsMap();
    }

    public void setMultipleValues(String valueFunc) {
        setMap(valueFunc);
        setMultipleValues();
    }

    public void setMultipleValues() {
        jsDriver.doAction(objectMap);
    }

    public void setMap(String objectMap) {
        this.objectMap = objectMap;
    }
}
