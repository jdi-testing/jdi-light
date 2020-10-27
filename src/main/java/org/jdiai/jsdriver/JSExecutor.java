package org.jdiai.jsdriver;

import org.jdiai.JSBuilder;
import org.jdiai.ListSearch;
import org.openqa.selenium.By;

import static com.epam.jdi.tools.LinqUtils.listCopy;
import static com.epam.jdi.tools.LinqUtils.listCopyUntil;

public class JSExecutor {
    private String collector;
    private JSDriver jsDriver;

    public JSExecutor(String collector, JSDriver jsDriver) {
        this.collector = collector;
        this.jsDriver = jsDriver;
    }
    private JSBuilder builder() {
        return jsDriver.builder();
    }

    public JSProducer getOne() {
        if (jsDriver.locators().size() == 1) {
            return new JSProducer(builder()
                .getOneFromOne("document", jsDriver.firstLocator())
                .executeQuery(collector));
        }
        switch (jsDriver.strategy) {
            case ListSearch.CHAIN: return getOneChain();
            case ListSearch.MULTI: return getOneMultiSearch();
            default: return getOneChain();
        }
    }
    public JSListProducer getList() {
        if (jsDriver.locators().size() == 1) {
            return new JSListProducer(builder()
                    .getListFromOne("document", jsDriver.firstLocator(), collector)
                    .executeAsList("result"));
        }
        switch (jsDriver.strategy) {
            case ListSearch.CHAIN: return getListChain();
            case ListSearch.MULTI: return getListMultiSearch();
            default: return getListChain();
        }
    }

    public JSProducer getOneChain() {
        if (jsDriver.locators().size() == 1) {
            return getOne();
        }
        JSBuilder builder =  builder();
        String ctx = "document";
        for (By locator : jsDriver.locators()) {
            builder.getOneFromOne(ctx, locator);
            ctx = "element";
        }
        return new JSProducer(builder.executeQuery(collector));
    }
    public JSProducer getOneMultiSearch() {
        if (jsDriver.locators().size() == 1) {
            return getOne();
        }
        JSBuilder builder = builder()
                .getListFromOne("document", jsDriver.firstLocator());
        By prev = jsDriver.firstLocator();
        for (By locator : listCopy(jsDriver.locators(), 1, -1)) {
            builder.getListFromList(locator, prev);
            prev = locator;
        }
        builder.getOneFromList(jsDriver.lastLocator());
        return new JSProducer(builder.executeQuery(collector));
    }
    public JSListProducer getListChain() {
        if (jsDriver.locators().size() == 1) {
            return getList();
        }
        JSBuilder builder =  builder();
        String ctx = "document";
        for (By locator : listCopyUntil(jsDriver.locators(), -1)) {
            builder.getOneFromOne(ctx, locator);
            ctx = "element";
        }
        builder.getListFromOne("element", jsDriver.lastLocator(), collector);
        return new JSListProducer(builder.executeAsList("result"));
    }
    public JSListProducer getListMultiSearch() {
        if (jsDriver.locators().size() == 1) {
            return getList();
        }
        JSBuilder builder =  builder();
        builder.getListFromOne("document", jsDriver.firstLocator());
        By prev = jsDriver.firstLocator();
        for (By locator : listCopy(jsDriver.locators(), 1, -1)) {
            builder.getListFromList(locator, prev);
            prev = locator;
        }
        builder.getListFromList(jsDriver.lastLocator(), listCopy(jsDriver.locators(), -2, -2).get(0), collector);
        return new JSListProducer(builder.executeAsList("result"));
    }

}
