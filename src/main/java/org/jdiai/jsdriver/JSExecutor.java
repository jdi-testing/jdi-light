package org.jdiai.jsdriver;

import org.jdiai.IJSBuilder;
import org.openqa.selenium.By;

import static com.epam.jdi.tools.LinqUtils.listCopy;
import static com.epam.jdi.tools.LinqUtils.listCopyUntil;

public class JSExecutor {
    private final JSDriver jsDriver;
    private final IJSBuilder builder;

    public JSExecutor(JSDriver jsDriver, IJSBuilder builder) {
        this.jsDriver = jsDriver;
        this.builder = builder;
    }
    private IJSBuilder builder() {
        return builder;
    }
    public JSProducer getOne() {
        if (jsDriver.locators().size() == 1) {
            return new JSProducer(builder()
                .getOneToOne("document", jsDriver.firstLocator())
                .executeQuery());
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
                .executeAsList());
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
        IJSBuilder builder =  builder();
        String ctx = "document";
        for (By locator : jsDriver.locators()) {
            builder.getOneToOne(ctx, locator);
            ctx = "element";
        }
        return new JSProducer(builder.executeQuery());
    }
    public JSProducer getOneMultiSearch() {
        if (jsDriver.locators().size() == 1) {
            return getOne();
        }
        IJSBuilder builder = builder()
                .getOneToList("document", jsDriver.firstLocator());
        for (By locator : listCopy(jsDriver.locators(), 1, -1)) {
            builder.getListToList(locator);
        }
        builder.getListToOne(jsDriver.lastLocator());
        return new JSProducer(builder.executeQuery());
    }
    public JSListProducer getListChain() {
        if (jsDriver.locators().size() == 1) {
            return getList();
        }
        String ctx = "document";
        for (By locator : listCopyUntil(jsDriver.locators(), -1)) {
            builder().getOneToOne(ctx, locator);
            ctx = "element";
        }
        builder().getOneToList("element", jsDriver.lastLocator());
        return new JSListProducer(builder().executeAsList());
    }
    public JSListProducer getListMultiSearch() {
        if (jsDriver.locators().size() == 1) {
            return getList();
        }
        builder().getOneToList("document", jsDriver.firstLocator());
        for (By locator : listCopy(jsDriver.locators(), 1, -1)) {
            builder().getListToList(locator);
        }
        builder().getListToList(jsDriver.lastLocator());
        return new JSListProducer(builder().executeAsList());
    }

}
