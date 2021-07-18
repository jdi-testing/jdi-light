package com.jdiai.jswraper;

import com.jdiai.jsbuilder.SmartBuilderActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.function.Supplier;

import static com.epam.jdi.tools.LinqUtils.map;
import static com.epam.jdi.tools.LinqUtils.newList;
import static com.jdiai.jsbuilder.JSTemplates.XPATH_FUNC;
import static com.jdiai.jswraper.JSEntity.GET_ENTITY_MAP;

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

    protected Class<?> entity;

    public JSSmart setupEntity(Class<?> entity) {
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
}
