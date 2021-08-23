package com.jdiai.jsdriver;

import org.openqa.selenium.By;

public class JSRule {
    public By locator;
    public String script;
    public RuleType previous;
    public String filter;

    public JSRule(By locator) {
        this(locator, null);
    }

    public JSRule(By locator, String filter) {
        this.locator = locator;
        this.filter = filter;
    }

    public JSRule(String script) {
        this(script, null);
    }

    public JSRule(String script, RuleType previous) {
        this.script = script;
        this.previous = previous;
    }

    public boolean isLocator() {
        return this.locator != null;
    }

    public boolean isScript() {
        return this.script != null;
    }
}
