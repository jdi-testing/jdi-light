package com.jdiai.jsbuilder;

import org.openqa.selenium.By;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public interface IJSBuilder {
    IJSBuilder addJSCode(String code);
    IJSBuilder setSearchScript(String code);

    IJSBuilder oneToOne(String ctx, By locator);
    IJSBuilder listToOne(By locator);
    IJSBuilder oneToList(String ctx, By locator);
    IJSBuilder listToList(By locator);

    String condition();

    IJSBuilder doAction(String collectResult);
    IJSBuilder getResult(String collectResult);
    IJSBuilder getResultList(String collectResult);

    IJSBuilder trigger(String event);
    IJSBuilder trigger(String event, String options);
    Object executeQuery();
    List<Object> executeAsList();
    IJSBuilder registerFunction(String name, String function);
    void registerVariables(String... vars);
    String registerVariable(String variable);
    String rawQuery();
    String getQuery();
    IJSBuilder logQuery(int queryLevel);
    void cleanup();
    void updateFromBuilder(IJSBuilder builder);
    IJSBuilder copy();
    IJSBuilder updateActions(IBuilderActions builderActions);
    IJSBuilder setElementName(String elementName);
    IJSBuilder setCondition(String condition);
    IJSBuilder setTimeoutMs(Supplier<Long> timeoutMs);
    JSBuilder setProcessResultFunc(Function<String, String> processResultFunc);
    String getElementName();
}
