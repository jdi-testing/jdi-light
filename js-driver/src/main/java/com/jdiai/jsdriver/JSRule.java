package com.jdiai.jsdriver;

import org.openqa.selenium.By;

public class JSRule {
    public By locator;
    public String script;
    public RuleType previous;
    public String filter;

    public JSRule(By locator) {
        this.locator = locator;
    }

    public JSRule(By locator, RuleType previous) {
        this.locator = locator;
        this.previous = previous;
    }

    public JSRule(By locator, String filter) {
        this.locator = locator;
        this.filter = filter;
    }

    public JSRule(String script) {
        this.script = script;
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
