package com.jdiai.jsdriver;

import org.openqa.selenium.By;

public class JSRule {
    public By locator;
    public String script;
    public String filter;

    public JSRule(By locator) {
        this.locator = locator;
    }

    public JSRule(By locator, String filter) {
        this.locator = locator;
        this.filter = filter;
    }

    public JSRule(String script) {
        this.script = script;
    }
}
