package com.jdiai.jsbuilder;

import com.jdiai.jsbuilder.jsfunctions.BuilderFunctions;
import org.openqa.selenium.By;

public class BuilderActions implements IBuilderActions {
    protected IJSBuilder builder;
    protected BuilderFunctions functions;

    public void setBuilder(IJSBuilder builder) {
        this.builder = builder;
        functions = new BuilderFunctions(builder);
    }

    public String oneToOne(String ctx, By locator) {
        return functions.oneToOne(ctx, locator);
    }

    public String oneToList(String ctx, By locator) {
        return functions.oneToList(ctx, locator);
    }

    public String listToOne(By locator) {
        return functions.listToOne(locator);
    }

    public String listToList(By locator) {
        return functions.listToList(locator);
    }

    public String doAction(String collector) {
        return functions.action(collector);
    }

    public String doListAction(String collector) {
        return functions.listAction(collector);
    }

    public String getResult(String collector) {
        return functions.result(collector);
    }

    public String getResultList(String collector) {
        return functions.listResult(collector);
    }
}
