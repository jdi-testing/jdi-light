package org.jdiai.jsdriver;

import org.jdiai.JSBuilder;
import org.openqa.selenium.By;

import static com.epam.jdi.tools.LinqUtils.listCopy;
import static com.epam.jdi.tools.LinqUtils.listCopyUntil;

public class JSExecutor {
    private final String collector;
    private final JSDriver jsDriver;

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
                .getOneToOne("document", jsDriver.firstLocator())
                .executeQuery(collector));
        }
        switch (jsDriver.strategy) {
            case CHAIN: return getOneChain();
            case MULTI: return getOneMultiSearch();
            default: return getOneChain();
        }
    }
    public JSListProducer getList() {
        if (jsDriver.locators().size() == 1) {
            return new JSListProducer(builder()
                    .getOneToList("document", jsDriver.firstLocator())
                    .collect(jsDriver.firstLocator(), collector)
                    .executeAsList("result"));
        }
        switch (jsDriver.strategy) {
            case CHAIN: return getListChain();
            case MULTI: return getListMultiSearch();
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
            builder.getOneToOne(ctx, locator);
            ctx = "element";
        }
        return new JSProducer(builder.executeQuery(collector));
    }
    public JSProducer getOneMultiSearch() {
        if (jsDriver.locators().size() == 1) {
            return getOne();
        }
        JSBuilder builder = builder()
                .getOneToList("document", jsDriver.firstLocator());
        for (By locator : listCopy(jsDriver.locators(), 1, -1)) {
            builder.getListToList(locator);
        }
        builder.getListToOne(jsDriver.lastLocator());
        return new JSProducer(builder.executeQuery(collector));
    }
    public JSListProducer getListChain() {
        if (jsDriver.locators().size() == 1) {
            return getList();
        }
        JSBuilder builder =  builder();
        String ctx = "document";
        for (By locator : listCopyUntil(jsDriver.locators(), -1)) {
            builder.getOneToOne(ctx, locator);
            ctx = "element";
        }
        builder.getOneToList("element", jsDriver.lastLocator())
            .collect(jsDriver.lastLocator(), collector);
        return new JSListProducer(builder.executeAsList("result"));
    }
    public JSListProducer getListMultiSearch() {
        if (jsDriver.locators().size() == 1) {
            return getList();
        }
        JSBuilder builder =  builder();
        builder.getOneToList("document", jsDriver.firstLocator());
        for (By locator : listCopy(jsDriver.locators(), 1, -1)) {
            builder.getListToList(locator);
        }
        builder.getListToList(jsDriver.lastLocator()).collect(jsDriver.lastLocator(), collector);
        return new JSListProducer(builder.executeAsList("result"));
    }

}
