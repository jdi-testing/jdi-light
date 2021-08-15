package com.jdiai.jsbuilder;

import com.jdiai.jsbuilder.jsfunctions.BuilderFunctions;
import org.openqa.selenium.By;

import java.util.function.Supplier;

public class BuilderActions implements IBuilderActions {
    protected BuilderFunctions functions;

    public BuilderActions() { }
    public BuilderActions(BuilderFunctions functions) {
        this.functions = functions;
    }

    public void setBuilder(Supplier<IJSBuilder> builder) {
        if (functions != null) {
            functions.builder = builder;
        }
        functions = new BuilderFunctions().set(f -> f.builder = builder);
    }

    public String oneToOne(String ctx, By locator) {
        return functions.oneToOne(ctx, locator);
    }
    public String oneToOneFilter(String ctx, By locator) {
        return functions.oneToOneFilter(ctx, locator);
    }

    public String oneToList(String ctx, By locator) {
        return functions.oneToList(ctx, locator);
    }

    public String oneToListFilter(String ctx, By locator) {
        return functions.oneToListFilter(ctx, locator);
    }

    public String listToOne(By locator) {
        return functions.listToOne(locator);
    }

    public String listToOneFilter(By locator) {
        return functions.listToOneFilter(locator);
    }

    public String listToList(By locator) {
        return functions.listToList(locator);
    }
    public String listToListFilter(By locator) {
        return functions.listToListFilter(locator);
    }

    public String doAction(String collector) {
        return functions.action(collector);
    }

    public String doListAction(String collector) {
        return functions.listAction(collector);
    }

    public String preResult(String collector) {
        return functions.addStyles(collector);
    }

    public String getResult(String collector) {
        return functions.result(collector);
    }

    public String getResultList(String collector) {
        return functions.listResult(collector);
    }
}
