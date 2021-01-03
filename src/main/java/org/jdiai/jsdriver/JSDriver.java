package org.jdiai.jsdriver;

import com.epam.jdi.tools.LinqUtils;
import org.jdiai.JSException;
import org.jdiai.ListSearch;
import org.jdiai.jsbuilder.IJSBuilder;
import org.jdiai.jsbuilder.JSBuilder;
import org.jdiai.jsproducer.JSListProducer;
import org.jdiai.jsproducer.JSProducer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static com.epam.jdi.tools.LinqUtils.*;
import static org.jdiai.ListSearch.CHAIN;
import static org.jdiai.ListSearch.MULTI;

public class JSDriver {
    private final WebDriver driver;
    private final List<By> locators;
    private IJSBuilder builder;
    protected ListSearch strategy = CHAIN;

    public JSDriver(WebDriver driver, By... locators) {
        this(driver, newList(locators), null);
    }
    public JSDriver(WebDriver driver, List<By> locators) {
        this(driver, locators, null);
    }
    public JSDriver(WebDriver driver, List<By> locators, IJSBuilder builder) {
        if (driver == null)
            throw new JSException("JSDriver init failed: WebDriver == null");
        if (locators == null || locators.size() == 0)
            throw new JSException("JSDriver init failed: Require at least 1 locator");
        this.driver = driver;
        this.locators = copyList(locators);
        this.builder = builder;
    }

    public JSDriver setBuilder(IJSBuilder builder) {
        this.builder = builder;
        return this;
    }
    public JSProducer getOne(String collector) {
        if (locators().size() == 1) {
            return new JSProducer(builder()
                .oneToOne("document", firstLocator())
                .getResult(collector)
                .executeQuery());
        }
        switch (strategy) {
            case CHAIN: return getOneChain(collector);
            case MULTI: return getOneMultiSearch(collector);
            default: return getOneChain(collector);
        }
    }
    public JSListProducer getList(String collector) {
        if (locators().size() == 1) {
            return new JSListProducer(builder()
                .oneToList("document", firstLocator())
                .getResultList(collector)
                .executeAsList());
        }
        switch (strategy) {
            case CHAIN: return getListChain(collector);
            case MULTI: return getListMultiSearch(collector);
            default: return getListChain(collector);
        }
    }

    public JSProducer getOneChain(String collector) {
        if (locators().size() == 1) {
            return getOne(collector);
        }
        IJSBuilder builder =  builder();
        String ctx = "document";
        for (By locator : locators()) {
            builder.oneToOne(ctx, locator);
            ctx = "element";
        }
        return new JSProducer(builder.getResult(collector).executeQuery());
    }
    public JSProducer getOneMultiSearch(String collector) {
        if (locators().size() == 1) {
            return getOne(collector);
        }
        IJSBuilder builder = builder()
                .oneToList("document", firstLocator());
        for (By locator : listCopy(locators(), 1, -1)) {
            builder.listToList(locator);
        }
        builder.listToOne(lastLocator()).getResult(collector);
        return new JSProducer(builder.executeQuery());
    }
    public JSListProducer getListChain(String collector) {
        if (locators().size() == 1) {
            return getList(collector);
        }
        String ctx = "document";
        for (By locator : listCopyUntil(locators(), -1)) {
            builder().oneToOne(ctx, locator);
            ctx = "element";
        }
        builder().oneToList("element", lastLocator()).getResultList(collector);
        return new JSListProducer(builder().executeAsList());
    }
    public JSListProducer getListMultiSearch(String collector) {
        if (locators().size() == 1) {
            return getList(collector);
        }
        builder().oneToList("document", firstLocator());
        for (By locator : listCopy(locators(), 1, -1)) {
            builder().listToList(locator);
        }
        builder().listToList(lastLocator()).getResultList(collector);
        return new JSListProducer(builder().executeAsList());
    }
    
    public JSDriver multiSearch() {
        strategy = MULTI;
        return this;
    }
    public WebDriver driver() {
        return this.driver;
    }
    public IJSBuilder builder() {
        if (builder == null)
            builder = new JSBuilder(driver());
        return builder;
    }
    public List<By> locators() {
        return this.locators;
    }
    public By firstLocator() {
        return locators.get(0);
    }
    public By lastLocator() {
        return LinqUtils.last(locators);
    }

    public void invoke(String action) {
        getOne("element." + action).asString();
    }
}
