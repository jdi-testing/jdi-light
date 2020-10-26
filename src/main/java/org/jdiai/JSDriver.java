package org.jdiai;

import com.epam.jdi.tools.LinqUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static com.epam.jdi.tools.LinqUtils.*;
import static com.epam.jdi.tools.PrintUtils.print;
import static org.jdiai.ListSearch.CHAIN;
import static org.jdiai.ListSearch.MULTI;

public class JSDriver implements JSInterface {
    private final WebDriver driver;
    private final List<By> locators;
    public static boolean logQuery = false;
    public ListSearch strategy = CHAIN;

    public JSDriver(WebDriver driver, By... locators) {
        this(driver, newList(locators));
    }
    public JSDriver(WebDriver driver, List<By> locators) {
        if (driver == null)
            throw new JSException("JSDriver init failed: WebDriver == null");
        if (locators == null || locators.size() == 0)
            throw new JSException("JSDriver init failed: Require at least 1 locator");
        this.driver = driver;
        this.locators = copyList(locators);
    }
    public JSDriver multiSearch() {
        strategy = MULTI;
        return this;
    }
    private By first() {
        return LinqUtils.first(locators);
    }
    private By last() {
        return LinqUtils.last(locators);
    }

    public String getOne(String text) {
        if (locators.size() == 1) {
            return new JSBuilder(driver)
                    .getOneFromOne("document", locators.get(0))
                    .executeQuery("element." + text);
        }
        switch (strategy) {
            case CHAIN: return getOneChain(text);
            case MULTI: return getOneMultiSearch(text);
            default: return getOneChain(text);
        }
    }
    public JsonObject getOneJson(String json) {
        String jsObject = new JSBuilder(driver)
                .getOneFromOne("document", last())
                .executeQuery("JSON.stringify(" + json + ");");
        return new Gson().fromJson(jsObject, JsonObject.class);
    }
    public <T> T getOne(Class<T> cl, String json) {
        String jsObject = new JSBuilder(driver)
                .getOneFromOne("document", last())
                .executeQuery("JSON.stringify(" + json + ");");
        return new Gson().fromJson(jsObject, cl);
    }
    public JsonObject getOneJson(String... attributes) {
        String json = "{ " + print(map(attributes, el -> "\"" + el + "\": element." + el), ", ") + " }";
        return getOneJson(json);
    }
    public <T> T getOne(Class<T> cl, String... attributes) {
        String json = "{ " + print(map(attributes, el -> "\"" + el + "\": element." + el), ", ") + " }";
        return getOne(cl, json);
    }

    public String getStyle(String style) {
        return new JSBuilder(driver)
                .getOneFromOne("document", last())
                .executeQuery("getComputedStyle(element)." + style);
    }
    public List<String> getList(String text) {
        if (locators.size() == 1) {
            return new JSBuilder(driver)
                    .getListFromOne("document", locators.get(0), text)
                    .executeAsList("result");
        }
        switch (strategy) {
            case CHAIN: return getListChain(text);
            case MULTI: return getListMultiSearch(text);
            default: return getListChain(text);
        }
    }

    public String getOneChain(String text) {
        if (locators.size() == 1) {
            return getOne(text);
        }
        JSBuilder builder =  new JSBuilder(driver);
        String ctx = "document";
        for (By locator : locators) {
            builder.getOneFromOne(ctx, locator);
            ctx = "element";
        }
        return builder.executeQuery("element." + text);
    }
    public String getOneMultiSearch(String text) {
        if (locators.size() == 1) {
            return getOne(text);
        }
        By first = first();
        By last = last();
        JSBuilder builder =  new JSBuilder(driver)
                .getListFromOne("document", first);
        By prev = first;
        for (By locator : listCopy(locators, 1, -1)) {
            builder.getListFromList(locator, prev);
            prev = locator;
        }
        builder.getOneFromList(last);
        return builder.executeQuery("element." + text);
    }
    public List<String> getListChain(String text) {
        if (locators.size() == 1) {
            return getList(text);
        }
        JSBuilder builder =  new JSBuilder(driver);
        String ctx = "document";
        for (By locator : listCopyUntil(locators, -1)) {
            builder.getOneFromOne(ctx, locator);
            ctx = "element";
        }
        builder.getListFromOne("element", last(), text);
        return builder.executeAsList("result");
    }
    public List<String> getListMultiSearch(String text) {
        if (locators.size() == 1) {
            return getList(text);
        }
        JSBuilder builder =  new JSBuilder(driver);
        builder.getListFromOne("document", first());
        By prev = first();
        for (By locator : listCopy(locators, 1, -1)) {
            builder.getListFromList(locator, prev);
            prev = locator;
        }
        builder.getListFromList(last(), listCopy(locators, -2, -2).get(0), text);
        return builder.executeAsList("result");
    }
}
