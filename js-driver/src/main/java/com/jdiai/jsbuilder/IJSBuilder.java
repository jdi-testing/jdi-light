package com.jdiai.jsbuilder;

import org.openqa.selenium.By;

import java.util.List;
import java.util.function.Function;

public interface IJSBuilder {
    IJSBuilder addJSCode(String code);
    IJSBuilder setSearchScript(String code);

    IJSBuilder oneToOne(String ctx, By locator);
    IJSBuilder oneToOneFilter(String ctx, By locator);
    IJSBuilder listToOne(By locator);
    IJSBuilder listToOneFilter(By locator);
    IJSBuilder oneToList(String ctx, By locator);
    IJSBuilder oneToListFilter(String ctx, By locator);
    IJSBuilder listToList(By locator);
    IJSBuilder listToListFilter(By locator);

    IJSBuilder doAction(String collectResult);
    IJSBuilder doListAction(String collectResult);
    IJSBuilder getResult(String collectResult);
    IJSBuilder getResultList(String collectResult);

    IJSBuilder trigger(String event);
    IJSBuilder trigger(String event, String options);
    Object executeQuery();
    List<Object> executeAsList();
    IJSBuilder registerFunction(String name, String function);
    String getQuery();
    String getScript();
    IJSBuilder logQuery(int queryLevel);
    void cleanup();
    void updateFromBuilder(IJSBuilder builder);
    IJSBuilder copy();
    IJSBuilder updateActions(IBuilderActions builderActions);
    IJSBuilder setElementName(String elementName);
    JSBuilder setProcessResultFunc(Function<String, String> processResultFunc);
    String getElementName();
    String preResult(String collector);
}
