package com.jdiai.jsdriver;

import com.jdiai.jsbuilder.*;
import com.jdiai.jsproducer.JSListProducer;
import com.jdiai.jsproducer.JSProducer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.epam.jdi.tools.LinqUtils.*;
import static com.jdiai.jsbuilder.ListSearch.CHAIN;
import static com.jdiai.jsbuilder.ListSearch.MULTI;
import static com.jdiai.jsdriver.JSDriverUtils.getByLocator;
import static com.jdiai.jsdriver.JSDriverUtils.getByType;
import static java.util.regex.Pattern.compile;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class JSDriver {
    private final Supplier<WebDriver> driver;
    protected List<By> locators;
    protected IJSBuilder builder;
    public ListSearch strategy = CHAIN;
    public String context = "document";
    protected String filter = null;

    private static IJSBuilder defaultBuilder(Supplier<WebDriver> driver) {
        return new JSBuilder(driver, new BuilderActions());
    }

    public JSDriver(Supplier<WebDriver> driver, By... locators) {
        this(driver, newList(locators), defaultBuilder(driver));
    }

    public JSDriver(WebDriver driver, By... locators) {
        this(() -> driver, locators);
    }

    public JSDriver(Supplier<WebDriver> driver, List<By> locators) {
        this(driver, locators, defaultBuilder(driver));
    }

    public JSDriver(WebDriver driver, List<By> locators) {
        this(() -> driver, locators);
    }

    public JSDriver(Supplier<WebDriver> driver, List<By> locators, IBuilderActions actions) {
        this(driver, locators, new JSBuilder(driver, actions));
    }

    public JSDriver(WebDriver driver, List<By> locators, IBuilderActions actions) {
        this(() -> driver, locators, actions);
    }

    public JSDriver(WebDriver driver, List<By> locators, IJSBuilder builder) {
        this(() -> driver, locators, builder);
    }

    public JSDriver(Supplier<WebDriver> driver, List<By> locators, IJSBuilder builder) {
        if (driver == null) {
            throw new JDINovaException("JSDriver init failed: WebDriver == null");
        }
        this.driver = driver;
        setLocators(locators);
        this.builder = builder;
    }
    public JSDriver setLocators(List<By> locators) {
        if (locators == null) {
            this.locators = null;
            return this;
        }
        List<By> result = new ArrayList<>();
        Pattern idMatcher = compile("^#(?<id>[a-zA-Z][a-zA-Z0-9]*([-_:][a-zA-Z0-9]+)*)$");
        for (By locator : locators) {
            Matcher matcher = idMatcher.matcher(getByLocator(locator));
            if (matcher.matches()) {
                locator = By.id(matcher.group("id"));
                result = new ArrayList<>();
            } else if (getByType(locator).equals("id")) {
                result = new ArrayList<>();
            }
            result.add(locator);
        }
        this.locators = result;
        return this;
    }

    public JSDriver updateBuilderActions(IBuilderActions actions) {
        this.builder().updateActions(actions);
        return this;
    }

    public JSDriver setBuilder(IJSBuilder builder) {
        this.builder = builder.copy();
        return this;
    }

    public JSDriver elementCtx() {
        context = "element";
        return this;
    }

    public IJSBuilder buildOne() {
        if (isEmpty(locators())) {
            return builder();
        }
        if (locators().size() == 1) {
            return hasFilter()
                ? builder().oneToOneFilter(context, locators.get(0))
                : builder().oneToOne(context, locators.get(0));
        }
        switch (strategy) {
            case CHAIN: return buildOneChain();
            case MULTI: return buildOneMultiSearch();
            default: return buildOneChain();
        }
    }

    public void doAction(String collector) {
        buildOne().doAction(collector).executeQuery();
    }

    public JSProducer getOne(String collector) {
        return new JSProducer(buildOne().getResult(collector).executeQuery());
    }

    public IJSBuilder buildList() {
        if (isEmpty(locators())) {
            return builder();
        }
        if (locators().size() == 1) {
            return hasFilter()
                ? builder().oneToListFilter(context, locators.get(0))
                : builder().oneToList(context, locators.get(0));
        }
        switch (strategy) {
            case CHAIN: return buildListChain();
            case MULTI: return buildListMultiSearch();
            default: return buildListChain();
        }
    }

    public JSListProducer getList(String collector) {
        return new JSListProducer(buildList().getResultList(collector).executeAsList());
    }

    public JSProducer getFirst(String collector) {
        return new JSProducer(buildList().getResult(collector).executeQuery());
    }

    public int getSize() {
        try {
            return ((Long) buildList().getResult("return elements?.length ?? 0;").executeQuery()).intValue();
        } catch (Exception ignore) {
            return -1;
        }
    }

    public long indexOf(String condition) {
        try {
            return (Long) buildList().addJSCode("return elements.findIndex(e => e && e." + condition + ");\n").executeQuery();
        } catch (Exception ignore) {
            return -1;
        }
    }

    // Used only if locators().length > 1
    protected IJSBuilder buildOneChain() {
        String ctx = context;
        for (By locator : listCopyUntil(locators(), -1)) {
            builder().oneToOne(ctx, locator);
            ctx = "element";
        }
        if (hasFilter()) {
            builder().oneToOneFilter("element", last(locators));
        } else {
            builder().oneToOne("element", last(locators));
        }
        return builder();
    }

    // Used only if locators().length > 1
    public IJSBuilder buildOneMultiSearch() {
        builder().oneToList(context, locators.get(0));
        if (locators().size() > 2) {
            for (By locator : listCopy(locators(), 1, -1)) {
                builder().listToList(locator);
            }
        }
        if (hasFilter()) {
            builder().listToOneFilter(last(locators));
        } else {
            builder().listToOne(last(locators));
        }
        return builder();
    }

    // Used only if locators().length > 1
    public IJSBuilder buildListChain() {
        String ctx = context;
        for (By locator : listCopyUntil(locators(), -1)) {
            builder().oneToOne(ctx, locator);
            ctx = "element";
        }
        if (hasFilter()) {
            builder().oneToListFilter("element", last(locators));
        } else {
            builder().oneToList("element", last(locators));
        }
        return builder();
    }

    public IJSBuilder buildListMultiSearch() {
        builder().oneToList(context, locators.get(0));
        if (locators().size() > 2) {
            for (By locator : listCopy(locators(), 1, -1)) {
                builder().listToList(locator);
            }
        }
        if (hasFilter()) {
            builder().listToListFilter(last(locators));
        } else {
            builder().listToList(last(locators));
        }
        return builder();
    }
    
    public JSDriver multiSearch() {
        strategy = MULTI;
        return this;
    }

    public WebDriver driver() {
        return this.driver.get();
    }

    public IJSBuilder builder() {
        if (builder == null) {
            builder = new JSBuilder(driver);
        }
        return builder;
    }

    public List<By> locators() {
        return this.locators;
    }

    public void setScriptInElementContext(JSDriver otherDriver, String script) {
        builder().setSearchScript(otherDriver.buildList().getScript() + script);
        elementCtx();
        builder().updateFromBuilder(otherDriver.builder());
    }

    public JSDriver setFilter(String filter) {
        if (isBlank(filter)) {
            this.filter = null;
            return this;
        }
        this.filter = "filter = function (element) {\n  " + getFilterBody(filter) + "\n}\n";
        return this;
    }

    protected String getFilterBody(String filter) {
        String prefix = builder().preResult(filter);
        String filterBody = filter;
        if (!filterBody.endsWith("\n")) {
            filterBody += "\n";
        }
        filterBody = filterBody.replace("\n", "\n  ").trim();
        return prefix + "  " + returnFunc(filterBody);
    }

    public boolean hasFilter() {
        if (filter != null) {
            builder().registerFunction("filter", filter);
            return true;
        }
        return false;
    }

    protected String returnFunc(String func) {
        return func.contains("return ") ? func : "return " + func;
    }
}
