package org.jdiai.jsdriver;

import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.map.MapArray;
import com.google.gson.JsonObject;
import org.jdiai.IJSBuilder;
import org.jdiai.JSBuilder;
import org.jdiai.JSException;
import org.jdiai.ListSearch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static com.epam.jdi.tools.LinqUtils.*;
import static com.epam.jdi.tools.PrintUtils.print;
import static java.util.Arrays.asList;
import static org.jdiai.ListSearch.CHAIN;
import static org.jdiai.ListSearch.MULTI;

public class JSDriver {
    private final WebDriver driver;
    private final List<By> locators;
    public static boolean logQuery = false;
    public ListSearch strategy = CHAIN;
    private IJSBuilder builder;

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
    public WebDriver driver() {
        return this.driver;
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

    public JSDriver setBuilder(IJSBuilder builder) {
        this.builder = builder;
        return this;
    }
    public IJSBuilder builder() {
        if (builder != null)
            return builder;
        builder = new JSBuilder(driver());
        if (logQuery)
            builder.logQuery();
        return builder;
    }

    public void invoke(String action) {
        attribute(action).getOne();
    }
    public JSExecutor attribute(String text) {
        return new JSExecutor("element." + text, this);
    }
    public JSExecutor json(String json) {
        return new JSExecutor("JSON.stringify(" + json + ")", this);
    }
    public JSExecutor attributes(List<String> attributes) {
        String jsonObject = "{ " + print(map(attributes, el -> "\"" + el + "\": element." + el), ", ") + " }";
        return json(jsonObject);
    }
    public JSExecutor attributes(String... attributes) {
        return attributes(asList(attributes));
    }
    public String getStyle(String style) {
        return json("{ \"style\": getComputedStyle(element)." + style + " }").getOne().asJson().get("style").getAsString();
    }
    public MapArray<String, String> getStyles(List<String> styles) {
        String jsonObject = "{ " + print(map(styles, el -> "\"" + el + "\": getComputedStyle(element)." + el), ", ") + " }";
        JsonObject json = json(jsonObject).getOne().asJson();
        return new MapArray<>(styles, s -> s, s -> json.get(s).getAsString());
    }
    public MapArray<String, String> getStyles(String... styles) {
        return getStyles(asList(styles));
    }
}
