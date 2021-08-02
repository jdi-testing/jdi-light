package com.jdiai.jswraper;

import com.google.gson.JsonObject;
import com.jdiai.jsdriver.JSDriver;
import com.jdiai.jsproducer.JSProducer;
import com.jdiai.jsproducer.Json;

import java.util.List;

public interface JSEngine {
    JSDriver jsDriver();
    void updateDriver(JSDriver driver);
    void multiSearch();
    JSProducer jsGet(String script);
    String jsExecute(String script);
    void doAction(String action);
    String getAttribute(String attribute);
    String getValue(String valueFunc);
    List<String> getAttributeList(String attribute);
    Json getAttributes(String... attributes);
    int getSize();
    Json getAttributes(List<String> attributes);
    List<JsonObject> getJsonList(String json);
    void setMap(String objectMap);
    Json getAsMap();
    Json getAsMap(String valueFunc);
    String firstValue(String valueFunc);
    List<String> getValues(String valueFunc);
    List<Json> getMultiAttributes(List<String> attributes);
    JsonObject getJson(String json);
    List<Json> getMultiAttributes(String... attributes);
    String getStyle(String style);
    Json getStyles(List<String> styles);
    String color();
    String bgColor();
    String getColor(String name);
    Json getStyles(String... styles);
    Json getAllStyles();
    String pseudo(String name, String value);
    List<String> getStylesList(String style);
    List<Json> getMultiStyles(List<String> styles);
    Json getObject(String objectMap);
    List<Json> getMultiStyles(String... styles);
    Json getObject(List<String> attributes);
    JSEngine setupEntity(Class<?> entity);
    <T> T getEntity(String objectMap);
    <T> T getEntity();
    <T> T getEntity(List<String> attributes);
    <T> T getEntityFromAttr(String... attributes);
    <T> List<T> getEntityList(String objectMap);
    <T> List<T> getEntityList();
    <T> List<T> getEntityList(List<String> attributes);
    <T> List<T> getEntityListFromAttr(String... attributes);
    default JSEngine noFilters() {
        jsDriver().noFilters();
        return this;
    }
}
