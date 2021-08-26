package com.jdiai.jswraper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.function.Supplier;

import static com.jdiai.jswraper.JSWrapper.displayedFilter;
import static com.jdiai.tools.LinqUtils.newList;

public class JSWithFilters extends JSBaseEngine {
    public JSWithFilters(Supplier<WebDriver> driver, List<By> locators) {
        super(driver, locators);
        this.jsDriver.setFilter(displayedFilter);
    }

    public JSWithFilters(WebDriver driver, List<By> locators) {
        this(() -> driver, locators);
    }

    public JSWithFilters(Supplier<WebDriver> driver, By... locators) {
        this(driver, newList(locators));
    }

    public JSWithFilters(WebDriver driver, By... locators) {
        this(() -> driver, locators);
    }
}
